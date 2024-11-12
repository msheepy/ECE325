package ece325.labs.lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/** 
 * Finish this class.
 */
public class SongLoader {
	/**
	 * Load a SongCollection from a file. Uses one or more Scanners to read the
	 * file, create Song objects and insert them into a SongCollection.
	 * 
	 * 
	 * The input is of the format: Songtitle; Instruments; Rating 
	 * Contribution;Guitar,Guitar,Drums;4.5
	 * 
	 * (see songratings.txt for the full input)
	 * 
	 * @param file
	 * @return the loaded SongCollection
	 */
	public static SongCollection loadSongs(String file) {
		//read from file
		BufferedReader in = null;
		SongCollection collection = new SongCollection();
		try {
			in = new BufferedReader( new FileReader(file));
			String line;
			//as long as not at EOF keep reading
			while ((line = in.readLine()) != null){
				Song newSong = parseSong(line); //calls parseSOng to format input into classes used by this program
				collection.add(newSong); //adds the newly formatted song to the collection
			}
		}
		//If the file cannot be read
		catch (IOException e){
			System.out.println("I dont think that file exists, or I did something very wrong, probably the latter");
		}
		//makes sure file was closed
		finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (IOException e){
					System.out.println("Idk even know how it went this wrong");
				}
			}
			return collection;
		}
	}

	/**
	 * Parse a Song object from the String and return it. If the String cannot be
	 * parsed into a Song, throw an InvalidSongFormatException.
	 * 
	 * @param songString
	 * @return
	 * @throws InvalidSongFormatException
	 */
	public static Song parseSong(String songString) throws InvalidSongFormatException {
		
		//Lots of error checks

		//Seperates line read at ; to process each element
		String[] songElements = songString.split(";");
		try{
			//set title
			String title = songElements[0];
			//set instruments
			ArrayList<String> instruments = parseInstrumentsList(songElements[1]);
			//set rating
			if (instruments == null){
				throw new InvalidSongFormatException("Invalid Instruments");
			}
			AverageRating rating = new AverageRating(Float.parseFloat(songElements[2]));
			//check rating number in acceptable range
			//this is redundant, my code checks for this later on, but better safe than sorry
			if(rating.getAvgRating() < 0 || rating.getAvgRating() > 10){
				throw new InvalidSongFormatException("Rating is not a valid number");
			}
			//if no errors create a song
			Song song = new Song(title, instruments, rating);
			return song;

		}
		//check rating is actually a number
		catch (NumberFormatException e) {
			throw new InvalidSongFormatException("Rating provided is not a number");
		}
		catch (NullPointerException e) {
			throw new InvalidSongFormatException("Song input was not in appropriate format");
		}
		catch (InvalidSongFormatException e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Uses a scanner to parse the instruments string into an ArrayList of String
	 * objects. You can assume that the string comes in CSV (comma-separated-value)
	 * format, and that it is valid CSV (so no need to do error checking or account
	 * for issues with the data).
	 * 
	 * @param instruments
	 * @return an ArrayList with one String per parsed instrument
	 */
	public static ArrayList<String> parseInstrumentsList(String instruments) {
		//Instantiate ArrayList to save final list of isntruments too
		ArrayList<String> instrumentList = new ArrayList<>();
		//split line passed as instruments at , to get each individual instrument
		String[] arr = instruments.split(",");
		if(arr == null){
			return null;
		}
        instrumentList.addAll(Arrays.asList(arr)); //add each instrument to the list
		return instrumentList;

	}

	public static void main(String[] args) {
		//the filepath used in the instructions
		String file = "songratings.txt";
		//the filepath that I need to use in my IDE
		String file2 = "ece325_lab_assignment3\\lab_assignment3\\songratings.txt";
		System.out.println(SongLoader.loadSongs(file2));
	}
}
