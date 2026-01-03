package devices;

public class Amplifier {

    int volumeLevel;

    public void setVolume(int level) {
        this.volumeLevel = level;
        System.out.println("Amplifier volume set to " + level);
    }
    
}