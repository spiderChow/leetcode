/*
3.Longest Substring Without Repeating Characters


Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


*/

/*
用高低两个指针夹住一段无重复的区域

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int lo = 0, hi = lo;
        Set<Character> set = new HashSet();
        while(hi<s.length()){
            if(!set.add(s.charAt(hi))){
                ret = Math.max(ret,hi-lo);
                while(s.charAt(lo)!=s.charAt(hi)){
                    set.remove(s.charAt(lo++));
                }
                lo++;  
            }
            hi++;
        }
        ret = Math.max(ret,hi-lo);
        return ret;
    }
}