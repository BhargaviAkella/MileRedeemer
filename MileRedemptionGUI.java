import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MileRedemptionGUI extends JFrame
{
	//creating static private variable for Destination 
	private static Destination dest = null;
	private static MileRedeemer mRedeemer = new MileRedeemer(); //creating a private static Mile Redeemer variable 
	
	private  JList<String> cityName; //holds the list of city names
	private  JTextField reqMiles; // TextField for Required Miles
	private  JTextField freqMiles; // TextField for frequent fly Miles
	private  JTextField upgradeMiles; // TextField for upgraded Miles
	private  JTextField dateInfo; // TextField for dates 
	private  JLabel nrmlMile;    //Label for  required miles
	private  JLabel supersaverLabel; //Label for frequent fly miles
	private  JLabel upgradeLabel; //Label for upgraded miles
	private  JLabel dateLabel; // Label for SuperSaver Dates info
	
	private  JLabel enterMiles; // Label for Entering the miles
	private  JLabel enterMonth; //Label for Entering the month
	private  JLabel remainingMiles; //Label for  remaining miles
	private  JTextField enteringMiles; // TextField for entering the miles
	private  JTextField remainMiles; // TextField for showing the remaining miles
	private  JSpinner monthSpinner; // JSpinner for Selecting the month
	private  SpinnerListModel monthList; // SpinnerListModel for setting the month
	private  JButton redeemButton; // Button to redeem the miles
	private  JTextArea FlightInfo; //TextArea for showing the Flight Information
	private  String[] month; // Array of type String for holding the month names
	
	public MileRedemptionGUI() throws IOException
	{
		
		super("MILE REDEMPTION APP"); // Name of the frame
		
		setLayout(new GridLayout(0,2)); // sets the layout to the frame with 0 rows and 2 columns
		
		// this dialog box asks the user to enter the file name
		String filename = JOptionPane.showInputDialog("Enter the File Name");
		//This scans the file name
		Scanner s = new Scanner(new File( filename ));
		
		// executes if the  filename is null 
		if(filename == null )
		{
			System.exit(0);
		}
		
		//reads or processes the file 
		mRedeemer.readDestinations(s);		
		
		/******************************************
		 * creating the Left Panel				  *
		 ******************************************/
		JPanel leftPanel = new JPanel( new GridBagLayout() ); // creating the left Panel and setting a layout to the panel
		leftPanel.setBackground(new Color(100,150,100)); // this is used to set the background color
		TitledBorder LTitle; // this is used to set the Title 
        Border blackline = BorderFactory.createLineBorder(Color.black); //this is used to create a specific color for line border
		LTitle = BorderFactory.createTitledBorder(blackline,"Destinations"); // this is used to set the title
		LTitle.setTitleJustification(TitledBorder.CENTER);// this is used to center the border
		leftPanel.setBorder(LTitle); //this sets the border to the panel 
		add(leftPanel); //adds the left panel to the frame
		
		// the GridBagConstraints is used to set the constraints  for the components in the layout
		GridBagConstraints gbc = new GridBagConstraints(); 
		GridBagConstraints gc = new GridBagConstraints();
		
		
		String[] cities = mRedeemer.getCityNames(); // it gets the city names into the array
		cityName= new JList<String>(cities); // this is used to add the city names into the list
		cityName.setVisibleRowCount(10); // this is used to set the rows of the list without using scrolling
		gc.fill = GridBagConstraints.BOTH;  // this is used to display the area both horizontally and vertically      
		//constraints for the list
		gc.gridwidth = 2; //specifies the number of cells in a row
		gc.weighty = 10; // specifies the extra vertical distributed space
	    gc.weightx = 30; // specifies the extra horizontal distributed space
	    gc.gridx = 0;//specify the column at the upper left 
	    gc.gridy = 0;//specify the  row at the upper left
	    leftPanel.add(cityName, gc); // adds the list to the panel
	    
	    nrmlMile = new JLabel("Normal Miles"); // Specifying the name of the label
	    //constraints for the label
	    gbc.anchor = GridBagConstraints.LINE_START; //Used when the component is smaller than its display area to determine where to place the component
	    gbc.gridx=0;
	    gbc.gridy=2;
	    leftPanel.add(nrmlMile,gbc);// adds the label  to the left panel
	    
	    
	    reqMiles = new JTextField("",10); // Specifying the column length of the TextField
	    reqMiles.setEditable(false);// This specifies that the textfield cannot be edited
	    //constraints for the textfield
	    gbc.fill = GridBagConstraints.HORIZONTAL; // this is used to display the area horizontally   
	    gbc.gridx=1;
	    gbc.gridy=2;
	    leftPanel.add(reqMiles,gbc); // adds the  Textfield to the left panel
    
	    supersaverLabel= new JLabel("Supersaver Miles"); // Specifying the name of the label
		//constraints for the Label
	    gbc.gridx=0;
	    gbc.gridy=3;
	    leftPanel.add(supersaverLabel,gbc); // adds the label to the left panel
	    
	    freqMiles = new JTextField("",10); // Specifying the column length of the TextField
	    freqMiles.setEditable(false);// This specifies that the textfield cannot be edited
		//constraints for the TextField
	    gbc.fill = GridBagConstraints.HORIZONTAL;    // this is used to display the area horizontally    
	    gbc.gridx=1;
	    gbc.gridy=3;
	    leftPanel.add(freqMiles,gbc); //adds the  Textfield to the left panel
	    
	    upgradeLabel = new JLabel("Upgrade Cost"); // Specifying the name of the label
		//constraints for the Label
	    gbc.gridx=0;
	    gbc.gridy=4;
	    leftPanel.add(upgradeLabel,gbc); // adds the  to the left panel
	    
	    upgradeMiles = new JTextField("",10); // Specifying the column length of the TextField
	    upgradeMiles.setEditable(false);// This specifies that the textfield cannot be edited
		//constraints for the TextField
	    gbc.fill = GridBagConstraints.HORIZONTAL;   // this is used to display the area horizontally     
	    gbc.gridx=1;
	    gbc.gridy=4;
	    leftPanel.add(upgradeMiles,gbc); // adds the  Textfield to the left panel
	    
	    
	    dateLabel = new JLabel("Supersaver Dates"); // Specifying the name of the label
	    gbc.gridx=0;
	    gbc.gridy=5;
	    leftPanel.add(dateLabel,gbc); // adds the label to the left panel
	    
	    dateInfo = new JTextField("",10);  // Specifying the column length of the TextField
	    dateInfo.setEditable(false);// This specifies that the textfield cannot be edited
		//constraints for the TextField
	    gbc.fill = GridBagConstraints.HORIZONTAL;    // this is used to display the area horizontally      
	    gbc.gridx=1;
	    gbc.gridy=5;
	    leftPanel.add(dateInfo,gbc); // adds the  Textfield to the left panel
	    
	    /********
	     * Creating the right Panel
	     * **********/

	 	JPanel rightPanel = new JPanel( new GridBagLayout() );  // creating the left Panel and setting a layout to the panel
		rightPanel.setBackground(new Color(100,100,150));// this is used to set the background color
		TitledBorder RTitle ; // this is used to set the Title 
        Border black = BorderFactory.createLineBorder(Color.black); //this is used to create a specific color for line border
		RTitle = BorderFactory.createTitledBorder(black,"Redeem Miles");// this is used to set the title
		RTitle.setTitleJustification(TitledBorder.CENTER);// this is used to center the border
		rightPanel.setBorder(RTitle);//this sets the border to the panel 
		add(rightPanel);//adds the right panel to the frame

		
		 enterMiles = new JLabel("Enter your Miles"); // Specifying the name of the label
		 //constraints for the Label
		 gbc.weightx = 0.5;
		 gbc.gridx=0;
		 gbc.gridy=0;
		 rightPanel.add(enterMiles,gbc);//adds the label to right panel
		 
		 enteringMiles = new JTextField("",10); // Specifying the column length of the TextField
		 //constraints for the TextField
		 gbc.gridx = 1;
		 gbc.gridy = 0;
		 rightPanel.add(enteringMiles,gbc);//adds the textfield to right panel
		 
		 enterMonth = new JLabel("Select the month of Departure "); // Specifying the name of the month label
		 //constraints for the Label
		 gbc.gridx=0;
		 gbc.gridy=1;
		 rightPanel.add(enterMonth,gbc);//adds the label to right panel
		 
		 month = getMonthStrings(); //calls the method which returns the string and store it in the array
		 monthList = new SpinnerListModel(month); // passes the month array into monthlist
		 monthSpinner = new JSpinner(monthList);  //setting  the Spinner to use month strings in the list
		 //constraints for the spinner
		 gbc.gridx=1;
		 gbc.gridy=1;
		 rightPanel.add(monthSpinner,gbc);//adds the Spinner to the right panel
		 
		 redeemButton = new JButton("Redeem Miles"); //specifying the name of the button 
		 //constraints for the button
		 gbc.gridwidth = 2;
		 gbc.gridx=0;
		 gbc.gridy=2;
		 rightPanel.add(redeemButton,gbc);//adds the button to the right panel
		 
		 
		 FlightInfo = new JTextArea(100,100); // this specifies the textArea with rows and columns
		 //constraints for the TextArea
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.anchor = GridBagConstraints.LINE_START;
		 gbc.weighty = 10;
		 gbc.gridwidth = 2;
		 gbc.gridx = 0;
		 gbc.gridy = 3;
		 FlightInfo.setEditable(false);// This specifies that the textfield cannot be edited
		 rightPanel.add(FlightInfo,gbc);//adds the right panel
		 
		 remainingMiles = new JLabel("Your Remaining Miles"); // Specifying the name of the label
		 //constraints for the Label
		 gbc.anchor = GridBagConstraints.LINE_START;
		 gbc.weighty = 1;
		 gbc.gridwidth = 1;
		 gbc.gridx = 0;
		 gbc.gridy = 6;
		 rightPanel.add(remainingMiles,gbc); //adds the label to the right panel
		 
		 remainMiles = new JTextField("",10); // Specifying the column length of the TextField
		 //constraints for the TextField
		 gbc.gridx=1;
		 gbc.gridy=6;
		 remainMiles.setEditable(false);// This specifies that the textfield cannot be edited
		 rightPanel.add(remainMiles,gbc);//adds the textfield to right panel
		 
		 /*************************************************
		  * This method is executed when the button is clicked
		  * 
		  * *****************************************************/
		 redeemButton.addActionListener(new ActionListener()
			      {
			        @Override
			        public void actionPerformed(ActionEvent event)
			        	{ 
			        	 //sets the text to nothing
			        	 FlightInfo.setText("");
			        	 //this holds the miles entered in the textfield
			        	 String text = enteringMiles.getText();
			        	 //this converts the string to integer 
			             int miles = Integer.parseInt( text );
			             //gets the name of the month from the Spinner
			             String spinString = (String) monthSpinner.getValue();
			             int index = -1;
			             //finding the index of the month
			             for (int i = 0; i < month.length && index == -1; i++) 
			             {
			               if (month[i] == spinString)
			                 index = i;
			             }
			             //this stores the destination for the miles and index in the array 
			             String [] destination = mRedeemer.redeemMiles( miles, index+1);
			             
			             //Checks if the array length is not equal to zero
			             if(destination.length!=0)
			             	{
			            	 for( String message : destination)
			            	 {
			            		 //prints each message 
			            		 FlightInfo.append( message + "\n");
			            	 }
			             	}
			             else
			             {
			            	 //prints this text when the array length is equal to zero
			        	  FlightInfo.setText("Your client has not accumulated enough Frequent Flyer Miles");
			             }
			             //This prints the remaining miles from the entered miles in the text field
			             remainMiles.setText( String.valueOf(mRedeemer.getRemainingMiles()) );
			        	}
			      	}                              
			    );		
	   
		// This method is execured when the list of cities are selected
		cityName.addListSelectionListener(new ListSelectionListener()
				{
			@Override
			public void valueChanged(ListSelectionEvent event) 
				{
					
					//sets the destination name as the city name from the list
					dest = mRedeemer.findDestination(cityName.getSelectedValue().toString());
					//this sets the required miles textfield with  the required miles
				    reqMiles.setText(String.valueOf(dest.getRequiredMiles()));
					//this sets the  Supersaver miles textfield with  the frequentflyer miles
				    freqMiles.setText(String.valueOf(dest.getFrequentFlyerMiles()));
					//this sets the Upgrade cost miles textfield with  the upgraded miles
				    upgradeMiles.setText(String.valueOf(dest.getUpgradeMiles()));
					//this sets the Supersaver date textfield with  the start Month and end month 
				    dateInfo.setText(getMonthName(dest.getStartMonth())+ "-"+ getMonthName(dest.getEndMonth()));
				}
				
			}
	);
	
	
	}	
	/**********************************************
	 * This method returns spinner's month Strings 
	 * 
	 * *************************************************/
		 protected String[] getMonthStrings() 
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
		 /**************
		  * this method returns the monthname 
		  * ***********************/
		 private String getMonthName(int Month)
			{
				int choice = Month;
				String monthname ="";
				
				
				switch(choice)
				{
				case 1 : monthname =  "January";
				 		break;
				case 2 : monthname =  "February";
				 		break;
				case 3 : monthname =  "March";
				 		break;
				case 4 : monthname =  "April";
				 		break;
				case 5 : monthname =  "May";
						break;
				case 6 : monthname =  "June";
						break;
				case 7 : monthname =  "July";
						break;
				case 8 : monthname =  "August";
				 		break;
				case 9 : monthname =  "September";
				 		break;
				case 10 : monthname =  "October";
				 		break;
				case 11 : monthname =  "November";
						break;
				case 12 : monthname =  "December";
						break;
				 default : monthname =  "Not a valid month";
				}
				return monthname;
			} 
	
	}
	
	
	
	
	
	

	


	

	
	

	
	


