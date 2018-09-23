package com.eclipse.jeffreyavalos;

import java.time.LocalDate;
import java.time.Period;
import java.util.Formatter;

import javax.swing.JOptionPane;

/**
 * @author Jeffrey Avalos 
 *  This class is encapsulates all the data inside a video game object.
 *  This class demonstrates correct object field manipulation. Trade in values are 
 *  the significant data being calculated from video game objects.
 */
public class VideoGame {

	private String gameTitle = ""; // Video game title.
	private double gamePrice; // Video game price.
	private double gameRating; //Video game rating, 0.0 - 10.0.
	private LocalDate releaseDate;//release day of the video game object.
	private String platform; //platform of game
	private static double sum = 0.0;
	/** This method returns the platform of the video game.
	 * @return platform The string value of the platform of the game
	 */
	
	public VideoGame(String title, double price, int doubleRating, String plat )
	{
		platform = plat;
		gameTitle = title;
		gamePrice = price;
		gameRating = doubleRating;
		int day = Integer.parseInt(JOptionPane.showInputDialog("Enter the day of release."));
		int month = Integer.parseInt(JOptionPane.showInputDialog("Enter the month of release."));
		int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year of release."));
		this.setReleaseDate(year, month, day);
		sum += this.calcTradeIn();
	}
	/** This constructor instantiates the video game object with the gamePrice, gameRating, gameTitle
	 *  and the release date of the game. This is for the hard coded object.
	 * @param price Game price.
	 * @param doubleRating Game rating.
	 */
	public VideoGame(double price,double rating ,String title, String plat, int day, int month, int year)
	{
		gameTitle = title;
		platform = plat;
		gamePrice = price;
		gameRating = rating;
		this.setReleaseDate(year, month, day);
		sum += this.calcTradeIn();
	}
	/** This is our default constructor in which no fields were hard coded so the user must be prompted
	 * for each field.
	 */
	public VideoGame()
	{
		double price, rating;
		String title, platformT;
		title = JOptionPane.showInputDialog("Enter the title of the video game.");
		platformT = JOptionPane.showInputDialog("Enter the platform of the video game.");
		price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the video game."));
		rating = Double.parseDouble(JOptionPane.showInputDialog("Enter the rating of the video game."));
		int day = Integer.parseInt(JOptionPane.showInputDialog("Enter the day of release."));
		int month = Integer.parseInt(JOptionPane.showInputDialog("Enter the month of release."));
		int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year of release."));
		this.setPlatform(platformT);
		this.setGameTitle(title);
		this.setReleaseDate(year, month, day);
		this.setGamePrice(price);
		this.setGameRating(rating);
		sum += this.calcTradeIn();
	}
	/** This method returns a string platform
	 * @return platform The string value of the platform
	 */
	public String getPlatform() {
		return platform;
	}
	/** This method sets the platform.
	 * @param platform The value being passed into the platform
	 */
	public void setPlatform(String platform) {
		try
		{
			this.platform = platform;
		}
		catch(Exception e)
		{
			System.out.println("Invalid String for the platform!");
		}
		
	}
	/** This method returns the release date of the video game.
	 * @return releaseDate Returns the date in which the video game was released.
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	/** This method sets the release day for a video game.
	 * This method throws the illegalArgumentException if a invalid date is passed.
	 * @param release The release day of the video game
	 */
	public void setReleaseDate(int yearR, int monthR, int dayR) 
	{
		if(yearR <=0 || monthR<=0 || dayR <= 0)
		{
			throw new IllegalArgumentException("Invalid Date!");
		}
		if(monthR>12 || dayR>31)
		{
			throw new IllegalArgumentException("Invalid Date!");
		}
		this.releaseDate =LocalDate.of(yearR, monthR, dayR);
	}
	/** This method returns the private field gameTitle.
	 * @return gameTitle The string title of the video game.
	 */
	public String getGameTitle() {
		return gameTitle;
	}
	/** This method sets the video game titles for a video game object.
	 * This method throws an exception if a string is not passed into the title.
	 * @param gameTitle The string being passed into the private title field.
	 */
	public void setGameTitle(String gameTitle) {
		try
		{
			this.gameTitle = gameTitle;
		}
		catch(Exception e)
		{
			System.out.println("Invalid String for the title!");
		}
	}
	/** This method returns the private field gamePrice .
	 * @return gamePrice The double storing the double price of the video game object. 
	 */
	public double getGamePrice() {
		
		return gamePrice;
	}
	/** This method sets the game price for a video game object.
	 * @param gamePrice The double value being passed into the private gamePrice field.
	 */
	public void setGamePrice(double gamePrice) {
		Formatter fmt = new Formatter();

	    fmt.format("%.2f", gamePrice);
		if(gamePrice <= 0.0)
		{
			throw new IllegalArgumentException("Invalid price negative number!");
		}
		this.gamePrice = gamePrice;
	}
	/** This method returns the private field gameRating which is from 0.0 -10.0.
	 * @return gameRating The double rating of the video game 10.0 being the highest and 0.0 lowest.
	 */
	public double getGameRating() {
		return gameRating;
	}
	/** This method sets the private double field gameRating to a new value of the video game object 
	 * @param gameRating The double value game rating of the video game object being set to the private field.
	 */
	public void setGameRating(double gameRating) {
		if(gameRating<0.0 || gameRating>10.0)
		{
			throw new IllegalArgumentException("Invalid Rating, Rating must be between 0.0-10.0!");
		}
		this.gameRating = gameRating;
	}
	/** This method calculates the trade in of the video game object.
     @return tradePrice The new price for the trade in of the video game today.
	 */
	public double calcTradeIn()
	{
		// 10% Depreciation is at a rate of 10/60 per day roughly 0.1666 repeating a day
		double tradePrice= 0; //trade in Price
		final double depreciation = 0.10; 
		LocalDate tradeDay = LocalDate.now(); // day of trade in
		Period gap = Period.between(tradeDay, this.getReleaseDate());// time between release and now
		int numsixtyDays  = gap.getDays()/60;
	
		tradePrice = this.getGamePrice() - (numsixtyDays * depreciation);
		if(this.getGameRating()>= 8.5 && this.getGamePrice()<tradePrice)
		{
		     tradePrice += 5;
		     
		}
	return tradePrice;
		
	}
	/** This static method does not belong to an instance of the class but just remains the same value 
	 * This method returns the sum of the trade ins.
	 * @return total the sum of the values of trade ins.
	 */
	public static double totalTradeIns()
	{
		 double total = 0.0;
		 total = total + sum;
		return total;
	}
	/**
	 * This method returns a string of all the objects fields in the correct format.
	 * @return str The string value of the object's fields.
	*/
	public String toString() {
		
		String str =  "Title: "+ this.getGameTitle() +"\n Platform: "+this.getPlatform()
				+"\n Release Date: "+ this.getReleaseDate()+ "\n Rating: "+ this.getGameRating()
				+"\n Price: "+ this.getGamePrice()+
				"\n Trade in Price: "+this.calcTradeIn() +"\n Total of trade ins so far: "+VideoGame.sum;
		return str;
	}
	
}	
