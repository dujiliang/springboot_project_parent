package com.yunbao.poolexecutor.future;

import org.springframework.beans.BeanUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: djl
 * @Date: 2020/6/2 15:22
 * @Version 1.0
 */
public class FutureTest {

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executorService.submit(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 1;
//        });
//        System.out.println(future.get());
//        System.out.println("finished");




        Long productId = 1L;
        Product pro = new Product();
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(()->{
            Product product = Product.builder().brand("百事").id(productId).build();
            //System.out.println(product.toString());
            return product;
        },executorService).thenAccept(product -> {
            product.setName("可乐");
            //System.out.println(product.toString());
            BeanUtils.copyProperties(product, pro);
        });


        System.out.println("ddd" + pro.toString());
        future.get();
        System.out.println("ddd" + pro.toString());
    }
}
