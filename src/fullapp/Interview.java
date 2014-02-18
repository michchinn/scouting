package fullapp;

public class Interview {

	/***General Team Info***/
	private int teamNumber;
	private String teamName;
	private String scoutName;
	/***Drive System***/
	private int length;
	private int width;
	private int weight;
	private int driveWheels;
	private String driveSystem;
	private boolean hasDropCenterWheels;
	private int speed;
	/***Shooter System***/
	private String shooterType;
	private boolean canMakeTrussShots;
	private String possibleGoals; //High, low, both
	/***Acquiring Balls***/
	private String acquiredLocations;
	private String intakeMechanism;
	private String catchingMechanism;
	/***Autonomous***/
	private boolean hasAutonomous;
	private String startingPosition;
	private String autonScoreLocations;
	private boolean targetsHotGoal;
	private int autonBallsScored;
	private String autonComment;
	/***Overall***/
	private String generalComment;

	public Interview(){
		 teamNumber = 0;
		 teamName = "";
		 scoutName = "";
		 length = 0;
		 width = 0;
		 weight = 0;
		 driveWheels = 0;
		 driveSystem = "";
		 hasDropCenterWheels = false;
		 speed = 0;
		 shooterType = "";
		 canMakeTrussShots = false;
		 possibleGoals = "";
		 acquiredLocations = "";
		 intakeMechanism = "";
		 catchingMechanism = "";
		 hasAutonomous = false;
		 startingPosition = "";
		 autonScoreLocations = "";
		 targetsHotGoal = false;
		 autonBallsScored = 0;
		 autonComment = "";
		 generalComment = "";
	}
	
	public Interview(int teamNumber, String teamName, String scoutName,
			int length, int width, int weight, int driveWheels,
			String driveSystem, boolean hasDropCenterWheels, int speed,
			String shooterType, boolean canMakeTrussShots,
			String possibleGoals, String acquiredLocations,
			String intakeMechanism, String catchingMechanism,
			boolean hasAutonomous, String startingPosition,
			String autonScoreLocations, boolean targetsHotGoal,
			int autonBallsScored, String autonComment, String generalComment) {
		super();
		this.teamNumber = teamNumber;
		this.teamName = teamName;
		this.scoutName = scoutName;
		this.length = length;
		this.width = width;
		this.weight = weight;
		this.driveWheels = driveWheels;
		this.driveSystem = driveSystem;
		this.hasDropCenterWheels = hasDropCenterWheels;
		this.speed = speed;
		this.shooterType = shooterType;
		this.canMakeTrussShots = canMakeTrussShots;
		this.possibleGoals = possibleGoals;
		this.acquiredLocations = acquiredLocations;
		this.intakeMechanism = intakeMechanism;
		this.catchingMechanism = catchingMechanism;
		this.hasAutonomous = hasAutonomous;
		this.startingPosition = startingPosition;
		this.autonScoreLocations = autonScoreLocations;
		this.targetsHotGoal = targetsHotGoal;
		this.autonBallsScored = autonBallsScored;
		this.autonComment = autonComment;
		this.generalComment = generalComment;
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
	public String getScoutName() {
		return scoutName;
	}
	public void setScoutName(String scoutName) {
		this.scoutName = scoutName;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getDriveWheels() {
		return driveWheels;
	}
	public void setDriveWheels(int driveWheels) {
		this.driveWheels = driveWheels;
	}
	public String getDriveSystem() {
		return driveSystem;
	}
	public void setDriveSystem(String driveSystem) {
		this.driveSystem = driveSystem;
	}
	public boolean isHasDropCenterWheels() {
		return hasDropCenterWheels;
	}
	public void setHasDropCenterWheels(boolean hasDropCenterWheels) {
		this.hasDropCenterWheels = hasDropCenterWheels;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getShooterType() {
		return shooterType;
	}
	public void setShooterType(String shooterType) {
		this.shooterType = shooterType;
	}
	public boolean isCanMakeTrussShots() {
		return canMakeTrussShots;
	}
	public void setCanMakeTrussShots(boolean canMakeTrussShots) {
		this.canMakeTrussShots = canMakeTrussShots;
	}
	public String getPossibleGoals() {
		return possibleGoals;
	}
	public void setPossibleGoals(String possibleGoals) {
		this.possibleGoals = possibleGoals;
	}
	public String getAcquiredLocations() {
		return acquiredLocations;
	}
	public void setAcquiredLocations(String acquiredLocations) {
		this.acquiredLocations = acquiredLocations;
	}
	public String getIntakeMechanism() {
		return intakeMechanism;
	}
	public void setIntakeMechanism(String intakeMechanism) {
		this.intakeMechanism = intakeMechanism;
	}
	public String getCatchingMechanism() {
		return catchingMechanism;
	}
	public void setCatchingMechanism(String catchingMechanism) {
		this.catchingMechanism = catchingMechanism;
	}
	public boolean isHasAutonomous() {
		return hasAutonomous;
	}
	public void setHasAutonomous(boolean hasAutonomous) {
		this.hasAutonomous = hasAutonomous;
	}
	public String getStartingPosition() {
		return startingPosition;
	}
	public void setStartingPosition(String startingPosition) {
		this.startingPosition = startingPosition;
	}
	public String getAutonScoreLocations() {
		return autonScoreLocations;
	}
	public void setAutonScoreLocations(String autonScoreLocations) {
		this.autonScoreLocations = autonScoreLocations;
	}
	public boolean isTargetsHotGoal() {
		return targetsHotGoal;
	}
	public void setTargetsHotGoal(boolean targetsHotGoal) {
		this.targetsHotGoal = targetsHotGoal;
	}
	public int getAutonBallsScored() {
		return autonBallsScored;
	}
	public void setAutonBallsScored(int autonBallsScored) {
		this.autonBallsScored = autonBallsScored;
	}
	public String getAutonComment() {
		return autonComment;
	}
	public void setAutonComment(String autonComment) {
		this.autonComment = autonComment;
	}
	public String getGeneralComment() {
		return generalComment;
	}
	public void setGeneralComment(String generalComment) {
		this.generalComment = generalComment;
	}
}