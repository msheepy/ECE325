package ece325.labs.lab3;

import java.util.ArrayList;
import java.util.Collections;

/** 
 * Finish this class.
 */
public class Song {
	private String title; //title of song
	private ArrayList<String> instruments; //list of instruments used to perform this song
	private AverageRating averageRating; //rating this performance received
	
	public Song(String title, ArrayList<String> instruments, AverageRating rating) {
		//instantiate variables
		this.title = title;
		this.instruments = instruments;
		this.averageRating = rating;
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	public boolean equals(Object o) {
		//Makes sure o is actually of appropriate class to compare
		if(o==null){
			return false;
		}
		if (o instanceof Song){
			Song songO = (Song) o;
			//stop if titles dont match
			if(!title.equals(songO.getTitle())){
				return false;
			}
			//if titles match check if instruments match
			else{
				return doInstrumentsMatch(songO);
			}
		}
		else{
			return false;
		}

	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	public boolean equals(Song s) {
		//end immediately if titles dont match
		if(!title.equals(s.getTitle())){
			return false;
		}
		//if titles match check if instruments match
		else{
			return doInstrumentsMatch(s);
		}
	}
	
	public ArrayList<String> getInstruments(){
		return instruments;
	}
	
	public void addRating(float rating) {
		averageRating.addRating(rating);
	}
	
	public AverageRating getRating() {
		return averageRating;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return "[Song: " + title + ", instruments: " + instruments + ", avg. rating: " + averageRating + "]"; 
	}

	public boolean doInstrumentsMatch(Song songO){
		//move instrument data from songO to a more convenient variable
		ArrayList<String> oInstruments = songO.getInstruments();
		//Sort so equals works even if array were initially in different orders
		Collections.sort(instruments);
		Collections.sort(oInstruments);
		//check if lists are the same and return true if they are
		return instruments.equals(oInstruments);
	}
}
