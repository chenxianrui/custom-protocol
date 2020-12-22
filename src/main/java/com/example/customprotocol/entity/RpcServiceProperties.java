package com.example.customprotocol.entity;

import lombok.*;

/**
 * @Author cxr
 * @Date 2020/12/22 21:25
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcServiceProperties {

    /**
     * 服务版本号
     */
    private String version;

    private String group;
    private String serviceName;

    public String toRpcServiceName(){
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }
}
