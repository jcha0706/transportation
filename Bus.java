package transportation;

public class Bus extends Car{
    boolean state = true;
    int theNumberOfBusStop;
    int busStopLeft = 0;
    int busGasPerStop = 5;
    int seatsLeft = 0;
    String busName = "";


    Bus(String busName) {
        setMaxPassenger(30);
        setBaseFare(1000);
        currentSpeed = 0;
        currentPassenger = 0;
        generateSerialNumb();
        this.busName = busName;
    }

    @Override
    void move(Passenger passenger) {
        System.out.println("-----------Bus Move-------------");
        if(gas < 11){
            state = false;
            System.out.println("This Bus cannot be operated");
            System.out.println("Gas must be at least over 10");
        }else{
            currentSpeed = 70;
            gas -= busGasPerStop;
            System.out.println(busName + " has departed, and the current speed is: " + currentSpeed);
            getStatus();
        }
        System.out.println("--------------------------------");
    }

    @Override
    void getStatus() {
        System.out.println("-----------Bus Status-----------");
        if(state == true){
            System.out.println("State: Operational");
        }else{
            System.out.println("State: No service");
        }
        System.out.println("Passenger seats: " + getMaxPassenger());
        System.out.println("Base fare: " + getBaseFare());
        System.out.println("Gas amount: " + gas);
        System.out.println("Current speed: " + currentSpeed);
        System.out.println("Serial Number: " + getSerialNumb());
        System.out.println("--------------------------------");
    }


    @Override
    void pickUp(Passenger passenger) {
        System.out.println("---------Bus Pick UP----------");
        seatsLeft = super.getMaxPassenger() - super.currentPassenger;
        System.out.println(seatsLeft + " seats are available on "+ busName);

        if(gas < 11) {
            getStatus();
        }else if(passenger.money < super.getBaseFare()){
            System.out.println("The passenger has insufficient balance. Cannot be on board");
        }else if(seatsLeft == 0){
            System.out.println("The bus is full, please take the next one");
        }else{
            System.out.println("The passenger, " + passenger.name + ", is on board");
            super.currentPassenger++;
            seatsLeft = super.getMaxPassenger() - super.currentPassenger;
            System.out.println(seatsLeft + " seats are left now");
        }
        System.out.println("--------------------------------");
    }
    @Override
    void dropOff(Passenger passenger) {
        System.out.println("--------Bus Drop Off---------");
        System.out.println(busName + " has been stopped to drop off " + passenger.name);
        currentSpeed = 0;
        System.out.println("Current speed is: " + currentSpeed);
        System.out.println(passenger.name + " got off from the bus");
        super.currentPassenger--;
        passenger.money -= getBaseFare();
        System.out.println("1000 has been charged. " + passenger.money + " left");
        int availableSeats = super.getMaxPassenger() - super.currentPassenger;
        if(availableSeats > 30){
            availableSeats = 30;
            System.out.println("The passenger already got off from the bus");
        }else {
            System.out.println(availableSeats + " seat(s) are left");
            getStatus();
        }
        System.out.println("--------------------------------");
    }
}
