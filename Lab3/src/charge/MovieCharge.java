package charge;

public class MovieCharge implements ChargeStrategy {
    private double totalCharge = 0.0;

    @Override
    public void charge(double amount) {
        totalCharge += amount;
    }

    @Override
    public String getDailyReport() {
        return "Total movie charge for today is: " + totalCharge;
    }
}
