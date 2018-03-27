/*
209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

*/

/*
一次就做出来的，但是循环条件改了半天，写法也不是很优雅
用两个pointer分别指示一个子串的首尾元素
hi 首先前进，直到区间sum>=s;
	lo接着前进，直到下一个位置时区间的sum<s;
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int lo = -1;
        int hi = -1;
        int sum = 0;
        int min = nums.length+1;
        while(hi+1<nums.length){
            // hi forwards
            hi = hi + 1;
            sum = sum + nums[hi]; 
            if(sum >= s){
                // lo forwards
                while(lo<hi){
                    if(sum - nums[lo+1] >= s){
                        lo = lo +1;
                        sum = sum - nums[lo];
                    }else{
                        if(min>hi-lo){
                            min = hi - lo;
                        }
                        break;
                    }
                }
            }    
        }
        if(min>nums.length){
            return 0;
        }
        return min;
    }
}

/*
看完答案写了一个优雅版本
hi++, 可以同时做到先取值后递增
Math.min 取小的值
min>nums.length?0:min; if else的简单写法
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int lo = 0;
        int hi = 0;
        int sum = 0;
        int min = nums.length+1;
        while(hi<nums.length){
            sum += nums[hi++];
            while(sum>=s){
                sum -= nums[lo++];
                min = Math.min(min, hi-lo+1);
            }
        }
        return min>nums.length?0:min;
        
    }
}