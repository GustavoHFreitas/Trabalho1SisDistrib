import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subscriber extends Remote {
    void receiveNews(String news) throws RemoteException;
    String getName() throws RemoteException;
}
