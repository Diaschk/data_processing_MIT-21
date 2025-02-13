public class Notification {

    public void send() {
        System.out.println("Sending a notification");
    }

    public static void main(String[] args) {
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        email.send();
        sms.send();
    }
    
    public static class EmailNotification extends Notification {
        @Override
        public void send() {
            System.out.println("Sending email notification");
        }
    }

    public static class SMSNotification extends Notification {
        @Override
        public void send() {
            System.out.println("Sending SMS notification");
        }
    }
}
