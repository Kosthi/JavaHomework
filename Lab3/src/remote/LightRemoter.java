package remote;

public class LightRemoter implements LightRemote {
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
        System.out.println("Light is dimming up.");
    }

    @Override
    public void dimDown() {
        System.out.println("Light is dimming down.");
    }
}
