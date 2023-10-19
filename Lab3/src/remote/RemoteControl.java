package remote;

public interface RemoteControl {
    void turnOn();
    void turnOff();
}

interface TvRemote extends RemoteControl {
    void volumeUp();

    void volumeDown();

    void channelUp();

    void channelDown();
}

interface LightRemote extends RemoteControl {
    void dimUp();
    void dimDown();
}

interface CdPlayerRemote extends RemoteControl {
    void play();
    void pause();
    void nextTrack();
    void previousTrack();
}

interface AirConditionerRemote extends RemoteControl {
    void temperatureUp();
    void temperatureDown();
    void setMode(String mode);
}
