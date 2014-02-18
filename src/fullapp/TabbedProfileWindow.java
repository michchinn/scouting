package fullapp;

import javax.swing.*;

public class TabbedProfileWindow extends JFrame {
	
	private JTabbedPane m_tabbedPane;
	private TeamProfileWindow m_teamWindow;
	private JPanel pan;
	
	public TabbedProfileWindow(Team t, Event e){
		pan = new JPanel();
		add(pan);
		m_tabbedPane = new JTabbedPane();
		m_teamWindow = new TeamProfileWindow(t,e);
		m_tabbedPane.addTab("Profile Window", m_teamWindow);
		pan.add(m_tabbedPane);
		
	}

}
