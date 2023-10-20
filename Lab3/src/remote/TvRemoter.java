package remote;

public class TvRemoter extends Remoter implements TvRemote {
    private int volume = 20; // 默认音量

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
        ++volume;
        System.out.println("TV volume is up.");
    }

    @Override
    public void volumeDown() {
        --volume;
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
