package inputSubPanels;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.*;

import javax.swing.*;
import javax.swing.text.*;

import org.json.simple.*;

import fullapp.MatchRecord;
/**
 *
 * @author michael
 */
public class Methods {
    
    public static void createButtonGroup(JPanel panel, String label){
        ButtonGroup bg = new ButtonGroup();
        panel.add(new JLabel(label));
        for( Integer i = 1; i <= 5; i++ ){
            JRadioButton b = new JRadioButton(i.toString());
            bg.add(b);
            panel.add(b);
        }  
    }

    public static void clearAndResetText(final JTextComponent t, final String label){
        t.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent e) {}

            public void mousePressed(MouseEvent e) {}

            public void mouseReleased(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {
                if(t.getText().equals(label))
                    t.setText("");
            }

            public void mouseExited(MouseEvent e) {
                if( t.getText().equals("") || (t.getText().equals(" ") && t.getCaret() == null)){
                    t.setText(label);
                }
            }
            
        });
    }

    /**
     *
     * @param panel
     * @param label
     * @param b1
     * @param b2
     */
    public static void addYNBG(JPanel panel,String label,String b1, String b2){
        panel.add(new JLabel(label));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton y = new JRadioButton(b1);
        JRadioButton n = new JRadioButton(b2);
        bg.add(y);bg.add(n);
        panel.add(y);panel.add(n);
    }
    private static void plusButton(final JButton p, final JTextField t){
    	p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Integer i = Integer.parseInt(t.getText()) + 1;
				t.setText(i.toString());
			}
    		
    	});
    }
    private static void minusButton(final JButton m, final JTextField t){
    	m.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Integer i = Integer.parseInt(t.getText()) - 1;
				t.setText(i.toString());
			}
    		
    	});
    }
    public static void scoringWithButtons(JButton plus, JButton minus, JTextField score){
    	plusButton(plus,score);
    	minusButton(minus,score);
    	score.setEditable(false);
    	score.setText("0");
    }
	@SuppressWarnings("unchecked")
	public static void saveMATCHToFile(MatchRecord r) throws IOException {
		
				JSONObject matchRecordObj = new JSONObject();
				
				matchRecordObj.put("teamNumber", r.getTeamNumber());
				matchRecordObj.put("teamName",r.getTeamName());
				matchRecordObj.put("eventAbbreviation", r.getEventAbbreviation());
				matchRecordObj.put("matchNumber", r.getMatchNumber());
				matchRecordObj.put("scoutName",r.getScoutName());
				//////////////////////////////////////////
				matchRecordObj.put("autoTopScoredNotHot",r.getAutoTopScoredNotHot());
				matchRecordObj.put("autoTopShotNotHot",r.getAutoTopShotNotHot());
				matchRecordObj.put("autoBottomScoredNotHot",r.getAutoBottomScoredNotHot());
				matchRecordObj.put("autoBottomShotNotHot",r.getAutoBottomShotNotHot());
				matchRecordObj.put("hotGoalTopScored",r.getHotGoalTopScored());
				matchRecordObj.put("hotGoalTopShot",r.getHotGoalTopShot());
				matchRecordObj.put("hotGoalBottomScored",r.getHotGoalBottomScored());
				matchRecordObj.put("hotGoalBottomShot",r.getHotGoalBottomShot());
				matchRecordObj.put("mobility", r.isMobility());
				//////////////////////////////////////////
				matchRecordObj.put("startingPosition", r.getStartingPosition());
				matchRecordObj.put("positionPlayed", r.getPositionPlayed());
				matchRecordObj.put("speed", r.getSpeed());
				matchRecordObj.put("agility", r.getAgility());
				matchRecordObj.put("pushingAbility", r.getPushingAbility());
				matchRecordObj.put("stability", r.getStability());
				//////////////////////////////////////////
				matchRecordObj.put("ballsScoredTopTeleop", r.getBallsScoredTopTeleop());
				matchRecordObj.put("ballsShotTopTeleop", r.getBallsShotTopTeleop());
				matchRecordObj.put("ballsScoredBottomTeleop", r.getBallsScoredBottomTeleop());
				matchRecordObj.put("ballsShotBottomTeleop", r.getBallsShotBottomTeleop());
				matchRecordObj.put("shooterSpeed", r.getShooterSpeed());
				matchRecordObj.put("pickUpSpeed", r.getPickUpSpeed());
				//////////////////////////////////////////
				matchRecordObj.put("possessions", r.getPossessions());
				matchRecordObj.put("successfulPasses", r.getSuccessfulPasses());
				matchRecordObj.put("totalPasses", r.getTotalPasses());
				matchRecordObj.put("successfulTrussThrows", r.getSuccessfulTrussThrows());
				matchRecordObj.put("totalTrussThrows", r.getTotalTrussThrows());
				matchRecordObj.put("successfulCatches", r.getSuccessfulCatches());
				matchRecordObj.put("totalCatches", r.getTotalCatches());
				//////////////////////////////////////////
				matchRecordObj.put("autoComment", r.getAutoComment());
				matchRecordObj.put("penaltyComment", r.getPenaltyComment());
				matchRecordObj.put("interestingStrategyComment", r.getInterestingStrategyComment());
				matchRecordObj.put("robotFlaws", r.getRobotFlaws());
				String path = System.getProperty("user.home") + "/Desktop/";
				File f = new File(path +Integer.toString(r.getTeamNumber())+"-"+Integer.toString(r.getMatchNumber())+"_match"+".json");
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(matchRecordObj.toJSONString());
				bw.close();
	}
}
