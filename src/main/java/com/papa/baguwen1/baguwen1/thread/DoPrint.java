package com.papa.baguwen1.baguwen1.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoPrint {
    private int number = 1;//A:1  B:2  C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printA(){
        lock.lock();
        try {
            while (number != 1){
                c1.await();
            }
            for (int i = 0; i < 1; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            number = 2;
            c2.signal();
        } catch (Exception  e){
            System.out.println("printA exp=" + e.getMessage());
        } finally {
            lock.unlock();
        }

    }

    public void printB(){
        lock.lock();
        try {
            while (number != 2){
                c2.await();
            }
            for (int i = 0; i < 2; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            number = 3;
            c3.signal();
        } catch (Exception  e){
            System.out.println("printB exp=" + e.getMessage());
        } finally {
            lock.unlock();
        }

    }

    public void printC(){
        lock.lock();
        try {
            while (number != 3){
                c3.await();
            }
            for (int i = 0; i < 3; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            number = 1;
            c1.signal();
        } catch (Exception  e){
            System.out.println("printC exp=" + e.getMessage());
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        DoPrint resource = new DoPrint();

        new Thread(()->{
            for (int i = 1; i <= 2; i++) {
                resource.printA();
            }
        },"A").start();


        new Thread(()->{
            for (int i = 1; i <= 2; i++) {
                resource.printB();
            }
        },"B").start();


        new Thread(()->{
            for (int i = 1; i <= 2; i++) {
                resource.printC();
            }
        },"C").start();
    }
}
