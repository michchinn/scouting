package fullapp;

public class Interview {
	
    int teamNumber;
    String teamName;
    String orientation;
    
    int driveMotorsNum;
    double weight;
    int numberOfWheels;
    int autonBallCount;
    
    boolean canMakeTrussShots;
    boolean hasAuton;
    boolean targetHotGoal;
    
    String driveMotorsType;
    String hasDropCenterWheels;
    String driveSystem;
    String shooterType;
    String generalGoals;
    String ballAquirySystem;
    String intakeType;
    String catcherType;
    String autonStartingPos;
    String autonGoals;
    
    // sets up defaults.
    public Interview(){
    	int teamNumber = 0;
        String teamName = "";
        String orientation = "";
        
        int driveMotorsNum = 0;
        double weight = 0.0;
        int numberOfWheels = 0;
        int autonBallCount = 0;
        
        boolean canMakeTrussShots = false;
        boolean hasAuton = false;
        boolean targetHotGoal = false;
        
        String driveMotorsType = "";
        String hasDropCenterWheels = "";
        String driveSystem = "";
        String shooterType = "";
        String generalGoals = "";
        String ballAquirySystem = "";
        String intakeType = "";
        String catcherType = "";
        String autonStartingPos = "";
        String autonGoals = "";
    }
    

    public Interview(int teamNumber, String teamName, String orientation,
			int driveMotorsNum, double weight, int numberOfWheels,
			int autonBallCount, boolean canMakeTrussShots, boolean hasAuton,
			boolean targetHotGoal, String driveMotorsType,
			String hasDropCenterWheels, String driveSystem, String shooterType,
			String generalGoals, String ballAquirySystem, String intakeType,
			String catcherType, String autonStartingPos, String autonGoals) {
		super();
		this.teamNumber = teamNumber;
		this.teamName = teamName;
		this.orientation = orientation;
		this.driveMotorsNum = driveMotorsNum;
		this.weight = weight;
		this.numberOfWheels = numberOfWheels;
		this.autonBallCount = autonBallCount;
		this.canMakeTrussShots = canMakeTrussShots;
		this.hasAuton = hasAuton;
		this.targetHotGoal = targetHotGoal;
		this.driveMotorsType = driveMotorsType;
		this.hasDropCenterWheels = hasDropCenterWheels;
		this.driveSystem = driveSystem;
		this.shooterType = shooterType;
		this.generalGoals = generalGoals;
		this.ballAquirySystem = ballAquirySystem;
		this.intakeType = intakeType;
		this.catcherType = catcherType;
		this.autonStartingPos = autonStartingPos;
		this.autonGoals = autonGoals;
	}


