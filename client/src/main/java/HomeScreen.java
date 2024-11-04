import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import pacman.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeScreen extends JFrame {
    private JPanel mainPanel; // Main panel to hold different screens
    private CardLayout cardLayout; // CardLayout to manage screens
    private String userName;
    private Clip backgroundMusic;

    private ManagedChannel channel;
    private LobbyServiceGrpc.LobbyServiceBlockingStub blockingStub;
    private TopScoresResponse topScores;

    public void leaveLobby() {
        LeaveRequest request = LeaveRequest.newBuilder().setPlayerName(userName).build();
        LeaveResponse response;
        try {
            response = blockingStub.leaveLobby(request);
            System.out.println(response.getMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("Failed to leave lobby: " + e.getStatus());
        }
    }

    public HomeScreen() {
        initializeGrpc();
        getTopScores();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (userName != null && !userName.isEmpty()) {
                    leaveLobby(); // Call the leaveLobby method when the window is closing
                }
                channel.shutdown();
                dispose(); // Dispose of the frame
            }
        });

        setTitle("Pac-Man GRPC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);


        // Add the BackgroundPanel (home screen)
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        mainPanel.add(backgroundPanel, "Home");

        // Add main panel to the JFrame
        add(mainPanel);

        // Maximize the window to fill the entire screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);

        playBackgroundMusic("client/src/main/assets/pacman_theme.wav");
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

    private void initializeGrpc() {
        String target = "localhost:9090"; // Change this to your server address
        channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        blockingStub = LobbyServiceGrpc.newBlockingStub(channel);
    }

    public void getTopScores() {
        // Create a request
        TopScoresRequest request = TopScoresRequest.newBuilder()
                .build(); // Add any necessary fields to the request

        try {
            // Call the GetTopScores method
            topScores = blockingStub.getTopScores(request);
            // Process the response
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    private ArrayList<String> joinLobby() {
        JoinRequest request = JoinRequest.newBuilder().setPlayerName(userName).build();
        try {
            JoinResponse response = blockingStub.joinLobby(request);
            System.out.println(response.getMessage());
            ArrayList<String> players = new ArrayList<>();
            for (Integer i = 0; i < response.getPlayersList().size(); i++){
                players.add(response.getPlayersList().get(i));
            }
            return players;
        } catch (Exception e) {
            System.out.println("Failed to join lobby: " + e.getMessage());
        }
        return null;
    }

    // Custom JPanel class to draw the GIF as a background
    class BackgroundPanel extends JPanel {
        private ImageIcon backgroundImage;
        private ImageIcon logoImage;
        private ImageIcon highestScoreImage; // New ImageIcon for the left-side image
        private PlaceholderTextField inputField; // Use the custom text field
        private JButton submitButton;
        private ImageIcon buttonImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon("client/src/main/assets/pacman.gif");
            logoImage = new ImageIcon("client/src/main/assets/logo.png");
            buttonImage = new ImageIcon("client/src/main/assets/submit_button.png");
            highestScoreImage = new ImageIcon("client/src/main/assets/highest_scores.png"); // Load your side image

            // Create the input field with a placeholder
            inputField = new PlaceholderTextField("Enter your name...");
            inputField.setPreferredSize(new Dimension(400, 100)); // Increase width and height for the input field

            // Create the button with the image
            submitButton = new JButton(buttonImage);
            submitButton.setBorderPainted(false); // Remove border
            submitButton.setContentAreaFilled(false); // Make the button transparent
            submitButton.setFocusPainted(false); // Remove focus border
            submitButton.setPreferredSize(new Dimension(buttonImage.getIconWidth(), buttonImage.getIconHeight())); // Set the preferred size of the button

            // Set the cursor to a hand cursor when hovering over the button
            submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // Add action listener to the submit button
            submitButton.addActionListener(e -> {
                if (inputField.getText() != null && !inputField.getText().isEmpty()) {
                    userName = inputField.getText(); // Store the user's name
                    System.out.println("Username: " + userName); // Print the name to the console (for testing)
                    ArrayList<String> players = joinLobby();
                    // Add the LobbyScreen
                    LobbyScreen lobbyScreen = new LobbyScreen(players, userName, channel, mainPanel, cardLayout);
                    mainPanel.add(lobbyScreen, "Lobby");
                    cardLayout.show(mainPanel, "Lobby"); // Switch to the Lobby screen
                    stopBackgroundMusic();
                }
            });

            // Create a panel for the input and button
            JPanel inputPanel = new JPanel();
            inputPanel.setOpaque(false);
            inputPanel.setLayout(new FlowLayout());
            inputPanel.add(inputField);
            inputPanel.add(submitButton);

            // Set the layout of the main panel to BoxLayout
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // Add the logo and input panel to the main panel
            add(Box.createVerticalGlue());
            LogoPanel logoPanel = new LogoPanel();
            logoPanel.setOpaque(false);
            add(logoPanel);

            // Add a rigid area to reduce spacing between logo and input
            add(Box.createRigidArea(new Dimension(0, 10))); // Adjust the height to your liking

            add(inputPanel);
            add(Box.createRigidArea(new Dimension(0, 10))); // Add space between input and image

            // Create a panel for the side image with left margin
            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the side image with a left margin
                    g.drawImage(highestScoreImage.getImage(), 60, 0, this); // 60px margin from the left
                }
            };
            imagePanel.setPreferredSize(new Dimension(400, 1)); // Adjusted height to 100
            imagePanel.setOpaque(false); // Make it transparent to see the background
            add(imagePanel); // Add the image panel to the main panel

// Create a panel for the score boxes
            JPanel scorePanel = new JPanel();
            scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS)); // Use BoxLayout for horizontal alignment
            scorePanel.setOpaque(false); // Make it transparent

