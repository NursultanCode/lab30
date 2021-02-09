import java.time.LocalDateTime;

public interface ParkingCostStrategy {
    int plusCash(LocalDateTime now);
}
