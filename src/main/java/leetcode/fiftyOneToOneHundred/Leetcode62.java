package leetcode.fiftyOneToOneHundred;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/27 9:27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode62 {

    public static void main(String[] args) {
        uniquePaths(3,7);
    }

    public static int uniquePaths(int m, int n) {
        int[][] f=new int[m][n];
        for(int i=0;i<m;++i){
            f[i][0]=1;
        }
        for(int i=0;i<n;++i){
            f[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                f[i][j]=f[i-1][j]+f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }



}
