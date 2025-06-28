interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() { System.out.println("Email sent."); }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) { super(notifier); }
    public void send() {
        notifier.send();
        System.out.println("SMS sent.");
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifier(new EmailNotifier());
        notifier.send();
    }
}
