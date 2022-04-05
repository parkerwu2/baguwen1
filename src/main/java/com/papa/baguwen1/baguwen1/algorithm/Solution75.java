package com.papa.baguwen1.baguwen1.algorithm;

//75. 颜色分类
public class Solution75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] == 0){
                a++;
            } else if (nums[i] == 1){
                b++;
            } else {
                c++;
            }
        }
        for (int i = 0; i < a;  i++){
            nums[i] = 0;
        }
        for (int i = a; i < a + b; i ++){
            nums[i] = 1;
        }
        for (int i = a + b; i < a + b + c; i ++){
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int [] a = new int[]{2,0,2,1,1,0};
        new Solution75().sortColors(a);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

    }
}
