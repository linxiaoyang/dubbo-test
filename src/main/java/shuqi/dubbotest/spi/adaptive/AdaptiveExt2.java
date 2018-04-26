package shuqi.dubbotest.spi.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

//@SPI
@SPI("dubbo")
public interface AdaptiveExt2 {
    /**
     * Can not create adaptive extenstion interface shuqi.dubbotest.spi.adaptive.AdaptiveExt2, cause:
     * No adaptive method on extension shuqi.dubbotest.spi.adaptive.AdaptiveExt2, refuse to create
     * the adaptive class!
     *
     * @param msg
     * @return
     */
    @Adaptive({"t"})
//    @Adaptive
    String echo(String msg, URL url);
}
