package org.example.synchronizationBasics.waitnotify;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable{
    private Message message;

    public Notifier(Message message){
        this.message = message;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": Started");

        try{
            TimeUnit.SECONDS.sleep(1);
            synchronized (message){
                message.setMessage(name + " Notifier Work done");
//                message.notify();
                message.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Notifier work done");
    }
}
