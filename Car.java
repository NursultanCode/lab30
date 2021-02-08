import java.util.Objects;

public class Car {
    private String id;
    private State state;
    private int idOFSpot;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Car(int id) {
        this.id = "kg"+id;
        state = State.OnRoad;
    }

    public int getIdOFSpot() {
        return idOFSpot;
    }

    public void setIdOFSpot(int idOFSpot) {
        this.idOFSpot = idOFSpot;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
