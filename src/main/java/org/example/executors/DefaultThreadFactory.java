package org.example.executors;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {
    AtomicInteger threadCount = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r){
        Thread t =  new Thread(r,"Custom thread Factory"+threadCount.incrementAndGet());
//        t.setDaemon(true);

        return t;
    }
}
