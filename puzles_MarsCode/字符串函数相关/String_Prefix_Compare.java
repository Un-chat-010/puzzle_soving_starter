package 字符串函数相关;
/**
 * 小U和小R有两个字符串，分别是S和TT，现在小U需要通过对S进行若干次操作，使其变成T的一个前缀。
 * 操作可以是修改S的某一个字符，或者删除S末尾的字符。
 * 现在你需要帮助小U计算出，最少需要多少次操作才能让S变成T的一个前缀。
 * 
 * 误区：
 * 想要让S完全匹配T
 * 过度关注字符串的相似度
 * 没有抓住"前缀"这个核心概念
 * 
 * 要点：
 * 1. 只需要变成前缀，不需要完全匹配
 * 2. 操作只有两种：修改字符 + 删除末尾
 * 
 * 处理：
 * 1. 在最小长度（S和T之间更短的那个）内找到S第一个不匹配T的索引
 * 2. 计算需要删除的次数
 * 3. 计算需要修改的次数
 * 4. 返回需要删除和修改的次数之和
 */

public class String_Prefix_Compare {
    public static int solution(String S, String T) {
        int operations = 0;
        int minLength = Math.min(S.length(), T.length());
        
        // 计算需要多少次修改操作
        for (int i = 0; i < minLength; i++) {
            if (S.charAt(i) != T.charAt(i)) {
                operations++;
            }
        }
        
        // 如果S比T长，需要删除多余的字符
        if (S.length() > minLength) {
            operations += S.length() - minLength;
        }
        
        return operations;
    }

    /**
     * 测试
     * 
        solution("abcd", "efg") == 4
        ```
        S: "abcd"
        T: "efg"
        比较：
        a != e  (操作+1)
        b != f  (操作+2)
        c != g  (操作+3)
        d 需要删除 (操作+4)
        结果：4次操作
        ```

                
        ### 4. `solution("hello", "helloworld") == 0`
        ```
        S: "hello"
        T: "helloworld"
        比较：
        h == h
        e == e
        l == l
        l == l
        o == o
        结果：0次操作（S已经是T的前缀）
        ```

                
        ### 7. `solution("bbbabaaaaa", "baaabaaabaaaba") == 3`
        ```
        S: "bbbabaaaaa"
        T: "baaabaaabaaaba"
        比较：
        b == b
        b != a  (操作+1)
        b != a  (操作+2)
        a == a
        b == b
        a == a
        a == a
        a == a
        a != b  (操作+3)
        a == a
        结果：3次操作
        ```

     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution("aba", "abb") == 1);
        System.out.println(solution("abcd", "efg") == 4);
        System.out.println(solution("xyz", "xy") == 1);
        System.out.println(solution("hello", "helloworld") == 0);
        System.out.println(solution("same", "same") == 0);
        System.out.println(solution("y", "nhs") == 1);  
        System.out.println(solution("bbbabaaaaa", "baaabaaabaaaba") == 3);

    }
    

}

