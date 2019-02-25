



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MileRedeemer {
	
	/*private  instance variable to hold the destination list*/
	private ArrayList<Destination> destList;
	/*integer to represent the remaining miles after the user's Frequent Flyer Miles have been redeemed*/
	int remMiles;
	/*
	 * This method uses the Scanner object to read and parse the destination data into an array of Destination objects.
	 *  Before ending, the method should sort the array of Destination objects in descending order by normal mileage 
	 * */
	public void readDestinations(Scanner fileScanner)
	{
		String str;
		destList = new ArrayList<Destination>();
		while(fileScanner.hasNext())
		{
			str = fileScanner.nextLine();
			String[] line = str.split(";");
			Destination dest = new Destination(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4].split("-")[0]), Integer.parseInt(line[4].split("-")[1]));
			destList.add(dest);
		}
		fileScanner.close();
		
	}
	
	
	/*
	 * As the input text file may be out of order based on normal miles, 
	 * the readDestinations( ) method will need to sort them in descending normal
	 *  miles order before any redemptions can be done.
	 * */
	public class MileageComparator implements Comparator<Destination> 
	{
	   public int compare(Destination d1, Destination d2) 
	   {
	      return (d2.getRequiredMiles() - d1.getRequiredMiles());
	   }
	}
	
	/*
	 * This method should loop through the array of Destination objects and create an array of String objects from the city names. 
	 *  This array can be sorted in ascending order and returned 
	 * just for the display of all possible destinations.
	 * */
	public String[] getCityNames()
	{
		String [] cityNames = new String[destList.size()]; //value that will be returned
	    for(int i = 0; i < destList.size(); i++)
	    {
	      cityNames[i] = destList.get(i).getCityName();
	    }
	    Arrays.sort(cityNames); //sorts the cityNames array in ascending order
	    return cityNames;
	}
	/*
	 * In this method, miles is the total available miles, and month is the desired month of departure. 
	 * This method returns an array of String objects containing descriptions of redeemed tickets that will be printed out 
	 * by the main program. It should also save the miles remaining after the tickets have been redeemed.
	 * */
	
	public String[] redeemMiles(int miles, int month)
	{
		Collections.sort(destList, new MileageComparator());
		ArrayList<String> redeemMiles = new ArrayList<String>();
		ArrayList<Destination> destFlights= new ArrayList<Destination>();
		
		for(Destination destination : destList){
			/*The condition checks whether the startmonth and end month is greater than the given month of departure
			 * and prints the  destination name and the flight class of clients who are  in Economy class*/
			if(destination.getStartMonth() <= month && destination.getEndMonth() >= month)
			{
				if(miles-destination.getFrequentFlyerMiles() >= 0)
				{
					String flightClass = "Economy Class";
					miles -= destination.getFrequentFlyerMiles();
					destFlights.add(destination);
					String redeem = "A trip to "+destination.getCityName()+" city "+" in "+ flightClass;
					redeemMiles.add(redeem);
				}
				
			}
			else
			{
				/*this condition checks whether the difference between the flyer miles and the required miles
				 * is greater than zero .If yes then it enters the loop and 
				 * 	prints the destination  city name and flight class */
				if(miles - destination.getRequiredMiles() >= 0)
				{
					String flightClass = "Economy Class";
					miles -= destination.getRequiredMiles();
					String redeem = "A trip to "+destination.getCityName()+" city "+" in "+ flightClass;
					//System.out.println(redeem);
					redeemMiles.add(redeem);
					destFlights.add(destination);
				}
			}
		}
		int i = 0; 
		for(Destination destination : destFlights)
		{
			String flightClass = "First Class";
			/*If condition checks whether the difference between flyer miles and upgraded miles
			 *  are greater than zero.If yes it prints the destination city name 
			 *  and the flight class of the clients who are in first class*/
			if(miles - destination.getUpgradeMiles() >= 0)
			{
				miles -= destination.getUpgradeMiles();
				redeemMiles.set(i, "A trip to "+destination.getCityName()+" city "+" in "+ flightClass);
			}
			i++;
		}
		remMiles = miles;
		return (String[])(redeemMiles.toArray(new String[redeemMiles.size()]));
	}
	/*This method will return the saved remaining miles.*/
	public int getRemainingMiles()
	{
		return remMiles;
	}

	/**
	 * tthis method returns the destination object for the given city name
	 * 
	 * ***/
	public Destination findDestination(String cityName)
	{
		Destination dobject = null;
		for(Destination d1 : destList)
		{
			if(d1.getCityName()== cityName)
			{
				dobject= d1;
			break;
		}
		
		}
		return dobject;
	}
	
	
	
	
}
