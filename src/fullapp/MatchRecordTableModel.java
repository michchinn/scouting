package fullapp;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class MatchRecordTableModel extends AbstractTableModel{
	private String[] _columnNames = {"Match #", "# Auton. High", "# Auton. Low", "Auton. Score", "# Teleop High", "# Teleop Low", "# Trusses", "# Catches", "Teleop Score","Possessions", "Start Pos.", "Play Style"};
	private Team _team;
	
	public Class<?> getColumnClass(int col) {
		return Integer.class;
	}
	
	/**
	 * @return The number of columns in the table.
	 */
	public int getColumnCount() {
		return _columnNames.length;
	}
	
	/**
	 * @return the number of MatchRecords in the table.
	 */
	public int getRowCount() {
		return _team.getNumberOfMatchRecords();
	}
	
	/**
	 * @return the heading for a given column.
	 */
	public String getColumnName(int col) {
		return _columnNames[col];
	}
	
	public Object getValueAt(int row) {
		return _team.getMatchRecord(row);
	}
	
	/**
	 * TODO: Return proper values once team class is completed.
	 * @return The item in a specified cell of the table.
	 */
	public Object getValueAt(int row, int col) {
		//String currentEventAbbr = EventOverviewWindow.getInstance().getCurrentEvent().getAbbreviation();
		MatchRecord record = _team.getMatchRecord(row);
		switch(col) {
			case 0: return record.getMatchNumber();
			case 1: return record.getAutoTopScoredNotHot() + record.getHotGoalTopScored();
			case 2: return record.getAutoBottomScoredNotHot() + record.getHotGoalBottomScored();
			case 3: return record.getAutonPoints();
			case 4: return record.getBallsScoredTopTeleop();
			case 5: return record.getBallsScoredBottomTeleop();
			case 6: return record.getSuccessfulTrussThrows();
			case 7: return record.getSuccessfulCatches();
			case 8: return record.getTeleopPoints();
			case 9: return record.getPossessions();
			case 10: if(record.getStartingPosition())return "WHITE";else return "GOALIE";
			case 11: return record.getPositionPlayed();
		}
		return null;
	}
	
	public void setValueAt(int row, MatchRecord record) {
		_team.setMatchRecord(row, record);
		fireTableDataChanged();
	}
	
	public void add(MatchRecord record) {
		_team.addMatchRecord(record);
		fireTableDataChanged();
	}
	
	public void remove(int index) {
		_team.removeMatchRecord(index);
		fireTableDataChanged();
	}
	
	public void setTeam(Team team) {
		_team = team;
	}
}
