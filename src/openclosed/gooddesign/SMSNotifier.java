package openclosed.gooddesign;

public class SMSNotifier implements Notifier {

    @Override
    public void send() {
        System.out.println("Sending SMS notification...");
    }

}
