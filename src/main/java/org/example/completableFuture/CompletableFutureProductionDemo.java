package org.example.completableFuture;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureProductionDemo {
    private static final ExecutorService networkPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        CompletableFuture<List<Product>> futures = CompletableFuture.supplyAsync(()-> fetchProductFromApi(),networkPool)
                .thenApply(products->enrichProductData(products))
                .thenApply(products -> applyDiscount(products));

        futures.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("Final Products: "+ result);
            }else{
                System.out.println(ex.getCause());
            }
        });

        futures.join();

        networkPool.shutdown();


    }

    private static List<Product> fetchProductFromApi(){
        try{
            System.out.println("Fetching Products from remote API");
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return Arrays.asList(
                new Product("Bricks",8.0),
                new Product("Cement", 300.0),
                new Product("Reti", 1000.0)
        );
    }

    private static List<Product> enrichProductData(List<Product> products){
        try{
            System.out.println("adding ratings to the products...");
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return products.stream().peek(p->p.setRating(Double.valueOf(new DecimalFormat("##.##").format(5*Math.random())))).toList();
    }

    private static List<Product> applyDiscount(List<Product> products){
        try{
            System.out.println("adding discount to the products...");
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return products.stream().peek(p->p.setPrice(p.getPrice()*0.8)).toList();
    }



    static class Product{
        private String name;
        private Double price;
        private Double rating;

        public Product(String name, Double price){
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", rating=" + rating +
                    '}';
        }
    }

}
