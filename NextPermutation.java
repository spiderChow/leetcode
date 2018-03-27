/*
31. Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

/*
从后往前遍历，直到遇到不是降序的位置i-1 i.e.，nums[i-1]<nums[i] ，然后交换 nums[i-1]与后面比她大的最小的值，然后将>=i 
部分整个reverse

*/

class Solution {
    public void nextPermutation(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;
        for(int i=nums.length-1; i>=0 ; i--){
        	//search from the end for the dec position
            if(i-1>=0 && nums[i-1]< nums[i]){
                //swap the nums[i-1] and least larger than nums[i-1]
                int small = nums[i-1];
                int index = i;
                while(++index<nums.length)
                {
                    if(nums[index]<=small){ 
                        break;
                    }  
                } 
                int temp = nums[index-1];
                nums[index-1] = nums[i-1];
                nums[i-1] = temp;
                lo = i;
                break;
                
                
            }
        }
        //reverse among [lo,hi]
        while(lo<hi){   
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            hi--;
            lo++;
        }
    }
}