package ece325.labs.lab4;

import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * This class represents a SongCollection. You are not allowed to change the
 * code that is in between the indications, but you are allowed to add code
 * before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
// not allowed to change anything after this (until the next marker which says you can add code again)
public class SongCollection {
	private TreeSet<Song> collection;

	public SongCollection() {
		collection = new TreeSet<Song>();
	}

	public void addSong(Song s) {
		collection.add(s);
	}

	public String toString() {
		String str = "[SongCollection: " + collection.size() + " songs: \n";
		for (Song s : collection) {
			str += "\t" + s + "\n";
		}
		return str + "]";
	}

	/**
	 * No need to change this method. You can just call it from your main method to
	 * demonstrate that your Song class can be used in a HashSet.
	 */
	private static void demonstrateHashSetUsage() {
		Song song1 = new Song("2023", new AverageRating(8.5f, 100));
		Song song2 = new Song("2023", new AverageRating(8.5f, 100));
		Song song3 = new Song("Bridges", new AverageRating(8.9f, 150));

		Set<Song> hashSet = new HashSet<Song>();

		hashSet.add(song1);
		hashSet.add(song2);
		hashSet.add(song3);
		System.out.println("\nHashSet:");
		System.out.println(hashSet);
	}

	// You are allowed to make changes or add code after this line
	/**
	 * Load the songs in the file directly into the collection. Your implementation
	 * must use a BufferedReader and a Scanner. The songs and their ratings are in
	 * the songratings.txt file (one song per line) in the following format:
	 * Title;rating;votes 
	 * Make sure that your program doesn't break when there are
	 * malformed inputs in the input file. For this assignment, it is OK to just
	 * silently ignore any malformed inputs – your program should not cause any
	 * unhandled exceptions.
	 * 
	 * @param filename
	 */
	public void loadSongs(String filename) {
		//read from file
		BufferedReader in = null;
		try {
			in = new BufferedReader( new FileReader(filename));
			String line;
			//as long as not at EOF keep reading
			while ((line = in.readLine()) != null){
				Song newSong = parseSong(line); //calls parseSong to format input into classes used by this program
				//if song was improperly formatted code will simply discard it
				if( newSong != null){
					if (this.collection.isEmpty()){
						this.addSong(newSong);
					}
					//tracks whether song should be added or if it is a duplicate
					boolean shouldAdd = true;
					//checks for duplicates
					for(Song s : this.collection){
						if(newSong.getTitle().equals(s.getTitle())){
							shouldAdd = false;
							if(newSong.getAverageRating().getVotes() > s.getAverageRating().getVotes()){
								s = newSong;
							}
						}
					}
					if(shouldAdd){
						this.addSong(newSong);
					}
				}
			}
		}
		//If the file cannot be read
		catch (IOException e){
			this.addSong(null);
		}
		//makes sure file was closed
		finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (IOException e){
				}
			}
		}
	}

	private static Song parseSong(String songString) {
		//Seperates line read at ; to process each element
		String[] songElements = songString.split(";");
		//set title
		String title = songElements[0];
		//set rating
		AverageRating rating = null;
		try {
			rating = new AverageRating(Float.parseFloat(songElements[1]), Integer.parseInt(songElements[2]));
		} catch (NumberFormatException e) {
			System.err.println("rating or votes were not valid numbers");
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("not enough information provided");
			return null;
		}
		Song song = new Song(title, rating);
		return song;
	}


	/**
	 * Returns a list of songs that is sorted by their average ratings.
	 * 
	 * @param comp
	 * @return
	 */

	public List<Song> sort() {
		List<Song> sortSong = new ArrayList<>();
		for(Song s: this.collection){
			sortSong.add(s);
		}
		Collections.sort(sortSong, new SongComparator());
		return sortSong;
	}

	public static void main(String[] args) {
		// Create SongCollection and load the songs
		SongCollection coll = new SongCollection();
		coll.loadSongs("ece325_lab_assignment4\\lab_assignment4\\songratings.txt");

		// Print the songs in the song collection
		System.out.println("Songs in collection:");
		System.out.println(coll);

		// Print the songs in the song collection ordered by average rating (from high
		// to low)
		System.out.println("Songs in collection ordered by average rating:");
		System.out.println(coll.sort());

		demonstrateHashSetUsage();

	}
}
