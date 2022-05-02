package com.papa.baguwen1.baguwen1.algorithm;

//324. 摆动排序 II 桶排序
public class Solution324 {
    public void wiggleSort(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] bucket = new int[max + 1];
        for (int num : nums) {
            bucket[num]++;
        }
        int len = nums.length;
        int k = max;
        for (int i = 1; i < len; i+=2){
            while (bucket[k] == 0){
                k--;
            }
            nums[i] = k;
            bucket[k]--;
        }
        for (int i = 0; i < len; i+=2){
            while (bucket[k] == 0){
                k--;
            }
            nums[i] = k;
            bucket[k]--;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[] {1,5,1,1,6,4};

        new Solution324().wiggleSort(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
        num =  new int[] {1,3,2,2,3,1};
        new Solution324().wiggleSort(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
