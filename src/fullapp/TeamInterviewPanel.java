package fullapp;

import inputSubPanels.SpringUtilities;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import static fullapp.EventOverviewWindow.*;

public class TeamInterviewPanel extends JPanel {
	
	private Team team;
	private Interview _interview;
	
	
	class MainInterviewPanel extends JPanel{
		
		private PhotoPanel m_photoPanel;
		private IAutonNoComment m_autonPanel;
		private DriveSystem drivePanel;
		private JPanel shootPanel;
		private JPanel aquireBallPanel;
		private JPanel gameStrategyPanel;
		
		public MainInterviewPanel(Team t, Event e){
					
			_interview = t.getInterview();
			m_photoPanel = new PhotoPanel(t);
			m_autonPanel = new IAutonNoComment(); 
			drivePanel = new DriveSystem();
			
			add(new JPanel());
			add(m_photoPanel);
			add(m_autonPanel);
			add(drivePanel);
			add(new JPanel());
			add(new JPanel());
			
			
			setLayout(new GridLayout(2,3));
		}
	}

	class IAutonNoComment extends JPanel{
		
		public IAutonNoComment(){
			if( _interview != null ){
				add(new JLabel("Has an autonomous:"));add(new JLabel("       "));
				if(_interview.isHasAuton())
					add(new JLabel("Yes"));
				else
					add(new JLabel("No"));
			
				add(new JLabel("Starting Position: "));add(new JLabel("       "));
				add(new JLabel(_interview.getAutonStartingPos()));
				
				add(new JLabel("Score in auton: "));add(new JLabel("       "));
				add(new JLabel(_interview.getAutonGoals()));
				
				add(new JLabel("Target hot goal: "));add(new JLabel("       "));
				if(_interview.isTargetHotGoal()) { add(new JLabel(_interview.getAutonStartingPos())); }else{ add(new JLabel(_interview.getAutonStartingPos()));}

				add(new JLabel("Number of balls scored: "));add(new JLabel("       "));
				add(new JLabel(_interview.getAutonBallCount() + " balls"));
				
				//setLayout(new SpringLayout());
				//SpringUtilities.makeCompactGrid(this, 5, 3, 0, 0, 0, 0);
				setLayout(new GridLayout(5,3));
				setBackground(null);
				setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
			}
	}
	class DriveSystem extends JPanel{
		
		public DriveSystem(){
			if( _interview != null ){
				add(new JLabel("Width:"));add(new JLabel(Integer.toString(_interview.getWidth())));
				add(new JLabel("Length:"));add(new JLabel(Integer.toString(_interview.getLength())));
				add(new JLabel("Weight:"));add(new JLabel(Integer.toString(_interview.getWeight())));
				add(new JLabel("# of Drive Wheels:     "));add(new JLabel(Integer.toString(_interview.getNumberOfWheels())));
				add(new JLabel("Speed:"));add(new JLabel(_interview.getSpeed()));
				add(new JLabel("Drive System:"));add(new JLabel(_interview.getDriveSystem()));
				add(new JLabel("Drop Center Wheels:"));add(new JLabel(_interview.getHasDropCenterWheels()));
				
				//setLayout(new GridLayout(7,2));
				setLayout(new SpringLayout());
				SpringUtilities.makeCompactGrid(this, 7, 2, 0, 0, 0, 0);
			}
			setBackground(null);
			Border line = BorderFactory.createLineBorder(Color.BLACK);
			Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			setBorder(BorderFactory.createCompoundBorder(empty, line));
		}
		
	}
	
	public TeamInterviewPanel(Team team, Event e){
		JLabel title = new JLabel("Team "+ team.getNumber() + " - " + team.getName() + "");
		title.setFont(new Font("SansSerif", Font.PLAIN, 24));
		
		JPanel titlePanel = new JPanel();
		titlePanel.add(title);
		add(titlePanel);
		add(new MainInterviewPanel(team,e));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	
}

class PhotoPanel extends JPanel{

	private JLabel imgLabel;
	private Image img;
	private ImageIcon imgIcon;
	
	public PhotoPanel(Team t){
		
		imgLabel = new JLabel();
		imgIcon = new ImageIcon();
		
		String exists = pictureExists(Integer.toString(t.getNumber()));
		if(exists.equals("false")){
			imgIcon = new ImageIcon(pathToData + "/images/AerialAssist.png");
			img = imgIcon.getImage();
			img = img.getScaledInstance(250, -1, Image.SCALE_SMOOTH);
			imgLabel.setIcon(new ImageIcon(img));
		}
		else{
			imgIcon = new ImageIcon(pathToData + "/images/teams/" + t.getNumber() + exists);
			img = imgIcon.getImage();
			img = img.getScaledInstance(250, -1, Image.SCALE_SMOOTH);
			imgLabel.setIcon(new ImageIcon(img));
		}
		add(imgLabel);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(new UploadButton2(new JFileChooser(), t, imgLabel, new JPanel()));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
}




