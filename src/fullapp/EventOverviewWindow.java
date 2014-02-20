package fullapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
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
	public JTabbedPane mainTabbedPane;
	
	private Event _currentEvent;
	private Team _currentTeam;
	
	private EventTableModel _eventTableModel;
	private JTable _eventTable;
	
	private ArrayList<Event> _eventList;
	
	private JLabel _avgPointsPerMatchLabel;
	private JLabel _avgAutonLabel;
	private JLabel _avgTeleopLabel;
	
	private JButton _viewTeamButton;
	private JButton _viewTeamWindow;
	private JButton _addRecordButton;
	private JButton _predictButton;
	JLabel aerialAssistLogo;
	JPanel logoPanel;
	private Image aerAssist;
	
	private static float[] floats = {0,0,0};
	private static Color daisyDarkBlue; // = Color.getHSBColor(floats[0], floats[1], floats[2]);
	
	public static String pathToData;
	
	class EventTableSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			int row = _eventTable.getSelectedRow();
			if (row == -1) {
				_viewTeamButton.setEnabled(false);
				_viewTeamWindow.setEnabled(false);
			} else {
				_viewTeamButton.setEnabled(true);
				_viewTeamWindow.setEnabled(true);
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
	
	class ViewTeamListenerTab implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TabbedProfileWindow window = new TabbedProfileWindow(_currentTeam, _currentEvent);
			try{mainTabbedPane.setSelectedComponent(window);}
			catch(Exception e2){
			addClosableTab(Main.frame.mainTabbedPane,window,Integer.toString(_currentTeam.getNumber()));
			mainTabbedPane.setSelectedIndex(mainTabbedPane.getTabCount()-1);}
		}
	}
	class ViewTeamListenerWindow implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TabbedProfileWindow window = new TabbedProfileWindow(_currentTeam, _currentEvent);
			JFrame f = new JFrame();
			f.add(window);
			f.pack();
			f.setVisible(true);
		}
	}
	
	class AddRecordListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		
			MatchRecordDialog dialog = null;
			dialog = new MatchRecordDialog(_currentEvent);
			if(_eventTable.getSelectedRow() != -1){
				dialog.setTeamNumber(_currentEvent.getTeamList().get(_eventTable.getSelectedRow()).getNumber());
				dialog.setTeamName(_currentEvent.getTeamList().get(_eventTable.getSelectedRow()).getName());
			}
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
				TabbedProfileWindow window = new TabbedProfileWindow(_currentTeam, _currentEvent);
				if (e.getClickCount() == 2) {
					int row = _eventTable.getSelectedRow();
					if (row != -1) {		
						JFrame f = new JFrame();
						f.add(window);
						f.pack();
						f.setVisible(true);
					}
				}
				if(e.isControlDown()){
					mainTabbedPane.addTab(Integer.toString(_currentTeam.getNumber()), window);
					addClosableTab(Main.frame.mainTabbedPane,window,Integer.toString(_currentTeam.getNumber()));
					
				}
				
			}
		});
		_eventList = new ArrayList<Event>();
		
		_avgPointsPerMatchLabel = new JLabel("" + _currentEvent.getAveragePointsPerMatch());
		_avgAutonLabel = new JLabel("" + _currentEvent.getAverageAutonomousScore());
		_avgTeleopLabel = new JLabel("" + _currentEvent.getAverageTeleoperatedScore());
		
		
		_viewTeamButton = new JButton("Open Team Tab");
		_viewTeamButton.setEnabled(false);
		_viewTeamButton.addActionListener(new ViewTeamListenerTab());
		_viewTeamWindow = new JButton("Open Team Window");
		_viewTeamWindow.setEnabled(false);
		_viewTeamWindow.addActionListener(new ViewTeamListenerWindow());
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
		
		JLabel eventSummaryLabel = new JLabel("Hatboro Horsham");
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
		buttonPanel.add(_viewTeamWindow);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.add(_predictButton);
		buttonPanel2.add(_addRecordButton);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(logoPanel);
//		rightPanel.add(eventSelectionPanel);
		rightPanel.add(eventDetailPanel);
		rightPanel.add(buttonPanel);
		rightPanel.add(buttonPanel2);
		
		JPanel rightPanelContainer = new JPanel();
		rightPanelContainer.add(rightPanel);
		
/*		// Add the subpanels to the frame.
		Container contentPane = getContentPane();
		setLayout(new BorderLayout());
		((JPanel)contentPane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));*/
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, 0));
		contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		contentPane.add(eventTablePanel, BorderLayout.CENTER);
		Box.createRigidArea(new Dimension(0,50));
		contentPane.add(rightPanelContainer, BorderLayout.EAST);
		contentPane.setFocusable(true);
		
		float[]colors = {0,0,0};
		colors = Color.RGBtoHSB(0, 81, 126, colors);
		contentPane.setBackground(daisyDarkBlue);

		setTitle("Aerial Assist Scoutr");
		_eventTableModel.setTeamList(_currentEvent.getTeamList());
		_eventTableModel.fireTableDataChanged();
		
		mainTabbedPane = new JTabbedPane();
		mainTabbedPane.addTab("Event Overview",contentPane);

		add(mainTabbedPane);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)d.getWidth()-250,(int)d.getHeight()-150));
	}
	public void addClosableTab(final JTabbedPane tabbedPane, final JComponent c, final String title) {
	    // Add the tab to the pane without any label
	    tabbedPane.addTab(null, c);
	    int pos = tabbedPane.indexOfComponent(c);

	    // Create a FlowLayout that will space things 5px apart
	    FlowLayout f = new FlowLayout(FlowLayout.CENTER, 5, 0);

	    JPanel pnlTab = new JPanel(f);
	    pnlTab.setOpaque(false);

	    // Add a JLabel with title and the left-side tab icon
	    JLabel lblTitle = new JLabel(title);

	    // Create a JButton for the close tab button
	    JButton btnClose = new JButton("X");
	    btnClose.setOpaque(false);

	    // Set border null so the button doesn't make the tab too big
	    btnClose.setBorder(null);

	    // Make sure the button can't get focus, otherwise it looks funny
	    btnClose.setFocusable(false);

	    // Put the panel together
	    pnlTab.add(lblTitle);
	    pnlTab.add(btnClose);

	    // Add a thin border to keep the image below the top edge of the tab
	    // when the tab is selected
	    pnlTab.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));

	    // Now assign the component for the tab
	    tabbedPane.setTabComponentAt(pos, pnlTab);

	    // Add the listener that removes the tab
	    ActionListener listener = new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	tabbedPane.remove(c);
	      }
	    };
	    btnClose.addActionListener(listener);

	    // Optionally bring the new tab to the front
	    tabbedPane.setSelectedComponent(c);
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

@SuppressWarnings("serial")
class ClosingButton extends JPanel implements ActionListener{
	
	private int tabIndex;
	
	public ClosingButton(int tabIndex){
		this.tabIndex = tabIndex - 1;
		add(new JLabel("X"));
		this.setFocusable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Pressed");
		Main.frame.mainTabbedPane.remove(this.tabIndex-1);
		Main.frame.mainTabbedPane.repaint();
		Main.frame.mainTabbedPane.revalidate();
	}

}