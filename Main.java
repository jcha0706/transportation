package transportation;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[]args){
        Bus bus1 = new Bus("bus1");
        Taxi taxi1 = new Taxi("taxi1");
        Passenger jake = new Passenger("Jake", 3000);
        Passenger jamie = new Passenger("Jamie", "GangNam", 20, 15000, 1);
        Passenger luke = new Passenger("Luke", "GangNam", 20, 30000, 3);
        bus1.getStatus();
        bus1.move(jake);
        bus1.pickUp(jake);
        bus1.move(jake);
        bus1.dropOff(jake);
        bus1.move(jake);
        bus1.move(jake);
        bus1.move(jake);


        taxi1.getStatus();
        taxi1.pickUp(jamie);
        taxi1.getStatus();
        taxi1.pickUp(luke);
        taxi1.move(luke);
        taxi1.dropOff(luke);







    }
}
