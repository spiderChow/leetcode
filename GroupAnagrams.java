/*
49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

*/

/*
看了眼答案，基本思想很像，但我就是没有记得用HashMap



使用HashMap,

HashMap<String, Integer> map = new HashMap<String, Integer>();
map.put("生物", 7);
map.put("化学", 8);
for(Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}


map.values(); return the Collection of the value
map.get(keys); return the value

String.valueOf(); // make other types into string

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList();
        
        Map<String, List<String>> map = new HashMap();
        
        for(String s:strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String news = String.valueOf(cs);
            
            if(map.containsKey(news)){
                // if the map has the kep , than add element in the value array
                map.get(news).add(s);
            }else{
                 // else contain new entry with the <news, new ArrayList()>
                List<String> list = new ArrayList();
                list.add(s);
                map.put(news,list);
            }       
        }
        
        for(List<String> list: map.values()){
            ret.add(list);
        }
        return ret;
    }
}