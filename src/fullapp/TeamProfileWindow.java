package fullapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
	
@SuppressWarnings("serial")
public class TeamProfileWindow extends JPanel {
	
	private JFileChooser _fileChooser;
	private JLabel teamPic;
	
	private Team t;

	public TeamProfileWindow(Team t){
		this.t = t;
		JLabel title = new JLabel("Team "+ t.getNumber() + " - " + t.getName() + "");
		title.setFont(new Font("SansSerif", Font.PLAIN, 24));
		
		JPanel titlePanel = new JPanel();
		titlePanel.add(title);
		add(titlePanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(new PhotoPanel(t));
		mainPanel.add(new CommentPane(t));
		mainPanel.add(new AveragePane(t));
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		//mainPanel.add(new TotalAutonPointsGraphPanel(t));
		
		mainPanel.setLayout(new GridLayout(2,3));
		add(mainPanel);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	
	
}

class CommentPane extends JTabbedPane{
	class PenaltiesComment extends JScrollPane{
		public PenaltiesComment(Team t){
			JPanel p = new JPanel();
			for( int i = 0; i < t.getNumberOfMatchRecords(); i++){
				JTextArea a = new JTextArea(t.getMatchRecord(i).getPenalties());
				a.setEditable(false);
				p.add(a);
				p.add(new JSeparator(SwingConstants.HORIZONTAL));
			}
			p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			setViewportView(p);
		}
	}
	class OverallGamePlay extends JScrollPane{
		public OverallGamePlay(Team t){
			JPanel p = new JPanel();
			for( int i = 0; i < t.getNumberOfMatchRecords(); i++){
				JTextArea a = new JTextArea(t.getMatchRecord(i).getOverallGamePlay());
				a.setEditable(false);
				p.add(a);
				p.add(new JSeparator(SwingConstants.HORIZONTAL));
			}	
			p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			setViewportView(p);
		}
	}
	public CommentPane(Team t){
		addTab("Penalties",new PenaltiesComment(t));
		addTab("Overall",new OverallGamePlay(t));
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	}
}
class AveragePane extends JPanel{
	class AverageData extends JPanel{
		
		public AverageData(Team t){
			add(new JLabel("Avg. Driver Ability"));add(new JLabel(Double.toString(t.getAverageDriverAbility())));
			add(new JLabel("Avg. Speed"));add(new JLabel(Double.toString(t.getAverageSpeed())));
			add(new JLabel("Avg. Stability"));add(new JLabel(Double.toString(t.getAverageStability())));
			add(new JLabel("Avg. Pushing Ability"));add(new JLabel(Double.toString(t.getAveragePushingAbility())));
			setLayout(new GridLayout(8,2));
		}
	}
	public AveragePane(Team t){
		JSeparator blackHorizontal = new JSeparator(SwingConstants.HORIZONTAL);
		blackHorizontal.setForeground(Color.BLACK);
		JLabel titleLabel = new JLabel("Averages");
		titleLabel.setFont(new Font(Font.SERIF,Font.BOLD,titleLabel.getFont().getSize()+5));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(titleLabel);
		add(blackHorizontal);
		add(new AverageData(t));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		Border line = BorderFactory.createLineBorder(Color.BLACK);
		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border firstCombine = BorderFactory.createCompoundBorder(empty,line);
		setBorder(BorderFactory.createCompoundBorder(firstCombine,empty));
	}
}

@SuppressWarnings("serial")
class UploadButton2 extends JButton implements ActionListener {

	private JFileChooser _fileChooser;
	private Team t;
	private JLabel teamPic;
	private JPanel window;
	private JFrame frame;
	
	public UploadButton2(final JFileChooser _fileChooser, final Team t, final JLabel teamPic, JPanel window){
		super("Upload/Change Team Picture");
		frame = new JFrame();
		this._fileChooser = _fileChooser;
		this.t = t;
		this.teamPic = teamPic;
		this.window = window;
		addActionListener(this);
		this._fileChooser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			try {
				FileUtils.copyFile(_fileChooser.getSelectedFile(), new File(EventOverviewWindow.pathToData + "/images/teams/"+t.getNumber() + "." + FilenameUtils.getExtension(_fileChooser.getSelectedFile().getName())));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ImageIcon icon = new ImageIcon(_fileChooser.getSelectedFile().getAbsolutePath());
			Image image = icon.getImage();
			if (icon.getIconHeight() > icon.getIconWidth()) {
				image = image.getScaledInstance(-1, 250, Image.SCALE_SMOOTH);
			} else {
				image = image.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
			}
			icon.setImage(image);
			teamPic.setIcon(icon);
			}
		});
		frame.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		window.add(_fileChooser);
		frame = new JFrame();
		frame.add(window);
		frame.pack();
		frame.setVisible(true);
	}
}

	
//	JScrollPane matchRecordPanel = new JScrollPane(_matchRecordTable);
//	matchRecordPanel.setPreferredSize(new Dimension(480, 250));
//	matchRecordPanel.setMaximumSize(new Dimension(480, 250));
//	
//	JPanel matchRecordPanelContainer = new JPanel();
//	matchRecordPanelContainer.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
//	matchRecordPanelContainer.add(matchRecordPanel);

