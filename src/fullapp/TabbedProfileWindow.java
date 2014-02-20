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
		addTab("Profile Window", m_teamWindow);
		addTab("Interview", m_interviewPanel);
		
	}
	public int getTeamNumber(){
		return teamNumber;
	}
}
