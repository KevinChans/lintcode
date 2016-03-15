# LintCode
推荐大家一个刷题的网站http://www.lintcode.com/    
我现在正在整理上面的题目,以此锻炼和提高提高自己的逻辑思维,解题能力.
### Section String
##### 1. 题目:No426-恢复IP地址
>描述:给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
样例:给出字符串 "25525511135"，所有可能的IP地址为(顺序无关紧要)
    [
      "255.255.11.135",
      "255.255.111.35"
    ]
分析题目:
输入:字符串(一串数字)    
输出:字符串数组(IP地址字符串数组)    
条件:输出的字符串数组中,每一项符合IP地址的条件,即对于每一个以点分隔的数字范围必须在
0<=x<=255之间,且需要注意的是1.00.0.0属于不合法的IP.

解题思路:    
分析可知,以上问题可以换个思路理解为:需要在输入字符串中添加3个点来组成IP地址,添加每个点
之后需要保证以点隔开的数字的范围在0-255之间,且不存在00这样的数字.
考虑使用递归来实现,分别将3个点插入字符串.    
[1] 递归函数
```java
/**
 * input  输入字符串,需要在其中添加点
 * output 输出字符串,最后需要添加到list中的值
 * k      需要在input中添加的点的个数
 */
public void addDot(String input,String output,int k);
```
[2] 跳出递归函数的条件
```java
if(k == 0){
    //a. k等于0说明,字符串input为ip地址中最后一个需要添加的数字,需要判断其合法性
    //b. 判断合法性包括两部分,数字的范围(0-255)和数字的合法性(02为不合法数字)
    //c. 如果合法则将字符串input添加到output末尾,并且将其添加到list中
    //d. 如果不合法直接return
}
```
[3] 递归函数体
```java
if(k > 0){
    //e. 判断首字符的合法性
    //f. 针对每次递归的输入字符串input,分别在每个字符后面添加点(分别尝试在前三个字符后面添加点)
    //g. 添加点之后判断添加点之后数字value的合法性
    //h. 如果value合法,output+=(value+"."),递归调用addDot();
    //i. 如果value不合法,return
}
```
经过以上分析代码如下:
```java
/**
 * Created by Kevin on 3/15/16.
 * <p/>
 * 详见 http://www.lintcode.com/zh-cn/problem/restore-ip-addresses
 * 根据输入的字符串恢复ip地址
 * @author Kevin
 */
public class Solution {
    private static ArrayList<String> arrayList = new ArrayList<String>();
    private static final char ZERO_VALUE = '0';
    private static final char DOT = '.';
    private static final int IP_LENGTH = 3;
    
    public void addDDDot(String input,String output,int k){
        if(k < 0 || input.equals("")){
            return;
        }
        //a
        if(k == 0){
            //b
            if(input.charAt(0) == ZERO_VALUE && input.length() != 1){
                //d
                return;
            }
            //c
            int value = Integer.valueOf(input);
            if(value >= 0 && value <= 255){
                output += input;
                arrayList.add(output.toString());
            }
        }
        if(k > 0){
            //e
            if(input.charAt(0) == ZERO_VALUE){
                output = output + ZERO_VALUE + DOT;
                addDDDot(input.substring(1,input.length()),new String(output),--k);
            }else{
                //f
                int m = --k;
                for(int i = 1;i <= IP_LENGTH && i <= input.length();i++){
                    int value= Integer.valueOf(input.substring(0, i));
                    //g
                    if(value >= 0 && value <= 255){
                        //h
                        addDDDot(input.substring(i,input.length()),output + value + DOT,m);
                    }else{
                        //i
                        return;
                    }
                }
            }
        }
    }
    public void printResult(){
        System.out.println("The result is:");
        arrayList.forEach(System.out::println);
    }
    
    public ArrayList<String> restoreIpAddresses(String s) {
        addDDDot(s, "", 3);
        return arrayList;
    }
}
```