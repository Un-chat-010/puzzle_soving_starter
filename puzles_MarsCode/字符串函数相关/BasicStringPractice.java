package 字符串函数相关;

/**
 * 字符串处理的基础练习
 * 包含常见的字符串操作和示例
 */
public class BasicStringPractice {
    
    // 1. 字符和ASCII码转换示例
    public static void charAsciiDemo(char c) {
        System.out.println("字符: " + c);
        System.out.println("ASCII码: " + (int)c);
        System.out.println("ASCII码97转回字符: " + (char)97);  // 'a'
    }
    
    // 2. 大小写转换示例
    public static void caseConversionDemo(char c) {
        // 大写转小写
        char lower = (char)(c + ('a' - 'A'));
        // 小写转大写
        char upper = (char)(c - ('a' - 'A'));
        System.out.println("原字符: " + c);
        System.out.println("转换后: " + lower + " 或 " + upper);
    }
    
    // 3. 字符类型判断
    public static void charTypeCheck(char c) {
        boolean isLower = (c >= 'a' && c <= 'z');
        boolean isUpper = (c >= 'A' && c <= 'Z');
        boolean isDigit = (c >= '0' && c <= '9');
        
        System.out.println("字符 '" + c + "' 是:");
        System.out.println("小写字母? " + isLower);
        System.out.println("大写字母? " + isUpper);
        System.out.println("数字? " + isDigit);
    }
    
    // 4. 判断回文串
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // 5. 判断变位词（两个字符串包含相同的字符，但顺序可能不同）
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int[] count = new int[26];  // 假设只包含小写字母
        
        // 统计第一个字符串中字符出现次数
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        
        // 减去第二个字符串中字符出现次数
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // 测试字符和ASCII码转换
        System.out.println("=== 字符和ASCII码转换 ===");
        charAsciiDemo('a');
        
        // 测试大���写转换
        System.out.println("\n=== 大小写转换 ===");
        caseConversionDemo('A');
        
        // 测试字符类型判断
        System.out.println("\n=== 字符类型判断 ===");
        charTypeCheck('a');
        charTypeCheck('A');
        charTypeCheck('5');
        
        // 测试回文串判断
        System.out.println("\n=== 回文串判断 ===");
        System.out.println("'radar' 是回文串? " + isPalindrome("radar"));
        System.out.println("'hello' 是回文串? " + isPalindrome("hello"));
        
        // 测试变位词判断
        System.out.println("\n=== 变位词判断 ===");
        System.out.println("'listen' 和 'silent' 是变位词? " + 
            isAnagram("listen", "silent"));
        System.out.println("'hello' 和 'world' 是变位词? " + 
            isAnagram("hello", "world"));
    }
} 