package fullapp;
import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

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

	public Event(String name, String abbreviation, int id) throws Exception{
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
			JSONArray teamArray = ((JSONArray) parser.parse(teamsJson));//.get("data");	
			
			for (int i = 0; i < teamArray.size(); i++) {
				JSONObject teamObject = (JSONObject)(teamArray.get(i));
				teamName = (String) (teamObject.get("name"));
				teamNumber = Integer.parseInt("" + teamObject.get("number"));
				_teamList.add(new Team(teamNumber,teamName));
				
				JSONObject interviewObj = (JSONObject)teamObject.get("interview");
				
				String orientation = "" + interviewObj.get("orientation");
				int driveMotorsNum = Integer.parseInt("" + interviewObj.get("driveMotorsNum"));
				double weight = Double.parseDouble("" + interviewObj.get("weight"));
				int numberOfWheels = Integer.parseInt("" + interviewObj.get("numberOfWheels"));
				int autonBallCount = Integer.parseInt("" + interviewObj.get("autonBallCount"));
				
				boolean canMakeTrussShots = Boolean.parseBoolean("" + interviewObj.get("canMakeTrussShots"));
				boolean hasAuton = Boolean.parseBoolean("" + interviewObj.get("hasAuton"));
				boolean targetHotGoal = Boolean.parseBoolean("" + interviewObj.get("targetHotGoal"));
				
				String driveMotorsType = "" + interviewObj.get("driveMotorsType");
				String hasDropCenterWheels = "" + interviewObj.get("hasDropCenterWheels");
				String driveSystem = "" + interviewObj.get("driveSystem");
				String shooterType = "" + interviewObj.get("shooterType");
				String generalGoals = "" + interviewObj.get("generalGoals");
				String ballAquirySystem = "" + interviewObj.get("ballAquirySystem");
				String intakeType = "" + interviewObj.get("intakeType");
				String catcherType = "" + interviewObj.get("catcherType");
				String autonStartingPos = "" + interviewObj.get("autonStartingPos");
				String autonGoals = "" + interviewObj.get("autonGoals");
			
				Interview interview = new Interview(teamNumber,teamName,orientation,
						driveMotorsNum,weight,numberOfWheels,
						autonBallCount,canMakeTrussShots,hasAuton,
						targetHotGoal,driveMotorsType,
						hasDropCenterWheels,driveSystem,shooterType,
						generalGoals,ballAquirySystem,intakeType,
						catcherType,autonStartingPos,autonGoals);
				_teamList.get(i).setInterview(interview);
				
				JSONArray matchRecordsArray = (JSONArray) teamObject.get("matchRecords");
				for( int j = 0; j < matchRecordsArray.size(); j++ ){
					JSONObject matchObj = (JSONObject) matchRecordsArray.get(j);
					
					/*General Info*/
					int teamNumber2 = Integer.parseInt("" + matchObj.get("teamNumber"));
					String teamName2 = "" + matchObj.get("teamName");
					int matchNumber = Integer.parseInt("" + matchObj.get("matchNumber"));
					String scoutName = "" + matchObj.get("scoutName");
					/*Autonomous*/
					int topAutonScored = Integer.parseInt("" + matchObj.get("topAutonScored"));
					int topAutonShot = Integer.parseInt("" + matchObj.get("topAutonShot"));
					int bottomAutonScored = Integer.parseInt("" + matchObj.get("bottomAutonScored"));
					int bottomAutonShot = Integer.parseInt("" + matchObj.get("bottomAutonShot"));
					int topHot = Integer.parseInt("" + matchObj.get("topHot"));
					int bottomHot = Integer.parseInt("" + matchObj.get("bottomHot"));
					boolean mobilityPoints = Boolean.parseBoolean("" + matchObj.get("mobilityPoints"));
					/*Drive System*/
					String posistionPlayed = "" + matchObj.get("positionPlayed");
					int speed = Integer.parseInt("" + matchObj.get("speed"));
					int driverAbility = Integer.parseInt("" + matchObj.get("driverAbility"));
					int stability = Integer.parseInt("" + matchObj.get("stability"));
					int pushingAbility = Integer.parseInt("" + matchObj.get("pushingAbility"));
					/*Shooting,Intake*/
					int topTeleopScored = Integer.parseInt("" + matchObj.get("topTeleopScored"));
					int topTeleopShot = Integer.parseInt("" + matchObj.get("topTeleopShot"));
					int bottomTeleopScored = Integer.parseInt("" + matchObj.get("bottomTeleopScored"));
					int bottomTeleopShot = Integer.parseInt("" + matchObj.get("bottomTeleopShot"));
					int shootingSpeed = Integer.parseInt("" + matchObj.get("shootingSpeed"));
					int shootingAccuracy = Integer.parseInt("" + matchObj.get("shootingAccuracy"));
					int acquisitionSpeed = Integer.parseInt("" + matchObj.get("acquisitionSpeed"));
					String acquisitionLocation = "" + matchObj.get("acquisitonLocation");
					/*Assisting and Catching*/
					int passesComplete = Integer.parseInt("" + matchObj.get("passesComplete"));
					int passesTotal = Integer.parseInt("" + matchObj.get("passesTotal"));
					int trussThrowsComplete = Integer.parseInt("" + matchObj.get("trussThrowsComplete"));
					int trussThrowsTotal = Integer.parseInt("" + matchObj.get("trussThrowsTotal"));
					int catchesComplete = Integer.parseInt("" + matchObj.get("catchesComplete"));
					int catchesTotal = Integer.parseInt("" + matchObj.get("catchesTotal"));
					/*Comments*/
					String penalties = "" + matchObj.get("penalties");
					String overallGamePlay = "" + matchObj.get("overallGamePlay");
					//////////////////////////
					
					_teamList.get(i).addMatchRecord(new MatchRecord(teamNumber2,teamName2,matchNumber,
							scoutName,topAutonScored,topAutonShot,
							bottomAutonScored,bottomAutonShot,topHot,
							bottomHot,mobilityPoints,posistionPlayed,
							speed,driverAbility,stability,pushingAbility,
							topTeleopScored,topTeleopShot,bottomTeleopScored,
							bottomTeleopShot,shootingSpeed,shootingAccuracy,
							acquisitionSpeed,acquisitionLocation,
							passesComplete,passesTotal,trussThrowsComplete,
							trussThrowsTotal,catchesComplete,catchesTotal,
							penalties,overallGamePlay));
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
			
			JSONObject interviewObj = new JSONObject();
			Interview in = team.getInterview();
			
			interviewObj.put("teamNumber", in.getTeamNumber());
			interviewObj.put("teamName", in.getTeamName());

			interviewObj.put("orientation", in.getOrientation());
			interviewObj.put("driveMotorsNum", in.getDriveMotorsNum());
			interviewObj.put("weight", in.getWeight());
			interviewObj.put("numberOfWheels", in.getNumberOfWheels());
			interviewObj.put("autonBallCount", in.getAutonBallCount());
			interviewObj.put("canMakeTrussShots", in.getCanMakeTrussShots());
			interviewObj.put("hasAuton", in.getHasAuton());
			interviewObj.put("targetHotGoal", in.getTargetHotGoal());
			interviewObj.put("driveMotorsType", in.getDriveMotorsType());
			interviewObj.put("hasDropCenterWheels", in.getHasDropCenterWheels());
			interviewObj.put("driveSystem", in.getDriveSystem());
			interviewObj.put("shooterType", in.getShooterType());
			interviewObj.put("generalGoals", in.getGeneralGoals());
			interviewObj.put("ballAquirySystem", in.getBallAquirySystem());
			interviewObj.put("intakeType", in.getIntakeType());
			interviewObj.put("catcherType",in.getCatcherType());
			interviewObj.put("autonStartingPos", in.getAutonStartingPos());
			interviewObj.put("autonGoals", in.getAutonGoals());
			
			teamObj.put("interview", interviewObj);
			
			JSONArray matchRecordArray = new JSONArray();
			for (int j = 0; j < team.getNumberOfMatchRecords(); j++) {
				
				MatchRecord r = team.getMatchRecord(j);
				JSONObject matchRecordObj = new JSONObject();
				
				matchRecordObj.put("teamNumber", r.getTeamNumber());
				matchRecordObj.put("teamName",r.getTeamName());
				matchRecordObj.put("matchNumber", r.getMatchNumber());
				matchRecordObj.put("scoutName",r.getScoutName());
				
				matchRecordObj.put("topAutonScored",r.getTopAutonScored());
				matchRecordObj.put("topAutonShot",r.getTopAutonShot());
				matchRecordObj.put("bottomAutonScored",r.getBottomAutonScored());
				matchRecordObj.put("bottomAutonShot",r.getBottomAutonShot());
				matchRecordObj.put("topHot",r.getTopHot());
				matchRecordObj.put("bottomHot",r.getBottomHot());
				matchRecordObj.put("mobilityPoints",r.isMobilityPoints());
				
				matchRecordObj.put("driverAbility", r.getDriverAbility());
				matchRecordObj.put("speed", r.getSpeed());
				matchRecordObj.put("stability", r.getStability());
				matchRecordObj.put("pushingAbility", r.getPushingAbility());
				matchRecordObj.put("positionPlayed", r.getPosistionPlayed());
				
				matchRecordObj.put("topTeleopScored", r.getTopTeleopScored());
				matchRecordObj.put("topTeleopShot", r.getTopTeleopShot());
				matchRecordObj.put("bottomTeleopScored", r.getBottomTeleopScored());
				matchRecordObj.put("bottomTeleopShot", r.getBottomTeleopShot());
				matchRecordObj.put("shootingSpeed", r.getShootingSpeed());
				matchRecordObj.put("shootingAccuracy", r.getShootingAccuracy());
				matchRecordObj.put("acquisitionSpeed", r.getAcquisitionSpeed());
				matchRecordObj.put("aquisitionLocation", r.getAcquisitionLocation());
				
				matchRecordObj.put("passesComplete", r.getPassesComplete());
				matchRecordObj.put("passesTotal", r.getPassesTotal());
				matchRecordObj.put("trussThrowsComplete", r.getTrussThrowsComplete());
				matchRecordObj.put("trussThrowsTotal", r.getTrussThrowsTotal());
				matchRecordObj.put("catchesComplete", r.getCatchesComplete());
				matchRecordObj.put("catchesTotal", r.getCatchesTotal());
				
				matchRecordObj.put("penalties", r.getPenalties());
				matchRecordObj.put("overallGamePlay", r.getOverallGamePlay());
				
				/*matchRecordObj.put("teamNumber", r.getTeamNumber());
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
				matchRecordObj.put("autonComment", r.getAutonComment());*/

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
