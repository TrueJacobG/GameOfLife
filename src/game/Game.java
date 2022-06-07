package game;

import game.button.FieldButton;
import game.button.RunGameButton;

import javax.swing.*;
import java.awt.*;

import static game.constant.Size.*;

public class Game {
    private static JButton[][] buttons;
    public static JPanel screen;
    public static JPanel grid;
    public static JFrame frame;

    public Game(){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Game of Life");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        screen = new JPanel();
        screen.setLayout(new BoxLayout(screen, BoxLayout.Y_AXIS));
        grid = new JPanel(new GridLayout(ROWS,COLS));
        buttons = new JButton[ROWS][COLS];

        for(int i = 0; i < ROWS; i++){
            JButton[] row = new JButton[COLS];
            for(int j = 0; j < COLS; j++){
                row[j] = new FieldButton(i, j);
            }
            buttons[i] = row;
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                grid.add(buttons[i][j]);
            }
        }

        JPanel menu = new JPanel();
        menu.add(new RunGameButton());

        screen.add(grid);
        screen.add(menu);

        frame.add(screen);
        frame.setVisible(true);
    }

    public static JButton[][] getButtons(){
        return buttons;
    }

    public static JPanel getGrid(){
        return grid;
    }
}
