package leetcode;


/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/23 19:58
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode243 {
    public static void main(String[] args) {
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(wordsDict, "makes", "coding"));


    }

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (word1.equals(wordsDict[i])) {
                  i1=i;
            }else if(word2.equals(wordsDict[i])){
                i2=i;
            }
            if(i1!=-1 && i2!=-1){
                min=Math.min(min,Math.abs(i1-i2));
            }
        }
        return min;
    }
}
