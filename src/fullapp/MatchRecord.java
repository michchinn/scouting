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
		
		avg += (this.getBallsScoredTopTeleop() + this.getBallsScoredTopTeleop())/(this.getBallsShotBottomTeleop()+ this.getBallsShotTopTeleop());
		
		return avg;
	}
}
