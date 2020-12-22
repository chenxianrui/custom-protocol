package com.example.customprotocol;

/**
 * @Author cxr
 * @Date 2020/12/22 21:33
 */
@SPI
public interface Serializer {

    /**
     * 序列化
     *
     * @param obj 要序列化的对象
     * @return 字节数组
     */
    byte[] serialize(Object obj);

    /**
     * 反序列化
     *
     * @param bytes 序列化后的字节数组
     * @param tClass 目标类
     * @param <T> 类的类型
     * @return 反序列化对象
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
