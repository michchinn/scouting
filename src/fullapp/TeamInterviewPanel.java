package fullapp;

import inputSubPanels.SpringUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import static fullapp.EventOverviewWindow.*;

public class TeamInterviewPanel extends JPanel {
	
	private Team team;
	private Interview _interview;
	private InterviewDialog editingIntDialog;
	
	class EditInterviewButton extends JButton implements ActionListener{
		
		public EditInterviewButton(){
			super("Edit Interview");
			addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent arg0) {
			_interview.setTeamNumber(team.getNumber());
			editingIntDialog = new InterviewDialog(_interview);
			editingIntDialog.infoLine.numberField.setText("" + team.getNumber());
		}
		
	}
	
	class MainInterviewPanel extends JPanel{
		
		private PhotoPanel m_photoPanel;
		private AutonInterview m_autonPanel;
		private DriveSystem drivePanel;
		private ShootPanel shootPanel;
		private AcquireBalls acquireBallPanel;
		private Comments gameStrategyPanel;
		
		public MainInterviewPanel(Team t, Event e){
					
			_interview = t.getInterview();
			m_photoPanel = new PhotoPanel(t);
			m_autonPanel = new AutonInterview(); 
			drivePanel = new DriveSystem();
			shootPanel = new ShootPanel();		
			acquireBallPanel = new AcquireBalls();
			gameStrategyPanel = new Comments();
			
			add(drivePanel);
			add(m_autonPanel);
			add(m_photoPanel);
			add(shootPanel);
			add(acquireBallPanel);
			add(gameStrategyPanel);
			
			
			setLayout(new GridLayout(2,3));
		}
	}
	class ShootPanel extends JPanel{
		class ShootData extends JPanel{
			public ShootData(){
				add(new JLabel("Shooter Type:"));add(new JLabel(_interview.getShooterType()));
				add(new JLabel("Can Make Truss Shots:         "));
				if(_interview.isCanMakeTrussShots()){add(new JLabel("Yes"));}else{add(new JLabel("Yes"));}
				add(new JLabel("Goals:"));add(new JLabel(_interview.getGeneralGoals()));
				setLayout(new SpringLayout());
				SpringUtilities.makeCompactGrid(this, 3, 2, 0, 0, 0, 0);
			}
		}
		public ShootPanel(){
			JSeparator blackHorizontal = new JSeparator(SwingConstants.HORIZONTAL);
			blackHorizontal.setForeground(Color.BLACK);
			JLabel titleLabel = new JLabel("Shooting");
			titleLabel.setFont(new Font(Font.SERIF,Font.BOLD,titleLabel.getFont().getSize()+5));
			titleLabel.setAlignmentX(CENTER_ALIGNMENT);
			add(titleLabel);
			add(blackHorizontal);
			add(new ShootData());
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			Border line = BorderFactory.createLineBorder(Color.BLACK);
			Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			Border firstCombine = BorderFactory.createCompoundBorder(empty,line);
			setBorder(BorderFactory.createCompoundBorder(firstCombine,empty));
		}
	}
	class AcquireBalls extends JPanel{
		class AcquireData extends JPanel{
			public AcquireData(){
				add(new JLabel("Acquire Locations:"));add(new JLabel(_interview.getBallAquirySystem()));
				add(new JLabel("Intake Mechanism:"));add(new JLabel(_interview.getIntakeType()));
				add(new JLabel("Catching Mechanisms:          "));add(new JLabel(_interview.getCatcherType()));
				setLayout(new SpringLayout());
				SpringUtilities.makeCompactGrid(this, 3, 2, 0, 0, 0, 0);
			}
		}
		public AcquireBalls(){
			JSeparator blackHorizontal = new JSeparator(SwingConstants.HORIZONTAL);
			blackHorizontal.setForeground(Color.BLACK);
			JLabel titleLabel = new JLabel("Acquire Balls");
			titleLabel.setFont(new Font(Font.SERIF,Font.BOLD,titleLabel.getFont().getSize()+5));
			titleLabel.setAlignmentX(CENTER_ALIGNMENT);
			add(titleLabel);
			add(blackHorizontal);
			add(new AcquireData());
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			Border line = BorderFactory.createLineBorder(Color.BLACK);
			Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			Border firstCombine = BorderFactory.createCompoundBorder(empty,line);
			setBorder(BorderFactory.createCompoundBorder(firstCombine,empty));
		}
	}
	class Comments extends JPanel{
		class CommentData extends JPanel{
			public CommentData(){
				JTextArea a = new JTextArea(_interview.getAutonComment());
				JTextArea g = new JTextArea(_interview.getGeneralComment());
				
				a.setEditable(false);
				g.setEditable(false);
				
				add(new JLabel("Autonomous Comment"));
				add(new JSeparator(SwingConstants.HORIZONTAL));	
				add(a);

				add(new JLabel("General Comment"));
				add(new JSeparator(SwingConstants.HORIZONTAL));
				add(g);
				
				setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			}
		}
		public Comments(){
			JSeparator blackHorizontal = new JSeparator(SwingConstants.HORIZONTAL);
			blackHorizontal.setForeground(Color.BLACK);
			JLabel titleLabel = new JLabel("Comments");
			titleLabel.setFont(new Font(Font.SERIF,Font.BOLD,titleLabel.getFont().getSize()+5));
			titleLabel.setAlignmentX(CENTER_ALIGNMENT);
			add(titleLabel);
			add(blackHorizontal);
			add(new CommentData());
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			Border line = BorderFactory.createLineBorder(Color.BLACK);
			Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			Border firstCombine = BorderFactory.createCompoundBorder(empty,line);
			setBorder(BorderFactory.createCompoundBorder(firstCombine,empty));
		}
	}
	class AutonInterview extends JPanel{
		class IAutonNoComment extends JPanel{
			
