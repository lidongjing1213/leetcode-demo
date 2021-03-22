package com.leetcode.demo;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/9 14:24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Test {
    //库存上限
    private final AtomicLong upper=new AtomicLong(0);
    //库存下限
    private final AtomicLong lower=new AtomicLong(0);

    void setUpper(long v){
        upper.set(v);
    }

    void setLower(long v){
        lower.set(v);
    }

}
