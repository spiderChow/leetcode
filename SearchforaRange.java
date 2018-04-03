/*
34. Search for a Range
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

/*
好难好难
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[]  ret = new int[]{-1,-1};
        if(nums.length==0){
            return ret;
        }
        int lo = 0;
        int hi = nums.length-1;
        /*
        
        case 1: lo + 1 == hi -->lo==hi; lo==hi ; lo==hi
        case 2: lo + 2 == hi --> case 1; case 1; ok
        case 4: lo + 3 == hi --> case 2; case 1;ok
        
        */
        while(lo<hi){
            int mid = lo + (hi-lo)/2;  // make return the first euql one
            if(nums[mid] < target){
                lo = mid +1;
            }else{
                hi = mid;  
            }
        }
        if(target!=nums[lo]){
            return ret;
        }else{
            ret[0] = lo;
        }
        hi = nums.length-1;
        while(lo<hi){
            int mid = lo + (hi-lo+1)/2;  // make return the first euql one
            if(nums[mid]>target){
                hi = mid-1;
            }else{
                lo = mid; 
            }
        }
        if(lo==hi){
            ret[1] = hi;
        }
        return ret;   
    } 
}