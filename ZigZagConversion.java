/*
6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

*/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int N = (numRows-1)*2;
        for(int i=0;i<numRows;i++){
            
            if(i==0||i==numRows-1){
                int j = i;
                while(j<s.length()){
                    sb.append(s.charAt(j));
                    j = j+N;
                }
            }else{
                int j = i;
                while(j<s.length()&&j+N-2*i<s.length()){
                    sb.append(s.charAt(j));
                    sb.append(s.charAt(j+N-2*i));
                    j = j+N;
                }
                if(j<s.length()){
                    sb.append(s.charAt(j));
                }
            }
            
            
            
        }
        return sb.toString();
        
    }
}