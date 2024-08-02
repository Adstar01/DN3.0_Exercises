package Week_1_Exercises_Part_2.Exercise1;

public class SingletonPatternTest {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Logger is a singleton. Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Logger is not a singleton. logger1 and logger2 are different instances.");
        }
    }
}

