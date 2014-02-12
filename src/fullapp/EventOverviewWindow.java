package fullapp;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import org.json.simple.*;
import org.json.simple.parser.*;

import resourceLoader.ResourceLoader;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class EventOverviewWindow extends JFrame {
	
	private static EventOverviewWindow _instance;
	
	private Event _currentEvent;
	private Team _currentTeam;
	
	private EventTableModel _eventTableModel;
	private JTable _eventTable;
	
	private JComboBox _eventComboBox;
	private ArrayList<Event> _eventList;
	
	private JLabel _avgPointsPerMatchLabel;
	private JLabel _avgAutonLabel;
	private JLabel _avgTeleopLabel;
	
	private JButton _viewTeamButton;
	private JButton _addRecordButton;
	private JButton _predictButton;
	JLabel ultimateAscentLogo;
	JPanel logoPanel;
	private Image ultAscent;
	
	public static String pathToData;
	
	class EventComboBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			_eventTable.clearSelection();
			for( int i = 0; !e.getItem().equals(_eventList.get(i).getName()); i++ ){
				_currentEvent = (Event)_eventList.get(i);
			}
			_eventTableModel.setTeamList(_currentEvent.getTeamList());
			
			if (_eventComboBox.getSelectedIndex() != 0) {
				_addRecordButton.setEnabled(true);
				_predictButton.setEnabled(true);
			}
			updateEventSummary();
	
		}
	}
	
	class EventTableSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			int row = _eventTable.getSelectedRow();
			if (row == -1) {
				_viewTeamButton.setEnabled(false);
			} else {
				_viewTeamButton.setEnabled(true);
				_currentTeam = (Team)(_eventTableModel.getValueAt(_eventTable.convertRowIndexToModel(row)));
				
				String fileExtension = pictureExists((Integer.toString(_currentTeam.getNumber())));

				if( !fileExtension.equals("false") ){
					ImageIcon icon = new ImageIcon(pathToData + "/images/teams/" + Integer.toString(_currentTeam.getNumber()) + fileExtension);
					Image image = icon.getImage();
					image = image.getScaledInstance(250, -1, Image.SCALE_SMOOTH);
					ultimateAscentLogo = new JLabel(new ImageIcon(image));
					logoPanel.remove(0);
					logoPanel.add(ultimateAscentLogo);
					logoPanel.repaint();
					logoPanel.revalidate();
				}
				else{
					ultimateAscentLogo = new JLabel(new ImageIcon(ultAscent));
					logoPanel.remove(0);
					logoPanel.add(ultimateAscentLogo);
					logoPanel.repaint();
					logoPanel.revalidate();
				}
			}
		}
	}
	
	class ViewTeamListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TeamProfileWindow window = new TeamProfileWindow(_currentTeam, _currentEvent);
			window.pack();
			window.setVisible(true);
		}
	}
	
	class AddRecordListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			_eventTable.clearSelection();
			_currentEvent = _eventList.get(_eventComboBox.getSelectedIndex());
			
			MatchRecordDialog dialog = null;
			dialog = new MatchRecordDialog(_currentEvent);
			dialog.setVisible(true);
		}
	}
	
	class PredictButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			_eventTable.clearSelection();
			
			PredictionDialog dialog = new PredictionDialog(_instance);
			dialog.pack();
			dialog.setVisible(true);
		}
	}
	
	public EventOverviewWindow() throws IOException {
		
		pathToData = System.getProperty("user.home") + "/Desktop/FRCData";
		_currentEvent = new Event();
		
		_eventTableModel = new EventTableModel();
		_eventTable = new JTable(_eventTableModel);
		_eventTable.setAutoCreateRowSorter(true);
		_eventTable.setSelectionModel(new DefaultListSelectionModel());
		_eventTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_eventTable.setShowHorizontalLines(true);
		_eventTable.getSelectionModel().addListSelectionListener(new EventTableSelectionListener());
		_eventTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = _eventTable.getSelectedRow();
					if (row != -1) {
						TeamProfileWindow window = new TeamProfileWindow(_currentTeam, _currentEvent);
						window.pack();
						window.setVisible(true);
					}
				}
			}
		});
		
		_eventList = new ArrayList<Event>();
		
		// Load Events
		String eventsJson = "";
		//eventsJson = new Scanner(ResourceLoader.load("data/2013_events.json")).useDelimiter("\\A").next();
		eventsJson = new Scanner(new File(pathToData + "/data/2013_events.json")).useDelimiter("\\A").next();
		
		JSONParser parser = new JSONParser();
		JSONArray eventArray = null;
		try {
			eventArray = (JSONArray)((JSONObject)(parser.parse(eventsJson))).get("data");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < eventArray.size(); i++) {
			JSONObject eventObject = (JSONObject)(eventArray.get(i));
			String name = (String)(eventObject.get("name"));
			String abbreviation = (String)(eventObject.get("api_name"));
			int id = Integer.parseInt((String)(eventObject.get("id")));
			Event event = new Event(name, abbreviation, id);
			if (event.getTeamList().size() > 0) {
				_eventList.add(event);
			}
		}
		
		Collections.sort(_eventList, new Comparator<Event>() {
			public int compare(Event e1, Event e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});

		_avgPointsPerMatchLabel = new JLabel("" + _currentEvent.getAveragePointsPerMatch());
		_avgAutonLabel = new JLabel("" + _currentEvent.getAverageAutonomousScore());
		_avgTeleopLabel = new JLabel("" + _currentEvent.getAverageTeleoperatedScore());
		
		
		_viewTeamButton = new JButton("View Team");
		_viewTeamButton.setEnabled(false);
		_viewTeamButton.addActionListener(new ViewTeamListener());
		_addRecordButton = new JButton("Add Record");
		_addRecordButton.setEnabled(false);
		_addRecordButton.addActionListener(new AddRecordListener());
		_predictButton = new JButton("Match Prediction");
		_predictButton.setEnabled(false);
		_predictButton.addActionListener(new PredictButtonListener());
		
		ArrayList<String> eventNames = new ArrayList();
		for( int i = 0; i < _eventList.size(); i++ ){
			eventNames.add(_eventList.get(i).getName());
			
		}
		_eventComboBox = new JComboBox(eventNames.toArray());
		_eventComboBox.addItemListener(new EventComboBoxListener());
		
		// Construct panels for the right side controls.
		JScrollPane eventTablePanel = new JScrollPane(_eventTable);
		eventTablePanel.setPreferredSize(new Dimension(600, 500));
	
		ImageIcon icon = new ImageIcon(pathToData + "/images/UltimateAscent.jpg");
		ultAscent = icon.getImage();
		ultAscent = ultAscent.getScaledInstance(250, -1, Image.SCALE_SMOOTH);
		JLabel ultimateAscentLogo = new JLabel(new ImageIcon(ultAscent));
		
		JPanel eventSelectionPanel = new JPanel();
		eventSelectionPanel.add(_eventComboBox);
		
		JLabel eventSummaryLabel = new JLabel("Event Summary");
		eventSummaryLabel.setFont(new Font(eventSummaryLabel.getFont().getName(),Font.BOLD,eventSummaryLabel.getFont().getSize()));
		
		JPanel eventSummaryPanel = new JPanel();
		eventSummaryPanel.setLayout(new GridLayout(0, 2, 15, 5));
		eventSummaryPanel.add(eventSummaryLabel);
		eventSummaryPanel.add(new JLabel());
		eventSummaryPanel.add(new JLabel("Avg. Pts/Match:"));
		eventSummaryPanel.add(_avgPointsPerMatchLabel);
		eventSummaryPanel.add(new JLabel("Avg. Auton Pts:"));
		eventSummaryPanel.add(_avgAutonLabel);
		eventSummaryPanel.add(new JLabel("Avg. Teleop Pts:"));
		eventSummaryPanel.add(_avgTeleopLabel);
		
		JPanel eventDetailPanel = new JPanel();
		eventDetailPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		eventDetailPanel.add(eventSummaryPanel);
		
		logoPanel = new JPanel();
		logoPanel.add(ultimateAscentLogo);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(_viewTeamButton);
		buttonPanel.add(_addRecordButton);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.add(_predictButton);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(logoPanel);
		rightPanel.add(eventSelectionPanel);
		rightPanel.add(eventDetailPanel);
		rightPanel.add(buttonPanel);
		rightPanel.add(buttonPanel2);
		
		JPanel rightPanelContainer = new JPanel();
		rightPanelContainer.add(rightPanel);
		
		// Add the subpanels to the frame.
		Container contentPane = getContentPane();
		setLayout(new BorderLayout());
		((JPanel)contentPane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		contentPane.add(eventTablePanel, BorderLayout.CENTER);
		contentPane.add(rightPanelContainer, BorderLayout.EAST);
		contentPane.setFocusable(true);
		
		setTitle("Aerial Assist Scoutr");
	}
	
	/**
	 * @return {JFrame} The instance of the active EventOverviewWindow.
	 * @throws IOException 
	 */
	public static EventOverviewWindow getInstance() throws IOException {
		if (_instance == null) {
			_instance = new EventOverviewWindow();
		}
		return _instance;
	}
	
	public Event getCurrentEvent() {
		return _currentEvent;
	}
	
	public Team getCurrentTeam() {
		return _currentTeam;
	}
	
	public void updateEventSummary() {
		_avgPointsPerMatchLabel.setText("" + _currentEvent.getAveragePointsPerMatch());
		_avgAutonLabel.setText("" + _currentEvent.getAverageAutonomousScore());
		_avgTeleopLabel.setText("" + _currentEvent.getAverageTeleoperatedScore());
	}
	public String pictureExists(String fileName){
		String[] fileExt = {".gif",".jpg",".png",".jpeg",".exif",".bmp"};
		File a = null;
		for(int i = 0; i < 6; i++ ){
			a = new File(pathToData + "/images/teams/" + fileName + fileExt[i]);
			if(a.exists())
				return fileExt[i];
		}
		return "false";
	}
}
