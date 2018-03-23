/*

48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, 
which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

*/

/*
首次做：发现(i,j) -> (j,n-1-i) -> (n-1-i,n-1-j) -> (n-1-j,i)-> (i,j)
比如，就是四个角的点互相替换，也就是说只需要操作矩阵的四分之一
注意奇偶略不同

不过似乎时间复杂度有一点高，操作次数有点多：
	1/2((n/2)^2+(n/2)*(n/2+1))*5 = 5(n^2/2+n/4)
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int ii = 0;
        int jj  =0;
        
        if(n%2==0){
            ii=jj=n/2;
        }else{
            ii = n/2;
            jj = n/2+1;
        }
        for(int i = 0; i < ii; i++){
            for(int j =0;j < jj; j++){
                int temp = matrix[i][j];
                
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
                
            }
        }
    }
}

/*
看了答案后，
发现 顺时针旋转有个结论：
	先以水平线上下做对称，再(i,j) <-> (j,i) 

 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3

计算复杂度低一些：
0.5*(n/2+n/2-1)*3+1/2(n-1)^2*3 = 3/2n(n-1)  < 5(n^2/2+n/4)=5/2n^2+5/4n

*/
class Solution {
    public void rotate(int[][] matrix) {
        int s = 0;
        int e = matrix.length-1;
        while(s<e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++;
            e--;
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j = i+1;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    
    }
}