// Create the score boxes
            Color[] borderColors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.PINK};
            String[] numbers = {"1st", "2nd", "3rd", "4th", "5th"};
            for (int i = 0; i < topScores.getScoresCount(); i++) {
                JPanel box = new JPanel();
                box.setBackground(Color.BLACK);
                box.setBorder(BorderFactory.createLineBorder(borderColors[i], 10)); // 10px border
                box.setLayout(new GridBagLayout()); // Use GridBagLayout for centering

                // Set preferred, minimum, and maximum size for the box
                box.setPreferredSize(new Dimension(200, 250)); // Width of 200 and height of 250
                box.setMinimumSize(new Dimension(200, 250)); // Enforce minimum size
                box.setMaximumSize(new Dimension(200, 250)); // Enforce maximum size

                // Create number label
                JLabel numberLabel = new JLabel(numbers[i], SwingConstants.CENTER);
                numberLabel.setForeground(borderColors[i]); // Set text color to white
                numberLabel.setFont(new Font("Arial", Font.BOLD, 42)); // Set font size

                // Create name label
                JLabel nameLabel = new JLabel(topScores.getScores(i).getPlayerName(), SwingConstants.CENTER);
                nameLabel.setForeground(Color.WHITE); // Set text color to white
                nameLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font size

                // Create score label
                JLabel scoreLabel = new JLabel(String.valueOf(topScores.getScores(i).getScore()), SwingConstants.CENTER);
                scoreLabel.setForeground(Color.WHITE); // Set text color to white
                scoreLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size

                // Create a GridBagConstraints object to position the labels
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
                gbc.anchor = GridBagConstraints.CENTER; // Center the components
                gbc.weighty = 1; // Allow the components to take up vertical space

// Add the number label
                gbc.gridx = 0; // Column 0
                gbc.gridy = 0; // Row 0
                gbc.insets = new Insets(20, 0, 5, 0); // Add top and bottom padding
                box.add(numberLabel, gbc);

// Add the name label
                gbc.gridy = 1; // Row 1
                gbc.insets = new Insets(5, 0, 5, 0); // Add top and bottom padding
                box.add(nameLabel, gbc);

// Add the score label
                gbc.gridy = 2; // Row 2
                gbc.insets = new Insets(5, 0, 10, 0); // Add top padding and more bottom padding
                box.add(scoreLabel, gbc);

                // Add the box to the score panel
                scorePanel.add(box);

                // Add a horizontal gap between boxes
                if (i < 4) { // Avoid adding a gap after the last box
                    scorePanel.add(Box.createRigidArea(new Dimension(50, 0))); // 50 pixels horizontal gap
                }
            }

// Add the score panel to the main panel
            add(scorePanel);
            add(Box.createVerticalGlue());
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

    // Method to stop the background music
    private void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop(); // Stop the music
        }
    }

    // Custom JTextField class to support placeholder text
    class PlaceholderTextField extends JTextField {
        private String placeholder;
        private Font placeholderFont; // Declare a Font variable for the placeholder

        public PlaceholderTextField(String placeholder) {
            this.placeholder = placeholder;

            // Set the placeholder font (size 20, bold)
            placeholderFont = new Font("Arial", Font.BOLD, 20);
            setFont(placeholderFont); // Set the same font for the text field
            setForeground(Color.GRAY); // Set placeholder color
            setOpaque(false); // Make the text field transparent
            setBorder(BorderFactory.createEmptyBorder()); // Remove default border

            // Set padding (left, top, right, bottom)
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 10, 0, 0), // Left padding of 10 pixels
                    BorderFactory.createLineBorder(Color.GRAY, 1) // Optional: Add a border if desired
            ));

            // Set the text color for user input
            setForeground(Color.BLACK); // Change this color to your desired input text color
        }

        @Override
        protected void paintComponent(Graphics g) {
            // Cast Graphics to Graphics2D for better control
            Graphics2D g2d = (Graphics2D) g;

            // Enable anti-aliasing for smoother edges
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw a semi-transparent white background with rounded corners
            g2d.setColor(new Color(255, 255, 255, 200)); // RGBA: white with 200 alpha for transparency
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Draw rounded rectangle for background

            super.paintComponent(g); // Call the superclass method to draw the text

            // Draw the placeholder text if the field is empty
            if (getText().isEmpty()) {
                g2d.setColor(Color.GRAY); // Set color for placeholder text
                g2d.setFont(placeholderFont); // Set the placeholder font
                g2d.drawString(placeholder, 15, getHeight() / 2 + g2d.getFontMetrics().getAscent() / 2 - 2);
            }
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(Color.GRAY); // Change this to your desired border color
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2)); // Set the thickness of the border
            g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Draw rounded rectangle
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 60); // Set preferred size if needed
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);
    }
}