package game.logic;

import javax.swing.*;

import java.awt.*;

import static game.Game.getButtons;
import static game.constant.Size.COLS;
import static game.constant.Size.ROWS;

public class GameThread extends Thread{

    public boolean running = true;

    public void run(){
        JButton[][] buttons = getButtons();
        while(running){
            for(int i = 0; i < ROWS; i++){
                for(int j = 0; j < COLS; j++){
                    buttons[i][j].setBackground(randomColor());
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private Color randomColor(){
        Color[] colors = {Color.WHITE, Color.GREEN, Color.BLACK, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.CYAN};
        int number = (int) ((Math.random() * (6)));
        return colors[number];
    }
}
