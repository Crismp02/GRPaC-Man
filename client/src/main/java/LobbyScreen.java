import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import pacman.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LobbyScreen extends JPanel {
    private JPanel mainPanel; // Main panel to hold different screens
    private CardLayout cardLayout; // CardLayout to manage screens
    private ImageIcon backgroundImage;
    private ImageIcon logoImage;
    private ImageIcon startButtonImage;
    private ArrayList<String> players;
    private JPanel boxPanel;
    private ArrayList<JPanel> playerBoxes;
    private String userName;
    private ManagedChannel channel;
    private final LobbyServiceGrpc.LobbyServiceStub asyncStub;
    private final String[] imagePaths = {
            "client/src/main/assets/ghost_1.png", // Replace with actual image paths
            "client/src/main/assets/ghost_2.png",
            "client/src/main/assets/ghost_3.png",
            "client/src/main/assets/ghost_4.png"
    };
    private final Color[] borderColors = {Color.RED, Color.YELLOW, Color.CYAN, Color.PINK}; // Different colors for the borders
    private Clip backgroundMusic;
    private boolean started = false;

    public LobbyScreen(ArrayList<String> playerNames, String playerName, ManagedChannel channel, JPanel mainPanel, CardLayout cardLayout) {
        players = playerNames;
        userName = playerName;
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        this.channel = channel;
        asyncStub = LobbyServiceGrpc.newStub(channel);
        playerBoxes = new ArrayList<>();
        System.out.println(channel);
        // Load the images
        backgroundImage = new ImageIcon("client/src/main/assets/pacman.gif");
        logoImage = new ImageIcon("client/src/main/assets/logo.png");
        startButtonImage = new ImageIcon("client/src/main/assets/start_button.png"); // Load the start button image

        playBackgroundMusic("client/src/main/assets/pacman_theme.wav");

        // Set the layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false); // Make the panel transparent

        // Add the logo panel
        LogoPanel logoPanel = new LogoPanel();
        logoPanel.setOpaque(false);
        add(logoPanel);

        // Add a rigid area for spacing
        add(Box.createRigidArea(new Dimension(0, 20))); // Adjust the height to your liking

        // Add a panel for the boxes
        boxPanel = new JPanel();
        boxPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the boxes
        boxPanel.setOpaque(false); // Make it transparent
        add(boxPanel);

        // Create boxes
        for (Integer i = 0; i < 4; i++) {
            String name;
            if (i < players.size()) {
                name = players.get(i);
            } else {
                name = "Esperando jugador";
            }
            JPanel box = createBox(name, i);
            playerBoxes.add(box);
            boxPanel.add(box);
            boxPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        }

        // Add vertical glue to center the content
        add(Box.createVerticalGlue());

        // Create and add the start button
        JButton startButton = new JButton(startButtonImage);
        startButton.setBorderPainted(false); // Remove border
        startButton.setContentAreaFilled(false); // Make button transparent
        startButton.setFocusPainted(false); // Remove focus border
        startButton.setPreferredSize(new Dimension(200, 100)); // Set preferred size for the button

        // Set the cursor to a hand cursor when hovering over the button
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Center the button
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> {
            started = true;
            startGame();
            //Model game = new Model(players, userName, channel, mainPanel, cardLayout);
            //mainPanel.add(game, "Game");
            cardLayout.show(mainPanel, "Game"); // Switch to the Lobby screen
            stopBackgroundMusic();
        });
        add(startButton);
        streamLobbyUpdates();
        streamGameStartNotifications();
    }

    private void playBackgroundMusic(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music
            backgroundMusic.start(); // Start playing the music
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }

    // Method to stop the background music
    private void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop(); // Stop the music
        }
    }

    private JPanel createBox(String playerName, Integer index) {
        JPanel box = createBox(borderColors[index], imagePaths[index], playerName);
        return box;
    }

    private void addPlayerToBox(String playerName) {
        // Find the index of the player in the players list
        int index = players.size() - 1;

        // Check if the player exists in the list
        if (index != -1) {
            // Update the player's name in the players list
            players.set(index, playerName);

            // Get the corresponding box
            JPanel box = playerBoxes.get(index);

            // Update the name label in the box
            JLabel nameLabel = (JLabel) box.getComponent(1); // Assuming the name label is at index 1
            nameLabel.setText(playerName);

            // Repaint the box to reflect the changes
            box.repaint();
        } else {
            System.out.println("Player not found: " + playerName);
        }
    }

    private void removePlayerFromBox(String playerName) {
        // Find the index of the player who left
        int index = players.indexOf(playerName);
        if (index == players.size() - 1) {
            JPanel box = playerBoxes.get(index);
            JLabel nameLabel = (JLabel) box.getComponent(1); // Assuming the name label is at index 1
            nameLabel.setText("Esperando jugador");
            box.repaint();
            return;
        }

        // Check if the player exists in the list
        if (index != -1) {
            String nameAux;
            for (int i = index + 1; i < players.size(); i++) {
                // Update the name of the box for the player moving up
                JPanel movingBox = playerBoxes.get(i - 1);
                JLabel movingNameLabel = (JLabel) movingBox.getComponent(1);
                String movingPlayerName = players.get(i);
                movingNameLabel.setText(movingPlayerName); // Change to "Esperando jugador"
                movingBox.repaint();
                JPanel actualBox = playerBoxes.get(i);
                JLabel actualNameLabel = (JLabel) actualBox.getComponent(1);
                actualNameLabel.setText("Esperando jugador");
                actualBox.repaint();
            }
            // Refresh the UI to reflect the changes
        } else {
            System.out.println("Player not found: " + playerName);
        }
    }

    private void streamLobbyUpdates() {
        StreamObserver<PlayerStatus> responseObserver = new StreamObserver<PlayerStatus>() {
            @Override
            public void onNext(PlayerStatus playerStatus) {
                try{
                    if (playerStatus.getCurrentPlayers() > players.size()) {
                        System.out.println("Se unió " + playerStatus.getPlayerName());
                        System.out.println("Jugadores actuales " + playerStatus.getCurrentPlayers());
                        // A new player has joined
                        String newPlayerName = playerStatus.getPlayerName();
                        players.add(newPlayerName);
                        addPlayerToBox(playerStatus.getPlayerName()); // Refresh the UI
                    } else if (playerStatus.getCurrentPlayers() < players.size()) {
                        System.out.println("Se Salió " + playerStatus.getPlayerName());
                        System.out.println("Jugadores actuales " + playerStatus.getCurrentPlayers());
                        // A player has left
                        String leavingPlayerName = playerStatus.getPlayerName();
                        removePlayerFromBox(leavingPlayerName);
                        players.remove(leavingPlayerName);
                    }
                }catch(Exception e){
                    System.err.println("Error en onNext: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error streaming updates: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming updates completed.");
            }
        };

        // Create a StreamObserver to send updates
        StreamObserver<LobbyUpdate> requestObserver = asyncStub.streamLobby(responseObserver);

        // Send updates to the server
        try {
            LobbyUpdate update = LobbyUpdate.newBuilder()
                    .setPlayerName(userName)
                    .setIsJoining(true)
                    .build();
            requestObserver.onNext(update);
            System.out.println("Update sent for player: " + userName);
        } catch (Exception e) {
            System.err.println("Failed to send update: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void startGame() {
        System.out.println("Start Game Button Pressed");
        StartGameRequest request = StartGameRequest.newBuilder()
                .setPlayerName(userName)
                .build();

        asyncStub.startGame(request, new StreamObserver<StartGameResponse>() {
            @Override
            public void onNext(StartGameResponse response) {
                System.out.println(response.getMessage());
                // You can also update the UI here if needed
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error starting game: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Game start request completed.");
            }
        });
    }

    private void streamGameStartNotifications() {
        // Create a StreamObserver to handle incoming game start notifications
        StreamObserver<GameStartNotification> responseObserver = new StreamObserver<GameStartNotification>() {
            @Override
            public void onNext(GameStartNotification notification) {
                System.out.println("Game started: " + notification.getMessage());
                if (!started) {
                    started = true;
                    //Model game = new Model(players, userName, channel, mainPanel, cardLayout);
                    //mainPanel.add(game, "Game");
                    cardLayout.show(mainPanel, "Game"); // Switch to the Lobby screen
                    stopBackgroundMusic();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error streaming game start notifications: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming game start notifications completed.");
            }
        };

        // Call the server to start streaming game start notifications
        StreamObserver<GameStartUpdate> requestObserver = asyncStub.streamGameStart(responseObserver);

        // Notify the server that this client is ready to receive notifications
        GameStartUpdate update = GameStartUpdate.newBuilder()
                .setPlayerName(userName)
                .build();
        requestObserver.onNext(update);
    }

    private JPanel createBox(Color borderColor, String imagePath, String name) {
        JPanel box = new JPanel();
        box.setBackground(Color.BLACK); // Set the background color of the box to black
        box.setBorder(BorderFactory.createLineBorder(borderColor, 10)); // Set border color
        box.setLayout(new GridBagLayout()); // Use GridBagLayout for centering

        // Set preferred, minimum, and maximum size for the box
        box.setPreferredSize(new Dimension(300, 400)); // Width of 200 and height of 250
        box.setMinimumSize(new Dimension(300, 400)); // Enforce minimum size
        box.setMaximumSize(new Dimension(300, 400)); // Enforce maximum size

        // Load the image
        ImageIcon icon = new ImageIcon(imagePath); // Use the provided image path
        JLabel imageLabel = new JLabel(icon, SwingConstants.CENTER);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the image

        // Create name label
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE); // Set text color to white
        nameLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font size

        // Create a GridBagConstraints object to position the labels
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.anchor = GridBagConstraints.CENTER; // Center the components
        gbc.weighty = 1; // Allow the components to take up vertical space

        // Add the image label
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.insets = new Insets(20, 0, 5, 0); // Add top and bottom padding
        box.add(imageLabel, gbc);

        // Add the name label
        gbc.gridy = 1; // Row 1
        gbc.insets = new Insets(5, 0, 5, 0); // Add top and bottom padding
        box.add(nameLabel, gbc);

        return box;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);

        // Set the color to black with transparency
        g.setColor(new Color(0, 0, 0, 128)); // 128 is the alpha value (0-255)
        // Draw a filled rectangle over the entire panel
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    // Custom panel to draw the logo separately
    class LogoPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int logoWidth = logoImage.getIconWidth();
            int logoHeight = logoImage.getIconHeight();
            int x = (getWidth() - logoWidth) / 2;
            int y = (getHeight() - logoHeight) / 2; // Adjusted y-coordinate to center the logo vertically
            g.drawImage(logoImage.getImage(), x, y, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 300); // Set the preferred size for the logo panel
        }
    }
}