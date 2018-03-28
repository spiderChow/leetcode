/*
43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/


/*

1. 首先n位和m位的数相乘，最大可得到n*m位的数

2.
	1	2
x	3	4
----------
	4	8
3	6
----------
4	0	8
对于每两个元素，比如，1和3，相乘之后得到的值3放在百分位上，距离数组的末尾有两个空位
即num1[i]  
  num2[j]  
  那么 (num1[i]*num2[j])%10 放在 i+j+1位置
  注意进位，进位的那个直接加1就可以，不用模十，因为倒着处理的，以后还要处理到那个元素

3. 还要判断有一个乘数是零的情况

*/
class Solution {
    public String multiply(String num1, String num2) {
        
        
        char[] cnum1 = num1.toCharArray();
        char[] cnum2 = num2.toCharArray();
        if(cnum1.length==1&&cnum1[0]-'0'==0){
            return new String("0");
        }
        if(cnum2.length==1&&cnum2[0]-'0'==0){
            return new String("0");
        }
        
        int[] ret = new int[cnum1.length+cnum2.length];
        
        for(int i =cnum1.length-1;i>=0;i--){
            
            for(int j =cnum2.length-1;j>=0;j--){
                int p = i+j+1;
                int delt = new Integer(cnum1[i]-'0')*new Integer(cnum2[j]-'0');//
                int old = ret[p];// 必须先提出来，因为一会要改变
                ret[p] = (old+delt)%10;
                ret[p-1] += (old+delt)/10;
                
            }
        }
        char[] cret = new char[ret.length];
        for(int i = 0;i<cret.length;i++){
            cret[i] = Character.forDigit(ret[i], 10);; 
        }
        
        String result = new String(cret);
        return ret[0]==0?result.substring(1,result.length()):result;
    }
}

/*
 看了答案后，发现有些java的操作不熟悉
 1. String 里面取出对应位置的char： char c = s.charAt(9);
 2. char ‘9’ 变成 int 9: int ic = c-'0';
 3. 对字符串进行修改的时候要用StringBuilder 类
 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
 然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。

	StringBuffer sb = new StringBuffer("菜鸟教程官网：");
    sb.append("www");
    sb.append(20); // 还可以添加int double char 等类型
	int len = sb.length();
	String s = sb.toString();
    System.out.println(sb);
*/
class Solution {
    public String multiply(String num1, String num2) {
        int[] ret = new int[num1.length()+num2.length()];  
        for(int i =num1.length()-1;i>=0;i--){
            for(int j =num2.length()-1;j>=0;j--){ 
                int p = i+j+1;
                int delt = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int old = ret[p];
                ret[p] = (old+delt)%10;
                ret[p-1] += (old+delt)/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: ret){
            if(i==0&&sb.length()==0){
                continue;
            }
            sb.append(ret[i]);
        }
        return sb.length()==0?"0":sb.toString();
    }
}