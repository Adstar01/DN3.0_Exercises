package Week_1_Exercises_Part_2.Exercise2;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document.");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document.");
    }
}



