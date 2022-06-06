package game;

import game.button.Field;

import javax.swing.*;
import java.awt.*;

import static game.constant.ScreenSize.*;

public class Game {
    public static void run(){
        JFrame frame = new JFrame();

        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel screen = new JPanel(new GridLayout(ROWS,COLS));
        JButton[][] buttons = new JButton[ROWS][COLS];

        for(int i = 0; i < ROWS; i++){
            JButton[] row = new JButton[COLS];
            for(int j = 0; j < COLS; j++){
                row[j] = new Field(String.valueOf(i*j));
            }
            buttons[i] = row;
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                screen.add(buttons[i][j]);
            }
        }

        frame.add(screen);
        frame.setVisible(true);
    }
}
