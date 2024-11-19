import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NewsServer {
    public static void main(String[] args) {
        try {
            NewsService newsService = new NewsServiceImpl();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("NewsService", newsService);
            System.out.println("News Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
