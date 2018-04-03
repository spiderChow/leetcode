/*
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]



*/

/*
使用bitmap这种思想来记录某个元素是否使用过，用于区别当前操作是新增一个subtree 还是沿着旧的path继续生长，
同时判别上一个操作的元素与本元素是否相同，以防止重复的答案发生

backtrace 其实是深度优先算法

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> paths = new ArrayList();
        List<Integer> stack = new ArrayList();
        boolean[] used = new boolean[candidates.length];
        traceback(paths,stack, candidates, candidates.length-1,  target,used);
        return paths;
    }
    
    public void traceback(List<List<Integer>> paths,List<Integer> stack, int[] nums, int index, int target,boolean[] used){
    
        for(int i=index;i>=0;i--){
            if(i<nums.length-1&&nums[i]==nums[i+1]&&!used[i+1]){
                continue;
                
            }
            
            if(nums[i]>target){
                continue;
                
            }else if(nums[i]==target){
                stack.add(nums[i]);
                paths.add(new ArrayList(stack));
                stack.remove(stack.size()-1);
            }else{
                stack.add(nums[i]);
                used[i] = true;
                traceback( paths,stack, nums, i-1, target-nums[i],used);
                stack.remove(stack.size()-1);
                used[i] = false;
            }
        }
    }
    
}

/*
答案的操作也不错，区别在于是先进stack再判断本次进站是否合理，还是判断之前进站，显然后者会快一些。

*/
public List<List<Integer>> combinationSum2(int[] cand, int target) {
    Arrays.sort(cand);
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    dfs_com(cand, 0, target, path, res);
    return res;
}
void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
    if (target == 0) {
        res.add(new ArrayList(path));
        return ;
    }
    if (target < 0) return;
    for (int i = cur; i < cand.length; i++){
        if (i > cur && cand[i] == cand[i-1]) continue;
        path.add(path.size(), cand[i]);
        dfs_com(cand, i+1, target - cand[i], path, res);
        path.remove(path.size()-1);
    }
}