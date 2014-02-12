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
	public Event(String name, String abbreviation, int id) throws FileNotFoundException {
		_name = name;
		_abbreviation = abbreviation;
		_id = id;
		_teamList = new ArrayList<Team>();
		
		String teamsJson = "";	 
		
		int teamNumber;
		String teamName;

//			teamsJson = new Scanner(ResourceLoader.load(abbreviation + "_teams.json")).useDelimiter("\\A").next();
			teamsJson = new Scanner(new File("./src/resourceLoader/data/" + abbreviation + "_teams.json")).useDelimiter("\\A").next();
			JSONParser parser = new JSONParser();
			JSONArray teamArray = null;
			try {
				teamArray = (JSONArray)((JSONObject)(parser.parse(teamsJson))).get("data");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < teamArray.size(); i++) {
				JSONObject eventObject = (JSONObject)(teamArray.get(i));
				teamName = (String)(eventObject.get("name"));
				teamNumber = Integer.parseInt((String)(eventObject.get("number")));
				_teamList.add(new Team(teamNumber, teamName));
			}
		//}
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
	public void saveToFile() {
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
			PrintWriter writer = new PrintWriter(("data/" + _abbreviation +"_data.json"));
			writer.println(jsonText);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}
