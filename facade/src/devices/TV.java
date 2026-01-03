package devices;

public class TV {
    
    boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("TV is turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("TV is turned OFF");
    }
}
