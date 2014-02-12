package inputSubPanels;


import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


/**
 *
 * @author michael
 */
@SuppressWarnings("serial")
public class CommentPanel extends JPanel{
    
    private final JTextArea interestingStrategy;
    private final JTextArea robotFlaws;
    private final JTextArea autoNotes;
    public final  SetUpPanel m_setUpPanel;
    
    @SuppressWarnings("unchecked")
	public CommentPanel(ArrayList teamNums, ArrayList teamNames){
        m_setUpPanel = new SetUpPanel(teamNums, teamNames);
        
        add(m_setUpPanel);
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        interestingStrategy = new JTextArea("Interesting Strategies",7,20);
        Methods.clearAndResetText(interestingStrategy, "Interesting Strategies");
        add(interestingStrategy);
        interestingStrategy.setLineWrap(true);
     
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        robotFlaws = new JTextArea("Robot Flaws",7,20);
        Methods.clearAndResetText(robotFlaws, "Robot Flaws");
        add(robotFlaws);
        robotFlaws.setLineWrap(true);
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        autoNotes = new JTextArea("Autonomous Notes",7,20);
        Methods.clearAndResetText(autoNotes, "Autonomous Notes");
        add(autoNotes);
        autoNotes.setLineWrap(true);
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }
    public String getInterestingStrategy(){
        return interestingStrategy.getText();
    }
    public String getRobotFlaws(){
        return robotFlaws.getText();
    }
    public String getAutoNotes(){
    	return autoNotes.getText();
    }
    
}