//package fullapp;
//
//import org.apache.commons.io.*;
//import org.json.simple.parser.*;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//
//import javax.swing.*;
//import javax.swing.event.*;
//
//@SuppressWarnings("serial")
//public class TeamProfileWindow extends JPanel {
//	
//	private MatchRecordDialog editingDialog;
//	private Team _team;
//	private Event _currentEvent;
//	
//	private JTable _matchRecordTable;
//	private MatchRecordTableModel _matchRecordTableModel;
//	
//	private JLabel _teamPicture;
//	private JFileChooser _fileChooser;
//	
//	private JButton _addButton;
//	private JButton _viewEditButton;
//	private JButton _deleteButton;
//	private JButton _uploadButton;
//	
///*	private JTabbedPane _graphPane;
//	private GraphPanel _totalPointsGraph;
//	private GraphPanel _totalAutonPointsGraph;
//	private GraphPanel _totalTeleopPointsGraph;*/
//	
//	private JLabel _bestMatchLabel;
//	private JLabel _maxAutonLabel;
//	private JLabel _maxTeleopLabel;
//	private JLabel _avgPerMatchLabel;
//	private JLabel _avgAutonLabel;
//	private JLabel _avgTeleopLabel;
//
//	class MatchRecordTableSelectionListener implements ListSelectionListener {
//		public void valueChanged(ListSelectionEvent e) {
//			int row = _matchRecordTable.getSelectedRow();
//			if (row == -1) {
//				_viewEditButton.setEnabled(false);
//				_deleteButton.setEnabled(false);
//			} else {
//				_viewEditButton.setEnabled(true);
//				_deleteButton.setEnabled(true);
//			}
//		}
//	}
//	
//	public class DeleteButtonListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			int row = _matchRecordTable.getSelectedRow();
//			_matchRecordTableModel.remove(row);
//			try{updateTeamSummary();}
//			catch(Exception ex){}
//			try {
//				_currentEvent.saveToFile();
//			} catch (IOException e1) {}
//		}
//	}
//
//	public class UploadButtonListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			int returnValue = _fileChooser.showOpenDialog(TeamProfileWindow.this);
//			if (returnValue == JFileChooser.APPROVE_OPTION) {
//	            File file = _fileChooser.getSelectedFile();
//	            try {
//					FileUtils.copyFile(file, new File(EventOverviewWindow.pathToData + "/images/teams/"+_team.getNumber() + "." + FilenameUtils.getExtension(file.getName())));
//	            } catch (IOException e1) {
//					e1.printStackTrace();
//				}
//	            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
//	            Image image = icon.getImage();
//	            if (icon.getIconHeight() > icon.getIconWidth()) {
//	    			image = image.getScaledInstance(-1, 250, Image.SCALE_SMOOTH);
//	    		} else {
//	    			image = image.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
//	    		}
//	    		icon.setImage(image);
//	            _teamPicture.setIcon(icon);
//	        }
//		}
//	}
//	public class SaveButton extends JButton implements ActionListener{
//
//		private int num;
//		
//		public SaveButton(int num){
//			this.num = num;
//			setText("Save");
//			addActionListener(this);
//		}
//		
//		public void actionPerformed(ActionEvent arg0) {
//			_team.setMatchRecord(num, editingDialog.getMatchRecord());
//			editingDialog.dispose();
//		}
//		
//	}
//	public TeamProfileWindow(Team team, Event event) {
//		_team = team;
//		_currentEvent = event;
//		
//		_fileChooser = new JFileChooser();
//		
//		JLabel title = new JLabel("Team "+ _team.getNumber() + " - " + _team.getName() + "");
//		title.setFont(new Font("SansSerif", Font.PLAIN, 24));
//		
//		JPanel titlePanel = new JPanel();
//		titlePanel.add(title);
//		
//		_matchRecordTableModel = new MatchRecordTableModel();
//		_matchRecordTableModel.setTeam(_team);
//		
//		_matchRecordTable = new JTable(_matchRecordTableModel);
//		_matchRecordTable.setAutoCreateRowSorter(true);
//		_matchRecordTable.setSelectionModel(new DefaultListSelectionModel());
//		_matchRecordTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		_matchRecordTable.getSelectionModel().addListSelectionListener((ListSelectionListener) new MatchRecordTableSelectionListener());
//		_matchRecordTable.setShowHorizontalLines(true);
//		_matchRecordTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		_matchRecordTable.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 2) {
//					try {
//						openEditMatchRecordDialog();
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//		
//		JScrollPane matchRecordPanel = new JScrollPane(_matchRecordTable);
//		matchRecordPanel.setPreferredSize(new Dimension(480, 250));
//		matchRecordPanel.setMaximumSize(new Dimension(480, 250));
//		
//		JPanel matchRecordPanelContainer = new JPanel();
//		matchRecordPanelContainer.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
//		matchRecordPanelContainer.add(matchRecordPanel);
//		
//		// TODO: Search for picture or use a default image if it doesn't exist.
//		File root = new File(EventOverviewWindow.pathToData + "/images/teams");
//		File[] files = root.listFiles(new FileFilter() {
//			public boolean accept(File file) {
//				String filename = file.getName();
//				filename = filename.substring(0, filename.indexOf("."));
//				String teamNumber = _team.getNumber() + "";
//				int i = filename.indexOf(teamNumber);
//				return (i != -1) && (filename.length() == teamNumber.length());
//			}
//		});
//		
//		_teamPicture = new JLabel();
//		ImageIcon icon;
//		if (files.length > 0) {
//			icon = new ImageIcon(files[0].getAbsolutePath());
//		} else {
//			icon = new ImageIcon(EventOverviewWindow.pathToData + "/images/defaultProfilePicture.jpg");
//		}
//		Image image = icon.getImage();
//		if (icon.getIconHeight() > icon.getIconWidth()) {
//			image = image.getScaledInstance(-1, 250, Image.SCALE_SMOOTH);
//		} else {
//			image = image.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
//		}
//		icon.setImage(image);
//        _teamPicture.setIcon(icon);
//		
//		JPanel picturePanel = new JPanel();
//		Dimension picturePanelDimenstion = new Dimension(300, 250); 
//		picturePanel.setPreferredSize(picturePanelDimenstion);
//		picturePanel.setMinimumSize(picturePanelDimenstion);
//		picturePanel.setMaximumSize(picturePanelDimenstion);
//		picturePanel.add(_teamPicture);
//		
//		JPanel topPanel = new JPanel();
//		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
//		topPanel.add(matchRecordPanelContainer);
//		topPanel.add(picturePanel);
//		
//		_addButton = new JButton("Add Record");
//		_addButton.setEnabled(true);
//		_addButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					openAddMatchRecordDialog();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try{updateTeamSummary();}
//				catch(Exception ex){}
//			}
//		});
//		
//		_viewEditButton = new JButton("View/Edit");
//		_viewEditButton.setEnabled(false);
//		_viewEditButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					openEditMatchRecordDialog();
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//		
//		_deleteButton = new JButton("Delete");
//		_deleteButton.setEnabled(false);
//		_deleteButton.addActionListener(new DeleteButtonListener());
//		
//		_uploadButton = new JButton("Upload/Change Picture");
//		_uploadButton.addActionListener(new UploadButtonListener());
//		
//		JPanel buttonPanel = new JPanel();
//		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
//		buttonPanel.add(_addButton);
//		buttonPanel.add(Box.createRigidArea(new Dimension(25,0)));
//		buttonPanel.add(_viewEditButton);
//		buttonPanel.add(Box.createRigidArea(new Dimension(25,0)));
//		buttonPanel.add(_deleteButton);
//		buttonPanel.add(Box.createRigidArea(new Dimension(140,0)));
//		buttonPanel.add(_uploadButton);
//		
///*		_graphPane = new JTabbedPane();
//		Dimension graphPaneDimension = new Dimension(500, 300);
//		_graphPane.setPreferredSize(graphPaneDimension);
//		_graphPane.setMaximumSize(graphPaneDimension);
//		_graphPane.setMinimumSize(graphPaneDimension);
//		
//		_totalPointsGraph = new TotalPointsGraphPanel(_team);
//		_graphPane.add(_totalPointsGraph);
//		_totalAutonPointsGraph = new TotalAutonPointsGraphPanel(_team);
//		_graphPane.add(_totalAutonPointsGraph);
//		_totalTeleopPointsGraph = new TotalTeleopPointsGraphPanel(_team);
//		_graphPane.add(_totalTeleopPointsGraph);
//		*/
//		_bestMatchLabel = new JLabel("" + _team.getBestMatchNumber() + " (" + _team.getTotalPointsScoredInMatch(_team.getBestMatchNumber()) + " pts.)");
//		_maxAutonLabel = new JLabel("" + _team.getMaxAutonomousPoints());
//		_maxTeleopLabel = new JLabel("" + _team.getMaxTeleoperatedPoints());
//		_avgPerMatchLabel = new JLabel("" + _team.getAveragePointsPerMatch());
//		_avgAutonLabel = new JLabel("" + _team.getAverageAutonPointsPerMatch());
//		_avgTeleopLabel = new JLabel("" + _team.getAverageTeleopPointsPerMatch());
//		
//		JLabel teamSummaryLabel = new JLabel("Team Summary");
//		teamSummaryLabel.setFont(new Font(teamSummaryLabel.getFont().getName(),Font.BOLD,teamSummaryLabel.getFont().getSize()));
//		
//		JPanel teamSummaryPanel = new JPanel();
//		teamSummaryPanel.setLayout(new GridLayout(0, 2, 15, 5));
//		teamSummaryPanel.add(teamSummaryLabel);
//		teamSummaryPanel.add(new JLabel());
//		teamSummaryPanel.add(new JLabel("Best Match"));
//		teamSummaryPanel.add(_bestMatchLabel);
//		teamSummaryPanel.add(new JLabel("Max. Auton Pts:"));
//		teamSummaryPanel.add(_maxAutonLabel);
//		teamSummaryPanel.add(new JLabel("Max. Teleop Pts:"));
//		teamSummaryPanel.add(_maxTeleopLabel);
//		teamSummaryPanel.add(new JLabel("Avg. Pts/Match:"));
//		teamSummaryPanel.add(_avgPerMatchLabel);
//		teamSummaryPanel.add(new JLabel("Avg. Auton. Pts:"));
//		teamSummaryPanel.add(_avgAutonLabel);
//		teamSummaryPanel.add(new JLabel("Avg. Teleop Pts:"));
//		teamSummaryPanel.add(_avgTeleopLabel);
//		
//		JPanel teamSummaryContainer = new JPanel();
//		teamSummaryContainer.setBorder(BorderFactory.createEmptyBorder(20, 40, 0, 0));
//		teamSummaryContainer.add(teamSummaryPanel);
//		
//		JPanel bottomPanel = new JPanel();
//		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
//		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
////		bottomPanel.add(_graphPane);
//		bottomPanel.add(teamSummaryContainer);
//		
//		
//		// Add the subpanels to the frame.
//		Container contentPane = new JPanel();
//		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
//		((JPanel)contentPane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//		
//		contentPane.add(titlePanel);
//		contentPane.add(topPanel);
//		contentPane.add(buttonPanel);
//		contentPane.add(bottomPanel);
//		
//		contentPane.setFocusable(true);
//		add(contentPane);
//	}
//	
//	private void openAddMatchRecordDialog() throws IOException, ParseException {
//		editingDialog = new MatchRecordDialog(_currentEvent);
//		editingDialog.setTeamName(_team.getName());
//		editingDialog.setTeamNumber(_team.getNumber());
//		editingDialog.pack();
//		editingDialog.setVisible(true);
//	}
//	
//	private void openEditMatchRecordDialog() throws Exception {
//		int row = _matchRecordTable.getSelectedRow();
//		MatchRecord record = (MatchRecord)(_matchRecordTableModel.getValueAt(_matchRecordTable.convertRowIndexToModel(row)));
//		editingDialog = new MatchRecordDialog(_currentEvent);
//		editingDialog.setMatchRecord(record);
//		editingDialog.bodyPanel.add(new SaveButton(row));
//		editingDialog.pack();
//		editingDialog.setVisible(true);
//		
//		//MatchRecord record = dialog.getMatchRecord();
//		//if (record != null && _matchRecordTable.getSelectedRow() != -1) {
//			row = _matchRecordTable.convertRowIndexToModel(_matchRecordTable.getSelectedRow());
//		//	_matchRecordTableModel.setValueAt(row, record);
//			
//			updateTeamSummary();
//			_currentEvent.saveToFile();
//	}
//
//	
//	private void updateTeamSummary() throws Exception {
//		_bestMatchLabel.setText("" + _team.getBestMatchNumber() + " (" + _team.getTotalPointsScoredInMatch(_team.getBestMatchNumber()) + " pts.)");
//		_maxAutonLabel.setText("" + _team.getMaxAutonomousPoints());
//		_maxTeleopLabel.setText("" + _team.getMaxTeleoperatedPoints());
//		_avgPerMatchLabel.setText("" + _team.getAveragePointsPerMatch());
//		_avgAutonLabel.setText("" + _team.getAverageAutonPointsPerMatch());
//		_avgTeleopLabel.setText("" + _team.getAverageTeleopPointsPerMatch());
//		
//		/*_totalPointsGraph.repaint();
//		_totalAutonPointsGraph.repaint();
//		_totalTeleopPointsGraph.repaint();*/
//		EventOverviewWindow.getInstance().updateEventSummary();
//	}
//	
//	public Event getCurrentEvent() {
//		return _currentEvent;
//	}
//	
//	public Team getTeam() {
//		return _team;
//	}
//}
//
