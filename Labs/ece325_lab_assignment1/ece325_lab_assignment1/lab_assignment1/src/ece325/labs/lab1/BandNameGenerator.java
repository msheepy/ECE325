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
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;		
	}
	
	
	/**
	 * Load the adjectives file and initialize that part of the generator.
	 */
	public void loadAdjectives() {
		adjectives = loadTxt(adjectivesFile); //Use load txt porvided to load list of adjectives
	}
	
	/**
	 * Load the nouns file and initialize that part of the generator.
	 */
	public void loadNouns() {
		nouns = loadTxt(nounsFile); //Use load txt porvided to load list of nouns
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
		String first = s.substring(0,1); //isolate first letter
		String newS = first.toUpperCase() + s.substring(1,s.length()); //capitalize and add rest of word back

		return newS;
	}
	
	
	/** 
	 * Generate a name for your band consisting of two adjectives and one noun.
	 * Make sure to return "UNINITIALIZED" if the band name generator is not initialized correctly yet.
	 * @return the generated name or "UNINITIALIZED"
	 */
	public String generateName() {
		int a = 0;
		for(String s : adjectives){
			a++; //count number of adjectives
		}

		int n = 0;
		for(String s : nouns){
			n++; //count number of nouns
		}

		//Generate random indexes to find random words in adjective and noun lists
		int ind1 = (int)(Math.random()*a);
		int ind2 = (int)(Math.random()*a);
		int ind3 = (int)(Math.random()*n);

		//Capitalize first letter of all words
		String first = capitalizeFirst(adjectives[ind1]); 
		String second = capitalizeFirst(adjectives[ind2]);
		String third = capitalizeFirst(nouns[ind3]);

		//Format output
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
		//Uses the address of adjective.txt and nouns.txt required for it to run in eclipse, 
		//this may not run with this address in the zip file I submittes
		BandNameGenerator gen = new BandNameGenerator("/ece325_lab_assignment1/lab_assignment1/adjectives.txt", "/ece325_lab_assignment1/lab_assignment1/nouns.txt");
		gen.loadNouns();
		gen.loadAdjectives();
		//prints 20 band names
		for (int i = 0; i < 20; i ++){
			System.out.println(gen.generateName());
		}	
	}
}
