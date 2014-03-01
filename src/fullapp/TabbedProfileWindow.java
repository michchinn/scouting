package fullapp;

import javax.swing.*;

public class TabbedProfileWindow extends JTabbedPane {

	private TeamProfileWindow m_teamWindow;
	private TeamInterviewPanel m_interviewPanel;
	private MatchTablePanel m_matchTablePanel;

	private int teamNumber;
	
	public TabbedProfileWindow(Team t, Event e){

		teamNumber = t.getNumber();
		
		m_teamWindow = new TeamProfileWindow(t);
		m_interviewPanel = new TeamInterviewPanel(t,e);
		m_matchTablePanel = new MatchTablePanel(t);
		JScrollPane windowPane = new JScrollPane(m_teamWindow);
		JScrollPane interviewPane = new JScrollPane(m_interviewPanel);
		JScrollPane matchTablePane = new JScrollPane(m_matchTablePanel);
		
		addTab("Profile Window", windowPane);
		addTab("Match Table",matchTablePane);
		addTab("Interview", interviewPane);
		
	}
	public int getTeamNumber(){
		return teamNumber;
	}

}
