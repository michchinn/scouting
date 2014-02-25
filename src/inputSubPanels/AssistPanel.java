package inputSubPanels;

import javax.swing.*;

public class AssistPanel extends JPanel {

	private JTextField possessionsText;
	private JTextField successfulPassesText;
	private JTextField totalPassesText;
	private JTextField successfulTrussThrowsText;
	private JTextField totalTrussThrowsText;
	private JTextField successfulCatchesText;
	private JTextField totalCatchesText;
	
	public AssistPanel(){ 		  
		
		possessionsText = new JTextField("0",3);
		successfulPassesText = new JTextField("0",3);
		totalPassesText = new JTextField("0",3);
		successfulTrussThrowsText = new JTextField("0",3);
		totalTrussThrowsText = new JTextField("0",3);
		successfulCatchesText = new JTextField("0",3);
		totalCatchesText = new JTextField("0",3);
		
		  add(new JLabel("Possessions      "));
		  add(possessionsText);
		  
		  add(new JLabel());
		  add(new JLabel());
		  
		  add(new JLabel("Passes"));
		  add(successfulPassesText);
		  
		  add(new JLabel("/"));
		  add(totalPassesText);
		  
		  add(new JLabel("Truss Throws"));
		  add(successfulTrussThrowsText);
		  
		  add(new JLabel("/"));
		  add(totalTrussThrowsText);
		  
		  add(new JLabel("Catches"));
		  add(successfulCatchesText);
		  
		  add(new JLabel("/"));
		  add(totalCatchesText);
		  
		  setLayout(new SpringLayout());
		  SpringUtilities.makeCompactGrid(this, this.getComponentCount() / 4, 4,
					0, 0, 0, 0);
	}
	public int getPossessions(){
		return Integer.parseInt(possessionsText.getText());
	}
	public void setPossessions(int possessions){
		possessionsText.setText(Integer.toString(possessions));
	}
	public int getPassesComplete(){
		return Integer.parseInt(successfulPassesText.getText());
	}
	public void setPassesComplete(int passesComplete){
		successfulPassesText.setText(Integer.toString(passesComplete));
	}
	public int getPassesTotal(){
		return Integer.parseInt(totalPassesText.getText());
	}
	public void setPassesTotal(int passesTotal){
		totalPassesText.setText(Integer.toString(passesTotal));
	}
	public int getTrussThrowsComplete(){
		return Integer.parseInt(successfulTrussThrowsText.getText());
	}
	public void setTrussThrowsComplete(int trussThrowsComplete){
		successfulTrussThrowsText.setText(Integer.toString(trussThrowsComplete));
	}
	public int getTrussThrowsTotal(){
		return Integer.parseInt(totalTrussThrowsText.getText());
	}
	public void setTrussThrowsTotal(int trussThrowsTotal){
		totalTrussThrowsText.setText(Integer.toString(trussThrowsTotal));
	}
	public int getCatchesComplete(){
		return Integer.parseInt(successfulCatchesText.getText());
	}
	public void setCatchesComplete(int catchesComplete){
		successfulCatchesText.setText(Integer.toString(catchesComplete));
	}
	public int getCatchesTotal(){
		return Integer.parseInt(totalCatchesText.getText());
	}
	public void setCatchesTotal(int catchesTotal){
		totalCatchesText.setText(Integer.toString(catchesTotal));
	}
}
