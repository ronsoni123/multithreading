package org.example;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        var es = Executors.newCachedThreadPool();
        Future<String> f = es.submit(()-> "rounak is learning multithreading");
        System.out.println(f.get(10, TimeUnit.SECONDS));

    }
}
