package JianzhiOffer;
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
// 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
public class isNumeric_54 {
    public  boolean isNumeric(char[] str) {
        // null 或者空字符串
        if (str == null || str.length == 0) {
            return false;
        }
        int len = str.length;
        // 字符串长0角标
        int index = 0;
        if (str[index] == '+' || str[index] == '-')
            index++;
        if (index == len)
            return false;
        // 扫描数字,并返回扫描到第一个非数字的字符的角标
        // 符号位之后出现整数，小数点，e/E，都可以
        index = scanDigit(str, index);
        // 纯数字
        if (index == len)
            return true;
        // .2 或者 +.2 或者 +.e2的情况
        if (str[index] == '.') {
            index++;
            if (index > len)
                return false;
            index = scanDigit(str, index);
            // 纯小数
            if (index == len)
                return true;
            // 小数点之后是科学计数法
            if (str[index] == 'e' || str[index] == 'E')
                return isExp(str, index);
        }
        // 科学计数法
        else if (str[index] == 'e' || str[index] == 'E') {
            return isExp(str, index);
        } else
            return false;

        return false;
    }

    // 是不是科学计数法
    public boolean isExp(char[] str, int index) {
        if (str[index] != 'e' && str[index] != 'E') {
            return false;
        }
        index++;
        if (index >= str.length)
            return false;
        if (str[index] == '+' || str[index] == '-')
            index++;
        if (index >= str.length)
            return false;
        index = scanDigit(str, index);
        if (index < str.length)
            return false;
        else
            return true;
    }

    // 扫描字符串中的数字，并返回遇到的第一个不是数字的字符的角标
    public int scanDigit(char[] str, int index) {
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return index;
    }

}