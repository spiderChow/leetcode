/*
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 

Example:

Input: "cbbd"

Output: "bb"


*/

/*看了答案才最后把题目完成，因为不知道如何让函数记住substring，如果只是返回最长的长度就应该可以直接写出来了
记住substring，也可以用s.substring(low,low+maxLen),并不是一定要记住两个lo 和 hi
不过那个样子也可以，可以用一个全局的maxlen控制是否更新,然后还要记住的是一个全局的lo 和 hi
*/
class Solution {
    int maxLen = 0;
    int low = 0;
        
    public String longestPalindrome(String s) {
        
        for(int i=0;i<s.length();i++){
            int lo = i;
            int hi = i;
            aux(s, i, i);
            aux(s, i, i+1);
            
        
        }
        return s.substring(low,low+maxLen);
    }
    
    public void aux(String s, int lo, int hi){
        while(hi<s.length() && lo>=0 && s.charAt(lo)==s.charAt(hi)){
                lo--;
                hi++;
            
            int len = hi - lo - 1;
            if(maxLen<len){
                low = lo+1;
                maxLen = len;
            }
        }
    }
}