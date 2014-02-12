package fullapp;
import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

import resourceLoader.ResourceLoader;

public class Event {
	public String _name;
	public String _abbreviation;
	public int _id;
	public ArrayList<Team> _teamList;
	
	public Event() {
		_name = "";
		_abbreviation = "";
		_id = 0;
		_teamList = new ArrayList<Team>();
	}

	@SuppressWarnings("resource")
	public Event(String name, String abbreviation, int id) throws FileNotFoundException, ParseException {
		_name = name;
		_abbreviation = abbreviation;
		_id = id;
		_teamList = new ArrayList<Team>();
		
		String teamsJson = "";	 
		
		int teamNumber;
		String teamName;
		File eventDataFile = new File(EventOverviewWindow.pathToData + "/data/" + abbreviation + "_data.json");
		File teamListFile = new File(EventOverviewWindow.pathToData + "/data/" + abbreviation + "_teams.json");
		
		if(eventDataFile.exists()){
			teamsJson = new Scanner(eventDataFile).useDelimiter("\\A").next();
			JSONParser parser = new JSONParser();
			JSONArray teamArray = null;
			try {
				teamArray = ((JSONArray) parser.parse(teamsJson));//.get("data");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < teamArray.size(); i++) {
				JSONObject teamObject = (JSONObject)(teamArray.get(i));
				teamName = (String) (teamObject.get("name"));
				teamNumber = Integer.parseInt("" + teamObject.get("number"));
				_teamList.add(new Team(teamNumber,teamName));
				JSONArray matchRecordsArray = (JSONArray) teamObject.get("matchRecords");
				for( int j = 0; j < matchRecordsArray.size(); j++ ){
					JSONObject matchObj = (JSONObject) matchRecordsArray.get(j);
					
					int teamNumber2 = Integer.parseInt("" + matchObj.get("teamNumber"));
					String teamName2 = ("" + matchObj.get("teamName"));
					String eventAbbreviation = ("" + matchObj.get("eventAbbreviation"));
					int matchNumber  = Integer.parseInt("" + matchObj.get("matchNumber"));
					String scoutName = ("" + matchObj.get("scoutName"));
					
					int autoTopScoredNotHot = Integer.parseInt("" + matchObj.get("autoTopScoredNotHot"));
					int autoTopShotNotHot = Integer.parseInt("" + matchObj.get("autoTopShotNotHot"));
					int autoBottomScoredNotHot = Integer.parseInt("" + matchObj.get("autoBottomScoredNotHot"));
					int autoBottomShotNotHot = Integer.parseInt("" + matchObj.get("autoBottomShotNotHot"));
					int hotGoalTopScored = Integer.parseInt("" + matchObj.get("hotGoalTopScored"));
					int hotGoalTopShot = Integer.parseInt("" + matchObj.get("hotGoalTopShot"));
					int hotGoalBottomScored = Integer.parseInt("" + matchObj.get("hotGoalBottomScored"));
					int hotGoalBottomShot = Integer.parseInt("" + matchObj.get("hotGoalBottomShot"));
					boolean mobility = Boolean.parseBoolean(("" + matchObj.get("mobility")));
					
					boolean startingPosition = Boolean.parseBoolean(("" + matchObj.get("startingPosition")));
					String positionPlayed = ("" + matchObj.get("positionPlayed"));
					int speed = Integer.parseInt("" + matchObj.get("speed"));
					int agility = Integer.parseInt("" + matchObj.get("agility"));
					int pushingAbility = Integer.parseInt("" + matchObj.get("pushingAbility"));
					int stability = Integer.parseInt("" + matchObj.get("stability"));
					
				    int ballsScoredTopTeleop = Integer.parseInt("" + matchObj.get("ballsScoredTopTeleop"));
				    int ballsShotTopTeleop = Integer.parseInt("" + matchObj.get("ballsShotTopTeleop"));
				    int ballsScoredBottomTeleop = Integer.parseInt("" + matchObj.get("ballsScoredBottomTeleop"));
				    int ballsShotBottomTeleop = Integer.parseInt("" + matchObj.get("ballsShotBottomTeleop"));
				    int shooterSpeed = Integer.parseInt("" + matchObj.get("shooterSpeed"));
				    int pickUpSpeed = Integer.parseInt("" + matchObj.get("pickUpSpeed"));
					
				    int possessions = Integer.parseInt("" + matchObj.get("possessions"));
				    int successfulPasses = Integer.parseInt("" + matchObj.get("successfulPasses"));
				    int totalPasses = Integer.parseInt("" + matchObj.get("totalPasses"));
				    int successfulTrussThrows = Integer.parseInt("" + matchObj.get("successfulTrussThrows"));
				    int totalTrussThrows = Integer.parseInt("" + matchObj.get("totalTrussThrows"));
				    int successfulCatches = Integer.parseInt("" + matchObj.get("successfulCatches"));
				    int totalCatches = Integer.parseInt("" + matchObj.get("totalCatches"));				    
					
				    String autoComment = ("" + matchObj.get("autoComment"));
				    String penaltyComment = ("" + matchObj.get("penaltyComment"));
				    String interestingStrategyComment = ("" + matchObj.get("interesintgStrategyComment"));
				    String robotFlaws = ("" + matchObj.get("robotFlaws"));    
			
					_teamList.get(j).addMatchRecord(new MatchRecord(teamNumber2,teamName2,eventAbbreviation,matchNumber,
					scoutName,autoTopScoredNotHot,autoTopShotNotHot,
					autoBottomScoredNotHot,autoBottomShotNotHot,hotGoalTopScored,
					hotGoalTopShot,hotGoalBottomScored,hotGoalBottomShot,
					mobility,positionPlayed,startingPosition,speed,agility,
					pushingAbility,stability,ballsScoredTopTeleop,
					ballsShotTopTeleop,ballsScoredBottomTeleop,
					ballsShotBottomTeleop,shooterSpeed,pickUpSpeed,
					possessions,successfulPasses,totalPasses,
					successfulTrussThrows,totalTrussThrows,
					successfulCatches,totalCatches,autoComment,
					penaltyComment,interestingStrategyComment,
					robotFlaws));
					}
				}
			}
		else{
			teamsJson = new Scanner(teamListFile).useDelimiter("\\A").next();
			JSONParser parser = new JSONParser();
			JSONArray teamArray = null;
			try {
				teamArray = (JSONArray)((JSONObject)(parser.parse(teamsJson))).get("data");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < teamArray.size(); i++) {
				JSONObject teamObject = (JSONObject)(teamArray.get(i));
				teamName = (String)(teamObject.get("name"));
				teamNumber = Integer.parseInt((String)(teamObject.get("number")));
				_teamList.add(new Team(teamNumber,teamName));
			}
		}
	}
	
	
	
