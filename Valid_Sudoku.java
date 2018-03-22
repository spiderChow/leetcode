/*
36. Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

//其实就是检查`已经填上去`的数字是否满足，每一行每一列每一个sub-box，1-9z只出现过一次
*/

// 看了答案才写的一个
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            HashSet<Character> col = new HashSet();
            HashSet<Character> row = new HashSet();
            HashSet<Character> box = new HashSet();
            for(int j=0;j<9;j++){
                
                if(board[i][j]!='.'&&!row.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!col.add(board[j][i])){
                    return false;
                }
                int starti = 3*(i%3);
                int startj = 3*(i/3);
                int deli = j/3;
                int delj = j%3;
                if(board[starti+deli][startj+delj]!='.'&&!box.add(board[starti+deli][startj+delj])){
                    return false;
                }
            }
        }
        return true;
    }
}
/*
希望一次遍历O(n^2)就可以解决问题
(i,j)元素，遍历一行的时候利用set检查是否重复；
同时(j,i)可以检查一列；
我们也希望可以检查一个3x3f方格：
	(3*(i%3),3*(i/3)) 分别是每一个方格的第一个元素的位置
	每一个方格遍历9个元素 （3*(i%3)+j/3, 3*(i/3)+j%3）

HashSet<E> 的add方法可以返回bool值，若有重复，则会返回false；

*/