package com.leetcode.demo.array;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * @Date: 2020/12/24 9:35
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 0, 2};
        candy(ratings);


    }

    /**
     * 算法思路：如果当前同学比上一个同学评分高，说明我们就在最近的递增序列中，直接分配给该同学 pre+1 个糖果即可。
     * <p>
     * 否则我们就在一个递减序列中，我们直接分配给当前同学一个糖果，并把该同学所在的递减序列中所有的同学都再多分配一个糖果，以保证糖果数量还是满足条件。
     * <p>
     * 我们无需显式地额外分配糖果，只需要记录当前的递减序列长度，即可知道需要额外分配的糖果数量。
     * <p>
     * 同时注意当当前的递减序列长度和上一个递增序列等长时，需要把最近的递增序列的最后一个同学也并进递减序列中。
     *
     * 这样，我们只要记录当前递减序列的长度 dec，最近的递增序列的长度 inc 和前一个同学分得的糖果数量 pre 即可。
     */
    private static int candy(int[] ratings) {
        int ret = 1;
        int pre = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                pre = pre + 1;
                ret = ret + pre;
            } else {

            }
        }
        return ret;
    }
}
