package com.TicTacToe.TicTacToe;

import com.TicTacToe.GetAndSetHighScore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static com.TicTacToe.JFrameMain.jFrame;

/**
 * Tic-Tac-Toe: Two-player Graphics version with Simple-OO
 */
@SuppressWarnings("serial")
public class Play2Players extends JFrame {
    public static int newRow ;
    public static int rowPreSelected = -1;
    public static int colPreSelected = -1;
    public static int rowPreDiLai;
    public static int colPreDiLai;
    // Named-constants for the game board
    public static  int ROWS ;  // ROWS by COLS cells
    public static  int COLS ;
    private static String Player1Name;
    private static String Player2Name;
    public static int STEPS=0;

    // Named-constants of the various dimensions used for graphics drawing
    public static  int CELL_SIZE = 100; // cell width and height (square)
    public static  int CANVAS_WIDTH = CELL_SIZE * COLS;  // the drawing canvas
    public static  int CANVAS_HEIGHT = CELL_SIZE * ROWS;
    public static  int GRID_WIDTH = 2;                   // Grid-line's width
    public static  int GRID_WIDHT_HALF = GRID_WIDTH / 2; // Grid-line's half-width
    // Symbols (cross/nought) are displayed inside a cell, with padding from border
    public static  int CELL_PADDING = CELL_SIZE / 6;
    public static  int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2; // width/height
    public static  int SYMBOL_STROKE_WIDTH = 8; // pen's stroke width

    // Use an enumeration (inner class) to represent the various states of the game
    private GameState currentState;  // the current game state
    private Seed currentPlayer;
    // Use an enumeration (inner class) to represent the seeds and cell contents
    // the current player
    private Seed PlayerReRun;

    private Board board;    // Game board of ROWS-by-COLS cells
    private DrawCanvas canvas; // Drawing canvas (JPanel) for the game board
    private JLabel statusBar;  // Status Bar
    private JPanel pnButton;
    private Button btnDiLai;
    private Button btnBoDiLai;

    public Play2Players(String name1, String name2) {
        STEPS =0 ;
        PlayGame(name1,name2);
    }
//    private static Play2Players instance;
//    public static Play2Players getInstance(String name1,String name2) {
//        if(instance == null) {
//            instance = new Play2Players(name1, name2);
//        }
//        return instance;
//    }

    // Set up lại kích cỡ bàn cờ.
    public void SetUpBoard(int row){
        ROWS = row;
        COLS = row;
        CELL_SIZE = (30/row) *20;
        CANVAS_WIDTH = CELL_SIZE * COLS;
        CANVAS_HEIGHT = CELL_SIZE * ROWS;
        CELL_PADDING = CELL_SIZE / 6;
        SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    }

