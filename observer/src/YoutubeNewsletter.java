import java.util.ArrayList;
import java.util.List;

public class YoutubeNewsletter implements NewsletterService {

    List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String emailContent) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveEmail(emailContent);
        }
    }
    
}
