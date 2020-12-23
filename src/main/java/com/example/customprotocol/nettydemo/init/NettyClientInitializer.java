package com.example.customprotocol.nettydemo.init;

import com.example.customprotocol.codec.RpcMessageDecoder;
import com.example.customprotocol.codec.RpcMessageEncoder;
import com.example.customprotocol.nettydemo.handler.NettyClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Author cxr
 * @Date 2020/12/23 19:56
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("decoder", new RpcMessageDecoder());
        socketChannel.pipeline().addLast("encoder", new RpcMessageEncoder());
        socketChannel.pipeline().addLast(new NettyClientHandler());
    }
}