    public void PlayGame(String name1, String name2){
        SetUpBoard(newRow);
        Player1Name = name1;
        Player2Name = name2;
        canvas = new DrawCanvas();  // Construct a drawing canvas (a JPanel)
                canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

                // The canvas (JPanel) fires a MouseEvent upon mouse-click
                canvas.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {  // mouse-clicked handler
                int mouseX = e.getX();
                int mouseY = e.getY();
                // Get the row and column clicked
                int rowSelected = mouseY / CELL_SIZE;
                int colSelected = mouseX / CELL_SIZE;
                //nếu trạng thái là đang chơi thì có phép người chơi đánh cờ
                if (currentState == GameState.DangChoi) {
                    if (rowSelected >= 0 && rowSelected < ROWS
                            && colSelected >= 0 && colSelected < COLS
                            && board.cells[rowSelected][colSelected].giaTri == Seed.Trong) {
                        rowPreSelected = rowSelected;
                        colPreSelected = colSelected;
                        board.cells[rowSelected][colSelected].giaTri = currentPlayer; // Make a move
                        updateGame(currentPlayer, rowSelected, colSelected); // update state
                        // Switch player
                        currentPlayer = (currentPlayer == Seed.Quan_X) ? Seed.Quan_O : Seed.Quan_X;
                        STEPS++;
                    }
                    btnDiLai.setEnabled(true);
                    btnBoDiLai.setEnabled(false);
                } else {       // game over
                    initGame(); // restart the game
                }
                // Refresh the drawing canvas
                repaint();  // Call-back paintComponent().
            }
        });

        // Setup the status bar (JLabel) to display status message
        statusBar = new JLabel("  ");
        statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        statusBar.setOpaque(true);
        statusBar.setBackground(Color.LIGHT_GRAY);
        //Thêm Button
        btnDiLai = new Button("Đi lại");
        btnDiLai.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        btnDiLai.setEnabled(false);
        btnDiLai.setSize(10,10);

        btnDiLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentState != GameState.DangChoi) return;
                if(STEPS==0) return;
                rowPreDiLai =rowPreSelected;
                colPreDiLai =colPreSelected;
                PlayerReRun = board.cells[rowPreSelected][colPreSelected].giaTri;
                currentPlayer = PlayerReRun;
                board.cells[rowPreSelected][colPreSelected].giaTri = Seed.Trong;
                btnBoDiLai.setEnabled(true);
                btnDiLai.setEnabled(false);
                repaint();
            }
        });

        btnBoDiLai = new Button("Bỏ đi lại");
        btnBoDiLai.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        btnBoDiLai.setEnabled(false);
        //btnDiLai.setSize(10,10);

        btnBoDiLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentState != GameState.DangChoi) return;
                if(STEPS == 0 || PlayerReRun == null ) return;
                board.cells[rowPreDiLai][colPreDiLai].giaTri = PlayerReRun;
                currentPlayer = (currentPlayer == Seed.Quan_X) ? Seed.Quan_O : Seed.Quan_X;
                btnBoDiLai.setEnabled(false);
                repaint();
            }
        });

        pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnButton.add(btnDiLai);
        pnButton.add(btnBoDiLai);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(statusBar, BorderLayout.PAGE_END); // same as SOUTH
        cp.add(pnButton, BorderLayout.PAGE_START);

        pack();  // pack all the components in this JFrame
        setTitle("Cờ ca rô 2 người");
        setLocationRelativeTo(null);
        setVisible(true);  // show this JFrame

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                jFrame.setVisible(true);
            }
        });

        board = new Board(); // allocate array
        initGame(); // initialize the game board contents and game variables
    }

    /** Initialize the game-board contents and the current-state */
    public void initGame() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                board.cells[row][col].giaTri = Seed.Trong; // all cells empty
            }
        }
        currentState = GameState.DangChoi;  // ready to play
        int choice = JOptionPane.showConfirmDialog((Component)null, "Người chơi "+Player1Name+" đi trước đúng không?", "Ai là người đi trước?", 0);
        // Neu 0 thi nguoi choi dau di truoc 1 la nguoi choi 2 di truoc
        currentPlayer = choice == 0 ? Seed.Quan_X : Seed.Quan_O;
    }

    /** Update the currentState after the player with "theSeed" has placed on
     (rowSelected, colSelected). */
    public void updateGame(Seed giaTri, int row, int col) {
        if (board.hasWon(giaTri, row, col)) {  // check for win
            currentState = (giaTri == Seed.Quan_X) ? GameState.X_Thang : GameState.O_Thang;

            if(giaTri == Seed.Quan_X){
                try {
                    GetAndSetHighScore.ghiFile(GetAndSetHighScore.FILE_NAME,Player1Name,Player2Name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,Player1Name+" thắng rồi! Click chuột để chơi lại");
            }
            else {

                try {
                    GetAndSetHighScore.ghiFile(GetAndSetHighScore.FILE_NAME,Player2Name,Player1Name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, Player2Name + " thắng rồi! Click chuột để chơi lại");
            }
        } else if (board.isDraw()) {  // check for draw
            currentState = GameState.Hoa;
            JOptionPane.showMessageDialog(null,"Hòa rồi! Click chuột để chơi lại");
        }
        // Otherwise, no change to current state (still GameState.PLAYING).
    }

    public class DrawCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {  // invoke via repaint()
            super.paintComponent(g);    // fill background
            setBackground(Color.WHITE); // set its background color
            board.paint(g);
            // Draw the grid-lines
            g.setColor(Color.LIGHT_GRAY);
            for (int row = 1; row < ROWS; ++row) {
                g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF,
                        CANVAS_WIDTH-1, GRID_WIDTH, GRID_WIDTH, GRID_WIDTH);
            }
            for (int col = 1; col < COLS; ++col) {
                g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0,
                        GRID_WIDTH, CANVAS_HEIGHT-1, GRID_WIDTH, GRID_WIDTH);
            }

            // Draw the Seeds of all the cells if they are not empty
            // Use Graphics2D which allows us to set the pen's stroke


            // Print status-bar message
            if (currentState == GameState.DangChoi) {
                statusBar.setForeground(Color.BLACK);
                if (currentPlayer == Seed.Quan_X) {
                    statusBar.setText("Lượt của "+Player1Name);
                } else {
                    statusBar.setText("Lượt của "+Player2Name);
                }
            } else if (currentState == GameState.Hoa) {
                statusBar.setForeground(Color.RED);
                statusBar.setText("Hòa rồi! Click chuột để chơi lại");
            } else if (currentState == GameState.X_Thang) {
                statusBar.setForeground(Color.RED);
                statusBar.setText(Player1Name+" thắng rồi! Click chuột để chơi lại");
            } else if (currentState == GameState.O_Thang) {
                statusBar.setForeground(Color.RED);
                statusBar.setText(Player2Name+" thắng rồi! Click chuột để chơi lại");
            }
        }
    }
}
