import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NewsServiceImpl extends UnicastRemoteObject implements NewsService {
    private List<Subscriber> subscribers;
    private AtomicInteger subscriberCounter;

    public NewsServiceImpl() throws RemoteException {
        subscribers = new ArrayList<>();
        subscriberCounter = new AtomicInteger(0);
    }

    @Override
    public synchronized void subscribe(Subscriber subscriber) throws RemoteException {
        subscribers.add(subscriber);
        System.out.println("New subscriber: " + subscriber.getName());
    }

    @Override
    public synchronized void unsubscribe(Subscriber subscriber) throws RemoteException {
        subscribers.remove(subscriber);
        System.out.println("Subscriber removed: " + subscriber.getName());
    }

    @Override
    public synchronized void publishNews(String news) throws RemoteException {
        System.out.println("Publishing news: " + news);
        List<Subscriber> toRemove = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            try {
                subscriber.receiveNews(news);
            } catch (RemoteException e) {
                toRemove.add(subscriber);
                System.out.println("Removed inactive subscriber: " + subscriber.getName());
            }
        }
        subscribers.removeAll(toRemove);
    }

    @Override
    public int getNextSubscriberNumber() throws RemoteException {
        return subscriberCounter.incrementAndGet();
    }
}
