public class ObserverApp {
    public static void main(String[] args) throws Exception {
        
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        YoutubeNewsletter newsletter = new YoutubeNewsletter();
        newsletter.subscribe(user1);
        newsletter.subscribe(user2);

        newsletter.notifySubscribers("Welcome to our Youtube Newsletter!");
    }
}
