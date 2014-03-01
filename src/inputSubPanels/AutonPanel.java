package inputSubPanels;

import javax.swing.*;

import fullapp.MatchRecord;

/**
 *
 * @author michael
 */
@SuppressWarnings("serial")
public class AutonPanel extends JPanel {
	public ScoringPanel sP;
	public startingAndMobility sAM;
	public AutonPanel() {
		add(new JLabel("Autonomous"));
		sP = new ScoringPanel();
		add(sP);	
		sAM = new startingAndMobility();
		add(sAM);
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
	}
	
	public int getTopAutonScored(){
		return Integer.parseInt(sP.tTopScoredNotHot.getText());
	}
	public void setTopAutonScored(int topAutonScored){
		sP.tTopScoredNotHot.setText(Integer.toString(topAutonScored));
	}
	public int getTopAutonShot(){
		return Integer.parseInt(sP.tTopShotNotHot.getText());
	}
	public void setTopAutonShot(int topAutonShot){
		sP.tTopShotNotHot.setText(Integer.toString(topAutonShot));
	}
	public int getBottomAutonScored(){
		return Integer.parseInt(sP.tBottomScoredNotHot.getText());
	}
	public void setBottomAutonScored(int bottomAutonScored){
		sP.tBottomScoredNotHot.setText(Integer.toString(bottomAutonScored));
	}
	public int getBottomAutonShot(){
		return Integer.parseInt(sP.tBottomShotNotHot.getText());
	}
	public void setBottomAutonShot(int bottomAutonShot){
		sP.tBottomShotNotHot.setText(Integer.toString(bottomAutonShot));
	}
	public int getTopHot(){
		return Integer.parseInt(sP.tHotTopScored.getText());
	}
	public void setTopHot(int topHot){
		sP.tHotTopScored.setText(Integer.toString(topHot));
	}
	public int getBottomHot(){
		return Integer.parseInt(sP.tHotBottomScored.getText());
	}
	public void setBottomHot(int bottomHot){
		sP.tHotBottomScored.setText(Integer.toString(bottomHot));
	}
	public boolean getMobility(){
		startingAndMobility s = (startingAndMobility) getComponent(2);
		JRadioButton r = (JRadioButton)s.getComponent(1);
		return r.isSelected();
	}
	public void setMobility(boolean mobility){
		JRadioButton y = (JRadioButton)sAM.getComponent(1);
		JRadioButton n = (JRadioButton)sAM.getComponent(2);
		if(mobility) y.setSelected(true);
		else n.setSelected(true);
	}
	public boolean getStartingPosition(){
		startingAndMobility s = (startingAndMobility) getComponents()[2];
		JRadioButton r = (JRadioButton)s.getComponents()[4];
		return r.isSelected();
	}
	public void setStartingPosition(boolean startingPosition){
		JRadioButton y = (JRadioButton)sAM.getComponent(4);
		JRadioButton n = (JRadioButton)sAM.getComponent(5);
		if(startingPosition) y.setSelected(true);
		else n.setSelected(true);
	}

}
	class ScoringPanel extends JPanel{
		
		private MatchRecord mR = null;
		
		public JTextField tTopScoredNotHot;
		public JTextField tTopShotNotHot;
		public JTextField tBottomScoredNotHot;
		public JTextField tBottomShotNotHot;
		public JTextField tHotTopScored;
		public JTextField tHotTopShot;
		public JTextField tHotBottomScored;
		public JTextField tHotBottomShot;
		
		
		public ScoringPanel(){
			
			tTopScoredNotHot = new JTextField("0",3);
			tTopShotNotHot = new JTextField("0",3);
			tBottomScoredNotHot = new JTextField("0",3);
			tBottomShotNotHot = new JTextField("0",3);
			tHotTopScored = new JTextField("0",3);
			tHotBottomScored = new JTextField("0",3);
		
			  add(new JLabel("Top"));
			  add(tTopScoredNotHot);
			  
			  add(new JLabel("/"));
			  add(tTopShotNotHot);
			  
			  add(new JLabel("Bottom"));
			  add(tBottomScoredNotHot);
			  
			  add(new JLabel("/"));
			  add(tBottomShotNotHot);
			  
			  add(new JLabel("Top Hot"));
			  add(tHotTopScored);
			  
			  add(new JLabel(""));add(new JLabel(""));

			  add(new JLabel("Bottom Hot     "));
			  add(tHotBottomScored);
			  
			  add(new JLabel(""));add(new JLabel(""));

			  setLayout(new SpringLayout());
			  SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 4, 4,
						0, 0, 0, 0);
		}
	}
	class startingAndMobility extends JPanel{
		
		public startingAndMobility(){
			Methods.addYNBG(this, "Mobility Points", "YES", "NO");
			Methods.addYNBG(this, "Start Zone", "WHITE", "GOALIE");
			setLayout(new SpringLayout());
			 SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 3, 3,
						0, 0, 0, 0);
		}
	}


