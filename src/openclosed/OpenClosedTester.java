package openclosed;

import openclosed.gooddesign.EmailNotifier;
import openclosed.gooddesign.NotificationService;
import openclosed.gooddesign.Notifier;
import openclosed.gooddesign.SMSNotifier;

public class OpenClosedTester {

    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        Notifier notifier = new EmailNotifier();
        notificationService.send(notifier);

        notifier = new SMSNotifier();
        notificationService.send(notifier);
    }
}
