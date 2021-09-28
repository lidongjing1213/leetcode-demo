package leetcode.zeroToFifty;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/27 9:26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode49 {

    public static void main(String[] args) {
        String[] strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] newStr=str.toCharArray();
            Arrays.sort(newStr);
            String string=String.valueOf(newStr);
            if(map.containsKey(string)){
               map.get(string).add(str);
            }else{
                List<String>  list=new ArrayList<>();
                list.add(str);
                map.put(string,list);
            }
        }

        result.addAll(map.values());
        return result;
    }
}
