package org.example.executors;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args) throws InterruptedException {
        var es = Executors.newScheduledThreadPool(1);
        es.schedule(()->{
            System.out.println(LocalDateTime.now());
        },1, TimeUnit.SECONDS);

        es.scheduleAtFixedRate(()->{
            System.out.println(LocalDateTime.now());
        },2,1,TimeUnit.SECONDS);


        Thread.sleep(10000);
        es.shutdown();


    }
}
