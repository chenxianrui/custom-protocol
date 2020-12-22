package com.example.customprotocol;

import java.lang.annotation.*;

/**
 * @Author cxr
 * @Date 2020/12/22 21:31
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SPI {
}
