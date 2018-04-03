/*
17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

 "1",   "abc", "def",
"ghi",  "jkl", "mno", 
"pqrs", "tuv", "wxyz"
		 "0"


*/

/*
胡乱做的，就做出来了
遇到什么全部排列的事情就会想用backtrace O(n*3^n)

*/
class Solution {
    char[][] matrix = new  char[10][];
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList();
        }
        List<String> ret = new ArrayList();
        
        matrix[0] = new char[]{' '};
        matrix[1] = new char[]{' '};
        matrix[2] = new char[]{'a','b','c'};
        matrix[3] = new char[]{'d','e','f'};
        matrix[4] = new char[]{'g','h','i'};
        matrix[5] = new char[]{'j','k','l'};
        matrix[6] = new char[]{'m','n','o'};
        matrix[7] = new char[]{'p','q','r','s'};
        matrix[8] = new char[]{'t','u','v'};
        matrix[9] = new char[]{'w','x','y','z'};
        
        backtrace(ret, new char[digits.length()],  digits,0);
        return ret;
        
    }
    
    public void backtrace(List<String> ret, char[]cs, String digits,int index){
        if(index == digits.length()){
            ret.add(String.valueOf(cs));
            return;
        }
        int d = digits.charAt(index)-'0';
        cs[index] = ' ';
        for(int j = 0;j<matrix[d].length;j++){
            cs[index] = matrix[d][j];
            backtrace(ret, cs, digits, index+1);
        }
        
    }
}

/*
看了答案，用了一个新的数据结构，LinkedList
LinkedList提供了队列，栈，双端队列的操作
与ArrayList相比，LinkedList插入和删除更加高效，但是随机访问慢
Queue 接口:
boolean offer(E e) 插入队列的尾部，成功则true
E poll() 获取并移除队列头部元素，若为空则返回null
E peek() 获取但不移除队列头部元素，如果队列为空则返回null

Deque接口：
boolean offerFirst(E e) 将元素插入双端队列的头部
boolean offerLast(E e) 将元素插入双端队列的尾部
E pollFirst()
E pollLast()
E peekFirst()
E peekLast()

*/

class Solution {
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new LinkedList();
        }
        // take advantages of the length
        LinkedList<String> fifo = new LinkedList();
        fifo.add("");
            
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        for(int i=0;i<digits.length();i++){
            int d = digits.charAt(i)-'0';
            while(fifo.peek().length()==i){
                String map = mapping[d];
                String e = fifo.poll();
                for(int j = 0;j<map.length();j++){
                    fifo.offer(e+map.charAt(j));
                }
            }
        }
        return fifo;
        
    }
    
    
}