	// Standard geters and seters
    public String getOrientation(){
        return orientation;
    }
    public void setOrientation(String newOrientation){
        orientation = newOrientation;
    }
    public String getDriveMotorsType(){
        return driveMotorsType;
    }
    public void setDriveMotorsType(String newDriveMotorsType){
        driveMotorsType = newDriveMotorsType;
    }
    public int getDriveMotorsNum(){
        return driveMotorsNum;
    }
    public void setDriveMotorsNum(int newNumDriveMotors){
        driveMotorsNum = newNumDriveMotors;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(String newWeight){
        weight = Double.parseDouble(newWeight);
    }
    public void setWeight(double newWeight){
        weight = newWeight;
    }
    public int getNumberOfWheels(){
        return numberOfWheels;
    }
    public void setNumberOfWheels(int newNumberOfWheels){
        numberOfWheels = newNumberOfWheels;
    }
    public int getAutonBallCount(){
        return autonBallCount;
    }
    public void setAutonBallCount(int newAutonBallCount){
        autonBallCount = newAutonBallCount;
    }
    public String getHasDropCenterWheels(){
        return hasDropCenterWheels;
    }  
    public void setHasDropCenterWheels(String newHasDropCenterWheels){
        hasDropCenterWheels = newHasDropCenterWheels;
    }
    public boolean getCanMakeTrussShots(){
        return canMakeTrussShots;
    }   
    public void setCanMakeTrussShots(boolean newCanMakeTrussShots){
        canMakeTrussShots = newCanMakeTrussShots;
    }
    public boolean getHasAuton(){
        return hasAuton;
    } 
    public void setHasAuton(boolean newHasAuton){
        hasAuton = newHasAuton;
    }     
    public boolean getTargetHotGoal(){
        return targetHotGoal;
    }  
    public void setTargetHotGoal(boolean newTargetHotGoal){
        targetHotGoal = newTargetHotGoal;
    }
    public String getDriveSystem(){
        return driveSystem;
    }  
    public void setDriveSystem(String newDriveSystem){
        driveSystem = newDriveSystem;
    }
    public String getShooterType(){
        return shooterType;
    } 
    public void setShooterType(String newShooterType){
        shooterType = newShooterType;
    }
    public String getGeneralGoals(){
        return generalGoals;
    } 
    public void setGeneralGoals(String newGeneralGoals){
        generalGoals = newGeneralGoals;
    }
    public String getBallAquirySystem(){
        return ballAquirySystem;
    } 
    public void setBallAquirySystem(String newBallAquirySystem){
        ballAquirySystem = newBallAquirySystem;
    }
    // used to build on the ball aquiry system  because it has multiple options
    public void addToBallAquirySystem(String addition){
        // check if there are contents already
        if(getBallAquirySystem() != null){
            ballAquirySystem += " and ";  // if so add an and connector
            ballAquirySystem += addition;
        }
        // if there is not simply make the value into the addition
        else{
            setBallAquirySystem(addition);
        }
    }
    public String getIntakeType(){
        return intakeType;
    } 
    public void setIntakeType(String newIntakeType){
        intakeType = newIntakeType;
    }
    public String getCatcherType(){
        return catcherType;
    }  
    public void setCatcherType(String newCatcherType){
        catcherType = newCatcherType;
    }
    public String getAutonStartingPos(){
        return autonStartingPos;
    } 
    public void setAutonStartingPos(String newAutonStartingPos){
        autonStartingPos = newAutonStartingPos;
    }
    public String getAutonGoals(){
        return autonGoals;
    } 
    public void setAutonGoals(String newAutonGoals){
        autonGoals = newAutonGoals;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String newTeamName){
        teamName = newTeamName;
    }
    public int getTeamNumber(){
    	return teamNumber;
    }
    public void setTeamNumber(int newTeamNumber){
        teamNumber = newTeamNumber;
    }
}

//
//public class Interview {
//
//	/***General Team Info***/
//	private int teamNumber;
//	private String teamName;
//	private String scoutName;
//	/***Drive System***/
//	private int length;
//	private int width;
//	private int weight;
//	private int driveWheels;
//	private String driveSystem;
//	private String hasDropCenterWheels;
//	private int speed;
//	/***Shooter System***/
//	private String shooterType;
//	private boolean canMakeTrussShots;
//	private String possibleGoals; //High, low, both
//	/***Acquiring Balls***/
//	private String acquiredLocations;
//	private String intakeMechanism;
//	private String catchingMechanism;
//	/***Autonomous***/
//	private boolean hasAutonomous;
//	private String startingPosition;
//	private String autonScoreLocations;
//	private boolean targetsHotGoal;
//	private int autonBallsScored;
//	private String autonComment;
//	/***Overall***/
//	private String generalComment;
//
//	public Interview(){
//		 teamNumber = 0;
//		 teamName = "";
//		 scoutName = "";
//		 length = 0;
//		 width = 0;
//		 weight = 0;
//		 driveWheels = 0;
//		 driveSystem = "";
//		 hasDropCenterWheels = "";
//		 speed = 0;
//		 shooterType = "";
//		 canMakeTrussShots = false;
//		 possibleGoals = "";
//		 acquiredLocations = "";
//		 intakeMechanism = "";
//		 catchingMechanism = "";
//		 hasAutonomous = false;
//		 startingPosition = "";
//		 autonScoreLocations = "";
//		 targetsHotGoal = false;
//		 autonBallsScored = 0;
//		 autonComment = "";
//		 generalComment = "";
//	}
//	
//	public Interview(int teamNumber, String teamName, String scoutName,
//			int length, int width, int weight, int driveWheels,
//			String driveSystem, String hasDropCenterWheels, int speed,
//			String shooterType, boolean canMakeTrussShots,
//			String possibleGoals, String acquiredLocations,
//			String intakeMechanism, String catchingMechanism,
//			boolean hasAutonomous, String startingPosition,
//			String autonScoreLocations, boolean targetsHotGoal,
//			int autonBallsScored, String autonComment, String generalComment) {
//		super();
//		this.teamNumber = teamNumber;
//		this.teamName = teamName;
//		this.scoutName = scoutName;
//		this.length = length;
//		this.width = width;
//		this.weight = weight;
//		this.driveWheels = driveWheels;
//		this.driveSystem = driveSystem;
//		this.hasDropCenterWheels = hasDropCenterWheels;
//		this.speed = speed;
//		this.shooterType = shooterType;
//		this.canMakeTrussShots = canMakeTrussShots;
//		this.possibleGoals = possibleGoals;
//		this.acquiredLocations = acquiredLocations;
//		this.intakeMechanism = intakeMechanism;
//		this.catchingMechanism = catchingMechanism;
//		this.hasAutonomous = hasAutonomous;
//		this.startingPosition = startingPosition;
//		this.autonScoreLocations = autonScoreLocations;
//		this.targetsHotGoal = targetsHotGoal;
//		this.autonBallsScored = autonBallsScored;
//		this.autonComment = autonComment;
//		this.generalComment = generalComment;
//	}
//	
//	public int getTeamNumber() {
//		return teamNumber;
//	}
//	public void setTeamNumber(int teamNumber) {
//		this.teamNumber = teamNumber;
//	}
//	public String getTeamName() {
//		return teamName;
//	}
//	public void setTeamName(String teamName) {
//		this.teamName = teamName;
//	}
//	public String getScoutName() {
//		return scoutName;
//	}
//	public void setScoutName(String scoutName) {
//		this.scoutName = scoutName;
//	}
//	public int getLength() {
//		return length;
//	}
//	public void setLength(int length) {
//		this.length = length;
//	}
//	public int getWidth() {
//		return width;
//	}
//	public void setWidth(int width) {
//		this.width = width;
//	}
//	public int getWeight() {
//		return weight;
//	}
//	public void setWeight(int weight) {
//		this.weight = weight;
//	}
//	public int getDriveWheels() {
//		return driveWheels;
//	}
//	public void setDriveWheels(int driveWheels) {
//		this.driveWheels = driveWheels;
//	}
//	public String getDriveSystem() {
//		return driveSystem;
//	}
//	public void setDriveSystem(String driveSystem) {
//		this.driveSystem = driveSystem;
//	}
//	public String isHasDropCenterWheels() {
//		return hasDropCenterWheels;
//	}
//	public void setHasDropCenterWheels(String s) {
//		this.hasDropCenterWheels = s;
//	}
//	public int getSpeed() {
//		return speed;
//	}
//	public void setSpeed(int speed) {
//		this.speed = speed;
//	}
//	public String getShooterType() {
//		return shooterType;
//	}
//	public void setShooterType(String shooterType) {
//		this.shooterType = shooterType;
//	}
//	public boolean isCanMakeTrussShots() {
//		return canMakeTrussShots;
//	}
//	public void setCanMakeTrussShots(boolean canMakeTrussShots) {
//		this.canMakeTrussShots = canMakeTrussShots;
//	}
//	public String getPossibleGoals() {
//		return possibleGoals;
//	}
//	public void setPossibleGoals(String possibleGoals) {
//		this.possibleGoals = possibleGoals;
//	}
//	public String getAcquiredLocations() {
//		return acquiredLocations;
//	}
//	public void setAcquiredLocations(String acquiredLocations) {
//		this.acquiredLocations = acquiredLocations;
//	}
//	public String getIntakeMechanism() {
//		return intakeMechanism;
//	}
//	public void setIntakeMechanism(String intakeMechanism) {
//		this.intakeMechanism = intakeMechanism;
//	}
//	public String getCatchingMechanism() {
//		return catchingMechanism;
//	}
//	public void setCatchingMechanism(String catchingMechanism) {
//		this.catchingMechanism = catchingMechanism;
//	}
//	public boolean isHasAutonomous() {
//		return hasAutonomous;
//	}
//	public void setHasAutonomous(boolean hasAutonomous) {
//		this.hasAutonomous = hasAutonomous;
//	}
//	public String getStartingPosition() {
//		return startingPosition;
//	}
//	public void setStartingPosition(String startingPosition) {
//		this.startingPosition = startingPosition;
//	}
//	public String getAutonScoreLocations() {
//		return autonScoreLocations;
//	}
//	public void setAutonScoreLocations(String autonScoreLocations) {
//		this.autonScoreLocations = autonScoreLocations;
//	}
//	public boolean isTargetsHotGoal() {
//		return targetsHotGoal;
//	}
//	public void setTargetsHotGoal(boolean targetsHotGoal) {
//		this.targetsHotGoal = targetsHotGoal;
//	}
//	public int getAutonBallsScored() {
//		return autonBallsScored;
//	}
//	public void setAutonBallsScored(int autonBallsScored) {
//		this.autonBallsScored = autonBallsScored;
//	}
//	public String getAutonComment() {
//		return autonComment;
//	}
//	public void setAutonComment(String autonComment) {
//		this.autonComment = autonComment;
//	}
//	public String getGeneralComment() {
//		return generalComment;
//	}
//	public void setGeneralComment(String generalComment) {
//		this.generalComment = generalComment;
//	}
//}