			public IAutonNoComment(){
				if( _interview != null ){
					add(new JLabel("Has an autonomous:"));if(_interview.isHasAuton()){add(new JLabel("Yes"));}else{add(new JLabel("No"));}
				
					add(new JLabel("Starting Position:"));
					add(new JLabel(_interview.getAutonStartingPos()));
					
					add(new JLabel("Score in auton:"));
					add(new JLabel(_interview.getAutonGoals()));
					
					add(new JLabel("Target hot goal:"));
					if(_interview.isTargetHotGoal()) { add(new JLabel("Yes")); }else{ add(new JLabel("No"));}

					add(new JLabel("Number of balls scored:            "));
					add(new JLabel(_interview.getAutonBallCount() + " balls"));
					}
				setLayout(new SpringLayout());
				SpringUtilities.makeCompactGrid(this, 5, 2, 0, 0, 0, 0);
				}
		}
		public AutonInterview(){
			JSeparator blackHorizontal = new JSeparator(SwingConstants.HORIZONTAL);
			blackHorizontal.setForeground(Color.BLACK);
			JLabel titleLabel = new JLabel("Autonomous");
			titleLabel.setFont(new Font(Font.SERIF,Font.BOLD,titleLabel.getFont().getSize()+5));
			titleLabel.setAlignmentX(CENTER_ALIGNMENT);
			add(titleLabel);
			add(blackHorizontal);
			add(new IAutonNoComment());
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			Border line = BorderFactory.createLineBorder(Color.BLACK);
			Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			Border firstCombine = BorderFactory.createCompoundBorder(empty,line);
			setBorder(BorderFactory.createCompoundBorder(firstCombine,empty));
		}
	}
	
	class DriveSystem extends JPanel{
		
		class DSdata extends JPanel{
			public DSdata(){
				if( _interview != null ){
					add(new JLabel("Width:"));add(new JLabel(Integer.toString(_interview.getWidth())));
					add(new JLabel("Length:"));add(new JLabel(Integer.toString(_interview.getLength())));
					add(new JLabel("Weight:"));add(new JLabel(Integer.toString(_interview.getWeight())));
					add(new JLabel("# of Drive Wheels:"));add(new JLabel(Integer.toString(_interview.getNumberOfWheels())));
					add(new JLabel("Speed:"));add(new JLabel(_interview.getSpeed()));
					add(new JLabel("Drive System:"));add(new JLabel(_interview.getDriveSystem()));
					add(new JLabel("Drop Center Wheels:        "));add(new JLabel(_interview.getHasDropCenterWheels()));
					
					setLayout(new SpringLayout());
					SpringUtilities.makeCompactGrid(this, 7, 2, 0, 0, 0, 0);
				}
				setBackground(null);

			}
		}
		
		public DriveSystem(){
			JSeparator blackHorizontal = new JSeparator(SwingConstants.HORIZONTAL);
			blackHorizontal.setForeground(Color.BLACK);
			JLabel titleLabel = new JLabel("Drive System");
			titleLabel.setFont(new Font(Font.SERIF,Font.BOLD,titleLabel.getFont().getSize()+5));
			titleLabel.setAlignmentX(CENTER_ALIGNMENT);
			add(titleLabel);
			add(blackHorizontal);
			add(new DSdata());
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			Border line = BorderFactory.createLineBorder(Color.BLACK);
			Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			Border firstCombine = BorderFactory.createCompoundBorder(empty,line);
			setBorder(BorderFactory.createCompoundBorder(firstCombine,empty));
		}
		
	}
	
	public TeamInterviewPanel(Team team, Event e){
		JLabel title = new JLabel("Team "+ team.getNumber() + " - " + team.getName() + "");
		title.setFont(new Font("SansSerif", Font.PLAIN, 24));
		
		this.team = team;
		
		JPanel titlePanel = new JPanel();
		titlePanel.add(title);
		add(titlePanel);
		EditInterviewButton b = new EditInterviewButton();
		b.setAlignmentX(CENTER_ALIGNMENT);
		add(b);
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
		imgLabel.setAlignmentX(CENTER_ALIGNMENT);
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
		UploadButton2 b = new UploadButton2(new JFileChooser(), t, imgLabel, new JPanel());
		b.setAlignmentX(CENTER_ALIGNMENT);
		add(b);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
}






