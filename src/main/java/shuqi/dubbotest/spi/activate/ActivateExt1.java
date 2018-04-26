package shuqi.dubbotest.spi.activate;

import com.alibaba.dubbo.common.extension.SPI;

@SPI("order1")
//@SPI
public interface ActivateExt1 {
    String echo(String msg);
}
