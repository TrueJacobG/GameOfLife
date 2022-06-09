package game.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.Game.getFields;
import static game.constant.Size.COLS;
import static game.constant.Size.ROWS;

public class ClearWindowButton extends JButton implements ActionListener {

    public ClearWindowButton() {
        this.setText("Clear");
        this.setBackground(Color.CYAN);
        this.setFocusable(false);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            FieldButton[][] fields = getFields();

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    fields[i][j].setLifeStatus(false);
                }
            }

        }
    }
}
