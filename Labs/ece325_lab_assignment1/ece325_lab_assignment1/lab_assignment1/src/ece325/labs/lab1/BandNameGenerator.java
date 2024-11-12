package ece325.labs.lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;
	
	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;
	
	String adjectivesFile;
	String nounsFile;
	
	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		/**
		 * Stores file addresses for list of nouns and adjectives in BandNameGenerator 
		 * object to make them easily accessible to methods like loadAdjectives
		 */
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;		
	}
	
	
	/**
	 * Load the adjectives file and initialize that part of the generator.
	 */
	public void loadAdjectives() {
		/**
		 * stores info from adjectives file in a more usable format (String[])
		 */
		adjectives = loadTxt(adjectivesFile);
	}
	
	/**
	 * Load the nouns file and initialize that part of the generator.
	 */
	public void loadNouns() {
		/**
		 * stores info from nouns file in a more usable format (String[])
		 */
		nouns = loadTxt(nounsFile);
	}
			
	/**
	 * Return a string that capitalizes the first letter of s and lowercases the rest. So for example,
	 * capitalizeFirst('cat') returns 'Cat', and capitalizeFirst('CHUBBY CAt') returns 'Chubby cat'. Read the assignment carefully and think about how 
	 * to implement this part of the code.
	 * 
	 * @param s
	 * @return
	 */
	public String capitalizeFirst(String s) {
		//Isolate first letter
		String first = s.substring(0,1);
		//Capitalize first and reappend the end of the word
		String newS = first.toUpperCase() + s.substring(1,s.length());

		return newS;
	}
	
	
	/** 
	 * Generate a name for your band consisting of two adjectives and one noun.
	 * Make sure to return "UNINITIALIZED" if the band name generator is not initialized correctly yet.
	 * @return the generated name or "UNINITIALIZED"
	 */
	public String generateName() {
		//count number of adjectives
		int numberOfAdjectives = 0;
		for(String s : adjectives){
			numberOfAdjectives++;
		}
		//count number of nouns
		int numberOfNouns = 0;
		for(String s : nouns){
			numberOfNouns++;
		}
		/**
		 * Use number of nouns and adjectives to generate random indices within the range of the string[] 
		 * of nouns and adjectives seperately
		 */
		int ind1 = (int)(Math.random()*numberOfAdjectives);
		int ind2 = (int)(Math.random()*numberOfAdjectives);
		int ind3 = (int)(Math.random()*numberOfNouns);

		//Find elements at indices generated and ensure they are capitalized
		String first = capitalizeFirst(adjectives[ind1]);
		String second = capitalizeFirst(adjectives[ind2]);
		String third = capitalizeFirst(nouns[ind3]);

		//Format output into adjective adjective noun
		String name = first + " " + second + " " + third;
		return name;
	}

	
	/**
	 * This method loads a text file into a String array. It assumes the number of 
	 * lines in the file is on the first line of the file itself.
	 * 
	 * Note: you are not allowed to make changes to this method. You can use this method for 
	 * loading text files in the other lab and course assignments as well.
	 * 
	 * @param file
	 * @return
	 */
	private String[] loadTxt(String file) {
		String[] data = new String[0];
		BufferedReader in = null;
		
		try { 
			in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			while((line = in.readLine()) != null)
			{
				data[i] = line;
				i++;
				
			}
		} catch (Exception e) {
			System.err.println("Problem while reading file: " + file);
			e.printStackTrace();			
		}
		finally {
			if(in != null) { 
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Problem closing file: " + file);
					e.printStackTrace();
				} 
			}
		}
		return data;
	}
	
	/**
	 * Returns the list of adjectives.
	 * @return
	 */
	public String[] getAdjectives() {
		return adjectives;
	}
	
	/**
	 * Returns the list of nouns.
	 * @return
	 */
	public String[] getNouns() {
		return nouns;
	}
	
	public static void main(String[] args) {
		// create a BandNameGenerator and initialize it
		/**The addresses currently present are the ones that will work if you run my code from the 
		 * directory Marin_1764942 if you run from a different location these addresses may not work. 
		 * In my screencast I used different addresses because my eclipse workspace was running the 
		 * code from a different starting directory.
		 */
		BandNameGenerator gen = new BandNameGenerator("adjectives.txt", "nouns.txt");
		//create String[]s of list of nouns and adjectives to use in the code
		gen.loadNouns();
		gen.loadAdjectives();
		// generate and print 20 names for your band
		for (int i = 0; i < 20; i ++){
			System.out.println(gen.generateName());
		}	
	}

}
