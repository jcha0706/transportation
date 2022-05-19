package transportation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

abstract class Car implements SerialNumb{
    private int maxPassenger;

    private HashSet<String> serialNumb = new HashSet<String>();
    int currentPassenger;
    private int baseFare;
    private int carNumb;
    int gas = 100;
    int currentSpeed;


    //setter
    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public void setBaseFare(int baseFare) {
        this.baseFare = baseFare;
    }

    public void setSerialNumb(HashSet<String> serialNumb) {
        this.serialNumb = serialNumb;
    }


    //getter
    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getBaseFare() {
        return baseFare;
    }

    public HashSet<String> getSerialNumb() {
        return serialNumb;
    }



    @Override
    public void generateSerialNumb() {
        Random random = new Random();
        int currentSerialNumbAmount = serialNumb.size();
        int[] serialIndex = new int[7];
        while(true) {
            for (int i = 0; i < serialIndex.length; i++) {
                serialIndex[i] = random.nextInt(9) + 1;
            }
            String stringSerialNumb = Arrays.toString(serialIndex).replaceAll("[^0-9]", "");
            serialNumb.add(stringSerialNumb);
            int newSerialNumbAmount = serialNumb.size();
            if (currentSerialNumbAmount == newSerialNumbAmount) {
                continue;
            }else{
                serialNumb.add(stringSerialNumb);
                break;
            }
        }
    }


//abstract method
    abstract void move(Passenger passenger);
    abstract void getStatus();
    abstract void pickUp(Passenger passenger);
    abstract void dropOff(Passenger passenger);
}