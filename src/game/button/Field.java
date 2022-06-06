package game.button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JButton implements ActionListener {
    private int id = 0;

    public Field(String number){
        id=Integer.parseInt(number);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this){
            System.out.println(id);
        }
    }
}
