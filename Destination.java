public class Destination {
	/*
	 * Private instance variables
	 * */
	private String cityName;
	private int requiredMiles;
	private int frequentFlyerMiles;
	private int upgradeMiles;
	private int startMonth;
	private int endMonth;
	/*
	 * this method returns the city names * 
	 * */
	public String getCityName() 
	{
		return cityName;
	}
	/*This method sets the city name */
	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}
	
	/*this method is used to return the required miles*/
	public int getRequiredMiles()
	{
		return requiredMiles;
	}
	/*This method sets the crequired miles */

	public void setRequiredMiles(int requiredMiles) 
	{
		this.requiredMiles = requiredMiles;
	}
	/*this is used to return the frequent flyer miles */
	public int getFrequentFlyerMiles() 
	{
		return frequentFlyerMiles;
	}
	/*
	 * this is used to set the frequent flyer miles
	 * */
	public void setFrequentFlyerMiles(int frequentFlyerMiles)
	{
		this.frequentFlyerMiles = frequentFlyerMiles;
	}
	/*This method is used for returning the upgraded miles */

	public int getUpgradeMiles()
	{
		return upgradeMiles;
	}
	/*This method is used for setting the upgraded miles */

	public void setUpgradeMiles(int upgradeMiles) 
	{
		this.upgradeMiles = upgradeMiles;
	}
	/*This method returns the start month*/

	public int getStartMonth() 
	{
		return startMonth;
	}
	/*This method sets the start month*/

	public void setStartMonth(int startMonth)
	{
		this.startMonth = startMonth;
	}
	public int getEndMonth() 
	{
		return endMonth;
	}
	/*This method is used to set the end month */

	public void setEndMonth(int endMonth) 
	{
		this.endMonth = endMonth;
	}
	/*
	 * Public Constructor used to initialize the values
	 * */
	public Destination(String cityName, int requiredMiles, int frequentFlyerMiles, int upgradeMiles, int startMonth,
			int endMonth)
	{
		super();
		this.cityName = cityName;
		this.requiredMiles = requiredMiles;
		this.frequentFlyerMiles = frequentFlyerMiles;
		this.upgradeMiles = upgradeMiles;
		this.startMonth = startMonth;
		this.endMonth = endMonth;
	}
	
	
}
