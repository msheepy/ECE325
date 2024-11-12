package Week5;

public class RaceCar extends Car{
    String name;
    public RaceCar(String name){
        this.name = name;
        maxSpeed = 370;
    }
    public RaceCar(String name, int maxSpeed){
        this.name = name;
        this.maxSpeed = maxSpeed;
    }
    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed();
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int maintain(){
        return 1;
    }
}
