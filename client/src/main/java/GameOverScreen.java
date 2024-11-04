import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import pacman.LeaveRequest;
import pacman.LeaveResponse;
import pacman.LobbyServiceGrpc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GameOverScreen extends JPanel {
    static class PlayerScore {
        public String name;
        public int score;
    }
    private ImageIcon backgroundImage;
    private ImageIcon logoImage;
    private ImageIcon startButtonImage;
    private LobbyServiceGrpc.LobbyServiceBlockingStub blockingStub;
    private String userName;
    private JPanel mainPanel; // Main panel to hold different screens
    private CardLayout cardLayout;

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

    public GameOverScreen(String userName, ManagedChannel channel, ArrayList<PlayerScore> playerScores, JPanel mainPanel, CardLayout cardLayout) {
        this.userName = userName;
        blockingStub = LobbyServiceGrpc.newBlockingStub(channel);
        this.mainPanel = mainPanel; // Store reference to main panel
        this.cardLayout = cardLayout; // Store reference to card layout

        // Load the images
        backgroundImage = new ImageIcon("client/src/main/assets/pacman.gif");
        logoImage = new ImageIcon("client/src/main/assets/logo.png");
        startButtonImage = new ImageIcon("client/src/main/assets/go_back.png"); // Load the start button image

        // Set the layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false); // Make the panel transparent

        // Add the logo panel
        LogoPanel logoPanel = new LogoPanel();
        logoPanel.setOpaque(false);
        add(logoPanel);

        // Add a rigid area for spacing
        add(Box.createRigidArea(new Dimension(0, 20))); // Adjust the height to your liking

        // Add "Game Over" label
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
            gameOverLabel.setForeground(Color.white); // Set text color to red
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Set font size
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label
        add(gameOverLabel);

        // Add another rigid area for spacing
        add(Box.createRigidArea(new Dimension(0, 20))); // Space between the label and the boxes

        // Add a panel for the boxes
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the boxes
        boxPanel.setOpaque(false); // Make it transparent

        // Define box properties
        String[] numbers = {"1st", "2nd", "3rd", "4th"};
        String[] names = {"Player 1", "Player 2", "Player 3", "Player 4"};
        String[] imagePaths = {
                "client/src/main/assets/ghost_1.png", // Replace with actual image paths
                "client/src/main/assets/ghost_2.png",
                "client/src/main/assets/ghost_3.png",
                "client/src/main/assets/ghost_4.png"
        };
        Color[] borderColors = {Color.RED, Color.YELLOW, Color.CYAN, Color.PINK}; // Different colors for the borders
        String[] scores = {"100", "200", "150", "250"}; // Replace with actual scores

        playerScores.sort(Comparator.comparingInt(ps -> ps.score));

        // Create boxes
        for (int i = 0; i < playerScores.size(); i++) {
            JPanel box = createBox(borderColors[i], imagePaths[i], playerScores.get(i).name, numbers[i], String.valueOf(playerScores.get(i).score)); // Pass the score
            boxPanel.add(box);
            boxPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Space between boxes
        }

        // Add the box panel to the lobby screen
        add(boxPanel);

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
            leaveLobby();
            channel.shutdown();
            cardLayout.show(mainPanel, "Home");
        });
        add(startButton);
    }

    private JPanel createBox(Color borderColor, String imagePath, String name, String rank, String score) {
        JPanel box = new JPanel();
        box.setBackground(Color.BLACK); // Set the background color of the box to black
        box.setBorder(BorderFactory.createLineBorder(borderColor, 10)); // Set border color
        box.setLayout(new GridBagLayout()); // Use GridBagLayout for centering

        // Set preferred, minimum, and maximum size for the box
        box.setPreferredSize(new Dimension(300, 500)); // Width of 300 and height of 500
        box.setMinimumSize(new Dimension(300, 500)); // Enforce minimum size
        box.setMaximumSize(new Dimension(300, 500)); // Enforce maximum size

        // Load the image
        ImageIcon icon = new ImageIcon(imagePath); // Use the provided image path
        JLabel imageLabel = new JLabel(icon, SwingConstants.CENTER);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the image

        // Create name label
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE); // Set text color to white
        nameLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Set font size

        // Create rank label
        JLabel rankLabel = new JLabel(rank, SwingConstants.CENTER);
        rankLabel.setForeground(borderColor); // Set text color to white
        rankLabel.setFont(new Font("Arial", Font.BOLD, 42)); // Set font size for rank

        // Create score label
        JLabel scoreLabel = new JLabel(score, SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE); // Set text color to white
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size for score

        // Create a GridBagConstraints object to position the labels
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.anchor = GridBagConstraints.CENTER; // Center the components
        gbc.weighty = 1; // Allow the components to take up vertical space

        // Add the rank label
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.insets = new Insets(10, 0, 5, 0); // Add top and bottom padding
        box.add(rankLabel, gbc);

        // Add the image label
        gbc.gridy = 1; // Row 1
        gbc.insets = new Insets(20, 0, 5, 0); // Add top and bottom padding
        box.add(imageLabel, gbc);

        // Add the name label
        gbc.gridy = 2; // Row 2
        gbc.insets = new Insets(5, 0, 5, 0); // Add top and bottom padding
        box.add(nameLabel, gbc);

        // Add the score label
        gbc.gridy = 3; // Row 2
        gbc.insets = new Insets(5, 0, 5, 0); // Add top and bottom padding
        box.add(scoreLabel, gbc);

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