package inputSubPanels;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author michael
 */
@SuppressWarnings("serial")
public class PenaltyPanel extends JPanel {
    
    private JTextField lostPoints;
    private JTextArea penaltyA;
    public JPanel subPanel;

    public PenaltyPanel(){
        
        subPanel = new JPanel();
        subPanel.add(new JLabel("Penalties"));
        subPanel.add(new JLabel(""));
        lostPoints = new JTextField(4);
        subPanel.add(new JLabel("Enter points lost"));
        subPanel.add(lostPoints);
        subPanel.setLayout(new GridLayout(2,2));
        add(subPanel);
        penaltyA = new JTextArea("Enter penalties here");
        
        Methods.clearAndResetText(penaltyA,penaltyA.getText());
        
        add(penaltyA);
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        
    }
    
    public int getPenaltyPoints(){
        return Integer.parseInt(lostPoints.getText());
    }
    public String getPenalties(){
        return penaltyA.getText();
    }
    
}
