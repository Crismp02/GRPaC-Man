import io.grpc.ManagedChannel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Model extends JPanel implements ActionListener {


    static class PlayerScore {
        public String name;
        public int score;
        public PlayerScore(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
    private ArrayList<PlayerScore> playerScores = new ArrayList<>();
    private JPanel mainPanel; // Main panel to hold different screens
    private CardLayout cardLayout; // CardLayout to manage screens
    private String userName;
    private ManagedChannel channel;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 25;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final int MAX_GHOSTS = 12;
    private final int PACMAN_SPEED = 6;
    private final short levelData[] = {
            0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
            0, 33, 18, 26, 26, 18, 18, 26, 26, 26, 18, 22,  0, 19, 18, 26, 26, 26, 18, 18, 26, 26, 18, 54,  0,
            0, 17, 20,  0,  0, 17, 20,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0, 17, 20,  0,  0, 17, 20,  0,
            0, 17, 20,  0,  0, 17, 20,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0, 17, 20,  0,  0, 17, 20,  0,
            0, 17, 16, 18, 18, 16, 16, 18, 18, 18, 16, 16, 18, 16, 16, 18, 18, 18, 16, 16, 18, 18, 16, 20,  0,
            0, 17, 16, 24, 24, 16, 16, 24, 16, 16, 24, 24, 24, 24, 24, 16, 16, 24, 16, 16, 24, 24, 16, 20,  0,
            0, 17, 20,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0, 17, 20,  0,
            0, 17, 16, 18, 18, 16, 20,  0, 17, 16, 18, 22,  0, 19, 18, 16, 20,  0, 17, 16, 18, 18, 16, 20,  0,
            0, 25, 24, 24, 24, 16, 20,  0, 25, 24, 16, 20,  0, 17, 16, 24, 28,  0, 17, 16, 24, 24, 24, 28,  0,
            0,  0,  0,  0,  0, 17, 20,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0, 17, 20,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0, 17, 20,  0, 33, 18, 24, 16, 18, 16, 24, 18, 54,  0, 17, 20,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0, 17, 20,  0, 17, 20, 19, 16, 16, 16, 22, 17, 20,  0, 17, 20,  0,  0,  0,  0,  0,
            19, 18, 18, 18, 18, 16, 16, 18, 16, 20, 17, 16, 16, 16, 20, 17, 16, 18, 16, 16, 18, 18, 18, 18, 22,
            25, 24, 24, 24, 24, 16, 16, 24, 16, 20, 25, 24, 24, 24, 28, 17, 16, 24, 16, 16, 24, 24, 24, 24, 28,
            0,  0,  0,  0,  0, 17, 20,  0, 17, 16, 18, 18, 18, 18, 18, 16, 20,  0, 17, 20,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0, 17, 20,  0, 17, 16, 24, 24, 24, 24, 24, 16, 20,  0, 17, 20,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0,  0,  0,
            0, 33, 26, 26, 18, 16, 16, 26, 24, 24, 18, 22,  0, 19, 18, 24, 24, 26, 16, 16, 18, 26, 26, 54,  0,
            0, 21,  0,  0, 17, 16, 20,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0, 17, 16, 20,  0,  0, 21,  0,
            0, 25, 22,  0, 17, 16, 16, 26, 18, 18, 16, 24, 26, 24, 16, 18, 18, 26, 16, 16, 20,  0, 19, 28,  0,
            0,  0, 21,  0, 17, 16, 20,  0, 17, 16, 20,  0,  0,  0, 17, 16, 20,  0, 17, 16, 20,  0, 21,  0,  0,
            0, 19, 24, 26, 24, 24, 28,  0, 25, 24, 16, 22,  0, 19, 16, 24, 28,  0, 25, 24, 24, 26, 24, 22,  0,
            0, 21,  0,  0,  0,  0,  0,  0,  0,  0, 17, 20,  0, 17, 20,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
            0, 41, 26, 26, 26, 26, 26, 26, 26, 26, 24, 24, 26, 24, 24, 26, 26, 26, 26, 26, 26, 26, 26, 36,  0,
            0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0

    };

    private final int[] validSpeeds = {1, 2, 3, 4, 6, 8};
    private final int maxSpeed = 6;
    private Dimension d;
    private boolean inGame = true;
    private boolean dying = false;
    private int N_GHOSTS = 12;
    private boolean[] isActive;
    private int lives, score;
    private int[] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    private Image heart;
    private Image up, down, left, right, superUp, superDown, superLeft, superRight, ghost1, ghost2, ghost3, ghost4;
    private int pacman_x, pacman_y, pacmand_x, pacmand_y;
    private int req_dx, req_dy;
    private int currentSpeed = 3;
    private short[] screenData;
    private Timer timer;
    private final Timer powerPelletTimer;

    private boolean canEatGhosts = false;
    private Image[] ghostImages;

    private int timeRemaining; // Tiempo restante en segundos
    private Timer countdownTimer; // Timer para el temporizador

    public Model(ArrayList<String> playerNames, String playerName, ManagedChannel channel, JPanel mainPanel, CardLayout cardLayout) {
        for (Integer i = 0; i < playerNames.size(); i++) {
            PlayerScore player = new PlayerScore(playerNames.get(i), 0);
            playerScores.add(player);
        }

        userName = playerName;
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        loadImages();
        initGhostImages();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);

        initGame();

        powerPelletTimer = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canEatGhosts = false;
                powerPelletTimer.stop();
            }
        });
    }

    private Image resizeImage(Image originalImage, int width, int height) {
        Image resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) resizedImage.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    private void loadImages() {
        down = new ImageIcon("client/src/main/assets/down.gif").getImage();
        up = new ImageIcon("client/src/main/assets/up.gif").getImage();
        left = new ImageIcon("client/src/main/assets/left.gif").getImage();
        right = new ImageIcon("client/src/main/assets/right.gif").getImage();

        superDown = new ImageIcon("client/src/main/assets/superpacman-down.gif").getImage();
        superUp = new ImageIcon("client/src/main/assets/superpacman-up.gif").getImage();
        superLeft = new ImageIcon("client/src/main/assets/superpacman-left.gif").getImage();
        superRight = new ImageIcon("client/src/main/assets/superpacman-right.gif").getImage();

        // Cargar las imágenes de los fantasmas


        ghost1 = resizeImage(new ImageIcon("client/src/main/assets/cyan-fire.png").getImage(), 22, 22);
        ghost2 = resizeImage(new ImageIcon("client/src/main/assets/red-fire.png").getImage(), 22, 22);
        ghost3 = resizeImage(new ImageIcon("client/src/main/assets/orange-fire.png").getImage(), 22, 22);
        ghost4 = resizeImage(new ImageIcon("client/src/main/assets/pink-fire.png").getImage(), 22, 22);


        heart = new ImageIcon("client/src/main/assets/heart.png").getImage();
    }

    private void initVariables() {

        screenData = new short[N_BLOCKS * N_BLOCKS];
        d = new Dimension(100000, 100000);
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeed = new int[MAX_GHOSTS];
        isActive = new boolean[MAX_GHOSTS];
        dx = new int[4];
        dy = new int[4];

        timer = new Timer(40, this);
        timer.start();
    }

    private void playGame(Graphics2D g2d) {

        if (dying) {

            death();

        } else {

            movePacman();
            drawPacman(g2d);
            drawGhosts(g2d);
            moveGhosts(g2d);
            checkMaze();
        }
    }



    private void drawScore(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Score: " + score;
        g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

        for (int i = 0; i < lives; i++) {
            g.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
        }
    }

    private void checkMaze() {

        int i = 0;
        boolean finished = true;

        while (i < N_BLOCKS * N_BLOCKS && finished) {

            if ((screenData[i]) != 0) {
                finished = false;
            }

            i++;
        }

        if (finished) {

            score += 50;

            if (N_GHOSTS < MAX_GHOSTS) {
                N_GHOSTS++;
            }

            if (currentSpeed < maxSpeed) {
                currentSpeed++;
            }

            initLevel();
        }
    }

    private void death() {

        lives--;

        if (lives == 0) {
            inGame = false;
        }

        continueLevel();
    }

    private void moveGhosts(Graphics2D g2d) {

        int pos;
        int count;

        for (int i = 0; i < N_GHOSTS; i++) {

            if (!isActive[i]) {
                continue; // Saltar fantasmas inactivos
            }

            // Asegúrate de que ghost_x y ghost_y están dentro de los límites
            if (ghost_x[i] < 0 || ghost_x[i] >= SCREEN_SIZE || ghost_y[i] < 0 || ghost_y[i] >= SCREEN_SIZE) {
                continue; // Si están fuera de los límites, salta a la siguiente iteración
            }

            if (ghost_x[i] % BLOCK_SIZE == 0 && ghost_y[i] % BLOCK_SIZE == 0) {
                pos = ghost_x[i] / BLOCK_SIZE + N_BLOCKS * (ghost_y[i] / BLOCK_SIZE);

                if (pos < 0 || pos >= screenData.length) {
                    continue; // Si pos está fuera de los límites, salta a la siguiente iteración
                }

                count = 0;

                if ((screenData[pos] & 1) == 0 && ghost_dx[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && ghost_dy[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && ghost_dx[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && ghost_dy[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screenData[pos] & 15) == 15) {
                        ghost_dx[i] = 0;
                        ghost_dy[i] = 0;
                    } else {
                        ghost_dx[i] = -ghost_dx[i];
                        ghost_dy[i] = -ghost_dy[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghost_dx[i] = dx[count];
                    ghost_dy[i] = dy[count];
                }

            }

            ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeed[i]);
            ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeed[i]);


            if (pacman_x > (ghost_x[i] - 12) && pacman_x < (ghost_x[i] + 12)
                    && pacman_y > (ghost_y[i] - 12) && pacman_y < (ghost_y[i] + 12)
                    && inGame) {

                // Si Pac-Man puede comer fantasmas
                if (canEatGhosts) {
                    isActive[i] = false;
                    score += 100; // Sumar 100 puntos
                } else {
                    dying = true; // Pac-Man muere si no puede comer fantasmas
                }
            }


        }
    }

    private void initGhostImages() {
        ghostImages = new Image[MAX_GHOSTS];
        ghostImages[0] = ghost1; // Fantasma 1 (Cyan)
        ghostImages[1] = ghost2; // Fantasma 2 (Rojo)
        ghostImages[2] = ghost3; // Fantasma 3 (Naranja)
        ghostImages[3] = ghost4; // Fantasma 4 (Rosa)
        // Puedes agregar más fantasmas si es necesario
    }

    private void drawGhosts(Graphics2D g2d) {
        for (int i = 0; i < N_GHOSTS; i++) {
            if (isActive[i]) {
                // Dibuja la imagen del fantasma en lugar de un rectángulo
                g2d.drawImage(ghostImages[i % ghostImages.length], ghost_x[i], ghost_y[i], this);
            }
        }
    }


    private void movePacman() {

        int pos;
        short ch;

        if (pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
            pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (pacman_y / BLOCK_SIZE);
            ch = screenData[pos];

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                score++;
            }

            if (ch == 33 || ch == 41 || ch == 54 ||ch == 36  ) {

                if(ch == 33){
                    screenData[pos] = (short) (ch = 19);
                }

                if(ch == 36){
                    screenData[pos] = (short) (ch = 28);
                }
                if(ch == 41){
                    screenData[pos] = (short) (ch = 25);
                }
                if(ch == 54){
                    screenData[pos] = (short) (ch = 22);
                }

                score++;
                canEatGhosts = true;
                powerPelletTimer.start();
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                }
            }

            // Check for standstill
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        }
        pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
    }

    private void drawPacman(Graphics2D g2d) {
        if (canEatGhosts) {
            // Usar las imágenes de Super Pac-Man
            if (req_dx == -1) {
                g2d.drawImage(superLeft, pacman_x + 1, pacman_y + 1, this);
            } else if (req_dx == 1) {
                g2d.drawImage(superRight, pacman_x + 1, pacman_y + 1, this);
            } else if (req_dy == -1) {
                g2d.drawImage(superUp, pacman_x + 1, pacman_y + 1, this);
            } else {
                g2d.drawImage(superDown, pacman_x + 1, pacman_y + 1, this);
            }
        } else {
            // Usar las imágenes normales
            if (req_dx == -1) {
                g2d.drawImage(left, pacman_x + 1, pacman_y + 1, this);
            } else if (req_dx == 1) {
                g2d.drawImage(right, pacman_x + 1, pacman_y + 1, this);
            } else if (req_dy == -1) {
                g2d.drawImage(up, pacman_x + 1, pacman_y + 1, this);
            } else {
                g2d.drawImage(down, pacman_x + 1, pacman_y + 1, this);
            }
        }
    }

    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(new Color(0, 72, 251));
                g2d.setStroke(new BasicStroke(5));


                if ((levelData[i] == 0)) {
                    g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                }

                if (screenData[i] != 33 || screenData[i] != 36 || screenData[i] != 37 || screenData[i] != 38) {

                    if ((screenData[i] & 1) != 0) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 2) != 0) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                    }

                    if ((screenData[i] & 4) != 0) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                                y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 8) != 0) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                                y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 16) != 0) {
                        g2d.setColor(new Color(255, 255, 255));
                        g2d.fillOval(x + 10, y + 10, 5, 5);
                    }

                }
                if (screenData[i] == 33) { // Power Pellet con pared superior izquierda
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(x + 10, y + 10, 9, 9);
                    g2d.setColor(Color.BLUE);
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1); // Pared izquierda
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y); // Pared superior
                }



                if (screenData[i] == 36) { // Power Pellet con pared inferior derecha
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(x + 10, y + 10, 9, 9);
                    g2d.setColor(Color.BLUE);
                    g2d.drawLine(x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y); // Pared derecha
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1); // Pared inferior

                }

                if (screenData[i] == 41 || screenData[i] == 54) { // Power Pellet en la esquina inferior izquierda
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(x + 10, y + 10, 9, 9); // Dibuja la power pellet
                }

                i++;
            }
        }
    }

    private void initGame() {

        lives = 3;
        score = 0;
        timeRemaining = 60;
        initLevel();
        N_GHOSTS = 12;
        currentSpeed = 3;
        req_dx = 0;  // Asegúrate de que req_dx se inicialice a 0
        req_dy = 0;  // Asegúrate de que req_dy se inicialice a 0

        countdownTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timeRemaining > 0){
                    timeRemaining--;
                }

                if (timeRemaining <= 0) {
                    countdownTimer.stop();
                    inGame = false; // Finaliza el juego
                }
            }
        });
        countdownTimer.start();
    }

    private void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }

        continueLevel();
    }

    private void continueLevel() {

        int dx = 1;
        int random;

        for (int i = 0; i < N_GHOSTS; i++) {

            isActive[i] = true;
            ghost_y[i] = (N_BLOCKS / 2) * BLOCK_SIZE; //start position
            ghost_x[i] = (N_BLOCKS / 2) * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            ghostSpeed[i] = validSpeeds[random];

            if (i >= 4) {
                int ghostIndex = (int) (Math.random() * 4); // 0 a 3
                ghostImages[i] = ghostImages[ghostIndex]; // Selecciona una imagen aleatoria
            }

        }

        pacman_x = (N_BLOCKS / 2) * BLOCK_SIZE;  //start position
        pacman_y = 19 * BLOCK_SIZE;
        pacmand_x = 0;    //reset direction move
        pacmand_y = 0;
        req_dx = 0;        // reset direction controls
        req_dy = 0;
        dying = false;
    }

    private void drawTimer(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(255, 0, 0)); // Color rojo para el temporizador
        String timeText = "Tiempo: " + timeRemaining + "s";
        g.drawString(timeText, SCREEN_SIZE / 2 - 50, SCREEN_SIZE + 16); // Ajusta la posición según sea necesario
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        drawScore(g2d);
        drawTimer(g2d);

        if (canEatGhosts) {
            // Dibuja el texto "EAT!" en la parte inferior, al lado de los corazones
            g2d.setColor(Color.YELLOW);
            g2d.setFont(new Font("Arial", Font.BOLD, 24));
            g2d.drawString("EAT!", SCREEN_SIZE / 2 - 30, SCREEN_SIZE / 2); // Ajusta la posición según sea necesario
        }

        if (!inGame) {
            // Dibuja el texto "EAT!" en la parte inferior, al lado de los corazones
            g2d.setColor(Color.CYAN);
            g2d.setFont(new Font("Arial", Font.BOLD, 24));
            g2d.drawString("¡Perdiste! :(", SCREEN_SIZE / 2 - 67, SCREEN_SIZE / 2); // Ajusta la posición según sea necesario
        }

        if (!inGame && timeRemaining <= 0) {
            // Si el tiempo se ha acabado, dibuja el mensaje
            g2d.setColor(Color.cyan); // Color del mensaje
            g2d.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente del mensaje
            String message = "Se acabó el tiempo :(";
            FontMetrics fm = g2d.getFontMetrics();
            int x = (SCREEN_SIZE - fm.stringWidth(message)) / 2; // Centrar horizontalmente
            int y = SCREEN_SIZE / 2; // Centrar verticalmente
            g2d.drawString(message, x, y);
        }

        if (inGame) {
            playGame(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    //controls
    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                }
            }
        }
    }

}