	public String getName() {
		return _name;
	}
	
	public String getAbbreviation() {
		return _abbreviation;
	}
	
	public int getId() {
		return _id;
	}
	
	public ArrayList<Team> getTeamList() {
		return _teamList;
	}
	public double getAverageAutonomousScore() {
		double total = 0;
		for (int i = 0; i < _teamList.size(); i++) {
			total += _teamList.get(i).getAverageAutonPointsPerMatch();
		}
		double avg = total / _teamList.size(); 
		return (double)Math.round(avg * 10000) / 10000;
	}
	
	public double getAverageTeleoperatedScore() {
		double total = 0;
		for (int i = 0; i < _teamList.size(); i++) {
			total += _teamList.get(i).getAverageTeleopPointsPerMatch();
		}
		double avg = total / _teamList.size(); 
		return (double)Math.round(avg * 10000) / 10000;
	}

	public double getAveragePointsPerMatch() {
		double total = 0;
		for (int i = 0; i < _teamList.size(); i++) {
			total += _teamList.get(i).getAveragePointsPerMatch();
		}
		double avg = total / _teamList.size(); 
		return (double)Math.round(avg * 10000) / 10000;
	}
	
	@SuppressWarnings("unchecked")
	public void saveToFile() throws IOException {
		File dataFile = new File(EventOverviewWindow.pathToData + "/data/" + getAbbreviation() + "_data.json" );
		if(!dataFile.exists())
			dataFile.createNewFile();
		JSONArray teamList = new JSONArray();
		for (int i = 0; i < _teamList.size(); i++) {
			Team team = _teamList.get(i);
			
			JSONObject teamObj = new JSONObject();
			teamObj.put("number", team.getNumber());
			teamObj.put("name", team.getName());
			
			JSONArray matchRecordArray = new JSONArray();
			for (int j = 0; j < team.getNumberOfMatchRecords(); j++) {
				
				MatchRecord r = team.getMatchRecord(j);
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
				matchRecordArray.add(matchRecordObj);
			}
			
			teamObj.put("matchRecords", matchRecordArray);
			teamList.add(teamObj);
		}
		
		StringWriter out = new StringWriter();
		try {
			JSONValue.writeJSONString(teamList, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String jsonText = out.toString();
		try {
			PrintWriter writer = new PrintWriter(dataFile);
			writer.println(jsonText);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}
