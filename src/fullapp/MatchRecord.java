package fullapp;
 
public class MatchRecord{ 
	
	///////////////////////
	private int teamNumber;
	private String teamName;
	private int matchNumber;
	private String scoutName;
	////////////////////////
	private int topAutonScored;
	private int topAutonShot;
	private int bottomAutonScored;
	private int bottomAutonShot;
	private int topHot;
	private int bottomHot;
	private boolean mobilityPoints;
	private boolean startZone;
	/////////////////////////
	private int driverAbility;
	private int speed;
	private int maneuverability;
	private int stability;
	private int pushingAbility;
	private String posistionPlayed;
	/////////////////////////
	private int topTeleopScored;
	private int topTeleopShot;
	private int bottomTeleopScored;
	private int bottomTeleopShot;
	private int shootingSpeed;
	private int shootingAccuracy;
	private int acquisitionSpeed;
	private String acquisitionLocation;
	//////////////////////////
	private int possessions;
	private int passesComplete;
	private int passesTotal;
	private int trussThrowsComplete;
	private int trussThrowsTotal;
	private int catchesComplete;
	private int catchesTotal;
	//////////////////////////
	private String penalties;
	private String overallGamePlay;
	private String robotFlaws;
	private String allianceComment;
	private String autonComment;
	//////////////////////////
	
	public MatchRecord(){
		  teamNumber = 0;
		  teamName = "";
		  matchNumber = 0;
		  scoutName = "";
		  topAutonScored = 0;
		  topAutonShot = 0;
		  bottomAutonScored = 0;
		  bottomAutonShot = 0;
		  topHot = 0;
		  bottomHot = 0;
		  mobilityPoints = false;
		  startZone = false;
		  driverAbility = 0;
		  speed = 0;
		  maneuverability = 0;
		  stability = 0;
		  pushingAbility = 0;
		  posistionPlayed = "";
		  topTeleopScored = 0;
		  topTeleopShot = 0;
		  bottomTeleopScored = 0;
		  bottomTeleopShot = 0;
		  shootingSpeed = 0;
		  shootingAccuracy = 0;
		  acquisitionSpeed = 0;
		  acquisitionLocation = "";
		  possessions = 0;
		  passesComplete = 0;
		  passesTotal = 0;
		  trussThrowsComplete = 0;
		  trussThrowsTotal = 0;
		  catchesComplete = 0;
		  catchesTotal = 0;
		  penalties = "";
		  overallGamePlay = "";
		  robotFlaws = "";
		  allianceComment = "";
		  autonComment = "";
	}
	
