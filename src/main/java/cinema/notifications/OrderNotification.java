package cinema.notifications;

public class OrderNotification implements OrderObserver {
    private Notification notificationAdapter;

    public OrderNotification(Notification notificationAdapter) {
        this.notificationAdapter = notificationAdapter;
    }

    @Override
    public void update(String message) {
        notificationAdapter.sendNotification(message);
    }
    
}
