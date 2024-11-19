import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.InetAddress;

public class NewsServer {
    public static void main(String[] args) {
        try {
			
            Registry registry;
            try {
                registry = LocateRegistry.createRegistry(1099);
                System.out.println("RMI registry created on port 1099.");
            } catch (java.rmi.server.ExportException e) {
                registry = LocateRegistry.getRegistry(1099);
                System.out.println("Using existing RMI registry on port 1099.");
            }
			
            NewsService newsService = new NewsServiceImpl();
            registry.rebind("NewsService", newsService);
            
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("News Server is running...");
            System.out.println("Server IP address: " + ip);
            System.out.println("Share this IP address with clients to connect.");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
