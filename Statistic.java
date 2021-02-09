public class Statistic {
    private int carsLeastMin;
    private int cash;
    private int load;

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }



    public int getCarsLeastMin() {
        return carsLeastMin;
    }

    public void setCarsLeastMin(int carsLeastMin) {
        this.carsLeastMin = carsLeastMin;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "\nStatistic{" +
                "carsLeastMin=" + carsLeastMin +
                ", cash=" + cash +
                ", load=" + load +
                '}';
    }
}
