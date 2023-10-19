package remote;

public class AirConditionerRemoter implements AirConditionerRemote {
    private int temperature = 25; // 默认温度
    private String mode = "auto"; // 默认模式

    @Override
    public void turnOn() {
        System.out.println("Air conditioner is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Air conditioner is turned OFF.");
    }

    @Override
    public void temperatureUp() {
        temperature++;
        System.out.println("Temperature is set to: " + temperature);
    }

    @Override
    public void temperatureDown() {
        temperature--;
        System.out.println("Temperature is set to: " + temperature);
    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
        System.out.println("Mode is set to: " + mode);
    }
}
