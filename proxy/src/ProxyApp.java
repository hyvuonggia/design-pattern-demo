public class ProxyApp {
    public static void main(String[] args) throws Exception {
        
        Secretary secretary = new Secretary(new CEO());

        System.out.println("Attempting to sign a regular document:");
        secretary.signDocument("Project_Plan.pdf");

        System.out.println();

        System.out.println("Attempting to sign an important document:");
        secretary.signDocument("Financial_Report_[IMPORTANT].pdf");
    }
}
