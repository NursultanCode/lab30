import java.time.LocalDateTime;

public class Spot {
    private int id;
    private boolean free;
    private Car car;
    private TimeParking timeParking;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Spot(int id) {
        this.id = id;
        free = true;
    }

    public  void assignCar(Car car, LocalDateTime timeIn){
        free = false;
        this.car = car;
        timeParking.setTimeIn(timeIn);
        car.setState(State.InPark);
    }

//    public int getCheck(LocalDateTime timeOut){
//        timeParking.setTimeOut(timeOut);
//
//    }

    public void removeCar(){
        car.setState(State.OnRoad);
        free = true;
        car = null;
    }
}
