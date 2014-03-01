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

            @Override
			public void mouseClicked(MouseEvent e) {}

            @Override
			public void mousePressed(MouseEvent e) {}

            @Override
			public void mouseReleased(MouseEvent e) {}

            @Override
			public void mouseEntered(MouseEvent e) {
                if(t.getText().equals(label))
                    t.setText("");
            }

            @Override
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

	@SuppressWarnings("unchecked")
	public static void saveMATCHToFile(MatchRecord r) throws IOException {
		
				JSONObject matchRecordObj = new JSONObject();
				
				matchRecordObj.put("teamNumber", r.getTeamNumber());
				matchRecordObj.put("teamName",r.getTeamName());
				matchRecordObj.put("matchNumber", r.getMatchNumber());
				matchRecordObj.put("scoutName",r.getScoutName());
				//////////////////////////////////////////
				matchRecordObj.put("topAutonScored",r.getTopAutonScored());
				matchRecordObj.put("topAutonShot",r.getTopAutonShot());
				matchRecordObj.put("bottomAutonScored",r.getBottomAutonScored());
				matchRecordObj.put("bottomAutonShot",r.getBottomAutonShot());
				matchRecordObj.put("topHot",r.getTopHot());
				matchRecordObj.put("bottomHot",r.getBottomHot());
				matchRecordObj.put("mobilityPoints",r.isMobilityPoints());
				matchRecordObj.put("startZone",r.isStartZone());
				//////////////////////////////////////////
				matchRecordObj.put("driverAbility", r.getDriverAbility());
				matchRecordObj.put("speed", r.getSpeed());
				matchRecordObj.put("maneuverability", r.getManeuverability());
				matchRecordObj.put("stability", r.getStability());
				matchRecordObj.put("pushingAbility", r.getPushingAbility());
				matchRecordObj.put("positionPlayed", r.getPosistionPlayed());
				//////////////////////////////////////////
				matchRecordObj.put("topTeleopScored", r.getTopTeleopScored());
				matchRecordObj.put("topTeleopShot", r.getTopTeleopShot());
				matchRecordObj.put("bottomTeleopScored", r.getBottomTeleopScored());
				matchRecordObj.put("bottomTeleopShot", r.getBottomTeleopShot());
				matchRecordObj.put("shootingSpeed", r.getShootingSpeed());
				matchRecordObj.put("shootingAccuracy", r.getShootingAccuracy());
				matchRecordObj.put("acquisitionSpeed", r.getAcquisitionSpeed());
				matchRecordObj.put("aquisitionLocation", r.getAcquisitionLocation());
				//////////////////////////////////////////
				matchRecordObj.put("possessions", r.getPossessions());
				matchRecordObj.put("passesComplete", r.getPassesComplete());
				matchRecordObj.put("passesTotal", r.getPassesTotal());
				matchRecordObj.put("trussThrowsComplete", r.getTrussThrowsComplete());
				matchRecordObj.put("trussThrowsTotal", r.getTrussThrowsTotal());
				matchRecordObj.put("catchesComplete", r.getCatchesComplete());
				matchRecordObj.put("catchesTotal", r.getCatchesTotal());
				//////////////////////////////////////////
				matchRecordObj.put("penalties", r.getPenalties());
				matchRecordObj.put("overallGamePlay", r.getOverallGamePlay());
				matchRecordObj.put("robotFlaws", r.getRobotFlaws());
				matchRecordObj.put("allianceComment", r.getAllianceComment());
				matchRecordObj.put("autonComment", r.getAutonComment());
				
				String path = System.getProperty("user.home") + "/Desktop/";
				File f = new File(path +Integer.toString(r.getTeamNumber())+"-"+Integer.toString(r.getMatchNumber())+"_match"+".json");
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(matchRecordObj.toJSONString());
				bw.close();
	}
}
