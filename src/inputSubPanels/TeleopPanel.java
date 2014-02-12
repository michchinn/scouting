package inputSubPanels;

import javax.swing.*;
import static inputSubPanels.Methods.*;

public class TeleopPanel extends JPanel{
	public ShootingPanel m_shootingPanel;
	public ShootingRates m_shootingRates;
	public TeleopPanel(){
		m_shootingPanel = new ShootingPanel();
		m_shootingRates = new ShootingRates();
		add(m_shootingPanel);
		add(m_shootingRates);
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
	}
	public int getBallsScoredTopTeleop(){
		return Integer.parseInt(m_shootingPanel.ballsScoredTopTeleopText.getText());
	}
	public int getBallsShotTopTeleop(){
		return Integer.parseInt(m_shootingPanel.ballsShotTopTeleopText.getText());
	}
	public int getBallsScoredBottomTeleop(){
		return Integer.parseInt(m_shootingPanel.ballsScoredBottomTeleopText.getText());
	}
	public int getBallsShotBottomTeleop(){
		return Integer.parseInt(m_shootingPanel.ballsShotBottomTeleopText.getText());
	}
	public int getShooterSpeed(){
		for(int i = 0; i < 5; i++ ){
			JRadioButton r = (JRadioButton)m_shootingRates.getComponents()[i+1];
			if(r.isSelected())
				return i+1;
		}
		return 0;
	}
	public int getPickUpSpeed(){
		for(int i = 0; i < 5; i++ ){
			JRadioButton r = (JRadioButton)m_shootingRates.getComponents()[i+7];
			if(r.isSelected())
				return i+1;
		}
		return 0;
	}
}
class ShootingPanel extends JPanel {
	
	private JButton ballsScoredTopTeleopPlus;
	private JButton ballsScoredTopTeleopMinus;
	public JTextField ballsScoredTopTeleopText;
	
	private JButton ballsShotTopTeleopPlus;
	private JButton ballsShotTopTeleopMinus;
	public JTextField ballsShotTopTeleopText;
	
	private JButton ballsScoredBottomTeleopPlus;
	private JButton ballsScoredBottomTeleopMinus;
	public JTextField ballsScoredBottomTeleopText;
	
	private JButton ballsShotBottomTeleopPlus;
	private JButton ballsShotBottomTeleopMinus;
	public JTextField ballsShotBottomTeleopText;
	
	public ShootingPanel(){
		  ballsScoredTopTeleopPlus = new JButton("+");
		  ballsScoredTopTeleopMinus = new JButton("-");
		  ballsScoredTopTeleopText = new JTextField(3);
		  scoringWithButtons(ballsScoredTopTeleopPlus, ballsScoredTopTeleopMinus, ballsScoredTopTeleopText);
		  add(new JLabel("Balls Scored Top Teleop"));
		  add(ballsScoredTopTeleopMinus);add(ballsScoredTopTeleopPlus);add(ballsScoredTopTeleopText);
		  
		  ballsShotTopTeleopPlus = new JButton("+");
		  ballsShotTopTeleopMinus = new JButton("-");
		  ballsShotTopTeleopText = new JTextField(3);
		  scoringWithButtons(ballsShotTopTeleopPlus, ballsShotTopTeleopMinus, ballsShotTopTeleopText);
		  add(new JLabel("Balls Shot Top Teleop"));
		  add(ballsShotTopTeleopMinus);add(ballsShotTopTeleopPlus);add(ballsShotTopTeleopText);
		  
		  ballsScoredBottomTeleopPlus = new JButton("+");
		  ballsScoredBottomTeleopMinus = new JButton("-");
		  ballsScoredBottomTeleopText = new JTextField(3);
		  scoringWithButtons(ballsScoredBottomTeleopPlus, ballsScoredBottomTeleopMinus, ballsScoredBottomTeleopText);
		  add(new JLabel("Balls Scored Bottom Teleop"));
		  add(ballsScoredBottomTeleopMinus);add(ballsScoredBottomTeleopPlus);add(ballsScoredBottomTeleopText);
		  
		  ballsShotBottomTeleopPlus = new JButton("+");
		  ballsShotBottomTeleopMinus = new JButton("-");
		  ballsShotBottomTeleopText = new JTextField(3);
		  scoringWithButtons(ballsShotBottomTeleopPlus, ballsShotBottomTeleopMinus, ballsShotBottomTeleopText);
		  add(new JLabel("Balls Shot Bottom Teleop"));
		  add(ballsShotBottomTeleopMinus);add(ballsShotBottomTeleopPlus);add(ballsShotBottomTeleopText);
		  setLayout(new SpringLayout());
		  SpringUtilities.makeCompactGrid(this,4,4,0,0,0,0);
	}
}

class ShootingRates extends JPanel{
	public ShootingRates(){
		createButtonGroup(this,"Shooting Speed");
		createButtonGroup(this,"Intake Speed");
		setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(this,2,6,0,0,0,0);
	}
}