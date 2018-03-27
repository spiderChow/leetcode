/*
35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

*/

/*
这是学习了二分查找法之后，第二天早上拿个简单的题目练手用的。

1. mid = lo + (hi-lo)/2 中位数 不要(a+b)/2会溢出
2. low > high 才是终结条件 
3. low一直在朝着第一个目标数的位置在逼近。知道最终到达。


*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi =  nums.length-1;
        int mid = lo ;
        
        
        /*
        case 1: lo == hi --> ok
        case 2: lo + 1 == hi --> case 1;
        case 3: lo + 2 == hi --> case 2; case 1;
        */
        
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(nums[mid]<target){
                lo = mid + 1;
            }
            else if(target<nums[mid]){
                hi = mid -1;
            }else{
                return mid;
            }
        }
        
        return lo;
    }
}