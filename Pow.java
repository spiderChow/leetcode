/*
50. Pow(x, n)

Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100

*/

/*
注意n可能为负数
Integer.MAX_VALUE = 2147483647
Integer.MIN_VALUE = -2147483648

一个一个乘过去会发生超时的现象,减少计算可以只计算一半，x^n = (x^n/2)*(x^n/2)
Recursion 需要base case, 这里就是n = 0的时候ret = 1;
*/
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        } 
        if(n<0){
            n = -n;
            x = 1/x;
        }
          
        
        if(n%2==0){
            double half = myPow(x,  n/2);
            return half*half;
        }else{
            double half = myPow(x,  n/2);
            return half*half*x;
        }
    }
}