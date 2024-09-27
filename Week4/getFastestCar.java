public class getFastestCar {
    getFastestCar(){
    }
    public static int get(Car car1, RaceCar car2, SafetyCar car3){
        return max(car1.maxSpeed), (int)car2.maxSpeed, (int)car3.maxSpeed);
    }
    public static void main(String[] args) {
        Car c = new Car(8);
        RaceCar rc = new RaceCar(10);
        SafetyCar sc = new SafetyCar(2);
        int m = get(c, rc, sc);
        System.out.println(m);
    }
}

