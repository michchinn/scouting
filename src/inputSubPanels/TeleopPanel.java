package inputSubPanels;

import javax.swing.*;
import static inputSubPanels.Methods.*;

public class TeleopPanel extends JPanel{
	public ShootingPanel m_shootingPanel;
	public ShootingRates m_shootingRates;
	public JComboBox acquiringBallsComboBox;
	
	public TeleopPanel(){
		m_shootingPanel = new ShootingPanel();
		m_shootingRates = new ShootingRates();
		add(m_shootingPanel);
		add(m_shootingRates);
		String[] acquiringBalls = {"Floor Loading","Human Player","Both"};
		acquiringBallsComboBox = new JComboBox(acquiringBalls);
		add(acquiringBallsComboBox);
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
	}
	public int getTopTeleopScored(){
		return Integer.parseInt(m_shootingPanel.ballsScoredTopTeleopText.getText());
	}
	public void setTopTeleopScored(int topTeleopScored){
		m_shootingPanel.ballsScoredTopTeleopText.setText(Integer.toString(topTeleopScored));
	}
	public int getTopTeleopShot(){
		return Integer.parseInt(m_shootingPanel.ballsShotTopTeleopText.getText());
	}
	public void setTopTeleopShot(int topTeleopShot){
		m_shootingPanel.ballsShotTopTeleopText.setText(Integer.toString(topTeleopShot));
	}
	public int getBottomTeleopScored(){
		return Integer.parseInt(m_shootingPanel.ballsScoredBottomTeleopText.getText());
	}
	public void setBottomTeleopScored(int bottomTeleopScored){
		m_shootingPanel.ballsScoredBottomTeleopText.setText(Integer.toString(bottomTeleopScored));
	}
	public int getBottomTeleopShot(){
		return Integer.parseInt(m_shootingPanel.ballsShotBottomTeleopText.getText());
	}
	public void setBottomTeleopShot(int bottomTeleopShot){
		m_shootingPanel.ballsShotBottomTeleopText.setText(Integer.toString(bottomTeleopShot));
	}
	public int getShooterSpeed(){
		for(int i = 0; i < 5; i++ ){
			JRadioButton r = (JRadioButton)m_shootingRates.getComponent(i+1);
			if(r.isSelected())
				return i+1;
		}
		return 0;
	}
	public void setShooterSpeed(int shooterSpeed){
		if(shooterSpeed != 0){
			JRadioButton b = (JRadioButton)m_shootingRates.getComponent(shooterSpeed);
			b.setSelected(true);
		}
	}
	public int getShootingAccuracy(){
		for(int i = 0; i < 5; i++ ){
			JRadioButton r = (JRadioButton)m_shootingRates.getComponent(i+7);
			if(r.isSelected())
				return i+1;
		}
		return 0;
	}
	public void setShooterAccuracy(int shooterAccuracy){
		if(shooterAccuracy != 0){
			JRadioButton b = (JRadioButton)m_shootingRates.getComponent(shooterAccuracy+6);
			b.setSelected(true);
		}
	}
	public int getAcquisitionSpeed(){
		for(int i = 0; i < 5; i++ ){
			JRadioButton r = (JRadioButton)m_shootingRates.getComponent(i+19);
			if(r.isSelected())
				return i+1;
		}
		return 0;
	}
	public void setAcquisitionSpeed(int acquisitionSpeed){
		if(acquisitionSpeed != 0){
			JRadioButton b = (JRadioButton)m_shootingRates.getComponent(acquisitionSpeed+18);
			b.setSelected(true);
		}
	}
	public String getAcquistionLocation(){
		return "" + acquiringBallsComboBox.getSelectedItem();
	}
	public void setAcquisitionLocation(String location){
		acquiringBallsComboBox.setSelectedItem(location);
	}
}
class ShootingPanel extends JPanel {
	
	public JTextField ballsScoredTopTeleopText;
	public JTextField ballsShotTopTeleopText;
	public JTextField ballsScoredBottomTeleopText;
	public JTextField ballsShotBottomTeleopText;
	
	public ShootingPanel(){
		
		 ballsScoredTopTeleopText = new JTextField("0",3);
		 ballsShotTopTeleopText = new JTextField("0",3);
		 ballsScoredBottomTeleopText = new JTextField("0",3);
		 ballsShotBottomTeleopText = new JTextField("0",3);
		 
		 add(new JLabel("Top Teleop"));
		 add(ballsScoredTopTeleopText);
		  
		 add(new JLabel("/"));
		 add(ballsShotTopTeleopText);
		  
		 add(new JLabel("Bottom Teleop       "));
		 add(ballsScoredBottomTeleopText);
		  
		 add(new JLabel("/"));
		 add(ballsShotBottomTeleopText);
		 
		  setLayout(new SpringLayout());
		  SpringUtilities.makeCompactGrid(this,2,4,0,0,0,0);
	}
}

class ShootingRates extends JPanel{
	public ShootingRates(){
		createButtonGroup(this,"Shooting Speed");
		createButtonGroup(this,"Shooting Accuracy");
		add(new JSeparator(SwingConstants.HORIZONTAL));add(new JLabel());add(new JLabel());add(new JLabel());add(new JLabel());add(new JLabel());
		createButtonGroup(this,"Acquistion Speed");
		setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(this,4,6,0,0,0,0);
	}
}