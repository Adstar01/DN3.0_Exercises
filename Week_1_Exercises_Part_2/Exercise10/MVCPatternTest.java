package Week_1_Exercises_Part_2.Exercise10;

public class MVCPatternTest {
    public static void main(String[] args) {
        Student model = new Student();
        model.setName("John Doe");
        model.setId("123");
        model.setGrade("A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();
        System.out.println("");

        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B+");

        controller.updateView();
    }
}

