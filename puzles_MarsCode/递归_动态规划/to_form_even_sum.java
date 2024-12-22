package 递归_动态规划;
/**
 * 题目：小M面对一组从 1 到 9 的数字，这些数字被分成多个小组，并从每个小组中选择一个数字组成一个新的数。目标是使得这个新数的各位数字之和为偶数。
 * 任务是计算出有多少种不同的分组和选择方法可以达到这一目标。
 * numbers: 一个由多个整数字符串组成的列表，每个字符串可以视为一个数字组。小M需要从每个数字组中选择一个数字。
 * 例如对于[123, 456, 789]，14个符合条件的数为：147 149 158 167 169 248 257 259 268 347 349 358 367 369。
 * 
 */

public class to_form_even_sum { 

    //方法一:暴力解法
    // public static int solution1(int[] numbers) {
    //     // 将每个数字转换为字符串，形成数字组
    //     String[] groups = new String[numbers.length];
    //     for (int i = 0; i < numbers.length; i++) {
    //         groups[i] = String.valueOf(numbers[i]);
    //     }

    //     // 调用递归方法，计算符合条件的组合数
    //     return dfs(groups, 0, 0);
    // }

    // // 深度优先搜索方法
    // private static int dfs(String[] groups, int index, int currentSum) {
    //     // 如果遍历完所有组
    //     if (index == groups.length) {
    //         // 判断当前和是否为偶数
    //         return currentSum % 2 == 0 ? 1 : 0;
    //     }

    //     int count = 0;
    //     // 遍历当前组的每个数字
    //     for (char c : groups[index].toCharArray()) {
    //         int digit = c - '0'; // 转换为数字
    //         count += dfs(groups, index + 1, currentSum + digit);
    //     }
    //     return count;
    // }

    //方法二:优化解法
    public static int solution(int[] numbers) {
        // 将每个数字转换为字符串，形成数字组
        String[] groups = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            groups[i] = String.valueOf(numbers[i]);
        }

        // 调用递归方法，计算符合条件的组合数
        return dfs(groups, 0, 0);
    }

    // 深度优先搜索方法
    private static int dfs(String[] groups, int index, int currentSum) {
        // 如果遍历完所有组
        if (index == groups.length) {
            // 判断当前和是否为偶数
            return currentSum % 2 == 0 ? 1 : 0;
        }

        int count = 0;
        // 遍历当前组的每个数字
        for (char c : groups[index].toCharArray()) {
            int digit = c - '0'; // 转换为数字
            count += dfs(groups, index + 1, currentSum + digit);
        }
        return count;
    }

    public static void main(String[] args) {
        // 测试用的是第二个方法
        System.out.println(solution(new int[]{123, 456, 789}) == 14); // 示例1
        System.out.println(solution(new int[]{123456789}) == 4);      // 示例2
        System.out.println(solution(new int[]{14329, 7568}) == 10);   // 示例3
    }
}
