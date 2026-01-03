import devices.Amplifier;
import devices.Light;
import devices.TV;

public class FacadeApp {
    public static void main(String[] args) throws Exception {
        TV tv = new TV();
        Amplifier amplifier = new Amplifier();
        Light light = new Light();
        
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, amplifier, light);
        
        System.out.println("Starting movie: Inception");
        homeTheater.watchMovie(50, 30);
        
        Thread.sleep(2000); // Simulate movie duration
        
        homeTheater.endMovie();
    }
}
