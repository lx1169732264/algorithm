package algorithm;

/**
 * 基数排序     一种非比较排序算法
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
 * 基数排序的方式可以采用LSD/MSD
 * LSD的排序方式由键值的最右边开始，而MSD则相反，由键值的最左边开始
 *
 * @author lx
 */
public class RadixSort {

    //d表示最大的数有多少位
    public static void sort(int[] number, int d) {
        //控制排序依据在哪一位(个十百千)
        int n = 1, m = 1;
        //数组的第一维表示余数0-9
        int[][] temp = new int[10][number.length];
        //统计数组第一维已插入元素的个数
        int[] count = new int[10];
        while (m <= d) {
            for (int num : number) {
                int i = ((num / n) % 10);
                temp[i][count[i]] = num;
                count[i]++;
            }

            for (int i = 0; i < 10; i++) {
                int index = 0;
                if (count[i] != 0) {
                    for (int j = 0; j < count[i]; j++) {
                        number[index] = temp[i][j];
                        index++;
                    }
                }
                count[i] = 0;
            }
            n *= 10;
            m++;
        }
    }
}