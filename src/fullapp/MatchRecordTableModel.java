package fullapp;

import javax.swing.table.AbstractTableModel;

public class MatchRecordTableModel extends AbstractTableModel{
	private String[] _columnNames = {"Match #","Auton. High","Auton. Hot High","Auton. Score", "# Teleop High","# Teleop Low","Teleop Top Acc.", "Catches", "Trusses","Teleop Score", "Play Style","Scout Name"};
	private Team _team;

	public Object getValueAt(int row, int col) {
		
		MatchRecord record = _team.getMatchRecord(row);
		switch(col) {
			case 0: return record.getMatchNumber();
			case 1: return record.getTopAutonScored();
			case 2: return record.getTopHot();
			case 3: return record.getAutonPoints();
			case 4: return record.getTopTeleopScored();
			case 5: return record.getBottomTeleopScored();
			case 6: return record.getTopShootingPercentage();
			case 7: return record.getCatchesComplete();
			case 8: return record.getTrussThrowsComplete();
			case 9: return record.getTeleopPoints();			
			case 10: return record.getPosistionPlayed();
			case 11: return record.getScoutName();
		}
		return null;
	}
	
	@Override
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
	@Override
	public String getColumnName(int col) {
		return _columnNames[col];
	}
	
	public Object getValueAt(int row) {
		return _team.getMatchRecord(row);
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
