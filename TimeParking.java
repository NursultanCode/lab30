import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeParking {
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    @Override
    public String toString() {
        return "TimeParking{" +
                "timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                '}';
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public int getTimeDifference(){
        int minutes = (int) ChronoUnit.MINUTES.between(timeIn, timeOut);
        return minutes;
    }

    public int getTimeDifference(LocalDateTime changing) {
        int minutes = (int) ChronoUnit.MINUTES.between(timeIn, changing);
        return minutes;
    }
}

