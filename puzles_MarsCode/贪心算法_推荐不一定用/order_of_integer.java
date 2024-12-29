/**
 * 小C现在有一个长度为n的数组 a_1,a_2,...,a_n，她希望通过操作，使得这个数组出现至少一个逆序对。
 * 每次操作可以选择以下两种方式之一：
 * 选择一个元素 a_i，对其加上 x。
 * 选择一个元素 a_i，对其减去 y。
 * 她想知道，至少需要多少次操作才能确保数组中出现一个逆序对。逆序对的定义是，存在下标对 (i, j) 满足 1 ≤ i < j ≤ n 且 a_i > a_j。
 */

package 贪心算法_推荐不一定用;


import java.util.*;

public class order_of_integer {

    public static int solution(int n, int x, int y, List<Integer> a) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        // 次数
        int times = 0;
        // 上一个数与最小间隔（默认最大值：0到10）
        int curIn = 0;
        int min = 10;
        // 遍历当前每个元素
        for (int laIn : a) {
            // 如果下一组间隔小于0，存在逆序对则退出，记0次
            if (laIn - curIn < 0) {
                return 0;
            } else
            // 如果下一组间隔大于0，且小于默认间隔，则更新最小间隔
            if (laIn - curIn < min) {
                min = laIn - curIn;
            }
            curIn = laIn;
        }
        // 根据公式,ai - aj > 0 这时候不用算直接退出
        // (ai + x) - (aj - y) > 0时可以算出(ai - aj)+(x + y)>0
        // 不能int op = x + y;因为一次操作只能用一个数，要分开算
        while (min >= 0) {
            min -= x;
            times++;
            if ( min < 0 ){
                break;
            }
            min -= y;
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1, 2, Arrays.asList(1, 3, 5)) == 2);
        System.out.println(solution(4, 5, 7, Arrays.asList(4, 6, 10, 9)) == 0);
        System.out.println(solution(5, 3, 2, Arrays.asList(7, 7, 7, 7, 7)) == 1);
    }

}
