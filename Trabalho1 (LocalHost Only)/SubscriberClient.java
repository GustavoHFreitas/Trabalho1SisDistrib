import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class SubscriberClient extends UnicastRemoteObject implements Subscriber {
    private String name;

    protected SubscriberClient(NewsService newsService) throws RemoteException {
        int number = newsService.getNextSubscriberNumber();
        this.name = "Subscriber" + number;
    }

    public void receiveNews(String news) throws RemoteException {
        System.out.println(name + " received news: " + news);
    }

    public String getName() throws RemoteException {
        return name;
    }

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
            
            SubscriberClient subscriber = new SubscriberClient(newsService);
            newsService.subscribe(subscriber);
            System.out.println("Subscribed to news service as " + subscriber.getName() + ". Type 'exit' to quit.");

            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    newsService.unsubscribe(subscriber);
                    break;
                }
            }
            
            System.out.println("Unsubscribed from news service.");
            scanner.close();
            System.exit(0);

        } catch (Exception e) {
            System.err.println("Subscriber exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
