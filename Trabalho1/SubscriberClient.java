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
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            NewsService newsService = (NewsService) registry.lookup("NewsService");
            
            SubscriberClient subscriber = new SubscriberClient(newsService);
            newsService.subscribe(subscriber);
            System.out.println("Subscribed to news service as " + subscriber.getName() + ". Type 'exit' to quit.");

            // Keep the subscriber running until user types "exit"
            Scanner scanner = new Scanner(System.in);
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
