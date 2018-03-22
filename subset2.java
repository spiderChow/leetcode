/*

90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/


// 学习过backtrace后，没有看答案 直接做的
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> paths = new ArrayList();
        paths.add(new ArrayList());
        traceback(paths,new ArrayList(),nums,0);
        return paths;
    }
    
    
    public void traceback(List<List<Integer>> paths,List<Integer> stack,int[] nums,int index){
        
        int c=nums[0]-1;// make inital c is not the same as any element in nums
        for(int i = index;i<nums.length;i++){
            if(c == nums[i]){
                
                continue;
            }
            c = nums[i];
            stack.add(nums[i]);
            paths.add(new ArrayList(stack));
            traceback(paths,stack,nums,i+1);
            stack.remove(stack.size()-1);
            
        }
        
    }
}

/*
1. 由于有重复元素，每次从当前节点生长子树的时候，都要判断是否和上个‘儿子’的值相同，如果相同跳过这个元素。
每次操作一个元素的时候都要记录这个stack作为答案。

2. 不要忘记空集

3.backtrace: must add and then remove (dont forget remove)

*/
