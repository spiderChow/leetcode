/*

300. Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

*/

/*
my first subission:
	一个辅助数组，记录左边递增数列的长度
	aux_(len-1) = 0;
	aux_i = 递归nums[i]右边所有的比它大的元素，找到aux_j最大的值为max
		aux_i = max + 1
	

*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] aux= new int[nums.length];
        for(int i =nums.length-1;i>=0;i--){
            
            int max = 0;
            for(int j =i+1;j<nums.length;j++){
                
                if(nums[i]<nums[j]){
                    if(max<aux[j]+1){
                        max = aux[j]+1;
                    }
                }
            }
            aux[i]=max;
        }
        int max=0;
        for(int i =0;i<aux.length;i++){
            if(max<aux[i]){
                max = aux[i];
            }
        }
        return max+1;
    }
}