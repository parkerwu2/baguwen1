package com.papa.baguwen1.baguwen1;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
class A extends Thread{
    private CountDownLatch cd;
    public A(CountDownLatch cd){
        this.cd = cd;
    }

    @Override
    public void run() {
        System.out.println("A is running");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
        } finally {
            synchronized (cd) {
                cd.countDown();
                cd.notify();
            }
        }
    }
}
class B extends Thread{
    private CountDownLatch cd;
    public B(CountDownLatch cd){
        this.cd = cd;
    }

    @Override
    public void run() {
        System.out.println("B is running");
        try {
            sleep(500);
            synchronized (cd) {
                cd.wait();
                cd.notify();
            }
            System.out.println("A is over");
        } catch (InterruptedException e) {
        }
    }
}
//双指针 力扣 11. 盛最多水的容器
public class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j){
            int len = Math.min(height[i], height[j]);
            int width = j - i;
            int sum = len * width;
            if (sum > area){
                area = sum;
            }
            if (height[i] <= height[j]){
                i++;
            } else {
                j--;
            }
        }
        return area;
    }


    public static void main(String[] args) {
//        int[] height = new int[]{1, 1};
//        System.out.println(new Solution().maxArea(height));
//        height = new int[]{1,8,6,2,5,4,8,3,7};
//        System.out.println(new Solution().maxArea(height));
//        Vector strList = new Vector();
//        strList.add("To");
//        strList.add("SAIC");
//        strList.add("Welcome");
//        System.out.println(listToString(strList));
        CountDownLatch cd = new CountDownLatch(1);
        B b = new B(cd);
        A a = new A(cd);
        a.start();
        b.start();
    }
    public static String listToString(Vector strList){
        String str = new String();
        SortedSet set = new TreeSet();
        set.addAll(strList);
        for (Iterator iter = set.iterator(); iter.hasNext();){
            String currStr = (String)iter.next();
            str += currStr + ";";
        }
        return str;
    }

}
