package openclosed.baddesign;

public class NotificationService {

    public void send(String type) {
        if (type.equals("email")) {
            System.out.println("Sending email notification...");
        } else if (type.equals("sms")) {
            System.out.println("Sending SMS notification...");
        } else if (type.equals("push")) {
            System.out.println("Sending push notification...");
        } else {
            throw new IllegalArgumentException("Unsupported notification type: " + type);
        }
    }

}
