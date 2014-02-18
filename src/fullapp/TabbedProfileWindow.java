package fullapp;

import javax.swing.*;

public class TabbedProfileWindow extends JFrame {
	
	private JTabbedPane m_tabbedPane;
	private TeamProfileWindow m_teamWindow;
	private TeamInterviewPanel m_interviewPanel;
	private JPanel pan;
	
	public TabbedProfileWindow(Team t, Event e){
		pan = new JPanel();
		add(pan);
		m_tabbedPane = new JTabbedPane();
		m_teamWindow = new TeamProfileWindow(t,e);
		m_interviewPanel = new TeamInterviewPanel(t,e);
		m_tabbedPane.addTab("Profile Window", m_teamWindow);
		m_tabbedPane.addTab("Interview", m_interviewPanel);
		pan.add(m_tabbedPane);
		
	}

}
