package inputSubPanels;

import javax.swing.*;

/**
 *
 * @author michael
 */
@SuppressWarnings("serial")
public class DefensivePanel extends JPanel{

	public DefensivePanel(){
		Methods.addYNBG(this,"Plays Defense","YES","NO");add(new JLabel(""));add(new JLabel());
        Methods.addYNBG(this,"Avoids Being Pushed","YES","NO");add(new JLabel(""));add(new JLabel());
        Methods.addYNBG(this,"Has Goalie Mechanism","YES","NO");add(new JLabel(""));add(new JLabel());
        Methods.addYNBG(this,"Attempt to Control Oponent's Ball","YES","NO");add(new JLabel(""));add(new JLabel());
                //addYNBG(this,"Mobility Points","YES","NO");add(new JLabel(""));add(new JLabel());
                //addYNBG(this,"Start Zone","WHITE","GOALIE");add(new JLabel(""));add(new JLabel());
                
                setLayout(new SpringLayout());
                SpringUtilities.makeCompactGrid(this, 4, 5, 0, 0, 0, 0);
	}
}

