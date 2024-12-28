package 字符串函数相关;

import java.util.HashMap;

/**
 * 小U得到一个只包含小写字母的字符串 S。她可以执行如下操作：
 * 每次选择字符串中两个相同的字符删除，然后在字符串末尾添加一个任意的小写字母。
 * 小U想知道，最少需要多少次操作才能使得字符串中的所有字母都不相同？
 */

public class find_pairs {
        //方法一：数组
        public static int solution1(String S) {
            // 1. 创建数组记录每个字母出现次数
            int[] count = new int[26];  // 相当于26个计数器
            
            // 2. 统计每个字母出现次数
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                // 比如'a'的次数存在count[0],'b'的次数存在count[1]
                count[c - 'a']++; 
            }
            
            // 3. 计算需要的操作次数
            int operations = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] > 1) {  // 如果某个字母出现超过1次
                    operations += count[i]  / 2;  // 需要操作的次数
                }
            }
            
            return operations;
        }


        //方法二：哈希表
        public static int solution(String S) {
            // 创建一个HashMap，用来存储<字母, 出现次数>
            HashMap<Character, Integer> letterCount = new HashMap<>();
            
            // 遍历字符串中的每个字母
            for (char c : S.toCharArray()) {
                // 如果这个字母已经在HashMap中，就把它的次数加1
                // 如果不在，就把它放入HashMap，次数设为1
                if (letterCount.containsKey(c)) {
                    letterCount.put(c, letterCount.get(c) + 1);
                } else {
                    letterCount.put(c, 1);
                }
            }
            
            // 计算需要的操作次数
            int operations = 0;
            // 遍历HashMap中所有的次数
            for (int count : letterCount.values()) {
                // 如果某个字母出现超过1次
                if (count > 1) {
                    // 需要(出现次数/2)次操作
                    operations += count  / 2;
                }
            }
            
            return operations;
        }
    
        public static void main(String[] args) {
            // 测试用例
            System.out.println("abab的结果: " + solution("abab"));     // 应该是2
            System.out.println("aaaa的结果: " + solution("aaaa"));     // 应该是2
            System.out.println("abcabc的结果: " + solution("abcabc")); // 应该是3
        }

}
