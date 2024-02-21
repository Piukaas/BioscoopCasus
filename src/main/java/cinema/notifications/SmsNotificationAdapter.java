package cinema.notifications;

public class SmsNotificationAdapter implements Notification{

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
    
}
