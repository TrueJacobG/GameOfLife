package game;

import game.button.ClearWindowButton;
import game.button.ExitButton;
import game.button.FieldButton;
import game.button.RunGameButton;

import javax.swing.*;
import java.awt.*;

import static game.constant.Size.*;

public class Game {
    private static FieldButton[][] fields;

    public Game() {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Game of Life");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel screen = new JPanel();
        screen.setLayout(new BoxLayout(screen, BoxLayout.Y_AXIS));

        JPanel grid = new JPanel(new GridLayout(ROWS, COLS));

        fields = new FieldButton[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            FieldButton[] row = new FieldButton[COLS];
            for (int j = 0; j < COLS; j++) {
                row[j] = new FieldButton(i, j);
            }
            fields[i] = row;
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid.add(fields[i][j]);
            }
        }

        JPanel menu = new JPanel();
        menu.add(new RunGameButton());
        menu.add(new ClearWindowButton());
        menu.add(new ExitButton());

        screen.add(grid);
        screen.add(menu);

        frame.add(screen);
        frame.setVisible(true);
    }

    public static FieldButton[][] getFields() {
        return fields;
    }
}
