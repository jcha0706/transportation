package transportation;

public class Passenger {
    String destination;
    String name;
    int destinationDistance;
    int money;
    int theNumberOfPassenger;


    public Passenger( String name, String destination, int destinationDistance, int money, int theNumberOfPassenger){
        this.destination = destination;
        this.destinationDistance = destinationDistance;
        this.name = name;
        this.money = money;
        this.theNumberOfPassenger = theNumberOfPassenger;

    }

    public Passenger(String name, int money){
        this.name = name;
        this.money = money;
    }



}
