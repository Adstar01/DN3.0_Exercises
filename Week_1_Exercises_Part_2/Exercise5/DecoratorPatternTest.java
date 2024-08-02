package Week_1_Exercises_Part_2.Exercise5;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello, this is an email notification!");

        System.out.println();

        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Hello, this is an email and SMS notification!");

        System.out.println();

        Notifier slackNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        slackNotifier.send("Hello, this is an email, SMS, and Slack notification!");
    }
}

