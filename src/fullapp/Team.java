package fullapp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Team {
	
	private int number;
	private String name;
	private Vector<MatchRecord> _matchRecords;
	private Interview interview;
	
	public Team(int number, String name) {
		this.number = number;
		this.name = name;
		interview = new Interview();
		_matchRecords = new Vector<MatchRecord>();
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	public Interview getInterview(){
		return this.interview;
	}
	public void setInterview(Interview interview){
		this.interview = interview;
	}
	public void addMatchRecord(MatchRecord matchRecord) {
		_matchRecords.add(matchRecord);
		Collections.sort(_matchRecords, new Comparator<MatchRecord>() {
			public int compare(MatchRecord r1, MatchRecord r2) {
				return r1.getMatchNumber() - r2.getMatchNumber();
			}
		});
	}
	
	public void removeMatchRecord(int index) {
		_matchRecords.remove(index);
	}
	
	public MatchRecord getMatchRecord(int index) {
		return _matchRecords.get(index);
	}
	
	public void setMatchRecord(int index, MatchRecord record) {
		_matchRecords.set(index, record);
		Collections.sort(_matchRecords, new Comparator<MatchRecord>() {
			public int compare(MatchRecord r1, MatchRecord r2) {
				return r1.getMatchNumber() - r2.getMatchNumber();
			}
		});
	}
	
	public int getNumberOfMatchRecords() {
		return _matchRecords.size();
	}
	
	public double getAveragePointsPerMatch() {
		if (_matchRecords.size() == 0) {
			return 0;
		}
		
		int cumulativePointTotal = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
				cumulativePointTotal += _matchRecords.get(i).getTotalPoints();
		}
		double avg =  (double)(cumulativePointTotal) / (double)(_matchRecords.size());
		return (double)Math.round(avg * 10000) / 10000;
	}
	
	public double getAverageAutonPointsPerMatch() {
		if (_matchRecords.size() == 0) {
			return 0;
		}
		
		int cumulativePointTotal = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
				cumulativePointTotal += _matchRecords.get(i).getAutonPoints();
		}
		
		double avg = (double)(cumulativePointTotal) / (double)(_matchRecords.size()); 
		return (double)Math.round(avg * 10000) / 10000;
	}
	
	public double getAverageTeleopPointsPerMatch() {
		if (_matchRecords.size() == 0) {
			return 0;
		}
		
		int cumulativePointTotal = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
				cumulativePointTotal += _matchRecords.get(i).getTeleopPoints();
		}
		double avg = (double)(cumulativePointTotal) / (double)(_matchRecords.size()); 
		return (double)Math.round(avg * 10000) / 10000;
	}
	
	public double getAverageTopTeleopShootingPercentage() {
		if (_matchRecords.size() == 0) {
			return 0;
		}
		
		double accuracy = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
				accuracy += _matchRecords.get(i).getTopShootingPercentage();
		}
		double avg = (double)(accuracy) / (double)(_matchRecords.size()); 
		return (double)Math.round(avg * 10000) / 10000;
	}
	public double getAveragBottomTeleopShootingPercentage() {
		if (_matchRecords.size() == 0) {
			return 0;
		}
		
		double accuracy = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
				accuracy += _matchRecords.get(i).getBottomShootingPercentage();
		}
		double avg = (double)(accuracy) / (double)(_matchRecords.size()); 
		return (double)Math.round(avg * 10000) / 10000;
	}
	
	public int getMaxAutonomousPoints() {
		int max = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
			int autonPoints =_matchRecords.get(i).getAutonPoints(); 
			if (autonPoints > max) {
				max = autonPoints;
			}
		}
		return max;
	}
	
	public int getMaxTeleoperatedPoints() {
		int max = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
			int teleopPoints =_matchRecords.get(i).getTeleopPoints(); 
			if (teleopPoints > max) {
				max = teleopPoints;
			}
		}
		return max;
	}
	
	public int getBestMatchNumber() {
		int max = 0;
		int matchNumber = 0;
		for (int i = 0; i < _matchRecords.size(); i++) {
			int totalPoints =_matchRecords.get(i).getTotalPoints(); 
			if (totalPoints > max) {
				max = totalPoints;
				matchNumber = _matchRecords.get(i).getMatchNumber();
			}
		}
		return matchNumber;
	}
	
	public int getTotalPointsScoredInMatch(int matchNumber) {
		for (int i = 0; i < _matchRecords.size(); i++) {
			if (_matchRecords.get(i).getMatchNumber() == matchNumber) {
				return _matchRecords.get(i).getTotalPoints();
			}
		}
		return 0;
	}
	
	public String toString() {
		return "" + number;
	}

	public double getAverageDriverAbility(){
		try{int total = 0;
		for( int i = 0; i < this.getNumberOfMatchRecords(); i++ )
			total += this.getMatchRecord(i).getDriverAbility();
		return total/this.getNumberOfMatchRecords();}
		catch(Exception e){return 0.0;}
	}

	public double getAverageManeuverability(){
		try{int total = 0;
		for( int i = 0; i < this.getNumberOfMatchRecords(); i++ )
			total += this.getMatchRecord(i).getManeuverability();
		return total/this.getNumberOfMatchRecords();}
		catch(Exception e){return 0.0;}
	}

	public double getAverageStability(){
		try{int total = 0;
		for( int i = 0; i < this.getNumberOfMatchRecords(); i++ )
			total += this.getMatchRecord(i).getStability();
		return total/this.getNumberOfMatchRecords();}
		catch(Exception e){return 0.0;}
	}

	public double getAveragePushingAbility(){
		try{int total = 0;
		for( int i = 0; i < this.getNumberOfMatchRecords(); i++ )
			total += this.getMatchRecord(i).getPushingAbility();
		return total/this.getNumberOfMatchRecords();}
		catch(Exception e){return 0.0;}
	}
	
	public double getAverageSpeed(){
		try{int total = 0;
		for( int i = 0; i < this.getNumberOfMatchRecords(); i++ )
			total += this.getMatchRecord(i).getSpeed();
		return total/this.getNumberOfMatchRecords();}
		catch(Exception e){return 0.0;}
	}
	
	
}
