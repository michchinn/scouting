package fullapp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MatchTablePanel extends JPanel{

	private JButton _addButton;
	private JButton _viewEditButton;
	private JButton _deleteButton;
	private MatchRecordTableModel _matchRecordTableModel;
	private JTable _matchRecordTable;
	private MatchRecordDialog editingDialog;
	private Team t;
	
	class MatchRecordTableSelectionListener implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent arg0) {
			int row = _matchRecordTable.getSelectedRow();
			if (row == -1) {
				_viewEditButton.setEnabled(false);
				_deleteButton.setEnabled(false);
		} else {
				_viewEditButton.setEnabled(true);
				_deleteButton.setEnabled(true);
			}
		}
	}

	class DeleteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int row = _matchRecordTable.getSelectedRow();
			_matchRecordTableModel.remove(row);
			try {
				Main.frame._currentEvent.saveToFile();
			} catch (IOException e1) {}
		}
	}
	
	public class SaveButton extends JButton implements ActionListener{

		private int num;
		
		public SaveButton(int num){
			this.num = num;
			setText("Save");
			addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent arg0) {
			t.setMatchRecord(num, editingDialog.getMatchRecord());
			editingDialog.dispose();
		}
		
	}
	public MatchTablePanel(Team t){
		this.t = t;
		_matchRecordTableModel = new MatchRecordTableModel();
		_matchRecordTableModel.setTeam(t);
		
		JScrollPane tablePanel = new JScrollPane();
		_matchRecordTable = new JTable(_matchRecordTableModel);
		_matchRecordTable.setAutoCreateRowSorter(true);
		_matchRecordTable.setSelectionModel(new DefaultListSelectionModel());
		_matchRecordTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_matchRecordTable.getSelectionModel().addListSelectionListener((ListSelectionListener) new MatchRecordTableSelectionListener());
		_matchRecordTable.setShowHorizontalLines(true);
		_matchRecordTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		tablePanel.setOpaque(false);
		tablePanel.setViewportView(_matchRecordTable);
		
		_addButton = new JButton("Add Record");
		_addButton.setEnabled(true);
		_addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					openAddMatchRecordDialog();
				} catch (Exception e1) {}}
			});
		
		_viewEditButton = new JButton("View/Edit");
		_viewEditButton.setEnabled(false);
		_viewEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					openEditMatchRecordDialog();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		_deleteButton = new JButton("Delete");
		_deleteButton.setEnabled(false);
		_deleteButton.addActionListener(new DeleteButtonListener());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(_addButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(25,0)));
		buttonPanel.add(_viewEditButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(25,0)));
		buttonPanel.add(_deleteButton);
		add(tablePanel); add(buttonPanel);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	private void openAddMatchRecordDialog() throws Exception {
		editingDialog = new MatchRecordDialog(Main.frame._currentEvent);
		editingDialog.setTeamName(t.getName());
		editingDialog.setTeamNumber(t.getNumber());
		editingDialog.pack();
		editingDialog.setVisible(true);
	}
	
	private void openEditMatchRecordDialog() throws Exception {
		int row = _matchRecordTable.getSelectedRow();
		MatchRecord record = (MatchRecord)(_matchRecordTableModel.getValueAt(_matchRecordTable.convertRowIndexToModel(row)));
		editingDialog = new MatchRecordDialog(Main.frame._currentEvent);
		editingDialog.setMatchRecord(record);
		editingDialog.bodyPanel.add(new SaveButton(row));
		editingDialog.pack();
		editingDialog.setVisible(true);
	
		row = _matchRecordTable.convertRowIndexToModel(_matchRecordTable.getSelectedRow());
		
		Main.frame._currentEvent.saveToFile();
	}
}
