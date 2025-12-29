public class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receiveEmail(String emailContent) {
        System.out.println("User " + name + " received email: " + emailContent);
    }
    
}
