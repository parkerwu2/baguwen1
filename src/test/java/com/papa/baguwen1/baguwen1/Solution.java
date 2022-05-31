package com.papa.baguwen1.baguwen1;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        CountDownLatch cd = new CountDownLatch(1);
//        B b = new B(cd);
//        A a = new A(cd);
//        a.start();

//        b.start();
//       Map<String, String> map =  new HashMap<String, String>();
//       map.put(null, null);
//       Map<String, String> map2 = new ConcurrentHashMap<>();
//       map2.put(null, null);
//        String str = new String("good");
//        String str1 = "good";
//        String str2 = "good";
//            System.out.println(str==str1);//输出为false
//            System.out.println(str2==str1);//输出为true

        List<String> strings = Arrays.asList("六脉神剑",  "大神3", "小菜鸡", "交流群：549684836");
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
        //六脉神剑,大神 , 小菜鸡,交流群：549684836
        Stream<Integer> distinct = strings.stream().filter(string -> string.length() <= 6).map(String::length).sorted().limit(2)
                .distinct();
//        System.out.println(distinct.collect(Collectors.maxBy(Integer::compareTo)).orElse(0));
        Map<Object, List<Integer>> collectGroup = distinct.collect(Collectors.groupingBy(i -> i + 1));
        System.out.println(collectGroup);

        Stream<Integer> distinct2 = strings.stream().map(String::length).sorted();
        System.out.println(distinct2.collect(Collectors.groupingBy(i -> i)));
//        distinct.forEach(System.out::println);
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
