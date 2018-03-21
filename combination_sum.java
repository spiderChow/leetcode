/*

39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 

[
  [7],
  [2, 2, 3]
]

*/

// 没有自己一开始就做出来，看了讨论里面的答案后重新写了一遍
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret  = new ArrayList();
        stacktrace(ret, new ArrayList(), candidates, target, candidates.length-1);
        return ret;
    }
    public void stacktrace(List<List<Integer>> paths,List<Integer> stack,int[] nums,int remain,int index){
        // the path-tree grow from this step
        for(int i = index; i>=0;i--){
            // iterate all the possible node
            if(remain-nums[i]>0){
            	// continue the path
                stack.add(nums[i]);
                stacktrace(paths,stack,nums,remain-nums[i],i); 
                // after return, all the subtrees should be checked
                stack.remove(stack.size()-1);
            }else if(remain-nums[i]==0){
            	// get a correct path
                stack.add(nums[i]);
                paths.add(new ArrayList(stack)); 
                stack.remove(stack.size()-1);                
            }          
        }
    }
}

/*
List<List<Integer>> 这样的结构 放置每一个答案的可能
先将candidates排序(倒序？？)
不断的重复放置第i个元素，直到List<Integer>的和超过target,remove当前元素后放置下一个

一种回溯的机制：构建一条路径，往前走一步，如果没有办法走下去就只能回溯每一步
利用函数的statck来实现，所以使用的递归之类的操作

e.g.[2,3,6,7]

7->7->7
    ->6
 ->6->7
...
6->7
..
3
...
2
...

 不属于全排，因为不知道到底排列多少个元素；是一种遍历每一条可能路径的问题
--------
|7| stack top
--------

*/



