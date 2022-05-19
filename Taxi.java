package transportation;

public class Taxi extends Car{
    boolean state = true;
    int taxiGasPerKillo = 2;
    int estimatedGasUsage = 0;
    int wholeTripFare = 0;
    int seats = 0;
    String taxiName = "";


    Taxi(String taxiName) {
        setMaxPassenger(4);
        setBaseFare(3000);
        this.taxiName = taxiName;
        currentSpeed = 0;
        generateSerialNumb();
    }

    @Override
    void move(Passenger passenger) {
        System.out.println("-----------Taxi Move------------");
        if(gas < 11){
            state = false;
            System.out.println("This taxi cannot be operated");
            System.out.println("Gas must be at least over 10");
        }else{
            currentSpeed = 70;
            gas -= taxiGasPerKillo*passenger.destinationDistance;
            System.out.println(taxiName + " has departed, and the current speed is: " + currentSpeed);
            if(gas < 11) {
                getStatus();
            }
        }
        System.out.println("--------------------------------");
    }

    @Override
    void getStatus() {
        System.out.println("-----------Taxi Status-----------");
        if(state == true){
            System.out.println("State: Operational");
        }else{
            System.out.println("State: No service");
        }
        System.out.println("Passenger seats: " + super.getMaxPassenger());
        System.out.println("Base fare: " + getBaseFare());
        System.out.println("Gas amount: " + gas);
        System.out.println("Current speed: " + currentSpeed);
        System.out.println("Serial Number: " + getSerialNumb());
        System.out.println("--------------------------------");
    }

    @Override
    void pickUp(Passenger passenger) {
        System.out.println("---------Taxi Pick Up----------");
        seats = super.getMaxPassenger();
        estimatedGasUsage = passenger.destinationDistance*taxiGasPerKillo;
        wholeTripFare = getBaseFare() + passenger.destinationDistance*1000;
        if(gas < 11) {
            getStatus();
        }else if(gas < estimatedGasUsage){
            System.out.println("The required gas for the distance to the destination is not sufficient");
        }else if(passenger.money < wholeTripFare){
            System.out.println("The passenger has insufficient balance. Cannot be on board");
        }else if(seats == 0){
            System.out.println("The taxi is full, please take the next one");
        }else{
            System.out.println("The passenger, " + passenger.name + ", is on board");
            seats = super.getMaxPassenger() - passenger.theNumberOfPassenger;
            System.out.println(seats + " seats are left now");
        }
        System.out.println("--------------------------------");
    }
    @Override
    void dropOff(Passenger passenger) {
        System.out.println("--------Taxi Drop Off----------");
        System.out.println(taxiName + " arrived at " + passenger.destination + " and dropping off " + passenger.name);
        currentSpeed = 0;
        System.out.println("Current speed is: " + currentSpeed);
        System.out.println(passenger.name + " got off from the taxi");
        passenger.money -= wholeTripFare;
        System.out.println(wholeTripFare + " has been charged. " + passenger.money + " left");
        int availableSeats = super.getMaxPassenger();
        wholeTripFare = 0;
        if(availableSeats > 4){
            availableSeats = 4;
            System.out.println("The passenger already got off from the bus");
        }else {
            System.out.println(availableSeats + " seat(s) are left");
            getStatus();
        }
        System.out.println("--------------------------------");
    }
}
