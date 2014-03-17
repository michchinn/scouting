package inputSubPanels;

import javax.swing.*;

/**
 *
 * @author michael
 */
@SuppressWarnings("serial")
public class GeneralInfoPanel extends JPanel {
    
    private final JComboBox position;
    private final String[] positions = {"Offensive","Midfielder","Defensive","Goalie"};
    
    public GeneralInfoPanel(){
        
        position = new JComboBox(positions);
        add(position);add(new JLabel());add(new JLabel());
        add(new JLabel());add(new JLabel()); add(new JLabel());
        Methods.createButtonGroup(this,"Speed");//0,1,2,3,4,5
        Methods.createButtonGroup(this,"Driver Ability");//6,7,8,9,10,11
        Methods.createButtonGroup(this,"Stability");//12,13,14,15,16,17
        Methods.createButtonGroup(this,"Pushing Ability");//18,19,20,21,22,23

        //setBackground(fullapp.EventOverviewWindow.daisyLightBlue);
        
        setLayout(new SpringLayout());
        SpringUtilities.makeCompactGrid(this, 5, 6, 0, 0, 0, 0);
    }
    public String getPosition(){
    	return (String) position.getSelectedItem();
    }
    public void setPosition(String position){
    	this.position.setSelectedItem(position);
    }   
    public int getSpeed(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+1+6);
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
    public int getDriverAbility(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+7+6);
    		if(b.isSelected())
    			return i + 1;
    	}
    	return 0;
    }
    public void setDriverAbility(int driverAbility){
    	if(driverAbility != 0){
    		JRadioButton b = (JRadioButton)this.getComponent(driverAbility+6+6);
    		b.setSelected(true);
    	}
    }
    public int getStability(){
    	for( int i = 0; i < 5; i++ ){
    		JRadioButton b = (JRadioButton)this.getComponent(i+1+18);
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
    		JRadioButton b = (JRadioButton)this.getComponent(i+1+24);
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