	public MatchRecord(int teamNumber, String teamName, int matchNumber,
			String scoutName, int topAutonScored, int topAutonShot,
			int bottomAutonScored, int bottomAutonShot, int topHot,
			int bottomHot, boolean mobilityPoints, boolean startZone,
			int driverAbility, int speed, int maneuverability, int stability,
			int pushingAbility, String posistionPlayed, int topTeleopScored,
			int topTeleopShot, int bottomTeleopScored, int bottomTeleopShot,
			int shootingSpeed, int shootingAccuracy, int acquisitionSpeed,
			String acquisitionLocation, int possessions, int passesComplete,
			int passesTotal, int trussThrowsComplete, int trussThrowsTotal,
			int catchesComplete, int catchesTotal, String penalties,
			String overallGamePlay, String robotFlaws, String allianceComment,
			String autonComment) {
		this.teamNumber = teamNumber;
		this.teamName = teamName;
		this.matchNumber = matchNumber;
		this.scoutName = scoutName;
		this.topAutonScored = topAutonScored;
		this.topAutonShot = topAutonShot;
		this.bottomAutonScored = bottomAutonScored;
		this.bottomAutonShot = bottomAutonShot;
		this.topHot = topHot;
		this.bottomHot = bottomHot;
		this.mobilityPoints = mobilityPoints;
		this.startZone = startZone;
		this.driverAbility = driverAbility;
		this.speed = speed;
		this.maneuverability = maneuverability;
		this.stability = stability;
		this.pushingAbility = pushingAbility;
		this.posistionPlayed = posistionPlayed;
		this.topTeleopScored = topTeleopScored;
		this.topTeleopShot = topTeleopShot;
		this.bottomTeleopScored = bottomTeleopScored;
		this.bottomTeleopShot = bottomTeleopShot;
		this.shootingSpeed = shootingSpeed;
		this.shootingAccuracy = shootingAccuracy;
		this.acquisitionSpeed = acquisitionSpeed;
		this.acquisitionLocation = acquisitionLocation;
		this.possessions = possessions;
		this.passesComplete = passesComplete;
		this.passesTotal = passesTotal;
		this.trussThrowsComplete = trussThrowsComplete;
		this.trussThrowsTotal = trussThrowsTotal;
		this.catchesComplete = catchesComplete;
		this.catchesTotal = catchesTotal;
		this.penalties = penalties;
		this.overallGamePlay = overallGamePlay;
		this.robotFlaws = robotFlaws;
		this.allianceComment = allianceComment;
		this.autonComment = autonComment;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	public String getScoutName() {
		return scoutName;
	}

	public void setScoutName(String scoutName) {
		this.scoutName = scoutName;
	}

	public int getTopAutonScored() {
		return topAutonScored;
	}

	public void setTopAutonScored(int topAutonScored) {
		this.topAutonScored = topAutonScored;
	}

	public int getTopAutonShot() {
		return topAutonShot;
	}

	public void setTopAutonShot(int topAutonShot) {
		this.topAutonShot = topAutonShot;
	}

	public int getBottomAutonScored() {
		return bottomAutonScored;
	}

	public void setBottomAutonScored(int bottomAutonScored) {
		this.bottomAutonScored = bottomAutonScored;
	}

	public int getBottomAutonShot() {
		return bottomAutonShot;
	}

	public void setBottomAutonShot(int bottomAutonShot) {
		this.bottomAutonShot = bottomAutonShot;
	}

	public int getTopHot() {
		return topHot;
	}

	public void setTopHot(int topHot) {
		this.topHot = topHot;
	}

	public int getBottomHot() {
		return bottomHot;
	}

	public void setBottomHot(int bottomHot) {
		this.bottomHot = bottomHot;
	}

	public boolean isMobilityPoints() {
		return mobilityPoints;
	}

	public void setMobilityPoints(boolean mobilityPoints) {
		this.mobilityPoints = mobilityPoints;
	}

	public boolean isStartZone() {
		return startZone;
	}

	public void setStartZone(boolean startZone) {
		this.startZone = startZone;
	}

	public int getDriverAbility() {
		return driverAbility;
	}

	public void setDriverAbility(int driverAbility) {
		this.driverAbility = driverAbility;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getManeuverability() {
		return maneuverability;
	}

	public void setManeuverability(int maneuverability) {
		this.maneuverability = maneuverability;
	}

	public int getStability() {
		return stability;
	}

	public void setStability(int stability) {
		this.stability = stability;
	}

	public int getPushingAbility() {
		return pushingAbility;
	}

	public void setPushingAbility(int pushingAbility) {
		this.pushingAbility = pushingAbility;
	}

	public String getPosistionPlayed() {
		return posistionPlayed;
	}

	public void setPosistionPlayed(String posistionPlayed) {
		this.posistionPlayed = posistionPlayed;
	}

	public int getTopTeleopScored() {
		return topTeleopScored;
	}

	public void setTopTeleopScored(int topTeleopScored) {
		this.topTeleopScored = topTeleopScored;
	}

	public int getTopTeleopShot() {
		return topTeleopShot;
	}

	public void setTopTeleopShot(int topTeleopShot) {
		this.topTeleopShot = topTeleopShot;
	}

	public int getBottomTeleopScored() {
		return bottomTeleopScored;
	}

	public void setBottomTeleopScored(int bottomTeleopScored) {
		this.bottomTeleopScored = bottomTeleopScored;
	}

	public int getBottomTeleopShot() {
		return bottomTeleopShot;
	}

	public void setBottomTeleopShot(int bottomTeleopShot) {
		this.bottomTeleopShot = bottomTeleopShot;
	}

	public int getShootingSpeed() {
		return shootingSpeed;
	}

	public void setShootingSpeed(int shootingSpeed) {
		this.shootingSpeed = shootingSpeed;
	}

	public int getShootingAccuracy() {
		return shootingAccuracy;
	}

	public void setShootingAccuracy(int shootingAccuracy) {
		this.shootingAccuracy = shootingAccuracy;
	}

	public int getAcquisitionSpeed() {
		return acquisitionSpeed;
	}

	public void setAcquisitionSpeed(int acquisitionSpeed) {
		this.acquisitionSpeed = acquisitionSpeed;
	}

	public String getAcquisitionLocation() {
		return acquisitionLocation;
	}

	public void setAcquisitionLocation(String acquisitionLocation) {
		this.acquisitionLocation = acquisitionLocation;
	}

	public int getPossessions() {
		return possessions;
	}

	public void setPossessions(int possessions) {
		this.possessions = possessions;
	}

	public int getPassesComplete() {
		return passesComplete;
	}

	public void setPassesComplete(int passesComplete) {
		this.passesComplete = passesComplete;
	}

	public int getPassesTotal() {
		return passesTotal;
	}

	public void setPassesTotal(int passesTotal) {
		this.passesTotal = passesTotal;
	}

	public int getTrussThrowsComplete() {
		return trussThrowsComplete;
	}

	public void setTrussThrowsComplete(int trussThrowsComplete) {
		this.trussThrowsComplete = trussThrowsComplete;
	}

	public int getTrussThrowsTotal() {
		return trussThrowsTotal;
	}

	public void setTrussThrowsTotal(int trussThrowsTotal) {
		this.trussThrowsTotal = trussThrowsTotal;
	}

	public int getCatchesComplete() {
		return catchesComplete;
	}

	public void setCatchesComplete(int catchesComplete) {
		this.catchesComplete = catchesComplete;
	}

	public int getCatchesTotal() {
		return catchesTotal;
	}

	public void setCatchesTotal(int catchesTotal) {
		this.catchesTotal = catchesTotal;
	}

	public String getPenalties() {
		return penalties;
	}

	public void setPenalties(String penalties) {
		this.penalties = penalties;
	}

	public String getOverallGamePlay() {
		return overallGamePlay;
	}

	public void setOverallGamePlay(String overallGamePlay) {
		this.overallGamePlay = overallGamePlay;
	}

	public String getRobotFlaws() {
		return robotFlaws;
	}

	public void setRobotFlaws(String robotFlaws) {
		this.robotFlaws = robotFlaws;
	}

	public String getAllianceComment() {
		return allianceComment;
	}

	public void setAllianceComment(String allianceComment) {
		this.allianceComment = allianceComment;
	}

	public String getAutonComment() {
		return autonComment;
	}

	public void setAutonComment(String autonComment) {
		this.autonComment = autonComment;
	}

	public int getAutonPoints(){
			int autonPoints = 0;
			
			autonPoints += 6 * (this.getBottomAutonScored() - this.getBottomHot());
			autonPoints += 11 * this.getBottomHot();
			
			autonPoints += 15 * (this.getTopAutonScored() - this.getTopHot());
			autonPoints += 20 * this.getTopHot();
			
			if(this.isMobilityPoints())
				autonPoints += 5;
			return autonPoints;
	}
	public int getTeleopPoints(){
		int teleopPoints = 0;
		
		teleopPoints += this.getTopTeleopScored() * 10;
		teleopPoints += this.getBottomTeleopScored();
		teleopPoints += this.getTrussThrowsComplete() * 10;
//		teleopPoints += this.getPassesComplete() * 10;
		teleopPoints += this.getCatchesComplete() * 10;
		
		return teleopPoints;
	}
	public int getTotalPoints(){
		int totalPoints = 0;
		
		totalPoints += this.getAutonPoints();
		totalPoints += this.getTeleopPoints();
		
		return totalPoints;
	}
	public double getTopShootingPercentage(){
		double avg = 0.0;
//		System.out.println(this.getTopTeleopScored() + " " + this.getTopTeleopShot() + " " + (double)this.getTopTeleopScored()/this.getTopTeleopShot());
		try{
			avg += ((double)this.getTopTeleopScored())/(this.getTopTeleopShot());
//			System.out.println(avg);
		}
		catch(ArithmeticException e){
			e.printStackTrace();
//			System.out.println("CAUGHT");
		}
		return avg;
	}
	public double getBottomShootingPercentage(){
		double avg = 0.0;
		try{
			avg += ((double)this.getBottomTeleopScored())/(this.getBottomTeleopShot());
		}
		catch(ArithmeticException e){}
		return avg;
	}
}

/*
package fullapp;
public class MatchRecord{ 
	
    ////////////////////////
	private int teamNumber;
    private String teamName;
    private String eventAbbreviation;
    private int matchNumber;
    private String scoutName;
    ////////////////////////
    private int autoTopScoredNotHot;
    private int autoTopShotNotHot;
    private int autoBottomScoredNotHot;
    private int autoBottomShotNotHot;
    private int hotGoalTopScored;
    private int hotGoalTopShot;
    private int hotGoalBottomScored;
    private int hotGoalBottomShot;
    private boolean mobility;
    private boolean startingPosition;
    ////////////////////////
    private String positionPlayed;
    private int speed;
    private int agility;
    private int pushingAbility;
    private int stability;
    ////////////////////////
    private int ballsScoredTopTeleop;
    private int ballsShotTopTeleop;
    private int ballsScoredBottomTeleop;
    private int ballsShotBottomTeleop;
    private int shooterSpeed;
    private int pickUpSpeed;
    /////////////////////////
    private int possessions;
    private int successfulPasses;
    private int totalPasses;
    private int successfulTrussThrows;
    private int totalTrussThrows;
    private int successfulCatches;
    private int totalCatches;
    //////////////////////////
    private String autoComment;
    private String penaltyComment;
    private String interestingStrategyComment;
    private String robotFlaws;
	//////////////////////////
    
    public MatchRecord(){
    	teamNumber = 0;
        teamName = "";
        eventAbbreviation = "";
        matchNumber = 0;
        scoutName = "";
        autoTopScoredNotHot = 0;
        autoTopShotNotHot = 0;
        autoBottomScoredNotHot = 0;
        autoBottomShotNotHot = 0;
        hotGoalTopScored = 0;
        hotGoalTopShot = 0;
        hotGoalBottomScored = 0;
        hotGoalBottomShot = 0;
        mobility = false;
        startingPosition = false;
        positionPlayed = "";
        speed = 0;
        agility = 0;
        pushingAbility = 0;
        stability = 0;
        ballsScoredTopTeleop = 0;
        ballsShotTopTeleop = 0;
        ballsScoredBottomTeleop = 0;
        ballsShotBottomTeleop = 0;
        shooterSpeed = 0;
        pickUpSpeed = 0;
        possessions = 0;
        successfulPasses = 0;
        totalPasses = 0;
        successfulTrussThrows = 0;
        totalTrussThrows = 0;
        successfulCatches = 0;
        totalCatches = 0;
        autoComment = "";
        penaltyComment = "";
        interestingStrategyComment = "";
       	robotFlaws = "";
	}
	public MatchRecord(int teamNumber, String teamName, String eventAbbreviation, int matchNumber,
			String scoutName, int autoTopScoredNotHot, int autoTopShotNotHot,
			int autoBottomScoredNotHot, int autoBottomShotNotHot, int hotGoalTopScored,
			int hotGoalTopShot, int hotGoalBottomScored, int hotGoalBottomShot,
			boolean mobility, String positionPlayed, boolean startingPosition, int speed, int agility,
			int pushingAbility, int stability, int ballsScoredTopTeleop,
			int ballsShotTopTeleop, int ballsScoredBottomTeleop,
			int ballsShotBottomTeleop, int shooterSpeed, int pickUpSpeed,
			int possessions, int successfulPasses, int totalPasses,
			int successfulTrussThrows, int totalTrussThrows,
			int successfulCatches, int totalCatches, String autoComment,
			String penaltyComment, String interestingStrategyComment,
			String robotFlaws) {
		super();
		this.teamNumber = teamNumber;
		this.teamName = teamName;
		this.eventAbbreviation = eventAbbreviation;
		this.matchNumber = matchNumber;
		this.scoutName = scoutName;
		this.autoTopScoredNotHot = autoTopScoredNotHot;
		this.autoTopShotNotHot = autoTopShotNotHot;
		this.autoBottomScoredNotHot = autoBottomScoredNotHot;
		this.autoBottomShotNotHot = autoBottomShotNotHot;
		this.hotGoalTopScored = hotGoalTopScored;
		this.hotGoalTopShot = hotGoalTopShot;
		this.hotGoalBottomScored = hotGoalBottomScored;
		this.hotGoalBottomShot = hotGoalBottomShot;
		this.mobility = mobility;
		this.startingPosition = startingPosition;
		this.positionPlayed = positionPlayed;
		this.speed = speed;
		this.agility = agility;
		this.pushingAbility = pushingAbility;
		this.stability = stability;
		this.ballsScoredTopTeleop = ballsScoredTopTeleop;
		this.ballsShotTopTeleop = ballsShotTopTeleop;
		this.ballsScoredBottomTeleop = ballsScoredBottomTeleop;
		this.ballsShotBottomTeleop = ballsShotBottomTeleop;
		this.shooterSpeed = shooterSpeed;
		this.pickUpSpeed = pickUpSpeed;
		this.possessions = possessions;
		this.successfulPasses = successfulPasses;
		this.totalPasses = totalPasses;
		this.successfulTrussThrows = successfulTrussThrows;
		this.totalTrussThrows = totalTrussThrows;
		this.successfulCatches = successfulCatches;
		this.totalCatches = totalCatches;
		this.autoComment = autoComment;
		this.penaltyComment = penaltyComment;
		this.interestingStrategyComment = interestingStrategyComment;
		this.robotFlaws = robotFlaws;
	}
	
	
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getEventAbbreviation() {
		return this.eventAbbreviation;
	}
	public void setEventAbbreviation(String eventAbbreviation) {
		this.eventAbbreviation = eventAbbreviation;
	}
	public int getMatchNumber() {
		return matchNumber;
	}
	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}
	public String getScoutName() {
		return scoutName;
	}
	public void setScoutName(String scoutName) {
		this.scoutName = scoutName;
	}
	public int getAutoTopScoredNotHot() {
		return autoTopScoredNotHot;
	}
	public void setAutoTopScoredNotHot(int autoTopScoredNotHot) {
		this.autoTopScoredNotHot = autoTopScoredNotHot;
	}
	public int getAutoTopShotNotHot() {
		return autoTopShotNotHot;
	}
	public void setAutoTopShotNotHot(int autoTopShotNotHot) {
		this.autoTopShotNotHot = autoTopShotNotHot;
	}
	public int getAutoBottomScoredNotHot() {
		return autoBottomScoredNotHot;
	}
	public void setAutoBottomScoredNotHot(int autoBottomScoredNotHot) {
		this.autoBottomScoredNotHot = autoBottomScoredNotHot;
	}
	public int getAutoBottomShotNotHot() {
		return autoBottomShotNotHot;
	}
	public void setAutoBottomShotNotHot(int autoBottomShotNotHot) {
		this.autoBottomShotNotHot = autoBottomShotNotHot;
	}
	public int getHotGoalTopScored() {
		return hotGoalTopScored;
	}
	public void setHotGoalTopScored(int hotGoalTopScored) {
		this.hotGoalTopScored = hotGoalTopScored;
	}
	public int getHotGoalTopShot() {
		return hotGoalTopShot;
	}
	public void setHotGoalTopShot(int hotGoalTopShot) {
		this.hotGoalTopShot = hotGoalTopShot;
	}
	public int getHotGoalBottomScored() {
		return hotGoalBottomScored;
	}
	public void setHotGoalBottomScored(int hotGoalBottomScored) {
		this.hotGoalBottomScored = hotGoalBottomScored;
	}
	public int getHotGoalBottomShot() {
		return hotGoalBottomShot;
	}
	public void setHotGoalBottomShot(int hotGoalBottomShot) {
		this.hotGoalBottomShot = hotGoalBottomShot;
	}
	public boolean isMobility() {
		return mobility;
	}
	public void setMobility(boolean mobility) {
		this.mobility = mobility;
	}
	public boolean getStartingPosition(){
		return startingPosition;
	}
	public void setStartingPosition(boolean startingPosition){
		this.startingPosition = startingPosition;
	}
	public String getPositionPlayed() {
		return positionPlayed;
	}
	public void setPositionPlayed(String positionPlayed) {
		this.positionPlayed = positionPlayed;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getPushingAbility() {
		return pushingAbility;
	}
	public void setPushingAbility(int pushingAbility) {
		this.pushingAbility = pushingAbility;
	}
	public int getStability() {
		return stability;
	}
	public void setStability(int stability) {
		this.stability = stability;
	}
	public int getBallsScoredTopTeleop() {
		return ballsScoredTopTeleop;
	}
	public void setBallsScoredTopTeleop(int ballsScoredTopTeleop) {
		this.ballsScoredTopTeleop = ballsScoredTopTeleop;
	}
	public int getBallsShotTopTeleop() {
		return ballsShotTopTeleop;
	}
	public void setBallsShotTopTeleop(int ballsShotTopTeleop) {
		this.ballsShotTopTeleop = ballsShotTopTeleop;
	}
	public int getBallsScoredBottomTeleop() {
		return ballsScoredBottomTeleop;
	}
	public void setBallsScoredBottomTeleop(int ballsScoredBottomTeleop) {
		this.ballsScoredBottomTeleop = ballsScoredBottomTeleop;
	}
	public int getBallsShotBottomTeleop() {
		return ballsShotBottomTeleop;
	}
	public void setBallsShotBottomTeleop(int ballsShotBottomTeleop) {
		this.ballsShotBottomTeleop = ballsShotBottomTeleop;
	}
	public int getShooterSpeed() {
		return shooterSpeed;
	}
	public void setShooterSpeed(int shooterSpeed) {
		this.shooterSpeed = shooterSpeed;
	}
	public int getPickUpSpeed() {
		return pickUpSpeed;
	}
	public void setPickUpSpeed(int pickUpSpeed) {
		this.pickUpSpeed = pickUpSpeed;
	}
	public int getPossessions() {
		return possessions;
	}
	public void setPossessions(int possessions) {
		this.possessions = possessions;
	}
	public int getSuccessfulPasses() {
		return successfulPasses;
	}
	public void setSuccessfulPasses(int successfulPasses) {
		this.successfulPasses = successfulPasses;
	}
	public int getTotalPasses() {
		return totalPasses;
	}
	public void setTotalPasses(int totalPasses) {
		this.totalPasses = totalPasses;
	}
	public int getSuccessfulTrussThrows() {
		return successfulTrussThrows;
	}
	public void setSuccessfulTrussThrows(int successfulTrussThrows) {
		this.successfulTrussThrows = successfulTrussThrows;
	}
	public int getTotalTrussThrows() {
		return totalTrussThrows;
	}
	public void setTotalTrussThrows(int totalTrussThrows) {
		this.totalTrussThrows = totalTrussThrows;
	}
	public int getSuccessfulCatches() {
		return successfulCatches;
	}
	public void setSuccessfulCatches(int successfulCatches) {
		this.successfulCatches = successfulCatches;
	}
	public int getTotalCatches() {
		return totalCatches;
	}
	public void setTotalCatches(int totalCatches) {
		this.totalCatches = totalCatches;
	}
	public String getAutoComment() {
		return autoComment;
	}
	public void setAutoComment(String autoComment) {
		this.autoComment = autoComment;
	}
	public String getPenaltyComment() {
		return penaltyComment;
	}
	public void setPenaltyComment(String penaltyComment) {
		this.penaltyComment = penaltyComment;
	}
	public String getInterestingStrategyComment() {
		return interestingStrategyComment;
	}
	public void setInterestingStrategyComment(String interestingStrategyComment) {
		this.interestingStrategyComment = interestingStrategyComment;
	}
	public String getRobotFlaws() {
		return robotFlaws;
	}
	public void setRobotFlaws(String robotFlaws) {
		this.robotFlaws = robotFlaws;
	}
	public int getAutonPoints(){
			int autonPoints = 0;
			
			autonPoints += 6 * this.getAutoBottomScoredNotHot();
			autonPoints += 11 * this.getHotGoalBottomScored();
			
			autonPoints += 15 * this.getAutoTopScoredNotHot();
			autonPoints += 20 * this.getHotGoalTopScored();
			
			if(this.isMobility())
				autonPoints += 5;
			return autonPoints;
	}
	public int getTeleopPoints(){
		int teleopPoints = 0;
		
		teleopPoints += this.getBallsScoredTopTeleop() * 10;
		teleopPoints += this.getBallsScoredBottomTeleop();
		teleopPoints += this.getSuccessfulTrussThrows() * 10;
		teleopPoints += this.getSuccessfulPasses() * 10;
		teleopPoints += this.getSuccessfulCatches() * 10;
		
		return teleopPoints;
	}
	public int getTotalPoints(){
		int totalPoints = 0;
		
		totalPoints += this.getAutonPoints();
		totalPoints += this.getTeleopPoints();
		
		return totalPoints;
	}
	public double getTeleopShootingPercentage(){
		double avg = 0.0;
		try{
			avg += (this.getBallsScoredTopTeleop() + this.getBallsScoredTopTeleop())/(this.getBallsShotBottomTeleop() + this.getBallsShotTopTeleop());
		}
		catch(ArithmeticException e){}
		return avg;
	}
}
*/