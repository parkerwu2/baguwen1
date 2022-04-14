package com.papa.baguwen1.baguwen1.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class PoolResource{
    private AtomicInteger atomicInteger = new AtomicInteger();
    private String message;
    public PoolResource(){
        message = String.valueOf(atomicInteger.incrementAndGet());
    }

    @Override
    public String toString() {
        return "PoolResource{" +
                "atomicInteger=" + atomicInteger +
                ", message='" + message + '\'' +
                '}';
    }
}
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<>();
    private volatile boolean[] checkedOut;
    private Semaphore availabe;
    public Pool(Class<T> classObject, int size){
        this.size = size;
        checkedOut = new boolean[size];
        availabe = new Semaphore(size, true);
        for (int i = 0; i < size; i++){
            try {
                items.add(classObject.newInstance());
            } catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
    public T checkOut() throws InterruptedException {
        availabe.acquire();
        return getItem();
    }
    public void checkIn(T x){
        if (releaseItem(x)){
            availabe.release();
        }
    }
    private synchronized T getItem(){
        for (int i = 0; i < size; i++){
            if (!checkedOut[i]){
                checkedOut[i]  = true;
                return items.get(i);
            }
        }
        return null;
    }
    private synchronized  boolean releaseItem(T item){
        int index = items.indexOf(item);
        if (index == -1){
            return false;
        }
        if (checkedOut[index]){
            checkedOut[index] = false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Pool<PoolResource> pool = new Pool(PoolResource.class, 2);
        for (int i = 0; i < 5; i++){
            new Thread(()-> {
                try {
                    PoolResource it = pool.checkOut();
                    System.out.println(Thread.currentThread() + ":" + it + "," + System.currentTimeMillis());
                    Thread.sleep(1000);
                    pool.checkIn(it);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
