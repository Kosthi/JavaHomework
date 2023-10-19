package charge;

public class ParkingCharge implements ChargeStrategy {
    private double totalCharge = 0.0;

    @Override
    public void charge(double amount) {
        totalCharge += amount;
    }

    @Override
    public String getDailyReport() {
        return "Total parking charge for today is: " + totalCharge;
    }
}
