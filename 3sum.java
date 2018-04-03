/*
15. 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
/*
三个指针，index 遍历所有，然后每次遍历设置lo = index+1,hi=length-1
sum 大了 hi--;
sum小了 lo++;
else 一个答案

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> paths = new ArrayList();
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(i>=1&&nums[i-1]==nums[i]){
                continue;
            }
            int lo = i+1;
            int hi = nums.length-1;
            while(lo<hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if(sum >0){
                    hi--;
                }else if(sum<0){
                    lo++;
                }else{
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    paths.add(temp);
                    while(lo<hi && nums[lo]==nums[lo+1]){
                        lo++;
                    }
                    while(lo<hi && nums[hi]==nums[hi-1]){
                        hi--;
                    }
                    lo++;
                    hi--;
                    
                }
            }
        }
        return paths;
    }
    
    
}