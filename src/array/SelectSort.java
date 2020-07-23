package array;

import java.util.Arrays;

/**
 * 选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕
 *
 * @author boss
 */
public class SelectSort {
    public static void sort(int[] arr) {
        //temp用户替换数
        int temp, minIndex, i, j;
        for (i = 0; i < arr.length - 1; i++) {
            // 认为目前的数就是最小的, 记录最小数的下标
            minIndex = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 修改最小值的下标
                    minIndex = j;
                }
            }
            // 最小值找到了,看看下标是否就是之前定的最小下表
            if (i != minIndex) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0, 9, 1};
        SelectSortTest selectSortTest = new SelectSortTest();
        selectSortTest.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
