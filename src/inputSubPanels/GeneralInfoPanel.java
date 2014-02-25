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
        Methods.createButtonGroup(this,"Maneuverability");//12,13,14,15,16,17
        Methods.createButtonGroup(this,"Stability");//18,19,20,21,22,23
        Methods.createButtonGroup(this,"Pushing Ability");      
        add(position);
        add(new JLabel());add(new JLabel());add(new JLabel());
        add(new JLabel());add(new JLabel());
        
        //setBackground(fullapp.EventOverviewWindow.daisyLightBlue);
        
        setLayout(new SpringLayout());
        SpringUtilities.makeCompactGrid(this, 6, 6, 0, 0, 0, 0);
    }
    public String getPosition(){
    	return (String) position.getSelectedItem();
    }
    public void setPosition(String position){
    	this.position.setSelectedItem(position);
    }   
    public int getDriverAbility(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+1);
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public void setDriverAbility(int driverAbility){
    	if(driverAbility != 0){
    		JRadioButton b = (JRadioButton)this.getComponent(driverAbility);
    		b.setSelected(true);
    	}
    }
    public int getSpeed(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+7);
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public void setSpeed(int speed){
    	if(speed != 0){
    		JRadioButton b = (JRadioButton)this.getComponent(speed+6);
    		b.setSelected(true);
    	}
    }
    public int getManeuverability(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+13);
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public void setManeuverability(int maneuverability){
    	if(maneuverability != 0){
    		JRadioButton b = (JRadioButton)this.getComponent(maneuverability+12);
    		b.setSelected(true);
    	}
    }
    public int getStability(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+19);
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public void setStability(int stability){
    	if(stability != 0){
    		JRadioButton b = (JRadioButton)this.getComponent(stability+18);
    		b.setSelected(true);
    	}
    }
    public int getPushingAbility(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+25);
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public void setPushingAbility(int pushingAbility){
    	if(pushingAbility != 0){
    		JRadioButton b = (JRadioButton)this.getComponent(pushingAbility+24);
    		b.setSelected(true);
    	}
    }
}
