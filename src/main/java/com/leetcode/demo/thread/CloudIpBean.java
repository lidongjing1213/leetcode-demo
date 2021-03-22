package com.leetcode.demo.thread;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/15 11:11
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CloudIpBean implements Serializable {
    @Excel(name = "oldIp",orderNum="0")
    private String oldIp;
    @Excel(name = "newIp",orderNum="1")
    private String newIp;

    public String getOldIp() {
        return oldIp;
    }

    public void setOldIp(String oldIp) {
        this.oldIp = oldIp;
    }

    public String getNewIp() {
        return newIp;
    }

    public void setNewIp(String newIp) {
        this.newIp = newIp;
    }
}
