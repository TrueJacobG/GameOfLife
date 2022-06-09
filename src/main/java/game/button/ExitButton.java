package game.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {
    public ExitButton() {
        this.setText("Exit");
        this.setBackground(Color.ORANGE);
        this.setFocusable(false);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.exit(0);
        }
    }
}

