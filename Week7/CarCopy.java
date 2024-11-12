package Week7;

public class CarCopy {
    int maxSpeed;
    CarCopy(){
        this.maxSpeed = 2;
    }
    CarCopy(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    int getMaxSpeed(){
        return this.maxSpeed;
    }
    void setMaxSpeed(int s){
        this.maxSpeed = s;
    }
}
