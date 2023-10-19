package charge;

public class Tester {

    public static class ParkingChargeTester {
        public static void main(String[] args) {
            TestParkingCharge();
        }

        public static void TestParkingCharge() {
            ParkingCharge parkingCharge = new ParkingCharge();
            parkingCharge.charge(50);
            parkingCharge.charge(40);
            System.out.println(parkingCharge.getDailyReport());
        }
    }

    public static class MovieChargeTester {
        public static void main(String[] args) {
            TestMovieCharge();
        }

        public static void TestMovieCharge() {
            MovieCharge movieCharge = new MovieCharge();
            movieCharge.charge(10);
            movieCharge.charge(20);
            System.out.println(movieCharge.getDailyReport());
        }
    }
}
