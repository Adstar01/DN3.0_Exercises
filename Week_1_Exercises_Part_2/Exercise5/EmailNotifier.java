package Week_1_Exercises_Part_2.Exercise5;

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

