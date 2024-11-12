package ece325.labs.lab3;

import java.util.ArrayList;

/** 
 * Finish this class.
 */
public class SongCollection {
	private ArrayList<Song> songs; //stores all songs read from the file

	public SongCollection() {
	}

	/**
	 * Add the song if it is not in the list yet, otherwise update the average
	 * rating of the song.
	 * 
	 * @param s
	 */
	public void add(Song s) {
		//check if empty
		if(s == null){
		}
		else if (songs == null){
			songs = new ArrayList<>();
			songs.add(s);
		}
		//once not empty checks is the song can be added
		else {
			Boolean match = false;
			for(Object songO : songs){
				//Invalid input is processed as an object that is null
				//we set match to be true so the code ignores this input and doesnt add it to collection
				if(songO == null){
					match = true;
				}
				//If the input isn't invalid it will be of type song so we typecast from object to song
				else{
					Song song = (Song) songO;
					//If the song is already in the collection update rating
					if (song.equals(s)){
						match = true;
						song.addRating(s.getRating().getAvgRating());
					}
				}
				//If song doesn't match current song keep comparing against the rest of the songs
			}
			// If song didn't match any of the songs in list then add it to the list
			if(!match){
				songs.add(s);
			}
		}
	}

	public void remove(Song s) {
		//check is song you wish to remove is actually in list
		if(songs.contains(s)){
			//leverage ArrayList methods to make my life easier
			songs.remove(s);
		}
		else{
			System.out.println("element not in list");
		}
	}

	public boolean contains(Song s) {
		//leverage ArrayList methods to make my life easier
		return songs.contains(s);
	}

	//returns song at specified index
	public Song getSong(int index) {
		return songs.get(index);
	}

	//returns number of songs in this collection
	public int getNumberOfSongs() {
		return songs.size();
	}

	//returns all the songs in the collection
	public ArrayList<Song> getSongs() {
		return songs;
	}

	//makes it easy to print the collection
	@Override
	public String toString() {
		if(songs == null){
			return "No valid song input was read";
		}
		String toRet = "[SongCollection: ";
		for (Song s : songs)
			toRet += "\n\t" + s + "; ";
		return toRet + "\n]";
	}
}
