package game.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.constant.Size.FIELD_SIZE;

public class FieldButton extends JButton implements ActionListener {
    private int x = 0;
    private int y = 0;
    private Color color = Color.WHITE;

    public FieldButton(int x, int y) {
        this.x = x;
        this.y = y;
        this.setBackground(color);
        this.setPreferredSize(new Dimension(FIELD_SIZE, FIELD_SIZE));
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.printf("x: %d y: %d \n", x, y);
            if (color == Color.WHITE) {
                color = Color.BLACK;
            } else {
                color = Color.WHITE;
            }
            this.setBackground(color);
        }
    }
}
