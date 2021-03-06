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
        int dayTemp = 0;
        while (changing.isBefore(start.plusDays(30))){
            int day = changing.getDayOfMonth();
            if (dayTemp!=day){
                Statistic statistic = new Statistic();
                parkingZone.getStatistics().add(statistic);
                dayTemp = day;
            }
            Random r = new Random();
            for (Car car:cars
                 ) {
                int n = r.nextInt(100);
                if (n<3){
                    changeState(car,parkingZone);
                }
            }
            if (parkingZone.getStatistics().getLast().getLoad()==0){
                parkingZone.getStatistics().getLast().setLoad(countLoad(parkingZone));
            }else {
                parkingZone.getStatistics().getLast().setLoad((parkingZone.getStatistics().getLast().getLoad()+countLoad(parkingZone))/2);
            }
            for (Spot spot: parkingZone.spotList
                 ) {
                if (changing.getHour()>9 && changing.getHour()<21){
                    if (spot!=null && spot.getTimeParking()!=null && spot.getTimeParking().getTimeDifference(changing)>35){
                        parkingZone.getStatistics().getLast().setCash(parkingZone.getStatistics().getLast().getCash()+10);
                    }
                }
            }
            System.out.println(changing);
            parkingZone.printStatus();
            changing = changing.plusMinutes(5);
        }
        System.out.println(parkingZone.getStatistics().toString());
        DrawingTable.draw(parkingZone.getStatistics());
    }

    private static int countLoad(ParkingZone parkingZone) {
        int count =0;
        for (Spot spot:parkingZone.getSpotList()
             ) {
            if (spot.getCar()!=null){
                count++;
            }
        }
        return count*100/20;
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
