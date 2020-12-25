package com.example.customprotocol.nettydemo;

import com.example.customprotocol.constants.RpcConstants;
import com.example.customprotocol.dto.RpcMessage;
import com.example.customprotocol.dto.RpcRequest;
import com.example.customprotocol.enums.CompressTypeEnum;
import com.example.customprotocol.enums.SerializationTypeEnum;
import com.example.customprotocol.nettydemo.init.NettyClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author cxr
 * @Date 2020/12/23 19:56
 */
@Slf4j
public class NettyClient {

    public void start() {
        RpcRequest rpcRequest = new RpcRequest().builder()
                .group("test2").interfaceName("iiiii").build();
        RpcMessage rpcMessage = new RpcMessage();
        rpcMessage.setData(rpcRequest);
        rpcMessage.setCodec(SerializationTypeEnum.KYRO.getCode());
        rpcMessage.setCompress(CompressTypeEnum.GZIP.getCode());
        rpcMessage.setMessageType(RpcConstants.REQUEST_TYPE);

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                //该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
                .option(ChannelOption.TCP_NODELAY, false)
                .channel(NioSocketChannel.class)
                .handler(new NettyClientInitializer());

        try {
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8090).sync();
            log.info("客户端成功....");
            //发送消息
            future.channel().writeAndFlush(rpcMessage);
            // 等待连接被关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }
}

