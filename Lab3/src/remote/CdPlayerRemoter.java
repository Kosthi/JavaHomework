package remote;

public class CdPlayerRemoter implements CdPlayerRemote {
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
    public void nextTrack() {
        System.out.println("Skipped to the next track.");
    }

    @Override
    public void previousTrack() {
        System.out.println("Skipped to the previous track.");
    }
}
