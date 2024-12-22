package 递归_动态规划.字符串函数相关;

public class Number_Format {

    
    public static String solution(String s) {
        // 去掉前导零
        s = s.replaceFirst("^0+", "");

        // 如果处理后是空字符串，则说明原输入是“0”或“0000”
        if (s.isEmpty()) {
            return "0";
        }

        // 分离整数部分和小数部分
        String integerPart = s;
        String decimalPart = "";

        // 判断是否有小数部分
        if (s.contains(".")) {
            String[] parts = s.split("\\.");
            integerPart = parts[0];
            decimalPart = parts[1];
        }

        // 对整数部分进行千分位格式化
        StringBuilder formattedIntegerPart = new StringBuilder();
        int count = 0;

        // 从后往前处理整数部分，添加逗号
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) {
                formattedIntegerPart.insert(0, ",");
            }
            formattedIntegerPart.insert(0, integerPart.charAt(i));
            count++;
        }

        // 如果有小数部分，拼接整数部分和小数部分
        if (!decimalPart.isEmpty()) {
            return formattedIntegerPart + "." + decimalPart;
        } else {
            return formattedIntegerPart.toString();
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }

    

}
