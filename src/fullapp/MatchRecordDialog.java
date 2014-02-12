package fullapp;

import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import inputSubPanels.*;

import javax.swing.*;

/**
 *
 * @author michael
 */
public class MatchRecordDialog extends JDialog{
    
	public static MatchRecordDialog _instance;
	//private final JDialog matchFrame;
    private final JPanel fullPanel;
    private final JPanel bodyPanel;
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    private final JPanel leftTopPanel;
    
    private final AutonPanel m_autonPanel;
    private final AssistPanel m_assistPanel;
    private final TeleopPanel m_teleopPanel;
    private final GeneralInfoPanel m_generalInfoPanel;
    private final CommentPanel m_commentPanel;
    private final PenaltyPanel m_penaltyPanel;
    private final DefensivePanel m_defensivePanel;
    private final String eventAbb;

    private ArrayList<Integer> teamNums;
    private ArrayList<String> teamNames;
    
    @SuppressWarnings("unchecked")
    public MatchRecordDialog(Event e){
        
    	teamNums = new ArrayList();teamNames = new ArrayList();
    	for( int i = 0; i < e.getTeamList().size(); i++ ){
    		teamNums.add(e.getTeamList().get(i).getNumber());
    		teamNames.add(e.getTeamList().get(i).getName());
    	}
    	
        //matchFrame = new JDialog();
        setTitle("Match Record Input");
        bodyPanel = new JPanel();
        fullPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        leftTopPanel = new JPanel();
        
        m_autonPanel = new AutonPanel();
        m_assistPanel = new AssistPanel();
        m_generalInfoPanel = new GeneralInfoPanel();
        m_teleopPanel = new TeleopPanel();
        m_commentPanel = new CommentPanel(teamNums, teamNames);
        m_penaltyPanel = new PenaltyPanel();
        m_defensivePanel = new DefensivePanel();
        
        leftTopPanel.add(m_generalInfoPanel);
        leftTopPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftTopPanel.add(m_teleopPanel);
        leftTopPanel.setLayout(new BoxLayout(leftTopPanel,BoxLayout.PAGE_AXIS));
        topPanel.add(leftTopPanel);

        eventAbb = e._abbreviation;

        topPanel.add(new JSeparator(SwingConstants.VERTICAL));

        
        topPanel.add(m_autonPanel);
        
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.LINE_AXIS));
        bodyPanel.add(topPanel);
        bodyPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        bottomPanel.add(m_assistPanel);
        bottomPanel.add(m_defensivePanel);
        bottomPanel.add( new JSeparator(SwingConstants.VERTICAL));
        bottomPanel.add(m_penaltyPanel);
        bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.LINE_AXIS));
        bodyPanel.add(bottomPanel);
        JButton submitRecord = new JButton("Submit Record");
        submitRecord.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for( int i = 0; i < Main.frame.getCurrentEvent().getTeamList().size(); i++){
					if(Main.frame.getCurrentEvent().getTeamList().get(i).getNumber() == m_commentPanel.m_setUpPanel.getTeamNumber()){
						Main.frame.getCurrentEvent().getTeamList().get(i).addMatchRecord(getMatchRecord());
						try {
							Main.frame.getCurrentEvent().saveToFile();
						} catch (IOException e) {}
						dispose();
					}
				}
			}	
        });
        JButton saveToFile = new JButton("Save to File");
        saveToFile.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				MatchRecord r = getMatchRecord();
				try{Methods.saveMATCHToFile(r);}
				catch(IOException ex){}
				dispose();
			}
        	
        });
        bodyPanel.add( new JSeparator(SwingConstants.HORIZONTAL));
        bodyPanel.add(submitRecord);bodyPanel.add(saveToFile);
 
        bodyPanel.setLayout(new BoxLayout(bodyPanel,BoxLayout.PAGE_AXIS));
        
        JScrollPane bP = new JScrollPane(bodyPanel);
        fullPanel.add(bP);
        
        fullPanel.add(new JSeparator(SwingConstants.VERTICAL));
        fullPanel.add(m_commentPanel);

        fullPanel.setLayout(new BoxLayout(fullPanel,BoxLayout.LINE_AXIS));
        
        add(fullPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        pack();
    }
    public MatchRecordDialog(MatchRecord r,Event e){
        
    	teamNums = new ArrayList();teamNames = new ArrayList();
    	for( int i = 0; i < e.getTeamList().size(); i++ ){
    		teamNums.add(e.getTeamList().get(i).getNumber());
    		teamNames.add(e.getTeamList().get(i).getName());
    	}
    	
        setTitle("Match Record Input");
        bodyPanel = new JPanel();
        fullPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        leftTopPanel = new JPanel();
        
        m_autonPanel = new AutonPanel();
        m_assistPanel = new AssistPanel();
        m_generalInfoPanel = new GeneralInfoPanel();
        m_teleopPanel = new TeleopPanel();
        m_commentPanel = new CommentPanel(teamNums, teamNames);
        m_penaltyPanel = new PenaltyPanel();
        m_defensivePanel = new DefensivePanel();
        
        leftTopPanel.add(m_generalInfoPanel);
        leftTopPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftTopPanel.add(m_teleopPanel);
        leftTopPanel.setLayout(new BoxLayout(leftTopPanel,BoxLayout.PAGE_AXIS));
        topPanel.add(leftTopPanel);

        eventAbb = e._abbreviation;

        topPanel.add(new JSeparator(SwingConstants.VERTICAL));

        
        topPanel.add(m_autonPanel);
        
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.LINE_AXIS));
        bodyPanel.add(topPanel);
        bodyPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        bottomPanel.add(m_assistPanel);
        bottomPanel.add(m_defensivePanel);
        bottomPanel.add( new JSeparator(SwingConstants.VERTICAL));
        bottomPanel.add(m_penaltyPanel);
        bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.LINE_AXIS));
        bodyPanel.add(bottomPanel);
        JButton submitRecord = new JButton("Submit Record");
        submitRecord.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {	
				MatchRecord r = getMatchRecord();
				for( int i = 0; i < Main.frame.getCurrentEvent().getTeamList().size(); i++ )
					if(Main.frame.getCurrentEvent().getTeamList().get(i).getNumber() == m_commentPanel.m_setUpPanel.getTeamNumber() ){
						Main.frame.getCurrentEvent().getTeamList().get(i).addMatchRecord(r);
						break;
					}
						
				
				try{Main.frame.getCurrentEvent().saveToFile();}
				catch(IOException ex){}
				dispose();
			}
        
        });
        JButton saveToFile = new JButton("Save to File");
        saveToFile.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				MatchRecord r = getMatchRecord();
				try{Methods.saveMATCHToFile(r);}
				catch(IOException ex){}
				dispose();
			}
        	
        });
        bodyPanel.add( new JSeparator(SwingConstants.HORIZONTAL));
        bodyPanel.add(submitRecord);bodyPanel.add(saveToFile);
 
        bodyPanel.setLayout(new BoxLayout(bodyPanel,BoxLayout.PAGE_AXIS));
        
        JScrollPane bP = new JScrollPane(bodyPanel);
        fullPanel.add(bP);
        
        fullPanel.add(new JSeparator(SwingConstants.VERTICAL));
        fullPanel.add(m_commentPanel);

        fullPanel.setLayout(new BoxLayout(fullPanel,BoxLayout.LINE_AXIS));
        
        add(fullPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        pack();
    }
    public MatchRecord getMatchRecord(){
		    int teamNumber = m_commentPanel.m_setUpPanel.getTeamNumber();
			String teamName = m_commentPanel.m_setUpPanel.getTeamName();
			String eventAbbreviation = this.eventAbb;
			int matchNumber = m_commentPanel.m_setUpPanel.getMatchNumber();
			String scoutName = m_commentPanel.m_setUpPanel.getScoutName();
			////////////////////////
			int autoTopScoredNotHot = m_autonPanel.getAutoBottomScoredNotHot();
			int autoTopShotNotHot = m_autonPanel.getAutoTopShotNotHot();
			int autoBottomScoredNotHot = m_autonPanel.getAutoBottomScoredNotHot();
			int autoBottomShotNotHot = m_autonPanel.getAutoBottomShotNotHot();
			int hotGoalTopScored = m_autonPanel.getHotGoalTopScored();
			int hotGoalTopShot = m_autonPanel.getHotGoalTopShot();
			int hotGoalBottomScored = m_autonPanel.getHotGoalBottomScored();
			int hotGoalBottomShot = m_autonPanel.getHotGoalBottomShot();
			boolean mobility = m_autonPanel.getMobility();
			boolean startingPosition = m_autonPanel.getStartingPosition();
			////////////////////////
			String positionPlayed = m_generalInfoPanel.getPosition();
			int speed = m_generalInfoPanel.getSpeed();
			int agility = m_generalInfoPanel.getAgility();
			int pushingAbility = m_generalInfoPanel.getPushingAbility();
			int stability = m_generalInfoPanel.getStability();
			////////////////////////
			int ballsScoredTopTeleop = m_teleopPanel.getBallsScoredTopTeleop();
			int ballsShotTopTeleop = m_teleopPanel.getBallsShotTopTeleop();
			int ballsScoredBottomTeleop = m_teleopPanel.getBallsScoredBottomTeleop();
			int ballsShotBottomTeleop = m_teleopPanel.getBallsShotBottomTeleop();
			int shooterSpeed = m_teleopPanel.getShooterSpeed();
			int pickUpSpeed = m_teleopPanel.getPickUpSpeed();
			////////////////////////
			int possessions = m_assistPanel.getPossessions();
			int successfulPasses = m_assistPanel.getSuccessfulPasses();
			int totalPasses = m_assistPanel.getTotalPasses();
			int successfulTrussThrows = m_assistPanel.getSuccessfulTrussThrows();
			int totalTrussThrows = m_assistPanel.getTotalTrussThrows();
			int successfulCatches = m_assistPanel.getSuccessfulCatches();
			int totalCatches = m_assistPanel.getTotalCatches();
			////////////////////////
			String autoComment = m_commentPanel.getAutoNotes();
			String penaltyComment = m_penaltyPanel.getPenalties();
			String interestingStrategyComment = m_commentPanel.getInterestingStrategy();
			String robotFlaws = m_commentPanel.getRobotFlaws();
			////////////////////////
			
			 return new MatchRecord( teamNumber,  teamName,  eventAbbreviation,  matchNumber,
			 scoutName,  autoTopScoredNotHot,  autoTopShotNotHot,
			 autoBottomScoredNotHot,  autoBottomShotNotHot,  hotGoalTopScored,
			 hotGoalTopShot,  hotGoalBottomScored,  hotGoalBottomShot,
			 mobility,  positionPlayed,  startingPosition,  speed,  agility,
			 pushingAbility,  stability,  ballsScoredTopTeleop,
			 ballsShotTopTeleop,  ballsScoredBottomTeleop,
			 ballsShotBottomTeleop,  shooterSpeed,  pickUpSpeed,
			 possessions,  successfulPasses,  totalPasses,
			 successfulTrussThrows,  totalTrussThrows,
			 successfulCatches,  totalCatches,  autoComment,
			 penaltyComment,  interestingStrategyComment,
			 robotFlaws);
    }

    public MatchRecordDialog getInstance(Event e){
    	if( _instance == null ){
    		_instance = new MatchRecordDialog(e);
    	}
    	return _instance;
    }
    public void setTeamNumber(int teamNumber){
    	m_commentPanel.m_setUpPanel.setTeamNumber(teamNumber);
    }
}
