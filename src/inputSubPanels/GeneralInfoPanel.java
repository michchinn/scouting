package inputSubPanels;

import java.awt.Component;

import javax.swing.*;

/**
 *
 * @author michael
 */
@SuppressWarnings("serial")
public class GeneralInfoPanel extends JPanel {
    
    private final JComboBox position;
    private final String[] positions = {"Goalie","Defender","Shooter","Truss-thrower","Catcher","Passer"};
    
    public GeneralInfoPanel(){
        
        position = new JComboBox(positions);
        Methods.createButtonGroup(this,"Driver Ability");//0,1,2,3,4,5
        Methods.createButtonGroup(this,"Speed");//6,7,8,9,10,11
        Methods.createButtonGroup(this,"Agility");//12,13,14,15,16,17
        Methods.createButtonGroup(this,"Stability");//18,19,20,21,22,23
        Methods.createButtonGroup(this,"Pushing Ability");      
        add(position);
        add(new JLabel());add(new JLabel());add(new JLabel());
        add(new JLabel());add(new JLabel());
        
        setLayout(new SpringLayout());
        SpringUtilities.makeCompactGrid(this, 6, 6, 0, 0, 0, 0);
    }
        public GeneralInfoPanel(int driverAbility,int speed,int agility,int stability,int pushingAbility,String positionS){
        
        position = new JComboBox(positions);
        Methods.createButtonGroup(this,"Driver Ability");//0,1,2,3,4,5
        Methods.createButtonGroup(this,"Speed");//6,7,8,9,10,11
        Methods.createButtonGroup(this,"Agility");//12,13,14,15,16,17
        Methods.createButtonGroup(this,"Stability");//18,19,20,21,22,23
        Methods.createButtonGroup(this,"Pushing Ability");      
        add(position);
        add(new JLabel());add(new JLabel());add(new JLabel());
        add(new JLabel());add(new JLabel());
        
        Component[] comps = this.getComponents();
        
        setLayout(new SpringLayout());
        SpringUtilities.makeCompactGrid(this, 6, 6, 0, 0, 0, 0);
    }
    public String getPosition(){
    	return (String) position.getSelectedItem();
    }
    public int getSpeed(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponents()[i+7];
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public int getAgility(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponents()[i+13];
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public int getPushingAbility(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponents()[i+19];
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public int getStability(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponents()[i+25];
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
}
