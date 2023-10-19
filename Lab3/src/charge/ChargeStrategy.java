package charge;

public interface ChargeStrategy {
    void charge(double amount);
    String getDailyReport();
}
