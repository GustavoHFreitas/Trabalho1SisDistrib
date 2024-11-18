import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Publisher {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter server IP (or press Enter for localhost): ");
            String serverIP = scanner.nextLine().trim();
            if (serverIP.isEmpty()) {
                serverIP = "localhost";
            }
            
            System.out.println("Connecting to server at " + serverIP + "...");
            Registry registry = LocateRegistry.getRegistry(serverIP, 1099);
            NewsService newsService = (NewsService) registry.lookup("NewsService");
            System.out.println("Connected successfully!");
            
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
