/*
47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

// 回溯法总是要变通的啊喂，用bitmap来记住是否使用过
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        traceback(ret,new ArrayList(), nums, used);
        return  ret; 
    }
    
    
    public void traceback(List<List<Integer>> paths,ArrayList<Integer> stack,int[] nums, boolean[] used){
        if(stack.size()==nums.length){
            paths.add(new ArrayList(stack));
            return;
        }
        // the loop in the same method is for the new subtree equallly 
        for(int i=0;i<nums.length;i++){
            if((!used[i]) ){
                if(i>=1&&nums[i-1]==nums[i]&&!used[i-1]){
                    continue;
                }
                stack.add(nums[i]);
                used[i] = true;
                traceback(paths,stack,nums,used); // the new method is for the subtree growth
                stack.remove(stack.size()-1);
                used[i] = false;
            }
        }
    }
}