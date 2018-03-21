/**
*
*Given a collection of distinct numbers, return all possible permutations.
*
*For example,
*[1,2,3] have the following permutations:
*[
*  [1,2,3],
*  [1,3,2],
*  [2,1,3],
*  [2,3,1],
*  [3,1,2],
*  [3,2,1]
*]
*/

// solution 1.0
class Solution {
    /**
    *递归操作每个元素，使其插入之前元素全排序列的所有位置，新的序列重新放进buffer
    */
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        if(nums.length<=0){
            return null;
        }
        if(nums.length>0){
            List<Integer> l = new ArrayList();
            l.add(nums[0]);
            ret.add(l);
        }
        for(int i=1;i<nums.length;i++){
            int c = nums[i];      
            List<List<Integer>> newRet = new ArrayList();
            for(List<Integer> list : ret){
                int listLen = i;
                while(listLen>=0){
                    List<Integer> listCopy = listClone(list);
                    listCopy.add(listLen--,c);
                    newRet.add(listCopy);                    
                }
            } 
            ret = newRet;
            //printList(ret);
        }
        return ret;
    } 
    public  List<Integer> listClone(List<Integer> input){
        List<Integer> ret = new ArrayList();
        for(int i: input){
            ret.add(i);
        }
        return ret;
    }
}

/* solution 1.1 
    ArrayList(Collection<? extends E> c)
    Constructs a list containing the elements of the specified collection, 
    in the order they are returned by the collection's iterator.
使用Arraylist构造函数实现深拷贝
*/
class Solution {
    /**
    *递归操作每个元素，使其插入之前元素全排序列的所有位置，新的序列重新放进buffer
    */
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        if(nums.length<=0){
            return null;
        }
        if(nums.length>0){
            List<Integer> l = new ArrayList();
            l.add(nums[0]);
            ret.add(l);
        }
        for(int i=1;i<nums.length;i++){
            int c = nums[i];      
            List<List<Integer>> newRet = new ArrayList();
            for(List<Integer> list : ret){
                int listLen = i;
                while(listLen>=0){
                    List<Integer> listCopy = new ArrayList(list); // deep copy via constructor
                    listCopy.add(listLen--,c);
                    newRet.add(listCopy);                    
                }
            } 
            ret = newRet;
            //printList(ret);
        }
        return ret;
    }
    
}