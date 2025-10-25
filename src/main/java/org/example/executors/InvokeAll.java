package org.example.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll {

    public static void main(String[] args) throws InterruptedException{
        var es = Executors.newCachedThreadPool();
        List<Callable<String>> tasks = Arrays.asList(
                ()->"#task1",
                ()->"#task2",
                ()->"#task3");
        List<Future<String>> futures = es.invokeAll(tasks);

        futures.stream().map(future->{
            try{
                return future.get();
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
            return "";
        }).forEach(System.out::println);

    }
}
