import java.awt.Color;                         //Program set color
// The awt components would use in the program
import java.awt.GridBagConstraints;            //Program use GridBagConstraints
import java.awt.GridBagLayout;                 //Program use GridBagLayout
import java.awt.GridLayout;                    //Program use Gridlayout
import java.awt.event.ActionEvent;             //Program use ActionEvent
import java.awt.event.ActionListener;          //Program use ActionListener
import java.io.File;
import java.io.IOException;
import java.util.Arrays;     //Program uses Arrays function
import java.util.Scanner; //Program uses Scanner

import javax.swing.BorderFactory;               //Program use BorderFactory
import javax.swing.JButton;                     //Program use JButton
import javax.swing.JFrame;                      //Program use JFrame
import javax.swing.JLabel;                      //Program use JLabel
import javax.swing.JList;                       //Program use JList
import javax.swing.JOptionPane;                 //Program use JOptionPane
import javax.swing.JPanel;                      //Program use JPanel
import javax.swing.JSpinner;                    //Program use JSpinner
import javax.swing.JTextArea;                   //Program use JTextArea
import javax.swing.JTextField;                  //Program use JTextField
import javax.swing.SpinnerListModel;            //Program use SpinnerListModel
import javax.swing.border.TitledBorder;         //Program use TitledBorder
import javax.swing.event.ListSelectionEvent;    //Program use List Selection Event
// the swing components would use in the Program
import javax.swing.event.ListSelectionListener; //Program use List Selection Listener

public class GuiOfRedemption extends JFrame

{
  
//set up constructor for MileRedeemer and Destination program
   private static  Destination destination = null; //use for Destination program
   private  static MileRedeemer redeemer = new MileRedeemer(); //Use for MileRedeemer program
  
  //private final JLabel fileLabel;
  //private final JTextField fileInput;
  //private final JButton scanButton;
  
  
  //private final variables for left panel
  private final JList<String> cityList; //JList for city names
  private final JTextField normalMiles; //JTextField for normal miles info
  private final JTextField supersaver;  //JTextField for fly cheap miles
  private final JTextField upgrade;     //JTextField for upgrade needed miles
  private final JTextField dates;       //JTextField for dates info
  private final JLabel mileLabel;       //JLabel for label the normal miles info
  private final JLabel saverLabel;      //JLabel for label the fly cheap miles
  private final JLabel upLabel;         //JLabel for label the upgrade miles info
  private final JLabel dateLabel;       //JLabel for label the dates info
  
  //private final variables for right panel
  private final JLabel enterMiles;      //JLabel for label the enter miles text
  private final JLabel enterMonth;      //JLabel for label the enter month text
  private final JTextField milesText;   //JTextField for enter the miles
  private final JSpinner monthSpinner;  //JSpinner for select months
  private final SpinnerListModel monthList; //SpinnerListModel for set up the month
  private final JButton redeemButton;   //JButton to redeem miles
  private final JTextArea textArea;     //JTextArea for show all flight infomation
  private final JLabel remainingMiles;  //JLabel for label the remaining miles text
  private final JTextField remainMiles; //JTextField for remaining miles info
  private final String[] monthArray;

   
  
