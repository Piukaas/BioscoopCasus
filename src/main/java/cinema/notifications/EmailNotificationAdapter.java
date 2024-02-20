package cinema.notifications;

public class EmailNotificationAdapter implements Notification {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
    
}
