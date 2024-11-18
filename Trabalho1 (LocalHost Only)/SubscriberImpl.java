import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SubscriberImpl extends UnicastRemoteObject implements Subscriber {
    private String name;

    public SubscriberImpl(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public void receiveNews(String news) throws RemoteException {
        System.out.println(name + " received news: " + news);
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }
}
