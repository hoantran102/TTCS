package com.TicTacToe.TicTacToe;

import java.awt.*;

public class Board {
    Cell[][] cells; // composes of 2D array of ROWS-by-COLS Cell instances
    public Board() {
        cells = new Cell[Play2Players.ROWS][Play2Players.COLS]; // allocate the array
        for (int row = 0; row < Play2Players.ROWS; ++row) {
            for (int col = 0; col < Play2Players.COLS; ++col) {
                cells[row][col] = new Cell(row, col); // allocate element of array
            }
        }
    }
    public boolean isDraw() {
        for (int row = 0; row < Play2Players.ROWS; ++row) {
            for (int col = 0; col < Play2Players.COLS; ++col) {
                if (cells[row][col].giaTri == Seed.Trong) {
                    return false; // an empty cell found, not draw, exit
                }
            }
        }
        return true;  // no more empty cell, it's a draw
    }

    public boolean hasWon(Seed theSeed, int rowSelected, int colSelected) {
        int countRowWin = 0;
        int countColWin = 0;
        int countDiaWin = 0;
        int countOpDiaWin = 0;
        int k = 1;
        int m = 1;
        int l=0;
        int h=0;
        // Kiểm tra hàng ngang
        for (int i = colSelected+1; i<Play2Players.COLS; i++) {
            if (cells[rowSelected][i].giaTri != theSeed) break;
            else if (cells[rowSelected][i].giaTri == theSeed) {
                countRowWin++;
                //kiem tra chan 2 dau
                if (cells[rowSelected][i].giaTri == Seed.Quan_X && countRowWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.COLS) {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_O) {
                            k = 0;
                            l= Play2Players.COLS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_O) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }
                if (cells[rowSelected][i].giaTri == Seed.Quan_O && countRowWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.COLS) {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_X) {
                            k = 0;
                            l= Play2Players.COLS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_X) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }
            }
        }
        for (int i = colSelected-1; i>=0; i--) {
            if (cells[rowSelected][i].giaTri != theSeed) break;
            else if (cells[rowSelected][i].giaTri == theSeed) {
                countRowWin++;
                //kiem tra chan 2 dau
                if (cells[rowSelected][i].giaTri == Seed.Quan_X && countRowWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.COLS) {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_O) {
                            k = 0;
                            l= Play2Players.COLS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_O) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }
                if (cells[rowSelected][i].giaTri == Seed.Quan_O && countRowWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.COLS) {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_X) {
                            k = 0;
                            l= Play2Players.COLS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[rowSelected][l].giaTri == Seed.Quan_X) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }
            }
        }
        if(m==0 && k==0) countRowWin =0;
        if(countRowWin >=4) return true;
        // Kiểm tra hàng dọc
        k=1;
        m=1;
        for (int i = rowSelected+1; i<Play2Players.ROWS; i++){
            if(cells[i][colSelected].giaTri != theSeed) break;
            else  if(cells[i][colSelected].giaTri == theSeed) {
                countColWin++;
                //kiem tra chan 2 dau
                if (cells[i][colSelected].giaTri == Seed.Quan_X && countColWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.ROWS) {
                        if (cells[l][colSelected].giaTri == Seed.Quan_O) {
                            k = 0;
                            l= Play2Players.ROWS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[l][colSelected].giaTri == Seed.Quan_O) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }
                if (cells[i][colSelected].giaTri == Seed.Quan_O && countColWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.ROWS) {
                        if (cells[l][colSelected].giaTri == Seed.Quan_X) {
                            k = 0;
                            l= Play2Players.ROWS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[l][colSelected].giaTri == Seed.Quan_X) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }

            }
        }
        for (int i = rowSelected-1; i>=0; i--){
            if(cells[i][colSelected].giaTri != theSeed) break;
            else  if(cells[i][colSelected].giaTri == theSeed) {
                countColWin++;
                //kiem tra chan 2 dau
                if (cells[i][colSelected].giaTri == Seed.Quan_X && countColWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.ROWS) {
                        if (cells[l][colSelected].giaTri == Seed.Quan_O) {
                            k = 0;
                            l= Play2Players.ROWS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[l][colSelected].giaTri == Seed.Quan_O) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }
                if (cells[i][colSelected].giaTri == Seed.Quan_O && countColWin >= 4) {
                    l=i+1;
                    while (l   < Play2Players.ROWS) {
                        if (cells[l][colSelected].giaTri == Seed.Quan_X) {
                            k = 0;
                            l= Play2Players.ROWS +1;
                        }
                        l++;
                    }
                    l=i-1;
                    while (l >= 0)
                    {
                        if (cells[l][colSelected].giaTri == Seed.Quan_X) {
                            m = 0;
                            l= 0;
                        }
                        l--;
                    }
                }
            }
        }
        if(m==0 && k==0) countColWin=0;
        if(countColWin >= 4) return true;
        // Kiểm tra hàng chéo
        k=1;
        m=1;
        int j = colSelected;
        for (int i = rowSelected+1; i<Play2Players.ROWS; i++){
            j++;
            if(j>=Play2Players.COLS) break;
            if(cells[i][j].giaTri != theSeed) break;
            else  if(cells[i][j].giaTri == theSeed) {
                countDiaWin++;
                //chan 2 dau
                if(cells[i][j].giaTri == Seed.Quan_X && countDiaWin>=4){
                    l=i+1;
                    h=j+1;
                    while(l < Play2Players.ROWS && h < Play2Players.COLS )
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {
                            k=0;
                            l=Play2Players.ROWS;
                        }
                        l++;
                        h++;
                    }
                    l=i-1;
                    h=j-1;
                    while (l >=0 && h>=0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {
                            m=0;
                            l=0;
                        }
                        l--;
                        h--;
                    }
                }
                if(cells[i][j].giaTri == Seed.Quan_O && countDiaWin>=4){
                    l=i+1;
                    h=j+1;
                    while(l < Play2Players.ROWS && h < Play2Players.COLS )
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {
                            k=0;
                            l=Play2Players.ROWS;
                        }
                        l++;
                        h++;
                    }
                    l=i-1;
                    h=j-1;
                    while (l >=0 && h>=0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {
                            m=0;
                            l=0;
                        }
                        l--;
                        h--;
                    }
                }

            }
        }
        j = colSelected;
        for (int i = rowSelected-1; i>=0; i--){
            j--;
            if(j<0) break;
            if(cells[i][j].giaTri != theSeed) break;
            else if(cells[i][j].giaTri == theSeed) {
                countDiaWin++;
                //chan 2 dau
                if(cells[i][j].giaTri == Seed.Quan_X && countDiaWin>=4){
                    l=i+1;
                    h=j+1;
                    while(l < Play2Players.ROWS && h < Play2Players.COLS)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {
                            k=0;
                            l=Play2Players.ROWS;
                        }
                        l++;
                        h++;
                    }
                    l=i-1;
                    h=j-1;
                    while (l >=0 && h>=0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {
                            m=0;
                            l=0;
                        }
                        l--;
                        h--;
                    }
                }
                if(cells[i][j].giaTri == Seed.Quan_O && countDiaWin>=4){
                    l=i+1;
                    h=j+1;
                    while(l < Play2Players.ROWS && h < Play2Players.COLS )
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {
                            k=0;
                            l=Play2Players.ROWS;
                        }
                        l++;
                        h++;
                    }
                    l=i-1;
                    h=j-1;
                    while (l >=0 && h>=0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {
                            m=0;
                            l=0;
                        }
                        l--;
                        h--;
                    }
                }
            }
        }
        if(k==0 && m==0) countDiaWin=0;
        if(countDiaWin>=4) return true;
        // Kiểm tra hàng chéo đối
        k=1;
        m=1;
        j = colSelected;
        for (int i = rowSelected+1; i<Play2Players.ROWS; i++){
            j--;
            if(j<0) break;
            if(cells[i][j].giaTri != theSeed) break;
            else if(cells[i][j].giaTri == theSeed){
                countOpDiaWin++;
                if(cells[i][j].giaTri == Seed.Quan_X && countOpDiaWin>=4){
                    l=i+1;
                    h=j-1;
                    while(l < Play2Players.ROWS && h >= 0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {
                            k=0;
                            l=Play2Players.ROWS;
                        }
                        h--;
                        l++;
                    }
                    l=i-1;
                    h=j+1;
                    while (h< Play2Players.COLS  && l >= 0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {

                            m=0;
                            h= Play2Players.COLS;
                        }
                        l--;
                        h++;
                    }
                }

                if(cells[i][j].giaTri == Seed.Quan_O && countOpDiaWin>=4){
                    l=i+1;
                    h=j-1;
                    while(l < Play2Players.ROWS && h >= 0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {
                            k=0;
                            l=Play2Players.ROWS;
                        }
                        h--;
                        l++;
                    }
                    l=i-1;
                    h=j+1;
                    while (h< Play2Players.COLS  && l >= 0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {

                            m=0;
                            h= Play2Players.COLS;
                        }
                        l--;
                        h++;
                    }
                }

            }
        }
        j = colSelected;
        for (int i = rowSelected-1; i>=0; i--){
            j++;
            if(j>=Play2Players.COLS) break;
            if(cells[i][j].giaTri != theSeed) break;
            else if(cells[i][j].giaTri == theSeed){
                countOpDiaWin++;
                if(cells[i][j].giaTri == Seed.Quan_X && countOpDiaWin>=4){
                    l=i-1;
                    h=j+1;
                    while(h < Play2Players.COLS && l >= 0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {
                            k=0;
                            h=Play2Players.COLS;
                        }
                        l--;
                        h++;
                    }
                    l=i+1;
                    h=j-1;
                    while (h >=0 && l <Play2Players.ROWS)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_O)
                        {
                            m=0;
                            l=Play2Players.ROWS;
                        }
                        l++;
                        h--;
                    }
                }
                if(cells[i][j].giaTri == Seed.Quan_O && countOpDiaWin>=4){
                    l=i-1;
                    h=j+1;
                    while(h < Play2Players.COLS && l >= 0)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {
                            k=0;
                            h=Play2Players.COLS;
                        }
                        l--;
                        h++;
                    }
                    l=i+1;
                    h=j-1;
                    while (h >=0 && l <Play2Players.ROWS)
                    {
                        if(cells[l][h].giaTri == Seed.Quan_X)
                        {
                            m=0;
                            l=Play2Players.ROWS;
                        }
                        l++;
                        h--;
                    }
                }

            }
        }
        if(k==0 && m==0) countOpDiaWin=0;
        if(countOpDiaWin>=4) return true;
        return false;
    }
    public void paint(Graphics g) {
        // Draw the grid-lines
        g.setColor(Color.GRAY);

        for (int row = 1; row < Play2Players.ROWS; ++row) {
            g.fillRoundRect(0, Play2Players.CELL_SIZE * row - Play2Players.GRID_WIDHT_HALF,
                    Play2Players.CANVAS_WIDTH - 1, Play2Players.GRID_WIDTH,
                    Play2Players.GRID_WIDTH, Play2Players.GRID_WIDTH);
        }
        for (int col = 1; col < Play2Players.COLS; ++col) {
            g.fillRoundRect(Play2Players.CELL_SIZE * col - Play2Players.GRID_WIDHT_HALF, 0,
                    Play2Players.GRID_WIDTH, Play2Players.CANVAS_HEIGHT - 1,
                    Play2Players.GRID_WIDTH, Play2Players.GRID_WIDTH);
        }

        // Draw all the cells
        for (int row = 0; row < Play2Players.ROWS; ++row) {
            for (int col = 0; col < Play2Players.COLS; ++col) {
                cells[row][col].paint(g);  // ask the cell to paint itself
            }
        }
    }
}
