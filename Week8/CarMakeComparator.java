import java.util.Comparator;

public class CarMakeComparator implements Comparator<Cars>{
    @Override
    public int compare(Cars o1, Cars o2){
        return o1.getMake().compareTo(o2.getMake());
    }
}