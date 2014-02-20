package fullapp;

import javax.swing.*;

public class TabbedProfileWindow extends JTabbedPane {

	private TeamProfileWindow m_teamWindow;
	private TeamInterviewPanel m_interviewPanel;

	private int teamNumber;
	
	public TabbedProfileWindow(Team t, Event e){

		teamNumber = t.getNumber();
		
		m_teamWindow = new TeamProfileWindow(t,e);
		m_interviewPanel = new TeamInterviewPanel(t,e);
		JScrollPane windowPane = new JScrollPane(m_teamWindow);
		JScrollPane interviewPane = new JScrollPane(m_interviewPanel);
		
		addTab("Profile Window", windowPane);
		addTab("Interview", interviewPane);
		
	}
	public int getTeamNumber(){
		return teamNumber;
	}
}
