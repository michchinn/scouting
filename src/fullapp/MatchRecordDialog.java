package fullapp;

import java.awt.Dimension;
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
    private final JPanel fullPanel;
    final JPanel bodyPanel;
    private final JPanel leftPanel;
    private final JPanel rightPanel;
    
    private final AutonPanel m_autonPanel;
    private final AssistPanel m_assistPanel;
    private final TeleopPanel m_teleopPanel;
    private final GeneralInfoPanel m_generalInfoPanel;
    private final CommentPanel m_commentPanel;
    private final PenaltyPanel m_penaltyPanel;
    private final DefensivePanel m_defensivePanel;
    private final SetUpPanel m_setUpPanel;
    
    private final String eventAbb;

    private ArrayList<Integer> teamNums;
    private ArrayList<String> teamNames;
    
    public JScrollPane fullScroll;
    public JPanel fullerPanel;
    
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
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        
        m_autonPanel = new AutonPanel();
        m_assistPanel = new AssistPanel();
        m_generalInfoPanel = new GeneralInfoPanel();
        m_teleopPanel = new TeleopPanel();
        m_commentPanel = new CommentPanel(teamNums, teamNames);
        m_penaltyPanel = new PenaltyPanel();
        m_defensivePanel = new DefensivePanel();
        m_setUpPanel = new SetUpPanel(e);
        
        eventAbb = e._abbreviation;

        leftPanel.add(m_setUpPanel);
        leftPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftPanel.add(m_autonPanel);
        leftPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftPanel.add(m_generalInfoPanel);
        leftPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftPanel.add(m_teleopPanel);
        leftPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        leftPanel.add(m_assistPanel);
        
        leftPanel.add(m_commentPanel);
        
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
        
        JButton submitRecord = new JButton("Submit Record");
        submitRecord.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				for( int i = 0; i < Main.frame.getCurrentEvent().getTeamList().size(); i++){
					if(Main.frame.getCurrentEvent().getTeamList().get(i).getNumber() == m_setUpPanel.getTeamNumber()){
						Main.frame.getCurrentEvent().getTeamList().get(i).addMatchRecord(getMatchRecord());
						try {
							Main.frame.getCurrentEvent().saveToFile();
						} catch (IOException e) {}
						dispose();
					}
				}
			}	
        });
      
        bodyPanel.add( new JSeparator(SwingConstants.HORIZONTAL));
        bodyPanel.add(submitRecord);
 
        bodyPanel.setLayout(new BoxLayout(bodyPanel,BoxLayout.X_AXIS));
        
        JScrollPane bP = new JScrollPane(bodyPanel);

        fullPanel.add(leftPanel);
        fullPanel.add(Box.createRigidArea(new Dimension(20,0)));
        fullPanel.add(rightPanel);
        
        fullerPanel = new JPanel();
        fullerPanel.add(fullPanel);
        fullerPanel.add(bP);
        fullerPanel.setLayout(new BoxLayout(fullerPanel,BoxLayout.Y_AXIS));

        fullPanel.setLayout(new BoxLayout(fullPanel,BoxLayout.LINE_AXIS));
        
        fullScroll = new JScrollPane(fullerPanel);
        add(fullScroll);
        //add(fullPanel);
        fullPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        //setPreferredSize(new Dimension(800,700));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        //setResizable(false);
        pack();
    }
   
    public MatchRecord getMatchRecord(){
		    
    		int teamNumber = m_setUpPanel.getTeamNumber();
			String teamName = m_setUpPanel.getTeamName();
			int matchNumber = m_setUpPanel.getMatchNumber();
			String scoutName = m_setUpPanel.getScoutName();
			//////////////////////////////////////////////
			int topAutonScored = m_autonPanel.getTopAutonScored();
			int topAutonShot = m_autonPanel.getTopAutonShot();
			int bottomAutonScored = m_autonPanel.getBottomAutonScored();
			int bottomAutonShot = m_autonPanel.getBottomAutonShot();
			int topHot = m_autonPanel.getTopHot();
			int bottomHot = m_autonPanel.getBottomHot();
			boolean mobilityPoints = m_autonPanel.getMobility();
			//////////////////////////////////////////////
			int driverAbility = m_generalInfoPanel.getDriverAbility();
			int speed = m_generalInfoPanel.getSpeed();
			int stability = m_generalInfoPanel.getStability();
			int pushingAbility = m_generalInfoPanel.getPushingAbility();
			String positionPlayed = m_generalInfoPanel.getPosition();
			//////////////////////////////////////////////
			int topTeleopScored = m_teleopPanel.getTopTeleopScored();
			int topTeleopShot = m_teleopPanel.getTopTeleopShot();
			int bottomTeleopScored = m_teleopPanel.getBottomTeleopScored();
			int bottomTeleopShot = m_teleopPanel.getBottomTeleopShot();
			int shootingSpeed = m_teleopPanel.getShooterSpeed();
			int shootingAccuracy = m_teleopPanel.getShootingAccuracy();
			int acquisitionSpeed = m_teleopPanel.getAcquisitionSpeed();
			String acquisitionLocation = m_teleopPanel.getAcquistionLocation();
			//////////////////////////////////////////////
			int passesComplete = m_assistPanel.getPassesComplete();
			int passesTotal = m_assistPanel.getPassesTotal();
			int trussThrowsComplete = m_assistPanel.getTrussThrowsComplete();
			int trussThrowsTotal= m_assistPanel.getTrussThrowsTotal();
			int catchesComplete = m_assistPanel.getCatchesComplete();
			int catchesTotal = m_assistPanel.getCatchesTotal();
			//////////////////////////////////////////
			String penalties = m_commentPanel.getPenalties();
			String overallGamePlay = m_commentPanel.getOverallGamePlay();
		
			return new MatchRecord(teamNumber,teamName,matchNumber,
					scoutName,topAutonScored,topAutonShot,
					bottomAutonScored,bottomAutonShot,topHot,
					bottomHot,mobilityPoints,positionPlayed,
					speed,driverAbility,stability,pushingAbility,
					topTeleopScored,topTeleopShot,bottomTeleopScored,
					bottomTeleopShot,shootingSpeed,shootingAccuracy,
					acquisitionSpeed,acquisitionLocation,
					passesComplete,passesTotal,trussThrowsComplete,
					trussThrowsTotal,catchesComplete,catchesTotal,
					penalties,overallGamePlay);
    }
    public void setMatchRecord(MatchRecord r){
    	m_setUpPanel.setTeamNumber(r.getTeamNumber());
    	m_setUpPanel.setTeamName(r.getTeamName());
    	m_setUpPanel.setMatchNumber(r.getMatchNumber());
    	m_setUpPanel.setScoutName(r.getScoutName());
		
    	m_autonPanel.setTopAutonScored(r.getTopAutonScored());
		m_autonPanel.setTopAutonShot(r.getTopAutonShot());
		m_autonPanel.setBottomAutonScored(r.getBottomAutonScored());
		m_autonPanel.setBottomAutonShot(r.getBottomAutonShot());
		m_autonPanel.setTopHot(r.getTopHot());
		m_autonPanel.setBottomHot(r.getBottomHot());
		m_autonPanel.setMobility(r.isMobilityPoints());
		
		m_generalInfoPanel.setDriverAbility(r.getDriverAbility());
		m_generalInfoPanel.setSpeed(r.getSpeed());
		m_generalInfoPanel.setStability(r.getStability());
		m_generalInfoPanel.setPushingAbility(r.getPushingAbility());
		m_generalInfoPanel.setPosition(r.getPosistionPlayed());
		
		m_teleopPanel.setTopTeleopScored(r.getTopTeleopScored());
		m_teleopPanel.setTopTeleopShot(r.getTopTeleopShot());
		m_teleopPanel.setBottomTeleopScored(r.getBottomTeleopScored());
		m_teleopPanel.setBottomTeleopShot(r.getBottomTeleopShot());
		m_teleopPanel.setShooterSpeed(r.getShootingSpeed());
		m_teleopPanel.setShooterAccuracy(r.getShootingAccuracy());
		m_teleopPanel.setAcquisitionSpeed(r.getAcquisitionSpeed());
		m_teleopPanel.setAcquisitionLocation(r.getAcquisitionLocation());
		
		m_assistPanel.setPassesComplete(r.getPassesComplete());
		m_assistPanel.setPassesTotal(r.getPassesTotal());
		m_assistPanel.setTrussThrowsComplete(r.getTrussThrowsComplete());
		m_assistPanel.setTrussThrowsTotal(r.getTrussThrowsTotal());
		m_assistPanel.setCatchesComplete(r.getCatchesComplete());
		m_assistPanel.setCatchesTotal(r.getCatchesTotal());
		
		m_commentPanel.setPenalties(r.getPenalties());
		m_commentPanel.setOverallGamePlay(r.getOverallGamePlay());
    }
    public void setTeamNumber(int teamNumber){
    	m_setUpPanel.setTeamNumber(teamNumber);
    }
    public void setTeamName(String teamName){
    	m_setUpPanel.setTeamName(teamName);
    }
}
