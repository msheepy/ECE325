package Week5;

public class Main {
    Car car = new Car();
    car.maintain();

    RaceCar rc = new RaceCar("rc");
    rc.maintain();

    Car car2 = new RaceCar("car2");
    car2.maintain();
}