/*
16. 3Sum Closest

Given an array S of n integers, 
find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

/*
用高低指针似乎可以减少一层n的复杂度


看了答案才写出来的：
先将nums排序
答案使用三个指针指着三个位置：current, start, end
current 是从头开始向后，start从current+1 开始向后，end 从nums.length-1 开始向前

若 sum > target 则 end--; 若 sum < target 则 start++;

每一步都要判断 |sum-target| 是否变小，若是则更新result的值。


Arrays.sort(nums); //对nums进行排序
Math.abs(); 绝对值



*/


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int delt = Integer.MAX_VALUE;
        int ret = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i =0;i<nums.length-2;i++){
            int start = i+1, end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum>target){
                    end--;
                }else if(sum<target){
                    start++;
                }else{
                    return target;
                }
                
                int thisDelt = sum > target? sum - target: target-sum;
                delt = thisDelt>delt ? delt : thisDelt;
                ret = thisDelt>delt ? ret : sum;
                
                
                
            }
        }
        return ret;
    }
}