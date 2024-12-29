/**
 * 小S正在玩一个关于石子的游戏，给定了一些石子，它们位于一维数轴的不同位置，位置用数组 stones 表示
 * 如果某个石子处于最小或最大的一个位置，我们称其为端点石子。
 * 在每个回合，小S可以将一颗端点石子移动到一个未占用的位置，使其不再是端点石子。
 * 游戏继续，直到石子的位置变得连续，无法再进行任何移动操作。
 * 你需要帮助小S找到可以移动的最大次数。
 */
package 字符串函数相关;

import java.util.Arrays;

public class move_continuously {

    //错误的方法（找最长间隔）
    public static int solutionError(int[] stones) {
        // 次数
        int times = 0;
        // 排序
        Arrays.sort(stones);
        // 判断退出的条件
        int n = stones.length - 1;
        int max = stones[n];
        int min = stones[0];

        // 数组连续则退出，times为0
        if (max - min <= n) {
            return 0;
        }

        // 构造辅助数组，用于存储部分有序的值
        int[] sort = new int[n]; // 数组大小设置为 n（去掉两端）
        sort[0] = stones[1];
        int validCount = 1; // 记录 `sort` 中有效元素的个数

        for (int i = 1; i < n; i++) {
            if (stones[i + 1] - sort[validCount - 1] == 1 || stones[i + 1] - sort[validCount - 1] == -1) {
                sort[validCount] = stones[i + 1];
                validCount++; // 增加有效元素的计数
            }
        }

        // 对 `sort` 有效部分进行排序
        int[] validSort = Arrays.copyOfRange(sort, 0, validCount);
        Arrays.sort(validSort);

        // 计算最大移动位置（大-小的差）
        if (stones[0] - validSort[0] > max) {
            max = stones[0] - validSort[0];
        }
        times = max;

        return times;
    }


    //别人的方法
    public static int solution(int[] stones) {
        // 数量小于3时，无法移动任一端点石子
        if (stones.length < 3) return 0;
        // 排序
        Arrays.sort(stones);
        int res = 0;
        // 记录左右端点，方便取最值
        int l = 0, r = 0;
        for (int i = 1; i < stones.length; i++) {
            // 左端点
            if (i == 1) l = stones[i] - stones[i - 1] - 1;
            // 右端点
            else if (i == stones.length - 1) r = stones[i] - stones[i - 1] - 1;
            // 非端点，直接统计
            else res += stones[i] - stones[i - 1] - 1;
        }
        // 返回结果
        return res + Math.max(l, r);
    }
    

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 4, 9}) == 2);
        System.out.println(solution(new int[]{6, 5, 4, 3, 10}) == 3);
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}) == 0);
        System.out.println(solution(new int[]{2, 7, 12, 13, 15}) == 8);
    }
}
