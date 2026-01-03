package devices;

public class Light {
    
    int brightnessLevel;

    public void setBrightness(int level) {
        this.brightnessLevel = level;
        System.out.println("Light brightness set to " + level);
    }
}
