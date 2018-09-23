/**
 * 
 */
package com.eclipse.jeffreyavalos;

import javax.swing.JOptionPane;

/**
 * @author Jeffrey Avalos
 * This class demonstrates the video game class.
 */
public class VideoGameDemo {
	
	public static void main(String[] args) {
		//Day month year in constructor in this order.
		
		VideoGame prey = new VideoGame(59.99, 9.5,"Prey", "PS4",5,5,2017);
		JOptionPane.showMessageDialog(null, prey);
		VideoGame fallout = new VideoGame(9.99, 8.5,"Fallout New Vegas", "PS3", 19, 10,2010);
		JOptionPane.showMessageDialog(null, fallout);
	    VideoGame GOW = new VideoGame(59.99, 9.5,"God of War", "PS4", 15,12,2016 );
	    JOptionPane.showMessageDialog(null, GOW);
	    VideoGame myGame = new VideoGame();
	    JOptionPane.showMessageDialog(null, myGame);

	}

}
