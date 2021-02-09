import java.time.LocalDateTime;

public class Spot {
    private int id;
    private boolean free;
    private Car car;
    private TimeParking timeParking;

    public TimeParking getTimeParking() {
        return timeParking;
    }

    public void setTimeParking(TimeParking timeParking) {
        this.timeParking = timeParking;
    }

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
        timeParking = new TimeParking();
        timeParking.setTimeIn(timeIn);
        car.setState(State.InPark);
    }


    public void removeCar(){
        car.setState(State.OnRoad);
        free = true;
        car = null;
    }

    @Override
    public String toString() {
        return "\nSpot{" +
                "id=" + id +
                ", free=" + free +
                ", car=" + car +
                ", timeParking=" + timeParking +
                '}';
    }
}
