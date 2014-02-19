package fullapp;

import java.awt.*;

import javax.swing.*;

import static fullapp.EventOverviewWindow.*;

public class TeamInterviewPanel extends JPanel {

	private Interview _interview;
	
	private PhotoPanel m_photoPanel;
	private IAutonPanel m_autonPanel;
	private JPanel drivePanel;
	private JPanel shootPanel;
	private JPanel aquireBallPanel;
	private JPanel gameStrategyPanel;
	
	public TeamInterviewPanel(Team t, Event e){
				
		m_photoPanel = new PhotoPanel(t);
		
		add(m_photoPanel);
		
		setLayout(new GridLayout(2,3));
		
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
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
}
class IAutonPanel extends JPanel{
	
	public IAutonPanel(Interview i){
		
	}
	
}