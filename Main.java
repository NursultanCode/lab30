import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    static ArrayList <Car> cars;
    static LocalDateTime start;
    static LocalDateTime changing;
    public static void main(String[] args) throws NoEmptySpotAvailable {
        startMonthPark();
    }

    private static void startMonthPark() throws NoEmptySpotAvailable {
        createCars();
        ParkingZone parkingZone = new ParkingZone();
        start = LocalDateTime.now();
        changing = start;
        while (changing.isBefore(start.plusDays(30))){
            Random r = new Random();
            for (Car car:cars
                 ) {
                int n = r.nextInt(100);
                if (n<3){
                    changeState(car,parkingZone);
                }
            }
        }
    }

    private static void changeState(Car car, ParkingZone parkingZone) throws NoEmptySpotAvailable {
        if (car.getState().equals(State.InPark)){
            parkingZone.removeCar(car,changing);
            car.setState(State.OnRoad);
        }else {
            parkingZone.parkCar(car, changing);
            car.setState(State.InPark);
        }
    }

    private static void createCars() {
        cars = new ArrayList<>();
        for (int i = 0; i <200 ; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
    }
}
