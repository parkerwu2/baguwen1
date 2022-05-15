package com.papa.baguwen1.baguwen1.algorithm;

import java.util.Arrays;

public class QuickSort {

    /**
     * 实现快速排序，以最后一个数为基值
     *
     * @param arr   需要排序的数组
     * @param begin 数组的开始位置
     * @param pivot 基值下标
    **/
    public static void quickSort(int[] arr, int begin, int pivot){
        //判断数组长度是否大于1
        if (pivot <= begin){
            //如果数组长度小于等于1则返回数组
            return;
        } else {
            //如果数组长度大于1
            //先数组进行分组，比基值小的放左边，大的放右边
            int middle = division(arr, begin, pivot);
            //对比基值小的数进行快速排序
            quickSort(arr, begin, middle - 1);
            //对比基值大的数进行快速排序
            quickSort(arr, middle + 1, pivot);
        }
    }

    /**
     * 定义一个方法将数组进行分组，以最后一个数为基值，比基值小的放左边，大的放右边
     *
     * @param arr   需要进行分组的数组
     * @param begin 数组的开始位置
     * @param pivot 基值下标
     * @return
     */
    private static int division(int[] arr, int begin, int pivot) {
        //左指针
        int left = begin;
        //右指针
        int right = pivot - 1;
        while (true) {
            //从arr[left]开始遍历找到一个比arr[pivot]大的数
            while (arr[left] < arr[pivot]) {
                left++;
            }
            //从arr[right]开始反向遍历找到一个比arr[pivot]小的数
            while (arr[right] > arr[pivot] && right > 0) {
                right--;
            }
            //判断左右指针是否交叉
            if (left >= right) {
                //交叉则退出循环
                break;
            } else {
                //未交叉则交换arr[left]和arr[right]的位置
                swap(arr, left, right);
                //交换位置之后左指针右移，右指针左移
                left++;
                right--;
            }
        }
        //左右指针交叉之后说明已经遍历完一遍，这时把arr[pivot]与arr[left]交换位置把基值放到中间
        swap(arr, left, pivot);
        //这时比arr[pivot]小的全在左边，大的全在右边
        //此时返回arr[pivot]的下标，它的下标为left，
        // swap(arr[pivot],arr[left])这一步只是交换了它们的值，与下标无关，所以下标还是原来arr[left]的下标
        return left;
    }
    public static void main (String[]args){
        int[] arr1 = new int[]{3, 35, 33, 36, 42, 10, 141, 19, 27, 44, 26, 55};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }
    /**
        * 定义一个方法来交换数组中的两个值
       * @param arr   数组
     * @param left  第一个值
     * @param right 第二个值
    ***/
    private static void swap ( int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
