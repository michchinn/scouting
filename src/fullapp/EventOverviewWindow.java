package fullapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("serial")
public class EventOverviewWindow extends JDialog {
	
	private static EventOverviewWindow _instance;
	
	private Event _currentEvent;
	private Team _currentTeam;
	
	private EventTableModel _eventTableModel;
	private JTable _eventTable;
	
	private JComboBox<String> _eventComboBox;
	private ArrayList<Event> _eventList;
	
	private JLabel _avgPointsPerMatchLabel;
	private JLabel _avgAutonLabel;
	private JLabel _avgTeleopLabel;
	
	private JButton _viewTeamButton;
	private JButton _addRecordButton;
	private JButton _predictButton;
	JLabel aerialAssistLogo;
	JPanel logoPanel;
	private Image aerAssist;
	
	private static float[] floats = {0,0,0};
	private static Color daisyDarkBlue; // = Color.getHSBColor(floats[0], floats[1], floats[2]);
	
	public static String pathToData;
	
	class EventComboBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int x = 0;
			_eventTable.clearSelection();
			for( int i = 0; !e.getItem().equals(_eventList.get(i).getName()); i++ ){
				x = i;
			}
			if( x == 0 )
				x = _eventList.size();
			x -= 1;
			_currentEvent = Main.frame._eventList.get(x);
			_eventTableModel.setTeamList(_currentEvent.getTeamList());
			
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
					aerialAssistLogo = new JLabel(new ImageIcon(image));
					logoPanel.remove(0);
					logoPanel.add(aerialAssistLogo);
					logoPanel.repaint();
					logoPanel.revalidate();
				}
				else{
					aerialAssistLogo = new JLabel(new ImageIcon(aerAssist));
					logoPanel.remove(0);
					logoPanel.add(aerialAssistLogo);
					logoPanel.repaint();
					logoPanel.revalidate();
				}
			}
		}
	}
	
	class ViewTeamListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TabbedProfileWindow window = new TabbedProfileWindow(_currentTeam, _currentEvent);
			window.pack();
			window.setVisible(true);
		}
	}
	
	class AddRecordListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			
			MatchRecordDialog dialog = null;
			dialog = new MatchRecordDialog(_currentEvent);
			dialog.setTeamNumber(_currentEvent.getTeamList().get(_eventTable.getSelectedRow()).getNumber());
			dialog.setTeamName(_currentEvent.getTeamList().get(_eventTable.getSelectedRow()).getName());
			_eventTable.clearSelection();
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
	
	public EventOverviewWindow() throws Exception {
		
		floats = Color.RGBtoHSB(0, 81, 126,floats);
		daisyDarkBlue = Color.getHSBColor(floats[0], floats[1], floats[2]);
		
		pathToData = System.getProperty("user.home") + "/Desktop/FRCData";
		_currentEvent = new Event("Hatboro-Horsham FIRST Robotics District Competition","PAHAT",142);
		
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
						TabbedProfileWindow window = new TabbedProfileWindow(_currentTeam, _currentEvent);
						window.pack();
						window.setVisible(true);
					}
				}
			}
		});
		_eventList = new ArrayList<Event>();

		// Load Events
//		String eventsJson = "";
//		Scanner s = new Scanner(new File(pathToData + "/data/2013_events.json"));
//		eventsJson = new Scanner(new File(pathToData + "/data/2013_events.json")).useDelimiter("\\A").next();
//		eventsJson = s.useDelimiter("\\A").next();
		
//		JSONParser parser = new JSONParser();
//		JSONArray eventArray = null;
//		try {
//			eventArray = (JSONArray)((JSONObject)(parser.parse(eventsJson))).get("data");
//		} catch (ParseException e) {
//		e.printStackTrace();
//		}

//		for (int i = 0; i < eventArray.size(); i++) {
//			JSONObject eventObject = (JSONObject)(eventArray.get(i));
//			String name = (String)(eventObject.get("name"));
//			String abbreviation = (String)(eventObject.get("api_name"));
//			int id = Integer.parseInt((String)(eventObject.get("id")));
//			Event event = new Event(name, abbreviation, id);
//			if (event.getTeamList().size() > 0) {
//				_eventList.add(event);
//			}
//		}
//		
//		Collections.sort(_eventList, new Comparator<Event>() {
//			public int compare(Event e1, Event e2) {
//				return e1.getName().compareTo(e2.getName());
//			}
//		});

//		s.close();
		
		_avgPointsPerMatchLabel = new JLabel("" + _currentEvent.getAveragePointsPerMatch());
		_avgAutonLabel = new JLabel("" + _currentEvent.getAverageAutonomousScore());
		_avgTeleopLabel = new JLabel("" + _currentEvent.getAverageTeleoperatedScore());
		
		
		_viewTeamButton = new JButton("View Team");
		_viewTeamButton.setEnabled(false);
		_viewTeamButton.addActionListener(new ViewTeamListener());
		_addRecordButton = new JButton("Add Record");
//		_addRecordButton.setEnabled(false);
		_addRecordButton.addActionListener(new AddRecordListener());
		_predictButton = new JButton("Match Prediction");
//		_predictButton.setEnabled(false);
		_predictButton.addActionListener(new PredictButtonListener());
		
		ArrayList<String> eventNames = new ArrayList<String>();
		for( int i = 0; i < _eventList.size(); i++ ){
			eventNames.add(_eventList.get(i).getName());
			
		}
//		_eventComboBox = new JComboBox(eventNames.toArray());
//		_eventComboBox.addItemListener(new EventComboBoxListener());
		
		// Construct panels for the right side controls.
		JScrollPane eventTablePanel = new JScrollPane(_eventTable);
		eventTablePanel.setPreferredSize(new Dimension(600, 500));
	
		ImageIcon icon = new ImageIcon(pathToData + "/images/AerialAssist.png");
		aerAssist = icon.getImage();
		aerAssist = aerAssist.getScaledInstance(250, -1, Image.SCALE_SMOOTH);
		JLabel aerialAssistLogo = new JLabel(new ImageIcon(aerAssist));
		
	//	JPanel eventSelectionPanel = new JPanel();
//		eventSelectionPanel.add(_eventComboBox);
		
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
		logoPanel.add(aerialAssistLogo);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(_viewTeamButton);
		buttonPanel.add(_addRecordButton);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.add(_predictButton);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(logoPanel);
//		rightPanel.add(eventSelectionPanel);
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
		
		float[]colors = {0,0,0};
		colors = Color.RGBtoHSB(0, 81, 126, colors);
		contentPane.setBackground(daisyDarkBlue);

		setTitle("Aerial Assist Scoutr");
	//	setResizable(false);
		_eventTableModel.setTeamList(_currentEvent.getTeamList());
		_eventTableModel.fireTableDataChanged();
	}
	
	/**
	 * @return {JFrame} The instance of the active EventOverviewWindow.
	 * @throws Exception 
	 */
	public static EventOverviewWindow getInstance() throws Exception {
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
	public static String pictureExists(String fileName){
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
