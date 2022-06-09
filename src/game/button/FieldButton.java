package game.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.constant.Size.*;

public class FieldButton extends JButton implements ActionListener {
    private final boolean changeable;
    private boolean alive = false;

    public FieldButton(int x, int y) {
        this.changeable = !(x == 0 || y == 0 || x == ROWS - 1 || y == COLS - 1);

        if (!changeable) {
            this.setBackground(Color.GRAY);
        } else {
            this.setBackground(Color.WHITE);
        }

        this.setPreferredSize(new Dimension(FIELD_SIZE, FIELD_SIZE));
        this.addActionListener(this);
    }

    public void setLifeStatus(boolean status) {
        if (!changeable) {
            return;
        }
        alive = status;
        repaintField();
    }

    public boolean isAlive() {
        return alive;
    }

    private void repaintField() {
        if (alive) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.WHITE);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            setLifeStatus(!alive);
        }
    }
}
