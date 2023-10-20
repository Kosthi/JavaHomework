package remote;

public class LightRemoter extends Remoter implements LightRemote {
    private int luminance = 25; // 默认亮度

    @Override
    public void turnOn() {
        System.out.println("Light is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned off.");
    }

    @Override
    public void dimUp() {
        ++luminance;
        System.out.println("Light is dimming up.");
    }

    @Override
    public void dimDown() {
        --luminance;
        System.out.println("Light is dimming down.");
    }
}
