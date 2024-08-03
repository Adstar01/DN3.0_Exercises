package Week_1_Exercises_Part_2.Exercise7;


public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}
