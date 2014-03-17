package inputSubPanels;


import java.util.ArrayList;

import javax.swing.BoxLayout;
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
}
