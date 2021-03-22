package com.leetcode.demo.thread;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/19 16:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NettyTest {

    public static void main(String[] args) {
        //事件处理器
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        //boss线程组 处理网络连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //worker线程组  处理读写请求默认2*cpu核数
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(echoServerHandler);
                        }
                    });
            //bind服务端端口
            ChannelFuture f = bootstrap.bind(9090).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }


    }
}
