package com.TicTacToe.TicTacToe;

import java.awt.*;

public class Cell {
    // Package access
    Seed giaTri; // content cua moi Cell (Seed.trong, Seed.Quan_X, or Seed.Quan_Y)
    int row, col; // hang va cot cua moi Cell

    /**
     * Constructor to initialize this cell with the specified row and col
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear(); // clear content
    }

    /**
     * Clear this cell's content to EMPTY
     */
    public void clear() {
        giaTri = Seed.Trong;
    }

    /**
     * Paint itself on the graphics canvas, given the Graphics context
     */
    public void paint(Graphics g) {
        // Use Graphics2D which allows us to set the pen's stroke
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(Play2Players.SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));  // Graphics2D only
        int x1 = col * Play2Players.CELL_SIZE + Play2Players.CELL_PADDING;
        int y1 = row * Play2Players.CELL_SIZE + Play2Players.CELL_PADDING;
        if (giaTri == Seed.Quan_X) {//ve quan X gom tu 2 duong cheo voi x1,y1 la toa do diem dau va diem cuoi
            g2d.setColor(Color.RED);
            int x2 = (col + 1) * Play2Players.CELL_SIZE - Play2Players.CELL_PADDING;
            int y2 = (row + 1) * Play2Players.CELL_SIZE - Play2Players.CELL_PADDING;
            g2d.drawLine(x1, y1, x2, y2);
            g2d.drawLine(x2, y1, x1, y2);
        } else if (giaTri == Seed.Quan_O) {//ve quan O
            g2d.setColor(Color.BLUE);
            //ve duong tron thi can 2 toa do diem bat dau va die ket thuc
            g2d.drawOval(x1, y1, Play2Players.SYMBOL_SIZE, Play2Players.SYMBOL_SIZE);
            }
        }
    }

