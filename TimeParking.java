import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TimeParking {
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    public LocalDateTime getTimeIn() {
        return timeIn;
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
}

