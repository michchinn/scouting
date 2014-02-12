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
	public AutonPanel(MatchRecord r) {
		add(new JLabel("Autonomous"));
		sP = new ScoringPanel(r);
		add(sP);	
		sAM = new startingAndMobility(r);
		add(sAM);
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
	}
	public int getAutoTopScoredNotHot(){
		return Integer.parseInt(sP.tTopScoredNotHot.getText());
	}
	public int getAutoTopShotNotHot(){
		return Integer.parseInt(sP.tTopShotNotHot.getText());
	}
	public int getAutoBottomScoredNotHot(){
		return Integer.parseInt(sP.tBottomScoredNotHot.getText());
	}
	public int getAutoBottomShotNotHot(){
		return Integer.parseInt(sP.tBottomShotNotHot.getText());
	}
	public int getHotGoalTopScored(){
		return Integer.parseInt(sP.tHotTopScored.getText());
	}
	public int getHotGoalTopShot(){
		return Integer.parseInt(sP.tHotTopShot.getText());
	}
	public int getHotGoalBottomScored(){
		return Integer.parseInt(sP.tHotBottomScored.getText());
	}
	public int getHotGoalBottomShot(){
		return Integer.parseInt(sP.tHotBottomShot.getText());
	}
	public boolean getMobility(){
		startingAndMobility s = (startingAndMobility) getComponents()[2];
		JRadioButton r = (JRadioButton)s.getComponents()[1];
		return r.isSelected();
	}
	public boolean getStartingPosition(){
		startingAndMobility s = (startingAndMobility) getComponents()[2];
		JRadioButton r = (JRadioButton)s.getComponents()[4];
		return r.isSelected();
	}
}
	class ScoringPanel extends JPanel{
		
		private MatchRecord mR = null;
		
		private JButton topScoredNotHotPlus;
		private JButton topScoredNotHotMinus;
		public JTextField tTopScoredNotHot;
		private JButton topShotNotHotPlus;
		private JButton topShotNotHotMinus;
		public JTextField tTopShotNotHot;
		private JButton bottomScoredNotHotPlus;
		private JButton bottomScoredNotHotMinus;
		public JTextField tBottomScoredNotHot;
		private JButton bottomShotNotHotPlus;
		private JButton bottomShotNotHotMinus;
		public JTextField tBottomShotNotHot;
		
		private JButton hotTopScoredPlus;
		private JButton hotTopScoredMinus;
		public JTextField tHotTopScored;
		private JButton hotTopShotPlus;
		private JButton hotTopShotMinus;
		public JTextField tHotTopShot;
		private JButton hotBottomScoredPlus;
		private JButton hotBottomScoredMinus;
		public JTextField tHotBottomScored;
		private JButton hotBottomShotPlus;
		private JButton hotBottomShotMinus;
		public JTextField tHotBottomShot;
		
		
		public ScoringPanel(){
			  topScoredNotHotPlus = new JButton("+");
			  topScoredNotHotMinus = new JButton("-");
			  tTopScoredNotHot = new JTextField(3);
			  Methods.scoringWithButtons(topScoredNotHotPlus,topScoredNotHotMinus, tTopScoredNotHot);
			  add(new JLabel("Top Scored Not Hot"));
			  add(topScoredNotHotMinus);add(topScoredNotHotPlus);add(tTopScoredNotHot);
			  ///////////////////////////////////
			  topShotNotHotPlus = new JButton("+");
			  topShotNotHotMinus = new JButton("-");
			  tTopShotNotHot = new JTextField(3);
			  Methods.scoringWithButtons(topShotNotHotPlus,topShotNotHotMinus, tTopShotNotHot);
			  add(new JLabel("Top Shot Not Hot"));
			  add(topShotNotHotMinus);add(topShotNotHotPlus);add(tTopShotNotHot);
			  ///////////////////////////////////
			  bottomScoredNotHotPlus = new JButton("+");
			  bottomScoredNotHotMinus = new JButton("-");
			  tBottomScoredNotHot = new JTextField(3);
			  Methods.scoringWithButtons(bottomScoredNotHotPlus,bottomScoredNotHotMinus, tBottomScoredNotHot);
			  add(new JLabel("Bottom Scored Not Hot"));
			  add(bottomScoredNotHotMinus);add(bottomScoredNotHotPlus);add(tBottomScoredNotHot);
			  ///////////////////////////////////
			  bottomShotNotHotPlus = new JButton("+");
			  bottomShotNotHotMinus = new JButton("-");
			  tBottomShotNotHot = new JTextField(3);
			  Methods.scoringWithButtons(bottomShotNotHotPlus,bottomShotNotHotMinus, tBottomShotNotHot);
			  add(new JLabel("Bottom Shot Not Hot"));
			  add(bottomShotNotHotMinus);add(bottomShotNotHotPlus);add(tBottomShotNotHot);
			  ///////////////////////////////////
			  hotTopScoredPlus = new JButton("+");
			  hotTopScoredMinus = new JButton("-");
			  tHotTopScored = new JTextField(3);
			  Methods.scoringWithButtons(hotTopScoredPlus,hotTopScoredMinus, tHotTopScored);
			  add(new JLabel("Top Scored Hot"));
			  add(hotTopScoredMinus);add(hotTopScoredPlus);add(tHotTopScored);
			  ///////////////////////////////////
			  hotTopShotPlus = new JButton("+");
			  hotTopShotMinus = new JButton("-");
			  tHotTopShot = new JTextField(3);
			  Methods.scoringWithButtons(hotTopShotPlus,hotTopShotMinus, tHotTopShot);
			  add(new JLabel("Top Shot Hot"));
			  add(hotTopShotMinus);add(hotTopShotPlus);add(tHotTopShot);
			  ///////////////////////////////////
			  hotBottomScoredPlus = new JButton("+");
			  hotBottomScoredMinus = new JButton("-");
			  tHotBottomScored = new JTextField(3);
			  Methods.scoringWithButtons(hotBottomScoredPlus,hotBottomScoredMinus, tHotBottomScored);
			  add(new JLabel("Bottom Scored Hot"));
			  add(hotBottomScoredMinus);add(hotBottomScoredPlus);add(tHotBottomScored);
			  ///////////////////////////////////
			  hotBottomShotPlus = new JButton("+");
			  hotBottomShotMinus = new JButton("-");
			  tHotBottomShot = new JTextField(3);
			  Methods.scoringWithButtons(hotBottomShotPlus,hotBottomShotMinus, tHotBottomShot);
			  add(new JLabel("Bottom Shot Hot"));
			  add(hotBottomShotMinus);add(hotBottomShotPlus);add(tHotBottomShot);
			  setLayout(new SpringLayout());
			  SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 4, 4,
						0, 0, 0, 0);
		}
		public ScoringPanel(MatchRecord r){
			  topScoredNotHotPlus = new JButton("+");
			  topScoredNotHotMinus = new JButton("-");
			  tTopScoredNotHot = new JTextField(3);
			  Methods.scoringWithButtons(topScoredNotHotPlus,topScoredNotHotMinus, tTopScoredNotHot);
			  add(new JLabel("Top Scored Not Hot"));
			  add(topScoredNotHotMinus);add(topScoredNotHotPlus);add(tTopScoredNotHot);
			  ///////////////////////////////////
			  topShotNotHotPlus = new JButton("+");
			  topShotNotHotMinus = new JButton("-");
			  tTopShotNotHot = new JTextField(3);
			  Methods.scoringWithButtons(topShotNotHotPlus,topShotNotHotMinus, tTopShotNotHot);
			  add(new JLabel("Top Shot Not Hot"));
			  add(topShotNotHotMinus);add(topShotNotHotPlus);add(tTopShotNotHot);
			  ///////////////////////////////////
			  bottomScoredNotHotPlus = new JButton("+");
			  bottomScoredNotHotMinus = new JButton("-");
			  tBottomScoredNotHot = new JTextField(3);
			  Methods.scoringWithButtons(bottomScoredNotHotPlus,bottomScoredNotHotMinus, tBottomScoredNotHot);
			  add(new JLabel("Bottom Scored Not Hot"));
			  add(bottomScoredNotHotMinus);add(bottomScoredNotHotPlus);add(tBottomScoredNotHot);
			  ///////////////////////////////////
			  bottomShotNotHotPlus = new JButton("+");
			  bottomShotNotHotMinus = new JButton("-");
			  tBottomShotNotHot = new JTextField(3);
			  Methods.scoringWithButtons(bottomShotNotHotPlus,bottomShotNotHotMinus, tBottomShotNotHot);
			  add(new JLabel("Bottom Shot Not Hot"));
			  add(bottomShotNotHotMinus);add(bottomShotNotHotPlus);add(tBottomShotNotHot);
			  ///////////////////////////////////
			  hotTopScoredPlus = new JButton("+");
			  hotTopScoredMinus = new JButton("-");
			  tHotTopScored = new JTextField(3);
			  Methods.scoringWithButtons(hotTopScoredPlus,hotTopScoredMinus, tHotTopScored);
			  add(new JLabel("Top Scored Hot"));
			  add(hotTopScoredMinus);add(hotTopScoredPlus);add(tHotTopScored);
			  ///////////////////////////////////
			  hotTopShotPlus = new JButton("+");
			  hotTopShotMinus = new JButton("-");
			  tHotTopShot = new JTextField(3);
			  Methods.scoringWithButtons(hotTopShotPlus,hotTopShotMinus, tHotTopShot);
			  add(new JLabel("Top Shot Hot"));
			  add(hotTopShotMinus);add(hotTopShotPlus);add(tHotTopShot);
			  ///////////////////////////////////
			  hotBottomScoredPlus = new JButton("+");
			  hotBottomScoredMinus = new JButton("-");
			  tHotBottomScored = new JTextField(3);
			  Methods.scoringWithButtons(hotBottomScoredPlus,hotBottomScoredMinus, tHotBottomScored);
			  add(new JLabel("Bottom Scored Hot"));
			  add(hotBottomScoredMinus);add(hotBottomScoredPlus);add(tHotBottomScored);
			  ///////////////////////////////////
			  hotBottomShotPlus = new JButton("+");
			  hotBottomShotMinus = new JButton("-");
			  tHotBottomShot = new JTextField(3);
			  Methods.scoringWithButtons(hotBottomShotPlus,hotBottomShotMinus, tHotBottomShot);
			  add(new JLabel("Bottom Shot Hot"));
			  add(hotBottomShotMinus);add(hotBottomShotPlus);add(tHotBottomShot);
			  setLayout(new SpringLayout());
			  SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 4, 4,
						0, 0, 0, 0);
		}
	}
	class startingAndMobility extends JPanel{
		
		private MatchRecord mR = null;
		
		public startingAndMobility(){
			Methods.addYNBG(this, "Mobility Points", "YES", "NO");
			Methods.addYNBG(this, "Start Zone", "WHITE", "GOALIE");
			setLayout(new SpringLayout());
			 SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 3, 3,
						0, 0, 0, 0);
		}
		public startingAndMobility(MatchRecord r){
			mR = r;
			Methods.addYNBG(this, "Mobility Points", "YES", "NO");
			Methods.addYNBG(this, "Start Zone", "WHITE", "GOALIE");
			setLayout(new SpringLayout());
			 SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 3, 3,
						0, 0, 0, 0);
		}
		private void setMobilityPoints(){
			if( mR != null ){
				startingAndMobility s = (startingAndMobility) getComponents()[2];
				JRadioButton r1 = (JRadioButton)s.getComponents()[1];
				JRadioButton r2 = (JRadioButton)s.getComponents()[2];
				
				if(this.mR.isMobility()){
					r1.setSelected(true);
					r2.setSelected(false);
				}
				else{
					r2.setSelected(true);
					r1.setSelected(false);
				}	
			}
		}
		private void setStartZone(){
			if( mR != null ){	
				startingAndMobility s = (startingAndMobility) getComponents()[2];
				JRadioButton r1 = (JRadioButton)s.getComponents()[4];
				JRadioButton r2 = (JRadioButton)s.getComponents()[5];
				
				if(this.mR.getStartingPosition()){
					r1.setSelected(true);
					r2.setSelected(false);
				}
				else{
					r2.setSelected(true);
					r1.setSelected(false);
				}	
			}
		}
	}


