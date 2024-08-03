package Week_1_Exercises_Part_2.Exercise9;

public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();
        System.out.println("");

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

