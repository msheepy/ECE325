package ece325.labs.lab3;

/** 
 * Finish this class.
 */
public class AverageRating {
	private float avgRating; //current average rating
	private int count; //number or ratings contributing to average
	
	public AverageRating(float rating) {
		//instantiate variables
		this.avgRating = rating;
		this.count = 1;
	}
	
	/**
	 * Recomputes the average rating taking the new rating r into account.
	 * @param rating 
	 */
	public void addRating(float r) {
		if (r < 0 || r >10) {
			//checks if rating is valid
			//This should be redundant, when input the code checks to see if the rating is valid
		}
		else{
			//if no rating, set rating rather than calculating average
			if (count == 0) {
				avgRating = r;
				count = count + 1;
			}
			//previous rating is present so calculate average
			else {
				avgRating = (avgRating*count + r)/(count + 1); //calculates a new average rating
				count = count + 1; //increases the count, which tracks the number of ratings contributing to average
			}
		}
	}
	
	public float getAvgRating() {
		return avgRating;
	}
	
	//format output
	public String toString() {
		return "[AverageRating: " + avgRating + "]";
	}
}
