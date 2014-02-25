package fullapp;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterviewDialog extends JDialog{

    public final TeamInfoPanel infoLine;
    private final LengthWidthPanel LWLine;
    private final WeightPanel weightLine;
    private final NumberofWheelsPanel wheelsLine;
    private final DriveSystemPanel driveSystemLine;
    private final DropCenterWheelsCheckPanel dropLine;
    private final SpeedPanel speedLine;
    private final ShooterTypePanel shooterTypeLine;
    private final TrussShotsCheckPanel trussCheckLine;
    private final GoalsPanel goalsLine;
    private final BallsAquiredPanel ballsAquiredLine;
    private final IntakeTypePanel intakeTypeLine;
    private final CatcherTypePanel catcherTypeLine;
    private final AutonCheckPanel autonCheckLine;
    private final StartingPosPanel startingPosLine;
    private final AutonGoalPanel autonGoalLine;
    private final AutonHotCheckPanel autonHotCheckLine;
    private final AutonScoredPanel autonScoredLine;
    private final AutonComment autonComment;
    private final GeneralComment generalComment;
    private final SubmitPanel submitLine;
    
    class AutonComment extends JPanel{
    	
    	private JTextArea autonCommentArea;
    	
    	public AutonComment(Interview interview){
    		add(new JLabel("Auton Comment"));
    		add(new JSeparator(SwingConstants.HORIZONTAL));
    		autonCommentArea = new JTextArea(7,20);
    		autonCommentArea.setLineWrap(true);
    		if( interview.getAutonComment() != null || interview.getAutonComment() == "null" || interview.getAutonComment() != "" ){
    			autonCommentArea.setText(interview.getAutonComment());
    		}
    		add(autonCommentArea);
    	}
    	public void submitData(Interview interview){
    		interview.setAutonComment(autonCommentArea.getText());
    	}
    }
    class GeneralComment extends JPanel{
    	
    	private JTextArea generalCommentArea;
    	
    	public GeneralComment(Interview interview){
    		add(new JLabel("General Comment"));
    		add(new JSeparator(SwingConstants.HORIZONTAL));
    		generalCommentArea = new JTextArea(7,20);
    		generalCommentArea.setLineWrap(true);
    		if( interview.getGeneralComment() != null || interview.getGeneralComment() == "null" || interview.getGeneralComment() != "" ){
    			generalCommentArea.setText(interview.getGeneralComment());
    		}
    		add(generalCommentArea);
    	}
    	public void submitData(Interview interview){
    		interview.setGeneralComment(generalCommentArea.getText());
    	}
    }

    public InterviewDialog(Interview interview){
    	
    	infoLine = new TeamInfoPanel(interview);     
    	LWLine = new LengthWidthPanel(interview);
    	weightLine = new WeightPanel(interview);
    	wheelsLine = new NumberofWheelsPanel(interview);     
    	driveSystemLine = new DriveSystemPanel(interview);
    	dropLine = new DropCenterWheelsCheckPanel(interview);
    	speedLine = new SpeedPanel(interview);
    	shooterTypeLine = new ShooterTypePanel(interview);
    	trussCheckLine = new TrussShotsCheckPanel(interview);
    	goalsLine = new GoalsPanel(interview);
    	ballsAquiredLine = new BallsAquiredPanel(interview);
    	intakeTypeLine = new IntakeTypePanel(interview);
    	catcherTypeLine = new CatcherTypePanel(interview); 
    	autonCheckLine = new AutonCheckPanel(interview);
    	startingPosLine = new StartingPosPanel(interview);
    	autonGoalLine = new AutonGoalPanel(interview);
      	autonHotCheckLine = new AutonHotCheckPanel(interview);
      	autonScoredLine = new AutonScoredPanel(interview);
      	autonComment = new AutonComment(interview);
      	generalComment = new GeneralComment(interview);
      	submitLine = new SubmitPanel(interview, this);
      
      	setDefaultCloseOperation(DISPOSE_ON_CLOSE); // default close op
      	setSize(400,700); // 
      	setVisible(true); // make it visible on screen
      	setResizable(true); // not resizable
      
      	JScrollPane mainPane = new JScrollPane();
      	JPanel mainPanNoScroll = new JPanel();
      	add(mainPane);
      	
      	if(Main.frame._eventTable.getSelectedRow() == -1)
      		infoLine.numberField.setText("0");
    	else
    		infoLine.numberField.setText(Integer.toString(Main.frame._currentEvent.getTeamList().get(Main.frame._eventTable.getSelectedRow()).getNumber()));
      	
      	mainPanNoScroll.add(infoLine);
      	mainPanNoScroll.add(LWLine);
      	mainPanNoScroll.add(weightLine);
      	mainPanNoScroll.add(wheelsLine);
      	mainPanNoScroll.add(driveSystemLine);
      	mainPanNoScroll.add(dropLine);
      	mainPanNoScroll.add(speedLine);
      	mainPanNoScroll.add(shooterTypeLine);
      	mainPanNoScroll.add(trussCheckLine);
      	mainPanNoScroll.add(goalsLine);
      	mainPanNoScroll.add(ballsAquiredLine);
      	mainPanNoScroll.add(intakeTypeLine);
      	mainPanNoScroll.add(catcherTypeLine);
      	mainPanNoScroll.add(autonCheckLine);
      	mainPanNoScroll.add(startingPosLine);
      	mainPanNoScroll.add(autonGoalLine);
      	mainPanNoScroll.add(autonHotCheckLine);
      	mainPanNoScroll.add(autonScoredLine);
      	mainPanNoScroll.add(autonComment);
      	mainPanNoScroll.add(generalComment);
      	mainPanNoScroll.add(submitLine);
      	mainPanNoScroll.setLayout(new BoxLayout(mainPanNoScroll,BoxLayout.Y_AXIS));
      	mainPane.setViewportView(mainPanNoScroll);
      	add(mainPane);
    }

    

    public void sendToInterview(Interview interview) throws IOException{

      infoLine.submitData(interview);
      LWLine.submitData(interview);
      weightLine.submitData(interview);
      wheelsLine.submitData(interview);
      driveSystemLine.submitData(interview);
      dropLine.submitData(interview);
      speedLine.submitData(interview);
      shooterTypeLine.submitData(interview);
      trussCheckLine.submitData(interview);
      goalsLine.submitData(interview);
      ballsAquiredLine.submitData(interview);
      intakeTypeLine.submitData(interview);
      catcherTypeLine.submitData(interview);
      autonCheckLine.submitData(interview);
      startingPosLine.submitData(interview); 
      autonGoalLine.submitData(interview);
      autonHotCheckLine.submitData(interview);
      autonScoredLine.submitData(interview);
      autonComment.submitData(interview);
      generalComment.submitData(interview);
      
      for( int index = 0; index < Main.frame._currentEvent.getTeamList().size(); index++){
    	  if(Main.frame._currentEvent.getTeamList().get(index).getNumber() == interview.getTeamNumber()){
    		  Main.frame._currentEvent.getTeamList().get(index).setInterview(interview);
    		  break;
    	  }
      } 
      this.dispose();
      Main.frame._currentEvent.saveToFile();
}



// houses submit button and creates Json

class SubmitPanel extends  JPanel{

    JButton submitButton;
    Interview interview;
    ActionListener action;

    public SubmitPanel(Interview interview, InterviewDialog id){
        submitButton = new JButton("Submit!");  //setup button with text.
        add(submitButton); // add button to panel
        submitButton.addActionListener(new PressListener(interview, id));
    }
}



class PressListener implements ActionListener{

        Interview interview;
        InterviewDialog interviewDialog;

        public PressListener(Interview i, InterviewDialog id){
            interview = i;
            interviewDialog = id;
        }

        public void actionPerformed(ActionEvent ae) {
           try{interviewDialog.sendToInterview(interview);}
           catch(Exception e){}
        }



}

// Line 0

class TeamInfoPanel extends JPanel{

    JLabel numberLabel;
    JTextField numberField;

    public TeamInfoPanel(Interview interview){

     
        numberLabel = new JLabel("Team Number:");
        numberField = new JTextField(4);

        if(interview.getTeamNumber() != 0)

            numberField.setText(Integer.toString(interview.getTeamNumber()));

        add(numberLabel);

        add(numberField);

    }

    public void submitData(Interview interview){

        interview.setTeamNumber(Integer.parseInt(numberField.getText()));
        for( int i = 0; i < Main.frame._currentEvent.getTeamList().size(); i++ )
        	if( Main.frame._currentEvent.getTeamList().get(i).getNumber() == interview.getTeamNumber() ){
        		interview.setTeamName(Main.frame._currentEvent.getTeamList().get(i).getName());
        		break;
        	}
    }

}



// Line 1

class LengthWidthPanel extends JPanel{

    JLabel lengthLabel;

    JTextField lengthField;

    JLabel widthLabel;

    JTextField widthField;

    

    JLabel inchesLabel1;

    JLabel inchesLabel2;

    

    // Intitalizer adds and initializes all components outlined above

    public LengthWidthPanel(Interview interview){  

         this.lengthField = new JTextField("0",5);
         this.lengthLabel = new JLabel("Length: ");
         this.widthLabel = new JLabel("Width: ");
         this.widthField = new JTextField("0",5);

         

         // fill in the current number if it was previously submitted 

         if(interview.getLength() != 0)

         {

            lengthField.setText(Integer.toString(interview.getLength()));

         }

         if(interview.getWidth() != 0){

             widthField.setText(Integer.toString(interview.getWidth()));

         }

         

         inchesLabel1 = new JLabel("in");

         inchesLabel2 = new JLabel("in");

         add(lengthLabel);

         add(lengthField);

         add(inchesLabel1);

         add(widthLabel);

         add(widthField);

         add(inchesLabel2);

    }

    

     public void submitData(Interview interview){

        interview.setLength(Integer.parseInt(lengthField.getText()));

        interview.setWidth(Integer.parseInt(widthField.getText()));

    }

}

// Line 2

class WeightPanel extends JPanel{

    JLabel weightLabel;

    JLabel lbLabel;

    JTextField weightField;

    

    

    // Intitalizer adds all components outlined above.

    public WeightPanel(Interview interview){  

         weightLabel = new JLabel("Weight: ");

         lbLabel = new JLabel("lb");

         weightField = new JTextField("0",5);

         

         if(interview.getWeight() != 0)

         {

            weightField.setText(Integer.toString(interview.getWeight()));

         }

         

         add(weightLabel);

         add(weightField);

         add(lbLabel);

    }

     public void submitData(Interview interview){

        interview.setWeight(Integer.parseInt(weightField.getText()));

    }

}



// Line 3

class NumberofWheelsPanel extends JPanel{

    JLabel numberLabel; 

    JLabel otherLabel; // "Other"

    

    JTextField otherField; // used for input incase one of the options does not match actual.

    

    JRadioButton twoButton; 

    JRadioButton fourButton; 

    JRadioButton sixButton;

    JRadioButton eightButton;

    

    JLabel twoLabel; // "2"

    JLabel fourLabel; // "4"

    JLabel sixLabel; // "6"

    JLabel eightLabel; // "8"

    

    ButtonGroup options; // used to link buttons together

    

    public NumberofWheelsPanel(Interview interview)

    {

        numberLabel = new JLabel("Number of Wheels: "); 
        otherLabel = new JLabel("Other");
        otherField = new JTextField("0",2);

        // buttons 
        twoButton = new JRadioButton();
        fourButton = new JRadioButton();
        sixButton = new JRadioButton();
        eightButton = new JRadioButton();

        // text before buttons

        twoLabel = new JLabel("2");

        fourLabel = new JLabel("4");

        sixLabel = new JLabel("6");

        eightLabel = new JLabel("8");

        

        // link buttons making only 1 choosable

        options = new ButtonGroup();

        

        options.add(twoButton);

        options.add(fourButton);

        options.add(sixButton);

        options.add(eightButton);

        

        //checks if there is already a value set and if it is one of the 8 buttons

        if(interview.getNumberOfWheels() == 2)

            twoButton.setSelected(true);

        else if(interview.getNumberOfWheels() == 4)

            fourButton.setSelected(true);

        else if(interview.getNumberOfWheels() == 6)

            sixButton.setSelected(true);

        else if(interview.getNumberOfWheels() == 8)

            eightButton.setSelected(true);

        else if(interview.getNumberOfWheels() != 0)

            otherField.setText(Integer.toString(interview.getNumberOfWheels()));

        //Add all to the panel

        

        add(numberLabel);

        add(eightLabel);

        add(eightButton);

        add(sixLabel);

        add(sixButton);

        add(fourLabel);

        add(fourButton);

        add(twoLabel);

        add(twoButton);

        add(otherLabel);

        add(otherField);





    }

    public void submitData(Interview interview){

        if(twoButton.isSelected() == true)

            interview.setNumberOfWheels(2);

        else if(fourButton.isSelected() == true)

            interview.setNumberOfWheels(4);

        else if(sixButton.isSelected() == true)

            interview.setNumberOfWheels(6);

        else if(eightButton.isSelected() == true)

            interview.setNumberOfWheels(8);

        else{

            if(otherField.getText() != null)

                interview.setNumberOfWheels(Integer.parseInt(otherField.getText()));

        }

    }

}

//line 4

class DriveSystemPanel extends JPanel{

    JLabel driveSystemLabel;

    String[] selectionOptions;

    JComboBox driveSystemOptions;

    String driveSystem;

    

    JTextField otherField;

    JLabel otherLabel;

    

    public DriveSystemPanel(Interview interview){

        selectionOptions = new String[]{"High Traction Tank", "Kit Tank", "Mechanum", "Omni", "Swerve", "Omni-Traction Hybrid", "Other - "};

        driveSystemLabel = new JLabel("Drive System: ");

        driveSystemOptions = new JComboBox(selectionOptions); // drop down box with the string's indexs as options

        

        otherLabel = new JLabel("Other");

        otherField = new JTextField(5);

         

        // check if there is already information 

        if(interview.getDriveSystem() != null){

            driveSystem = interview.getDriveSystem();  // set a holding string to this previously input option

            //Compare to see what this was, then make the selected option that choice.

            if(selectionOptions[0].equals(driveSystem))

                driveSystemOptions.setSelectedIndex(0);

            else if(selectionOptions[1].equals(driveSystem))

                driveSystemOptions.setSelectedIndex(1);

            else if(selectionOptions[2].equals(driveSystem))

                driveSystemOptions.setSelectedIndex(2);

            else if(selectionOptions[3].equals(driveSystem))

                driveSystemOptions.setSelectedIndex(3);

            else if(selectionOptions[4].equals(driveSystem))

                driveSystemOptions.setSelectedIndex(4);

            else if(selectionOptions[5].equals(driveSystem))

                driveSystemOptions.setSelectedIndex(5);

                // fill other box.

            else{

                driveSystemOptions.setSelectedIndex(6);

                otherField.setText(driveSystem);

            }

        }

        add(driveSystemLabel);

        add(driveSystemOptions);

        add(otherLabel);

        add(otherField);

    }

    

    // changes the variables in an Interview Class so, effectively "sending in" the data.

    public void submitData(Interview interview ){

        // check if other field is selected

        if(driveSystemOptions.getSelectedIndex() == 6)

            interview.setDriveSystem(otherField.getText());  // set the value to the other text field

        // if not simply make it whatever is selected

        else

             interview.setDriveSystem((String) driveSystemOptions.getSelectedItem());



    }

}

// line 5

class DropCenterWheelsCheckPanel extends JPanel{

    JLabel DropLabel;

    JLabel YesLabel;

    JLabel NoLabel;

    JLabel NALabel;

    JRadioButton yesButton;

    JRadioButton noButton;

    JRadioButton NAButton;

    

    ButtonGroup yesNoNA;  // used so that only one button may be pressed

    

    public DropCenterWheelsCheckPanel(Interview interview){

        DropLabel = new JLabel("Drop Center Wheels: ");

        YesLabel = new JLabel("Yes");

        NoLabel = new JLabel("No");

        NALabel = new JLabel("N/A");

        

        yesButton = new JRadioButton();

        noButton = new JRadioButton();

        NAButton = new JRadioButton();

        

        yesNoNA = new ButtonGroup();

        

        yesNoNA.add(yesButton); // link buttons together.

        yesNoNA.add(noButton);

        yesNoNA.add(NAButton);
        
        NAButton.setSelected(true);

        //check if the interview class has a false value for this check.

        if("Yes".equals(interview.getHasDropCenterWheels()))

                yesButton.setSelected(true); // if so select the no button

        else if("No".equals(interview.getHasDropCenterWheels())) 

                noButton.setSelected(true); // if so select the no button

        else if("NA".equals(interview.getHasDropCenterWheels()))

                NAButton.setSelected(true);

        

        add(DropLabel);

        add(YesLabel);

        add(yesButton);

        add(NoLabel);

        add(noButton);

        add(NALabel);

        add(NAButton);

        

    }

    // checks which button is pressed, sends to the interview class

    public void submitData(Interview interview){

        if(yesButton.isSelected() == true) // check if "yes" button pressed

            interview.setHasDropCenterWheels("Yes"); // set the truss shots variable to true.

        else if(noButton.isSelected() == true)

            interview.setHasDropCenterWheels("No");

        else if(NAButton.isSelected() == true)

            interview.setHasDropCenterWheels("NA");

    }

}

//line 6

class SpeedPanel extends JPanel{

    JLabel speedLabel; // holds speed text
    JLabel ftSecLabel; // holds "ft / sec" text
    JTextField speedField; 

    public SpeedPanel(Interview interview){
        speedLabel = new JLabel("Speed: ");
        ftSecLabel = new JLabel("ft/sec");
        speedField = new JTextField("0",5);
        // fill in the current number if it was previously submitted 
        System.out.println(interview.getSpeed());
         if(interview.getSpeed() != null)
            speedField.setText(interview.getSpeed());

        // add components to panel
        add(speedLabel);
        add(speedField);
        add(ftSecLabel);
    }

    // changes the variables in an Interview Class so, effectively "sending in" the data.

    public void submitData(Interview interview ){
            interview.setSpeed(speedField.getText());
    }
}

//line 7
class ShooterTypePanel extends JPanel{

    JLabel shooterTypeLabel;

    String[] selectionOptions  = {"Catapult", "Slingshot", "Puncher", "Kicker","Pitching Wheel", "Other - "};

    JComboBox shooterTypeOptions;

    String shooterType;

    

    JLabel otherLabel;

    JTextField otherField;

    

    public ShooterTypePanel(Interview interview){

        // initialize variables

        shooterTypeLabel = new JLabel("Shooter Type: ");

        shooterTypeOptions = new JComboBox(selectionOptions); // drop down box with the string's indexs as options

        

        otherLabel = new JLabel("Other");

        otherField = new JTextField(5);

        

        // check if there is already information 

        if(interview.getShooterType() != null){

            shooterType = interview.getShooterType();  // set a holding string to this previously input option

            //Compare to see what this was, then make the selected option that choice.

            if(selectionOptions[0].equals(shooterType))

                shooterTypeOptions.setSelectedIndex(0);

            else if(selectionOptions[1].equals(shooterType))

                shooterTypeOptions.setSelectedIndex(1);

            else if(selectionOptions[2].equals(shooterType))

                shooterTypeOptions.setSelectedIndex(2);

            else if(selectionOptions[3].equals(shooterType))

                shooterTypeOptions.setSelectedIndex(3);

            else if(selectionOptions[4].equals(shooterType))

                shooterTypeOptions.setSelectedIndex(4);

        // fill other box.

            else{

                shooterTypeOptions.setSelectedIndex(5);

                otherField.setText(shooterType);

            }

        }

        add(shooterTypeLabel);

        add(shooterTypeOptions);

        add(otherLabel);

        add(otherField);

        

    }

    

    // changes the variables in an Interview Class so, effectively "sending in" the data.

    public void submitData(Interview interview ){

        // check if other field is selected

        if(shooterTypeOptions.getSelectedIndex() == 5)

            interview.setShooterType(otherField.getText());  // set the value to the other text field

        // if not simply make it whatever is selected

        else  

            interview.setShooterType((String)shooterTypeOptions.getSelectedItem());  // set the speed to the speedField's text and converts to an int.

    }

    

}



//line 8

class TrussShotsCheckPanel extends JPanel{

    JLabel trussLabel;

    JLabel YesLabel;

    JLabel NoLabel;

    JRadioButton yesButton;

    JRadioButton noButton;

    

    ButtonGroup yesNo;

    

    public TrussShotsCheckPanel(Interview interview){

        trussLabel = new JLabel("Can make Truss Shots: ");

        YesLabel = new JLabel("Yes");

        NoLabel = new JLabel("No");

        yesButton = new JRadioButton();

        noButton = new JRadioButton();

        

        yesNo = new ButtonGroup();

        

        yesNo.add(yesButton); // link buttons together.

        yesNo.add(noButton);

        

        //check if the interview class has a false value for this check.

        if(interview.isCanMakeTrussShots()== false)

            noButton.setSelected(true); // if so select the no button

        else if(interview.isCanMakeTrussShots()== true)

            yesButton.setSelected(true);

        

        add(trussLabel);

        add(YesLabel);

        add(yesButton);

        add(NoLabel);

        add(noButton);

    }

    // checks which button is pressed, sends to the interview class

    public void submitData(Interview interview){

        if(yesButton.isSelected() == true) // check if "yes" button pressed

            interview.setCanMakeTrussShots(true); // set the truss shots variable to true.

        else if(noButton.isSelected() == true)

            interview.setCanMakeTrussShots(false);

    }

}

//Line 9

class GoalsPanel extends JPanel{

    JLabel goalsLabel;

    String[] selectionOptions;

    JComboBox generalGoalsOptions;

    String generalGoals;

    

    public GoalsPanel(Interview interview){

        // initialize variables

        selectionOptions = new String[]{"High", "Low", "Both"};

        goalsLabel = new JLabel("Which Goals: ");

        generalGoalsOptions = new JComboBox(selectionOptions); // drop down box with the string's indexs as options

        

                // check if there is already information 

        if(interview.getGeneralGoals() != null)

            generalGoals = interview.getGeneralGoals();  // set a holding string to this previously input option

        //Compare to see what this was, then make the selected option that choice.

        if(selectionOptions[0].equals(generalGoals))

            generalGoalsOptions.setSelectedIndex(0);

        else if(selectionOptions[1].equals(generalGoals))

            generalGoalsOptions.setSelectedIndex(1);

        else if(selectionOptions[2].equals(generalGoals))

            generalGoalsOptions.setSelectedIndex(2);

        

        // setup Panel

        add(goalsLabel);

        add(generalGoalsOptions);

        

    }

    // sends selected dropDown box to the Interview class

    public void submitData(Interview interview){

            interview.setGeneralGoals((String)generalGoalsOptions.getSelectedItem());  // set variable to slected dropdown item

    }

}

//Line 10

class BallsAquiredPanel extends JPanel{

    JLabel ballsAquiredLabel;

    

    // labels before check boxes

    JLabel floorLabel;

    JLabel catchingLabel;

    JLabel humanLabel;

    

    // check boxes

    JCheckBox floorBox;

    JCheckBox catchingBox;

    JCheckBox humanBox;

    

    public BallsAquiredPanel(Interview interview){

        // initialize variables

        ballsAquiredLabel = new JLabel("Balls aquired: ");



        

        floorLabel = new JLabel("Floor Loading");

        catchingLabel = new JLabel("Catching");

        humanLabel = new JLabel("Human Player");

        

        floorBox = new JCheckBox();

        catchingBox = new JCheckBox();

        humanBox = new JCheckBox();

        

        // if there is already a value for ball aquiry system

        if(interview.getBallAquirySystem() != null){

            if(interview.getBallAquirySystem().contains(floorLabel.getText()))  // if Floor Loading was checked before

                floorBox.setSelected(true); // check the box

            if(interview.getBallAquirySystem().contains(catchingLabel.getText()))  // ... 

                catchingBox.setSelected(true); // check the box

            if(interview.getBallAquirySystem().contains(humanLabel.getText())) // ...

                humanBox.setSelected(true); // ...

                        

        }

      



        add(ballsAquiredLabel);

        //add(ballAquirySystemOptions);

        add(floorLabel);

        add(floorBox);

        add(catchingLabel);

        add(catchingBox);

        add(humanLabel);

        add(humanBox);

        

    }

    // send data to interview class

    public void submitData(Interview interview){

           // interview.setBallAquirySystem((String)ballAquirySystemOptions.getSelectedItem());  // set variable to slected dropdown item

        

         interview.setBallAquirySystem(null); // make it null so that input does not repeat due to a failure in the addToBallAquirySystem method. 



        // if the floor loading box is checked

        if(floorBox.isSelected() == true)

            interview.setBallAquirySystem(floorLabel.getText());

        if(catchingBox.isSelected() == true)

            interview.setBallAquirySystem(catchingLabel.getText());

        if(humanBox.isSelected() == true)

            interview.setBallAquirySystem(humanLabel.getText());

    }

}





//Line 11

class IntakeTypePanel extends JPanel{

    JLabel intakeTypeLabel;

    String[] selectionOptions;

    JComboBox intakeTypeOptions;

    String intakeType;

    

    JLabel otherLabel;

    JTextField otherField;

    

    public IntakeTypePanel(Interview interview){

        // initialize variables

        selectionOptions = new String[]{"Roller", "Pincher-Claw", "Suction", "None", "Other - "};

        intakeTypeLabel = new JLabel("Intake Mechanism: ");

        intakeTypeOptions = new JComboBox(selectionOptions); // drop down box with the string's indexs as options

        

        otherLabel = new JLabel("Other");

        otherField = new JTextField("0",5);



       // check if there is already information 

        if(interview.getIntakeType() != null){

            intakeType = interview.getIntakeType();  // set a holding string to this previously input option

            //Compare to see what this was, then make the selected option that choice.

            if(selectionOptions[0].equals(intakeType))

                intakeTypeOptions.setSelectedIndex(0);

            else if(selectionOptions[1].equals(intakeType))

                intakeTypeOptions.setSelectedIndex(1);

            else if(selectionOptions[2].equals(intakeType))

                intakeTypeOptions.setSelectedIndex(2);

            else if(selectionOptions[3].equals(intakeType))

                intakeTypeOptions.setSelectedIndex(3);

            // fill other box.

            else{

                intakeTypeOptions.setSelectedIndex(4);

                otherField.setText(intakeType);

            }

        }

        add(intakeTypeLabel);

        add(intakeTypeOptions);

        add(otherLabel);

        add(otherField);

        

    }

    

    public void submitData(Interview interview){      

        // check if other field is selected

        if(intakeTypeOptions.getSelectedIndex() == 4)

            interview.setIntakeType(otherField.getText());  // set the value to the other text field

        // if not simply make it whatever is selected

        else

            interview.setIntakeType((String)intakeTypeOptions.getSelectedItem());  // set variable to slected dropdown item

    }

}



//line 12

class CatcherTypePanel extends JPanel{

    JLabel catcherTypeLabel;

    String[] selectionOptions;

    JComboBox catcherTypeOptions;

    String catcherType;

    

    public CatcherTypePanel(Interview interview){

        // initialize variables

        selectionOptions = new String[]{"Bowl", "Pincher-Claw", "None"};

        catcherTypeLabel = new JLabel("Catcher Mechanism: ");

        catcherTypeOptions = new JComboBox(selectionOptions); // drop down box with the string's indexs as options

        

        // check if there is already information 

        if(interview.getCatcherType() != null)

            catcherType = interview.getCatcherType();  // set a holding string to this previously input option

        //Compare to see what this was, then make the selected option that choice.

        if(selectionOptions[0].equals(catcherType))

            catcherTypeOptions.setSelectedIndex(0);

        else if(selectionOptions[1].equals(catcherType))

            catcherTypeOptions.setSelectedIndex(1);

        else if(selectionOptions[2].equals(catcherType))

            catcherTypeOptions.setSelectedIndex(2);



        

        add(catcherTypeLabel);

        add(catcherTypeOptions);

        

    }

    public void submitData(Interview interview){

            interview.setCatcherType((String)catcherTypeOptions.getSelectedItem());  // set variable to slected dropdown item

    }

}



//line 13

class AutonCheckPanel extends JPanel{

    JLabel autonCheckLabel;
    JLabel YesLabel;
    JLabel NoLabel;
    JRadioButton yesButton;
    JRadioButton noButton;
    ButtonGroup yesNo;

    public AutonCheckPanel(Interview interview){
        autonCheckLabel = new JLabel("Autonomous: ");
        YesLabel = new JLabel("Yes");
        NoLabel = new JLabel("No");
        yesButton = new JRadioButton();
        noButton = new JRadioButton();

        yesNo = new ButtonGroup();
        yesNo.add(yesButton); // link buttons together.
        yesNo.add(noButton);
        //check if the interview class has a false value for this check.

        noButton.setSelected(true);
        
        if(interview.isHasAuton() == false)

            noButton.setSelected(true); // if so select the no button

        else if(interview.isHasAuton() == true)

            yesButton.setSelected(true);

        

        add(autonCheckLabel);

        add(YesLabel);

        add(yesButton);

        add(NoLabel);

        add(noButton);

    }

    // checks which button is pressed, sends to the interview class
    public void submitData(Interview interview){
        if(yesButton.isSelected() == true) // check if "yes" button pressed
            interview.setHasAuton(true); // set the truss shots variable to true.
        else if(noButton.isSelected() == true)
            interview.setHasAuton(false);
    }
}


class StartingPosPanel extends JPanel{

    JLabel startingPosLabel;
    String[] selectionOptions;
    JComboBox startingPosOptions;
    String startingPos;

    public StartingPosPanel(Interview interview){
        // initialize variables
        selectionOptions = new String[]{"Middle Zone", "Goalie", "Both"};
        startingPosLabel = new JLabel("Auton Starting Posistion: ");
        startingPosOptions = new JComboBox(selectionOptions); // drop down box with the string's indexs as options

        // check if there is already information 
        if(interview.getAutonStartingPos() != null)
        	startingPos = interview.getAutonStartingPos();  
        // set a holding string to this previously input option
        //Compare to see what this was, then make the selected option that choice.

        if(selectionOptions[0].equals(startingPos))
            startingPosOptions.setSelectedIndex(0);
        else if(selectionOptions[1].equals(startingPos))
            startingPosOptions.setSelectedIndex(1);
        else if(selectionOptions[2].equals(startingPos))
            startingPosOptions.setSelectedIndex(2);

        add(startingPosLabel);
        add(startingPosOptions);

        

    }

    public void submitData(Interview interview){
            interview.setAutonStartingPos((String)startingPosOptions.getSelectedItem());  // set variable to slected dropdown item
    }

}

//line 15

class AutonGoalPanel extends JPanel{

    JLabel autonGoalLabel;
    String[] selectionOptions;
    JComboBox autonGoalOptions;
    String autonGoals;

    

    public AutonGoalPanel(Interview interview){

        // initialize variables

        selectionOptions = new String[]{"High", "Low", "None"};

        autonGoalLabel = new JLabel("Score in Autonomous: ");

        autonGoalOptions = new JComboBox(selectionOptions); // drop down box with the string's indexs as options

        

        if(interview.getAutonGoals() != null)

            autonGoals = interview.getAutonGoals();  // set a holding string to this previously input option

        //Compare to see what this was, then make the selected option that choice.

        if(selectionOptions[0].equals(autonGoals))

            autonGoalOptions.setSelectedIndex(0);

        else if(selectionOptions[1].equals(autonGoals))

            autonGoalOptions.setSelectedIndex(1);

        else if(selectionOptions[2].equals(autonGoals))

            autonGoalOptions.setSelectedIndex(2);



        add(autonGoalLabel);

        add(autonGoalOptions);

        

    }

    public void submitData(Interview interview){

            interview.setAutonGoals((String)autonGoalOptions.getSelectedItem());  // set variable to slected dropdown item

    }

}





//line 16

class AutonHotCheckPanel extends JPanel{

    JLabel autonHotCheckLabel;

    JLabel YesLabel;

    JLabel NoLabel;

    JRadioButton yesButton;

    JRadioButton noButton;

    

    ButtonGroup yesNo;

    

    public AutonHotCheckPanel(Interview interview){

        autonHotCheckLabel = new JLabel("Target Hot Goal: ");

        YesLabel = new JLabel("Yes");

        NoLabel = new JLabel("No");

        yesButton = new JRadioButton();

        noButton = new JRadioButton();

        

        yesNo = new ButtonGroup();

        

        yesNo.add(yesButton); // link buttons together.

        yesNo.add(noButton);

        

        //check if the interview class has a false value for this check.

        if(interview.isTargetHotGoal() == false)

            noButton.setSelected(true); // if so select the no button

        else if(interview.isTargetHotGoal() == true)

            yesButton.setSelected(true);

        

        add(autonHotCheckLabel);

        add(YesLabel);

        add(yesButton);

        add(NoLabel);

        add(noButton);

    }

        // checks which button is pressed, sends to the interview class

    public void submitData(Interview interview){

        if(yesButton.isSelected() == true) // check if "yes" button pressed

            interview.setTargetHotGoal(true); // set the truss shots variable to true.

        else if(noButton.isSelected() == true)

            interview.setTargetHotGoal(false);

    }

}



class AutonScoredPanel extends JPanel{

    JLabel numberOfBallsLabel;

    JLabel autonScoredLabel;

    JTextField autonScoredField;

    

    public AutonScoredPanel(Interview interview){

        autonScoredLabel = new JLabel("Number of Balls Scored in Auton: "); // prompt

        numberOfBallsLabel = new JLabel("balls");  // unit label

        autonScoredField = new JTextField("0",1); // text box

        

        if(interview.getAutonBallCount() != 0)

           autonScoredField.setText(Integer.toString(interview.getAutonBallCount()));

        

        add(autonScoredLabel);

        add(autonScoredField);

        add(numberOfBallsLabel);

    }

    public void submitData(Interview interview){

        interview.setAutonBallCount(Integer.parseInt(autonScoredField.getText()));

        }

}}