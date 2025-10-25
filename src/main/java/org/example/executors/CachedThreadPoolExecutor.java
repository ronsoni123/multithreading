package org.example.executors;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CachedThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newCachedThreadPool();

        IntStream.range(0,1000).forEach(
                i -> {
                    es.submit(
                            ()->{
                                    try{
                                        TimeUnit.SECONDS.sleep(5);
                                        System.out.println(Thread.currentThread().getName());
                                    }catch (InterruptedException e){
                                        System.out.println(e);
                                    }
                            }
                    );
                }
        );

        es.shutdown();

        System.out.println(es.getPoolSize());
        System.out.println(es.getQueue().size());



    }

}
