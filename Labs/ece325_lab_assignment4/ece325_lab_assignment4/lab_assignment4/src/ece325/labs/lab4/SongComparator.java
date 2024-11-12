package ece325.labs.lab4;
import java.util.Comparator;

class SongComparator implements Comparator<Song> {
    @Override
    public int compare(Song s1, Song s2) {
        return s2.getAverageRating().compareTo(s1.getAverageRating());
    }
}
