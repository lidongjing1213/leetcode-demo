package leetcode.zeroToFifty;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 14:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuffer(),0,0,n);
        return result;
    }

    public void  backtrack( List<String> result,StringBuffer stringBuffer,int open,int close,int max){
        if(stringBuffer.length()==max*2){
            result.add(stringBuffer.toString());
            return;
        }
        if(open<max){
            stringBuffer.append('(');
            backtrack(result,stringBuffer,open+1,close,max);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if(close<open){
            stringBuffer.append(')');
            backtrack(result,stringBuffer,open,close+1,max);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }
}
