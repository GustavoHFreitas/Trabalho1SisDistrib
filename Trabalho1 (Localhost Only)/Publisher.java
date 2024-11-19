import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Publisher {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            NewsService newsService = (NewsService) registry.lookup("NewsService");
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("News Publisher started. Type your news message or 'exit' to quit.");
            
            String input;
            while (true) {
                System.out.print("Enter news to publish: ");
                input = scanner.nextLine();
                
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                
                if (!input.trim().isEmpty()) {
                    newsService.publishNews(input);
                    System.out.println("News published successfully!");
                }
            }
            
            System.out.println("Publisher shutting down.");
            scanner.close();
            System.exit(0);

        } catch (Exception e) {
            System.err.println("Publisher exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
