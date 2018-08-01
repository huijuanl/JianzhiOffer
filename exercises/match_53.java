package JianzhiOffer;
/*

1>pattern下一个字符不为‘*’：这种情况比较简单，直接匹配当前字符。如果
 匹配成功，继续匹配下一个；如果匹配失败，直接返回false。注意这里的
 “匹配成功”，除了两个字符相同的情况外，还有一种情况，就是pattern的
  当前字符为‘.’,同时str的当前字符不为‘\0’。
2>pattern下一个字符为‘*’时，稍微复杂一些，因为‘*’可以代表0个或多个。
 这里把这些情况都考虑到：
 a>当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，
  跳过这个‘*’符号；
 b>当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符
  不变。（这里匹配1个或多个可以看成一种情况，因为：当匹配一个时，
  由于str移到了下一个字符，而pattern字符不变，就回到了上边的情况a；
  当匹配多于一个字符时，相当于从str的下一个字符继续开始匹配）
 */
//请实现一个函数用来匹配包括'.'和'*'的正则表达式。
//模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
//在本题中，匹配是指字符串的所有字符匹配整个模式。
//例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
//递归实现
public class match_53 {
    public boolean match(char[] str, char[] pattern) {
        if(str==null||pattern==null)
            return false;
        return matchCore(str,0,pattern,0);

    }
    public boolean matchCore(char[]str,int a ,char[]pattern,int b){
        //有效性检验：str到尾，pattern到尾，匹配成功
        if(a==str.length&&b==pattern.length)
            return true;
        //pattern先到尾，匹配失败
        if(a!=str.length&&b==pattern.length)
            return false;
        if(b<pattern.length-1&&pattern[b+1]=='*'){
            if((pattern[b]=='.'&&a!=str.length)||(a!=str.length&&pattern[b]==str[a]))
                return matchCore(str,a,pattern,b+2)//模式后移2，视为x*匹配0个字符
                ||matchCore(str,a+1,pattern,b)//*匹配1个，再匹配str中的下一个
                ||matchCore(str,a+1,pattern,b+2);////视为模式匹配1个字符
            else return matchCore(str,a,pattern,b+2);
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if((pattern[b]=='.'&&a!=str.length)||(a!=str.length&&pattern[b]==str[a]))
            return matchCore(str,a+1,pattern,b+1);
        else return false;

    }
}
