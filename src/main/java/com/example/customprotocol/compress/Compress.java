package com.example.customprotocol.compress;

import com.example.customprotocol.SPI;

/**
 * @Author cxr
 * @Date 2020/12/22 21:32
 */
@SPI
public interface Compress {

    byte[] compress(byte[] bytes);


    byte[] decompress(byte[] bytes);
}
