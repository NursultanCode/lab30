import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingZone {
    List <Spot> spotList;
    List <Statistic> statistics;

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public ParkingZone() {
        spotList = new ArrayList<>();
        for (int i = 1; i <21 ; i++) {
            Spot spot = new Spot(i);
            spotList.add(spot);
        }
    }

    public Spot getEmptySpot() throws NoEmptySpotAvailable{
        for (Spot spot:spotList
             ) {
            if (spot.isFree()){
                return spot;
            }
        }
        throw new NoEmptySpotAvailable("No empty Spot");
    }

    public void parkCar(Car car, LocalDateTime time) throws NoEmptySpotAvailable{
        Spot emptySpot = getEmptySpot();
        emptySpot.assignCar(car, time);
        car.setIdOFSpot(emptySpot.getId());
        System.out.println("Car located");
    }


    public void removeCar(Car car, LocalDateTime changing) {
        for (Spot spot:spotList
             ) {
            if (spot.getCar().equals(car)){

                spot.removeCar();
            }
        }
    }
}
class NoEmptySpotAvailable extends Exception{
    public NoEmptySpotAvailable(String message){
        super(message);
    }
}
