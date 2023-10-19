package remote;

public class TvRemoter implements TvRemote {
    @Override
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off.");
    }

    @Override
    public void volumeUp() {
        System.out.println("TV volume is up.");
    }

    @Override
    public void volumeDown() {
        System.out.println("TV volume is down.");
    }

    @Override
    public void channelUp() {
        System.out.println("Up the channel.");
    }

    @Override
    public void channelDown() {
        System.out.println("Down the channel.");
    }
}
