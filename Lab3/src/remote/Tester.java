package remote;

public class Tester {
    public static class TvRemoterTester {

        public static void main(String[] args) {
            TestTvRemoter();
        }

        public static void TestTvRemoter() {
            TvRemoter tvRemoter = new TvRemoter();
            tvRemoter.turnOn();
            tvRemoter.turnOff();
            tvRemoter.channelUp();
            tvRemoter.channelDown();
            tvRemoter.volumeUp();
            tvRemoter.volumeDown();
        }
    }

    public static class LightRemoterTester {

        public static void main(String[] args) {
            TestLightRemoter();
        }

        public static void TestLightRemoter() {
            LightRemoter lightRemoter = new LightRemoter();
            lightRemoter.turnOn();
            lightRemoter.turnOff();
            lightRemoter.dimUp();
            lightRemoter.dimDown();
        }
    }

    public static class CdPlayerRemoterTester {

        public static void main(String[] args) {
            TestCdPlayerRemoter();
        }

        public static void TestCdPlayerRemoter() {
            CdPlayerRemoter cdPlayerRemoter = new CdPlayerRemoter();
            cdPlayerRemoter.turnOn();
            cdPlayerRemoter.turnOff();
            cdPlayerRemoter.volumeUp();
            cdPlayerRemoter.volumeDown();
            cdPlayerRemoter.play();
            cdPlayerRemoter.pause();
            cdPlayerRemoter.previousTrack();
            cdPlayerRemoter.nextTrack();
        }
    }

    public static class AirConditionerRemoterTester {

        public static void main(String[] args) {
            TestAirConditionerRemoter();
        }

        public static void TestAirConditionerRemoter() {
            AirConditionerRemoter airConditionerRemote = new AirConditionerRemoter();
            airConditionerRemote.turnOn();
            airConditionerRemote.turnOff();
            airConditionerRemote.temperatureUp();
            airConditionerRemote.temperatureDown();
            airConditionerRemote.setMode("Cold");
        }
    }
}
