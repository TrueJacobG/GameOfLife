package game.logic;

import game.button.FieldButton;

import static game.Game.getFields;
import static game.constant.Size.COLS;
import static game.constant.Size.ROWS;

public class GameThread extends Thread {
    private volatile boolean running = true;

    public void run() {
        FieldButton[][] buttons = getFields();
        while (running) {

            boolean[][] newLifeStatuses = new boolean[ROWS][COLS];

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    int numberOfNeighbours = getNumberOfNeighbours(buttons, i, j);
                    if (buttons[i][j].isAlive()) {
                        newLifeStatuses[i][j] = (numberOfNeighbours == 2 || numberOfNeighbours == 3);
                    } else {
                        newLifeStatuses[i][j] = numberOfNeighbours == 3;
                    }
                }
            }

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    buttons[i][j].setLifeStatus(newLifeStatuses[i][j]);
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private int getNumberOfNeighbours(FieldButton[][] buttons, int i, int j) {
        int neighbours = 0;

        if (!isValidCoords(i, j)) {
            return 0;
        }

        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (buttons[x][y].isAlive() && !(x == i && y == j)) {
                    neighbours++;
                }
            }
        }

        return neighbours;
    }

    private boolean isValidCoords(int i, int j) {
        return !(i - 1 == -1 || j - 1 == -1 || i + 1 == ROWS || j + 1 == COLS);
    }

    public void stopThread() {
        running = false;
    }
}
