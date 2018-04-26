package shuqi.dubbotest.spi.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author linyang on 18/4/20.
 */
public class DubboAdaptiveExt2 implements AdaptiveExt2 {

    public String echo(String msg, URL url) {
        return "dubbo";
    }
}
