package com.example.customprotocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author cxr
 * @Date 2020/12/22 21:28
 */
@AllArgsConstructor
@Getter
public enum SerializationTypeEnum {

    KYRO((byte) 0x01, "kyro");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (SerializationTypeEnum c : SerializationTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
