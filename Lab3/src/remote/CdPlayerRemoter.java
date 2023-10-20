package remote;

public class CdPlayerRemoter extends Remoter implements CdPlayerRemote {
    private int volume = 20; // 默认音量

    @Override
    public void turnOn() {
        System.out.println("CD player is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("CD player is turned off.");
    }

    @Override
    public void play() {
        System.out.println("CD is playing.");
    }

    @Override
    public void pause() {
        System.out.println("CD playback is paused.");
    }

    @Override
    public void volumeUp() {
        ++volume;
        System.out.println("CdPlayer volume is up.");
    }

    @Override
    public void volumeDown() {
        --volume;
        System.out.println("CdPlayer volume is down.");
    }

    @Override
    public void nextTrack() {
        System.out.println("Skipped to the next track.");
    }

    @Override
    public void previousTrack() {
        System.out.println("Skipped to the previous track.");
    }
}