  public GuiOfRedemption() throws IOException
  {
    //Name the prompt window 
	  super("MileRedemption");
    //Set up the layout for JFrame
	 setLayout( new GridLayout(0, 2) );
    
    //Set up JOptionPane to prompt user to input file name
    String fileName = JOptionPane.showInputDialog("Enter file name");     
    
    //Scan the file
    Scanner fileScan = new Scanner( new File( fileName ) );
    redeemer.readDestinations( fileScan );
    
    //get city names pass into string
    String[] cities = redeemer.getCityNames();    
    
    
/************************************************************************************************/    
    //Set up left panel
    JPanel leftPanel = new JPanel( new GridBagLayout() );       //create JPanel use gridbaglayout
    leftPanel.setBackground( Color.getHSBColor(200, 250, 50) ); //set the background color
    TitledBorder title1;                                        //set up title
    title1 = BorderFactory.createTitledBorder( "Destinations" );//name the titled border
    title1.setTitleJustification( TitledBorder.CENTER );        //center the title
    leftPanel.setBorder(title1);                                //apply the title to the panel
    add(leftPanel);                                             //add panel to JFrame
    
    //Set up Right Panel
    JPanel rightPanel = new JPanel( new GridBagLayout() );      //create JPanel use gridbaglayout
    rightPanel.setBackground( Color.getHSBColor(40, 120, 120) );//set the background color
    TitledBorder title2;                                        //set up title
    title2 = BorderFactory.createTitledBorder( "Redeem Miles" );//name the titled border
    title2.setTitleJustification( TitledBorder.CENTER );        //center the title
    rightPanel.setBorder( title2 );                             //apply the title to the panel
    add(rightPanel);                                            //add panel to JFrame
 
/*****************************         Left Panel            ***********************************/
    
    //set up grid bag constraints in order to control the layout
    GridBagConstraints g = new GridBagConstraints();
    GridBagConstraints c = new GridBagConstraints();
    
    //Set up JList cityList
    cityList = new JList<String>( cities );  //put city names into JList
    cityList.setVisibleRowCount(10);         //set up the visible row
    //Set the constraints for JList cityList
    c.fill = GridBagConstraints.BOTH;        
    c.anchor = GridBagConstraints.LINE_START;
    c.gridwidth = 2;
    c.weighty = 10;
    c.weightx = 30;
    c.gridx = 0;
    c.gridy = 0;
    leftPanel.add(cityList, c);               //add JList to leftPanel through gridbagconstraints
    
    
    //Set up Jlabel mileLabel
    mileLabel = new JLabel( "Normal Miles "); //name the label as Normal miles
    //Set the constraints for JLabel mileLabel
    g.anchor = GridBagConstraints.LINE_START; //
    g.gridx = 0;
    g.gridy = 2;
    leftPanel.add(mileLabel,g);               //add JLabel to leftPanel through gridbagconstraints
    
    
    //Set up JTextfield normalMiles
    normalMiles = new JTextField("", 10);     //set the textfield to default and set up length as 10
    normalMiles.setEditable( false );         //set the textfield uneditable
    //Set the constraints for JTextField normalMiles
    g.fill = GridBagConstraints.HORIZONTAL;
    g.gridx = 1;
    g.gridy = 2;
    leftPanel.add(normalMiles, g);            //add JTextField to leftPanel through gridbagconstraints
    
    
    //Set up JLabel saverLabel
    saverLabel = new JLabel( "Supersaver Miles ");//name the label as Supersaver Miles
    //Set the constraints for JLabel saverLabel
    g.anchor = GridBagConstraints.LINE_START;
    g.gridx = 0;
    g.gridy = 3;
    leftPanel.add(saverLabel, g);             //add JLabel to leftPanel through gridbagconstraints
    
    
    //Set up JTextField supersaver
    supersaver = new JTextField("", 10);      //set the textfield to default and set length as 10
    supersaver.setEditable( false );          //set the textfield uneditable
    //Set the constraints for JTextField supersaver
    g.gridx = 1;
    g.gridy = 3;
    leftPanel.add(supersaver, g);             //add JTextField to leftPanel through gridbagconstraints
    
    
    //Set up JLabel upLabel
    upLabel = new JLabel( "Upgrade Cost " );  //name the label as Upgrade cost
    //Set the constraints for JLabel upLabel
    g.anchor = GridBagConstraints.LINE_START;
    g.gridx = 0;
    g.gridy = 4;
    leftPanel.add(upLabel, g);                //add JLabel to leftPanel through gridbagconstraints
    
    
    //Set up JTextField upgrade
    upgrade = new JTextField("", 10);         //set the textfield to default and set length as 10
    upgrade.setEditable( false );             //set the textfield uneditable
    //Set the constraints for JTextField upgrade
    g.gridx = 1; 
    g.gridy = 4;
    leftPanel.add(upgrade, g);                //add JTextField to leftPanel through gridbagconstraints
    
    
    //Set up JLabel dateLabel
    dateLabel = new JLabel( "Supersaver Date ");//name the label as SuperSaver Date
    //Set the constraints for JLabel dateLabel
    g.anchor = GridBagConstraints.LINE_START;
    g.gridx = 0;
    g.gridy = 5;
    leftPanel.add(dateLabel, g);              //add JLabel to leftPanel through gridbagconstraints
    
    
    //Set up JTextField dates
    dates = new JTextField("", 10);           //set the textfield to default and set length as 10
    dates.setEditable( false );               //set the textfield uneditable
    //Set the constraints for JTextField dates
    g.gridx = 1;
    g.gridy = 5;
    leftPanel.add(dates, g);                  //add JTextField to leftPanel through gridbagconstraints
    
    //Set up the list selection listener
    cityList.addListSelectionListener(
      new ListSelectionListener()
      {
        @Override
        //every time the value selected in the JList the changed
        public void valueChanged(ListSelectionEvent event)
        {
          //set the destination city match the city name in file
          destination = redeemer.findDestination( cityList.getSelectedValue().toString() );
          
          //set the normalMiles textfield as destination miles
          normalMiles.setText( String.valueOf( destination.getRequiredMiles()) );
          
          //set the supersaver textfield as fly cheap miles
          supersaver.setText( String.valueOf( destination.getFrequentFlyerMiles() ) );
          
          //set the upgrade textfield as upgrade needed miels
          upgrade.setText( String.valueOf( destination.getUpgradeMiles() ) );
          
          //set the dates as range of begining month and ending month
          dates.setText ( getMonthNum( destination.getStartMonth() ) + "-" +
                         getMonthNum( destination.getEndMonth() ) );
             
        }
    
      }
    
    );
    
    
/*****************************         Right Panel            ***********************************/

    
    
    //Set up JLabel enterMiles
    enterMiles = new JLabel( "Enter Your Miles "); //name the label as Enter your miels
    //Set the constraints for JLabel enterMiles
    g.anchor = GridBagConstraints.LINE_START;
    g.weightx = 0.5;
    g.gridx = 0;
    g.gridy = 0;
    rightPanel.add(enterMiles, g);                 //add JLabel to rightPanel through gridbagconstraints
    
        
    //Set up JTextField milesText
    milesText = new JTextField("", 10);            //set the textfield to default and set length as 10
    //Set the constraints for JTextField milesText
    g.gridx = 1;
    g.gridy = 0;
    rightPanel.add(milesText, g);                  //add JTextField to rightPanel through gridbagconstraints
    
    
    //Set up JLabel enterMonth
    enterMonth = new JLabel( "Enter Month  ");     //name the label as enter month
     //Set the constraints for JLabel enterMonth
    g.anchor = GridBagConstraints.LINE_START;
    g.gridx = 0;
    g.gridy = 1;
    rightPanel.add(enterMonth, g);                 //add JLabel to rightPanel through gridbagconstraints
        
    
    //Set up the JSpinner monthSpinner
    monthArray = getMonthString();
    monthList = new SpinnerListModel( monthArray );// pass the list of month into string month
    monthSpinner = new JSpinner( monthList );          //set the Spinner use month strings
    //Set the constraints for JSpinner monthSpinner
    g.gridx = 1;
    g.gridy = 1;
    rightPanel.add(monthSpinner, g);               //add JSpinner to rightPanel through gridbagconstraints
    
    
    //Set up the JButton redeemButon
    redeemButton = new JButton( "Redeem Miles");   //Name the buttno as redeem miles
    //Set the constraints for JButton redeemButton
    g.anchor = GridBagConstraints.LINE_START;
    g.gridwidth = 2;
    g.gridx = 0;
    g.gridy = 2;
    rightPanel.add(redeemButton, g);              //add JButton to rightPanel through gridbagconstraints
    
    
    //Set up the JTextArea textArea
    textArea = new JTextArea( 100, 80 );          //set the size of the textArea
    //Set the constrains for JTextArea textArea
    g.fill = GridBagConstraints.BOTH;  
    g.anchor = GridBagConstraints.LINE_START;
    g.weighty = 10;
    g.gridwidth = 2;
    g.gridx = 0;
    g.gridy = 3;
    textArea.setEditable( false );                //set the text area uneditable
    rightPanel.add(textArea, g);                  //add JTextArea to rightPanel though gridbagconstraints
    
    
    //Set up JLabel remainingMiles
    remainingMiles = new JLabel( "Your Remaining Miles ");// Name the JLabel as Your remaining miles
    //Set the constraints for JLabel remainingArea
    g.anchor = GridBagConstraints.LINE_START;
    g.weighty = 0.5;
    g.gridwidth = 1;
    g.gridx = 0;
    g.gridy = 6;
    rightPanel.add(remainingMiles, g);           //add JLael to rightPanl through gridbagconstraints
    
    
    //Set up JTextField remainMiles
    remainMiles = new JTextField( "", 10);       //set the textfield to default and set length as 10
    g.weighty = 0.5;
    g.gridx = 1;
    g.gridy = 6;
    remainMiles.setEditable( false );            //set the textfield uneditable
    rightPanel.add(remainMiles, g);              //add JTextField t rightanel through gridbagconstraints

    //condition if the button clicked
    redeemButton.addActionListener(
      new ActionListener()
      {
        @Override
        public void actionPerformed(ActionEvent event)
        {  
          //Set the textArea to null everytime when button clicked
          textArea.setText("");
          
          //assign the entered number in milesText to text string
          String text = milesText.getText();
          
          //convert the text to integer miles
          int miles = Integer.parseInt( text );
          
          //assign the index of the month as month number
          int months = Arrays.asList(monthArray).indexOf( monthSpinner.getValue() ) + 1;
          
          //print out each flight message
          for( String message : redeemer.redeemMiles( miles, months ) )
          {
            textArea.append( message + "\n");
          }

          //Set the remaining miles to textField remainMiles
          remainMiles.setText( String.valueOf(redeemer.getRemainingMiles()) );
        }
      }                              
    );
    
     
  }
  
