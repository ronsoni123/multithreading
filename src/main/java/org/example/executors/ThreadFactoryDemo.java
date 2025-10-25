package org.example.executors;

import java.sql.SQLOutput;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadFactoryDemo {

    public static void main(String[] args) {
        int noThreads = 4;
        ExecutorService es = Executors.newFixedThreadPool(noThreads,new DefaultThreadFactory());

        IntStream.range(0,10).forEach(
                i->{
                    es.submit(()-> System.out.println(Thread.currentThread().getName()));
                }
        );

        IntStream.range(0,5).forEach(
                i->{
                    Future<Integer> future = es.submit(()->{
                        System.out.println(Thread.currentThread().getName());
                        return i;
                    });

                    try{
                        System.out.println("Future result : "+future.get());
                    }catch (InterruptedException | ExecutionException e){

                    }

                }
        );

        es.shutdown();
    }

}

