import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParkingZone {
    List <Spot> spotList;
    LinkedList<Statistic> statistics;

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public LinkedList<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(LinkedList<Statistic> statistics) {
        this.statistics = statistics;
    }

    public ParkingZone() {
        spotList = new ArrayList<>();
        statistics = new LinkedList<>();
        for (int i = 1; i <21 ; i++) {
            Spot spot = new Spot(i);
            spotList.add(spot);
        }
    }

    public Spot getEmptySpot() throws NoEmptySpotAvailable{
        try{
            for (Spot spot:spotList
            ) {
                if (spot.isFree()){
                    return spot;
                }
            }
            throw new NoEmptySpotAvailable("No empty Spot");
        }catch (NoEmptySpotAvailable e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void parkCar(Car car, LocalDateTime time){
        try{
            Spot emptySpot = getEmptySpot();
            if (emptySpot==null) throw new NoEmptySpotAvailable("There is no spot!");
            emptySpot.assignCar(car, time);
            System.out.println("Car located");
        } catch (NoEmptySpotAvailable noEmptySpotAvailable) {

        }

    }


    public void removeCar(Car car, LocalDateTime changing) {
        for (Spot spot:spotList
             ) {
            if (spot.getCar()!=null && spot.getCar().equals(car)){
                spot.getTimeParking().setTimeOut(changing);
                if (getDifferenceTime(spot)<=30){
                    statistics.getLast().setCarsLeastMin(statistics.getLast().getCarsLeastMin()+1);
                }
                spot.removeCar();
                System.out.println("Car removed");
            }
        }
    }

    private int getDifferenceTime(Spot spot) {
        return spot.getTimeParking().getTimeDifference();
    }

    public void printStatus() {
        for (Spot spot:getSpotList()
             ) {
            if (spot.getCar()!=null)
            System.out.println(spot.toString());
        }
    }
}
class NoEmptySpotAvailable extends Exception{
    public NoEmptySpotAvailable(String message){
        super(message);
    }
}