  /**************************************************************
  *                                                             *
  *   getMonthString get the month string into Spinner          *
  *                                                             *
  ***************************************************************/
  protected String[] getMonthString() 
  {
    String[] months = new java.text.DateFormatSymbols().getMonths();
  
    int lastIndex = months.length - 1;
    
    if (months[lastIndex] == null || months[lastIndex].length() <= 0)  
    { 
      String[] monthStrings = new String[lastIndex];
      System.arraycopy(months, 0, monthStrings, 0, lastIndex);
      return monthStrings;
    }
    else 
    { 
      return months;
    }
  }

  /**************************************************************
  *                                                             *
  *   getMonthNum get the month name assign with beginMonth     *
  *   and ending month                                          *
  *                                                             *
  ***************************************************************/  
  public String getMonthNum(int month)
  {
    String monthstring = "";
  
    if( month == 1)
      monthstring = "January";
    else if( month == 2)
      monthstring = "February";
     else if( month == 3 )
      monthstring = "March";
    else if( month == 4 )
     monthstring = "April"; 
    else if( month == 5)
      monthstring = "May";
    else if( month == 6 )
      monthstring = "June";
    else if( month == 7)
      monthstring = "July";
    else if( month == 8 )
      monthstring = "August";
    else if( month == 9 )
      monthstring = "September";
    else if( month == 10 )
      monthstring = "October";
    else if( month == 11 )
      monthstring = "November";
    else if( month == 12 )
      monthstring = "December";
    else
      monthstring = "Not Valid Month";
  
  
    return monthstring;
  }

}