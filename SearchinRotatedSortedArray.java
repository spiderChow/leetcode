/*

33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

// 看了答案
/*
首先找到最小值的位置
然后再利用二分查找法找到target

*/
class Solution {
    public int search(int[] nums, int target) {
        // find the smallest one
        int lo=0;
        int hi=nums.length-1;
        
        // if lo = hi -1 then the smallest is at lo=hi
        // if lo =hi-2 and nums[mid]>nums[hi] then lo=hi
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>nums[hi]){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        
        /*
		case 1: lo = hi
			mid = lo = hi 
		case 2: lo+1 = hi
			mid = lo 
			if A[mid]>t then hi=mid-1  --> 跳出循环
			if A[mid]<t then lo = mid+1=hi --> case 1
		case 3: lo + 2 = hi
			mid = lo + 1
			if A[mid]>t then hi=mid-1=lo  --> case 1
			if A[mid]<t then lo = mid+1=hi --> case 1



        */
        int small = hi;
        lo=0;
        hi = nums.length-1;
        while(lo<=hi){
            int mid  = (lo+hi)/2;
            int realmid =(mid+small)%nums.length;
            if(nums[realmid]==target){
                return realmid;
            }
            if(nums[realmid]>target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return -1;
        
        
        
    }   
}