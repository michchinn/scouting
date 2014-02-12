package inputSubPanels;

import javax.swing.*;

public class AssistPanel extends JPanel {

	private JButton possessionsPlus;
	private JButton possessionsMinus;
	private JTextField possessionsText;
	
	private JButton successfulPassesPlus;
	private JButton successfulPassesMinus;
	private JTextField successfulPassesText;
	
	private JButton totalPassesPlus;
	private JButton totalPassesMinus;
	private JTextField totalPassesText;
	
	private JButton successfulTrussThrowsPlus;
	private JButton successfulTrussThrowsMinus;
	private JTextField successfulTrussThrowsText;
	
	private JButton totalTrussThrowsPlus;
	private JButton totalTrussThrowsMinus;
	private JTextField totalTrussThrowsText;
	
	private JButton successfulCatchesPlus;
	private JButton successfulCatchesMinus;
	private JTextField successfulCatchesText;
	
	private JButton totalCatchesPlus;
	private JButton totalCatchesMinus;
	private JTextField totalCatchesText;
	
	public AssistPanel(){
		  possessionsPlus = new JButton("+");
		  possessionsMinus = new JButton("-");
		  possessionsText = new JTextField(3);
		  Methods.scoringWithButtons(possessionsPlus, possessionsMinus, possessionsText);
		  add(new JLabel("Possessions"));
		  add(possessionsMinus);add(possessionsPlus);add(possessionsText);
		  //////////////////////////////////////
		  successfulPassesPlus = new JButton("+");
		  successfulPassesMinus = new JButton("-");
		  successfulPassesText = new JTextField(3);
		  Methods.scoringWithButtons(successfulPassesPlus, successfulPassesMinus, successfulPassesText);
		  add(new JLabel("Successful Passes"));
		  add(successfulPassesMinus);add(successfulPassesPlus);add(successfulPassesText);
		  //////////////////////////////////////
		  totalPassesPlus = new JButton("+");
		  totalPassesMinus = new JButton("-");
		  totalPassesText = new JTextField(3);
		  Methods.scoringWithButtons(totalPassesPlus, totalPassesMinus, totalPassesText);
		  add(new JLabel("Total Passes"));
		  add(totalPassesMinus);add(totalPassesPlus);add(totalPassesText);
		  //////////////////////////////////////
		  successfulTrussThrowsPlus = new JButton("+");
		  successfulTrussThrowsMinus = new JButton("-");
		  successfulTrussThrowsText = new JTextField(3);
		  Methods.scoringWithButtons(successfulTrussThrowsPlus, successfulTrussThrowsMinus, successfulTrussThrowsText);
		  add(new JLabel("Successful Truss Throws"));
		  add(successfulTrussThrowsMinus);add(successfulTrussThrowsPlus);add(successfulTrussThrowsText);
		  //////////////////////////////////////
		  totalTrussThrowsPlus = new JButton("+");
		  totalTrussThrowsMinus = new JButton("-");
		  totalTrussThrowsText = new JTextField(3);
		  Methods.scoringWithButtons(totalTrussThrowsPlus, totalTrussThrowsMinus, totalTrussThrowsText);
		  add(new JLabel("Total Truss Throws"));
		  add(totalTrussThrowsMinus);add(totalTrussThrowsPlus);add(totalTrussThrowsText);
		  //////////////////////////////////////
		  successfulCatchesPlus = new JButton("+");
		  successfulCatchesMinus = new JButton("-");
		  successfulCatchesText = new JTextField(3);
		  Methods.scoringWithButtons(successfulCatchesPlus, successfulCatchesMinus, successfulCatchesText);
		  add(new JLabel("Successful Catches"));
		  add(successfulCatchesMinus);add(successfulCatchesPlus);add(successfulCatchesText);
		  //////////////////////////////////////
		  totalCatchesPlus = new JButton("+");
		  totalCatchesMinus = new JButton("-");
		  totalCatchesText = new JTextField(3);
		  Methods.scoringWithButtons(totalCatchesPlus, totalCatchesMinus, totalCatchesText);
		  add(new JLabel("Total Catches"));
		  add(totalCatchesMinus);add(totalCatchesPlus);add(totalCatchesText);
		  setLayout(new SpringLayout());
		  SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 4, 4,
					0, 0, 0, 0);
	}
	public int getPossessions(){
		return Integer.parseInt(possessionsText.getText());
	}
	public int getSuccessfulPasses(){
		return Integer.parseInt(successfulPassesText.getText());
	}
	public int getTotalPasses(){
		return Integer.parseInt(totalPassesText.getText());
	}
	public int getSuccessfulTrussThrows(){
		return Integer.parseInt(successfulTrussThrowsText.getText());
	}
	public int getTotalTrussThrows(){
		return Integer.parseInt(totalTrussThrowsText.getText());
	}
	public int getSuccessfulCatches(){
		return Integer.parseInt(successfulCatchesText.getText());
	}
	public int getTotalCatches(){
		return Integer.parseInt(totalCatchesText.getText());
	}
}
