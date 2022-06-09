package game.button;

import game.logic.GameThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunGameButton extends JButton implements ActionListener {
    private boolean isActive = false;
    private static GameThread gameThread = null;

    public RunGameButton() {
        this.setText("Run Game");
        this.setBackground(Color.GREEN);
        this.setFocusable(false);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            if (isActive) {
                isActive = false;
                this.setText("Resume");
                this.setBackground(Color.GREEN);
                gameThread.stopThread();
            } else {
                isActive = true;
                this.setText("Stop");
                this.setBackground(Color.RED);
                gameThread = new GameThread();
                gameThread.start();
            }
        }
    }
}
