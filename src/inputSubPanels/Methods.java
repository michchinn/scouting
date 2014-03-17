package inputSubPanels;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.*;

import javax.swing.*;
import javax.swing.text.*;

import org.json.simple.*;

import fullapp.MatchRecord;
/**
 *
 * @author michael
 */
public class Methods {
    
    public static void createButtonGroup(JPanel panel, String label){
        ButtonGroup bg = new ButtonGroup();
        panel.add(new JLabel(label));
        for( Integer i = 1; i <= 5; i++ ){
            JRadioButton b = new JRadioButton(i.toString());
            bg.add(b);
            panel.add(b);
        }  
    }

    public static void clearAndResetText(final JTextComponent t, final String label){
        t.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
                if(t.getText().equals(label))
                    t.setText("");
            }

			public void mouseExited(MouseEvent e) {
                if( t.getText().equals("") || (t.getText().equals(" ") && t.getCaret() == null)){
                    t.setText(label);
                }
            }
            
        });
    }

    /**
     *
     * @param panel
     * @param label
     * @param b1
     * @param b2
     */
    public static void addYNBG(JPanel panel,String label,String b1, String b2){
        panel.add(new JLabel(label));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton y = new JRadioButton(b1);
        JRadioButton n = new JRadioButton(b2);
        bg.add(y);bg.add(n);
        panel.add(y);panel.add(n);
    }
}
