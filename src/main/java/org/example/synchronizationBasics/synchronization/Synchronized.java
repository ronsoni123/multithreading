package org.example.synchronizationBasics.synchronization;

import java.util.ArrayList;
import java.util.List;

public class Synchronized {

    private static int counter;


    public static void main(String[] args) throws InterruptedException{
        int noOfIncrements = 10000;
        List<Thread> allThreads = new ArrayList<>();
        for(int i=0;i<noOfIncrements;i++){
            Thread t = new Thread(Synchronized::increment);
            allThreads.add(t);
            t.start();
        }

        for(Thread t: allThreads){
            t.join();
        }

        System.out.println(counter);
    }

    public static void increment(){
        synchronized (Synchronized.class){
            counter++;
        }
    }


}
