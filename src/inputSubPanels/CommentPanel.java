package inputSubPanels;


import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 *
 * @author michael
 */
@SuppressWarnings("serial")
public class CommentPanel extends JPanel{
    
    private JTextArea overallGamePlay;
    private JTextArea robotFlaws;
    private JTextArea autoNotes;
    private JTextArea allianceComment;
    private JTextArea penaltiesComment;
    
    @SuppressWarnings("unchecked")
	public CommentPanel(ArrayList teamNums, ArrayList teamNames){
        
    	penaltiesComment = new JTextArea(7,20);
    	add(new JTextField("Penalties"));
    	makeUneditable();
        add(penaltiesComment);
        penaltiesComment.setLineWrap(true);
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        overallGamePlay = new JTextArea(7,20);
        add(new JTextField("Overall Game Play"));
        makeUneditable();
        add(overallGamePlay);
        overallGamePlay.setLineWrap(true);
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        robotFlaws = new JTextArea(7,20);
        add(new JTextField("Robot Flaws"));
        makeUneditable();
        add(robotFlaws);
        robotFlaws.setLineWrap(true);
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        allianceComment = new JTextArea(7,20);
        add(new JTextField("Alliance Comment"));
        makeUneditable();
        add(allianceComment);
        allianceComment.setLineWrap(true);
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        autoNotes = new JTextArea(7,20);
        add(new JTextField("Auto Notes"));
        makeUneditable();
        add(autoNotes);
        autoNotes.setLineWrap(true);
        add( new JSeparator(SwingConstants.HORIZONTAL));
        
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }
    private void makeUneditable(){
    	JTextField j = (JTextField) this.getComponents()[this.getComponentCount()-1];
    	j.setEditable(false);
    	j.setBorder(null);
    	j.setBackground(null);
    	j.setFocusable(false);
    }
    public String getPenalties(){
        return penaltiesComment.getText();
    }
    public void setPenalties(String penalties){
    	penaltiesComment.setText(penalties);
    }
    public String getOverallGamePlay(){
    	return overallGamePlay.getText();
    }
    public void setOverallGamePlay(String gamePlay){
    	overallGamePlay.setText(gamePlay);
    }
    public String getRobotFlaws(){
    	return robotFlaws.getText();
    }
    public void setRobotFlaws(String robotFlaws){
    	this.robotFlaws.setText(robotFlaws);
    }
    public String getAllianceComment(){
    	return allianceComment.getText();
    }
    public void setAllianceComment(String allianceComment){
    	this.allianceComment.setText(allianceComment);
    }
    public String getAutoNotes(){
    	return autoNotes.getText();
    }
    public void setAutoNotes(String autoNotes1){
    	this.autoNotes.setText(autoNotes1);
    }
}
