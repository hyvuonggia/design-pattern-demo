import devices.Amplifier;
import devices.TV;
import devices.Light;

public class HomeTheaterFacade {
    
    private TV tv;
    private Amplifier amplifier;
    private Light light;

    public HomeTheaterFacade(TV tv, Amplifier amplifier, Light light) {
        this.tv = tv;
        this.amplifier = amplifier;
        this.light = light;
    }

    public void watchMovie(int volumeLevel, int brightnessLevel) {
        tv.turnOn();
        amplifier.setVolume(volumeLevel);
        light.setBrightness(brightnessLevel);
        System.out.println("Movie is ready to watch!");
    }

    public void endMovie() {
        tv.turnOff();
        System.out.println("Movie has ended.");
    }
}
