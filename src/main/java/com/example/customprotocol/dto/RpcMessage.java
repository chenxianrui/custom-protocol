package com.example.customprotocol.dto;

import lombok.*;

/**
 * @Author cxr
 * @Date 2020/12/22 21:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcMessage {

    //rpc 消息类型
    private byte messageType;
    //序列化类型
    private byte codec;
    //压缩类型
    private byte compress;
    //request id
    private int requestId;
    //request data
    private Object data;

}
