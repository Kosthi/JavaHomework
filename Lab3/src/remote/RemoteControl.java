package remote;

interface TvRemote {
    void volumeUp();

    void volumeDown();

    void channelUp();

    void channelDown();
}

interface LightRemote {
    void dimUp();

    void dimDown();
}

interface CdPlayerRemote {
    void play();

    void pause();

    void volumeUp();

    void volumeDown();

    void nextTrack();

    void previousTrack();
}

interface AirConditionerRemote {
    void temperatureUp();

    void temperatureDown();

    void setMode(String mode);
}
