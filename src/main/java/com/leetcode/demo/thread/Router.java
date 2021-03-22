package com.leetcode.demo.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/18 15:50
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class Router {
    private final String ip;
    private final Integer port;
    private final String iface;

    public Router(String ip, Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Router){
            Router r=(Router)obj;
            return iface.equals(r.iface) && ip.equals(r.ip) && port.equals(r.port);
        }
        return false;
    }

    public String getIp() {
        return ip;
    }

    public Integer getPort() {
        return port;
    }

    public String getIface() {
        return iface;
    }
}
