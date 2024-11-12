package ece325.labs.lab4;

/** 
 * Finish this class.
 */
public class AverageRating implements Comparable<AverageRating> {
	
	// not allowed to change anything after this (until the next marker which says you can add code again)
	private float avgRating;
	private int votes;
	
	public AverageRating(float rating, int votes) {
		this.avgRating = rating;
		this.votes = votes;
	}
		
	public float getAvgRating() {
		return avgRating;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public String toString() {
		return "[AverageRating: " + avgRating + ", votes: " + votes + "]";
	}

	@Override
	public int compareTo(AverageRating s){
		int comp = Float.compare(this.avgRating, s.getAvgRating());
		if(comp == 0){
			return Float.compare(this.votes, s.votes);
		}
		else {
			return comp;
		}
	}

	// You are allowed to make changes or add code after this line
}
