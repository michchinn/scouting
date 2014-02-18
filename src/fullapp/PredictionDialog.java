package fullapp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PredictionDialog extends JDialog {
	
	private JComboBox _red1;
	private JComboBox _red2;
	private JComboBox _red3;
	
	private JComboBox _blue1;
	private JComboBox _blue2;
	private JComboBox _blue3;
	
	private JLabel _predictedRedScore;
	private JLabel _predictedBlueScore;
	
	private TeamSummaryPanel _red1Panel;
	private TeamSummaryPanel _red2Panel;
	private TeamSummaryPanel _red3Panel;
	
	private TeamSummaryPanel _blue1Panel;
	private TeamSummaryPanel _blue2Panel;
	private TeamSummaryPanel _blue3Panel;
	
	private JButton _goButton;
	private JButton _cancelButton;
	
	class goButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Team r1 = (Team)_red1.getSelectedItem();
			Team r2 = (Team)_red2.getSelectedItem();
			Team r3 = (Team)_red3.getSelectedItem();
			
			Team b1 = (Team)_blue1.getSelectedItem();
			Team b2 = (Team)_blue2.getSelectedItem();
			Team b3 = (Team)_blue3.getSelectedItem();
			
			double red1 = r1.getAveragePointsPerMatch();
			double red2 = r2.getAveragePointsPerMatch();
			double red3 = r3.getAveragePointsPerMatch();
			_predictedRedScore.setText("" + (int)(red1 + red2 + red3));
			
			double blue1 = b1.getAveragePointsPerMatch();
			double blue2 = b2.getAveragePointsPerMatch();
			double blue3 = b3.getAveragePointsPerMatch();
			_predictedBlueScore.setText("" + (int)(blue1 + blue2 + blue3));
			
			_red1Panel.setTeam(r1);
			_red2Panel.setTeam(r2);
			_red3Panel.setTeam(r3);
			
			_blue1Panel.setTeam(b1);
			_blue2Panel.setTeam(b2);
			_blue3Panel.setTeam(b3);
		}
	}
	
	class TeamSummaryPanel extends JPanel {
		
		private JLabel _avgPtsLabel;
		private JLabel _accuracyLabel;
		private JLabel _maxAutonLabel;
		private JLabel _maxTeleopLabel;
		private JLabel _maxClimbLabel;
		
		public TeamSummaryPanel(JComboBox teamSelector) {
			super();
			
			setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			_avgPtsLabel = new JLabel();
			_accuracyLabel = new JLabel();
			_maxAutonLabel = new JLabel();
			_maxTeleopLabel = new JLabel();
			_maxClimbLabel = new JLabel();
			
			JPanel summaryGrid = new JPanel();
			summaryGrid.setLayout(new GridLayout(0, 2, 10, 2));
			summaryGrid.add(new JLabel("Avg. Pts/Match:"));
			summaryGrid.add(_avgPtsLabel);
			summaryGrid.add(new JLabel("Avg. Accuracy:"));
			summaryGrid.add(_accuracyLabel);
			summaryGrid.add(new JLabel("Max Auton:"));
			summaryGrid.add(_maxAutonLabel);
			summaryGrid.add(new JLabel("Max Teleop:"));
			summaryGrid.add(_maxTeleopLabel);
			summaryGrid.add(new JLabel("Max Climb:"));
			summaryGrid.add(_maxClimbLabel);
			
			add(teamSelector);
			add(summaryGrid);
		}
		
		public void setTeam(Team team) {
			_avgPtsLabel.setText("" + team.getAveragePointsPerMatch());
			_accuracyLabel.setText("" + team.getAverageTeleopShootingPercentage());
			_maxAutonLabel.setText("" + team.getMaxAutonomousPoints());
			_maxTeleopLabel.setText("" + team.getMaxTeleoperatedPoints());
		}
	}
	
	public PredictionDialog(EventOverviewWindow _instance) {
		super(_instance);
		
		_red1 = new JComboBox(((EventOverviewWindow)(_instance)).getCurrentEvent().getTeamList().toArray());
		_red2 = new JComboBox(((EventOverviewWindow)(_instance)).getCurrentEvent().getTeamList().toArray());
		_red3 = new JComboBox(((EventOverviewWindow)(_instance)).getCurrentEvent().getTeamList().toArray());
		_blue1 = new JComboBox(((EventOverviewWindow)(_instance)).getCurrentEvent().getTeamList().toArray());
		_blue2 = new JComboBox(((EventOverviewWindow)(_instance)).getCurrentEvent().getTeamList().toArray());
		_blue3 = new JComboBox(((EventOverviewWindow)(_instance)).getCurrentEvent().getTeamList().toArray());
		
		_predictedRedScore = new JLabel();
		_predictedBlueScore = new JLabel();
		
		_red1Panel = new TeamSummaryPanel(_red1);
		_red2Panel = new TeamSummaryPanel(_red2);
		_red3Panel = new TeamSummaryPanel(_red3);
		_blue1Panel = new TeamSummaryPanel(_blue1);
		_blue2Panel = new TeamSummaryPanel(_blue2);
		_blue3Panel = new TeamSummaryPanel(_blue3);
		
		_goButton = new JButton("Go");
		_goButton.addActionListener(new goButtonListener());
		
		_cancelButton = new JButton("Cancel");
		_cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JPanel predictionGridPanel = new JPanel();
		predictionGridPanel.setLayout(new GridLayout(0, 2, 15, 0));
		predictionGridPanel.add(new JLabel("Red"));
		predictionGridPanel.add(new JLabel("Blue"));
		predictionGridPanel.add(_predictedRedScore);
		predictionGridPanel.add(_predictedBlueScore);
		
		JPanel predictionPanel = new JPanel();
		predictionPanel.add(predictionGridPanel);
		
		JPanel redAlliancePanel = new JPanel();
		redAlliancePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		redAlliancePanel.setLayout(new BoxLayout(redAlliancePanel, BoxLayout.Y_AXIS));
		redAlliancePanel.add(_red1Panel);
		redAlliancePanel.add(_red2Panel);
		redAlliancePanel.add(_red3Panel);
		
		JPanel blueAlliancePanel = new JPanel();
		blueAlliancePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		blueAlliancePanel.setLayout(new BoxLayout(blueAlliancePanel, BoxLayout.Y_AXIS));
		blueAlliancePanel.add(_blue1Panel);
		blueAlliancePanel.add(_blue2Panel);
		blueAlliancePanel.add(_blue3Panel);
		
		JPanel summaryGridPanel = new JPanel();
		summaryGridPanel.setLayout(new GridLayout(0, 2, 15, 0));
		summaryGridPanel.add(redAlliancePanel);
		summaryGridPanel.add(blueAlliancePanel);
		
		JPanel summaryPanel = new JPanel();
		summaryPanel.add(summaryGridPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 275, 0, 0));
		buttonPanel.add(_goButton);
		buttonPanel.add(_cancelButton);
		
		JPanel contents = new JPanel();
		contents.setLayout(new BoxLayout(contents, BoxLayout.Y_AXIS));
		contents.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Match Prediction"), BorderFactory.createEmptyBorder(2, 10, 2, 10)));
		contents.add(predictionPanel);
		contents.add(summaryPanel);
		contents.add(buttonPanel);
		
		JPanel contentPane = (JPanel)getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		contentPane.add(contents);

		setTitle("Match Prediction");
		setResizable(false);
	}
}
