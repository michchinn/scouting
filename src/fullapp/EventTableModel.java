package fullapp;

import javax.swing.table.AbstractTableModel;

import java.io.IOException;
import java.util.ArrayList;

public class EventTableModel extends AbstractTableModel{
	private String[] _columnNames = {"Team #", "Avg. Pts/Match", "Avg. Auton. Pts.", "Avg. Teleop. Pts.", "Avg. Accuracy","Number of Matches"};
	private ArrayList<Team> _data = new ArrayList<Team>();
	
	public Class<?> getColumnClass(int col) {
		if (col == 0 || col == 5) {
			return Integer.class;
		} 
		else {
			return Double.class;
		}
	}
	
	/**
	 * @return The number of columns in the table.
	 */
	public int getColumnCount() {
		return _columnNames.length;
	}
	
	/**
	 * @return the number of Teams in the table.
	 */
	public int getRowCount() {
		return _data.size();
	}
	
	/**
	 * @return the heading for a given column.
	 */
	public String getColumnName(int col) {
		return _columnNames[col];
	}
	
	public Object getValueAt(int row) {
		return _data.get(row);
	}
	
	/**
	 * TODO: Return proper values once team class is completed.
	 * @return The item in a specified cell of the table.
	 */
	public Object getValueAt(int row, int col) {	
		//String currentEventAbbr = EventOverviewWindow.getInstance().getCurrentEvent().getAbbreviation();	
		Team team = _data.get(row);
		switch(col) {
			case 0: return team.getNumber();
			case 1: return team.getAveragePointsPerMatch();
			case 2: return team.getAverageAutonPointsPerMatch();
			case 3: return team.getAverageTeleopPointsPerMatch();
			case 4: return team.getAverageTeleopShootingPercentage();
			case 5: return team.getNumberOfMatchRecords();
		}
		return null;
	}
	
	public void setValueAt(int row, Team team) {
		_data.set(row, team);
		fireTableDataChanged();
	}
	
	public void add(Team team) {
		_data.add(team);
		fireTableDataChanged();
	}
	
	public void setTeamList(ArrayList<Team> teamList) {
		_data.clear();
		for (int i = 0; i < teamList.size(); i++) {
			_data.add(teamList.get(i));
		}
		fireTableDataChanged();
	}
	
	public void remove(int index) {
		_data.remove(index);
		fireTableDataChanged();
	}
}
