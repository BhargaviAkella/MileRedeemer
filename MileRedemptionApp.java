
import javax.swing.JFrame;
public class MileRedemptionApp 
{
  public static void main(String[] args) {
    
    //new instance of MileRedemptionGUI
   try
    {
    	MileRedemptionGUI myApp = new MileRedemptionGUI();
    	myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //sets the size of the frame
    	myApp.setSize(715, 340);
    	//sets the visibility
	    myApp.setVisible(true);
    	
    }
    catch (Exception e) 
	{
		e.printStackTrace();
	}
    

  }
}