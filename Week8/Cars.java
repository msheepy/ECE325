import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars implements Comparable<Cars>{
    private int maxSpeed;
    private String make;
    public Cars(int maxSpeed, String make){
        this.maxSpeed = maxSpeed;
        this.make = make;
    }
    public String getMake(){
        return make;
    }
    public int getMaxSpeed(){
        return maxSpeed;
    }
    @Override
    public int compareTo(Cars o){
        int i = Integer.compare(maxSpeed, o.getMaxSpeed());
        if (i != 0){
            return i;
        }
        else {
            return make.compareTo(o.getMake());
        }
    }
    public static void main(String[] args) {
        List<Cars> cars = new ArrayList<Cars>();
        cars.add(new Cars(300, "Ferrari"));
        cars.add(new Cars(320, "Lambo"));
        cars.add(new Cars(300, "Alpha Romeo"));
        Collections.sort(cars); //sorrts by natural sorting defined in Cars
        Collections.sort(cars, new CarMakeComparator()); //sorts by unnatural sorting in CarMakeComparator
    }
}
