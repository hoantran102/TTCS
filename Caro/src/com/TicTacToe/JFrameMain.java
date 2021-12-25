package com.TicTacToe;

import com.TicTacToe.TicTacToe.Play2Players;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMain {
    public static JFrame jFrame;
    private JPanel JPanelMain;
    private JButton btnPlay2Players;
    private JTextField txtPlayer1Name;
    private JTextField txtPlayer2Name;
    private JButton btnExit;
    private JButton btnHighScore;
    private JTextField textField1;

    public JFrameMain() {
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnPlay2Players.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Player1Name = txtPlayer1Name.getText();
                String Player2Name = txtPlayer2Name.getText();
                if(Player1Name.isEmpty() || Player2Name.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Bạn chưa nhập tên người chơi!!!");
                    return;
                }
                String k = textField1.getText();
                int row = Integer.parseInt(k);
                if( row<5 || row >30){
                    JOptionPane.showMessageDialog(null,"Bạn phải nhập số dòng, cột nằm trong khoảng" +
                            " giá trị từ 5 đến 30!!!");
                    return;
                }
                else{
                    if(row>=5) {
                        Play2Players.newRow = row;
                        new Play2Players(Player1Name, Player2Name);
                    }
                }
                jFrame.setVisible(false);
            }
        });
        btnHighScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HighScoreForm highScore = new HighScoreForm();
                highScore.CreateAndShow();
                jFrame.setVisible(false);
            }
        });
    }
    public void CreateAndShow(){
        jFrame =new JFrame("Game Ca rô 2 người");
        jFrame.setContentPane(new JFrameMain().JPanelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);

    }
}
