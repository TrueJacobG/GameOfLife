package game.button;

import game.logic.GameThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunGameButton extends JButton implements ActionListener {
    private String title = "Run Game";
    private Color color = Color.GREEN;
    private static GameThread gameThread = new GameThread();

    public RunGameButton(){
        this.setText(title);
        this.setBackground(color);
        this.setFocusable(false);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this){
            if(title.equals("Run Game")){
                title = "Stop";
                color = Color.RED;
                gameThread.start();
            } else {
                title = "Run Game";
                color = Color.GREEN;
                gameThread.running = false;
            }
            this.setText(title);
            this.setBackground(color);
        }
    }
}
