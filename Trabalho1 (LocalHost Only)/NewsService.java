import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewsService extends Remote {
    void subscribe(Subscriber subscriber) throws RemoteException;
    void unsubscribe(Subscriber subscriber) throws RemoteException;
    void publishNews(String news) throws RemoteException;
    int getNextSubscriberNumber() throws RemoteException;
}
