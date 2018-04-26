package shuqi.dubbotest.spi.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;

/**
 * @author linyang on 18/4/20.
 */
//@Adaptive
public class ThriftAdaptiveExt2 implements AdaptiveExt2 {

    public String echo(String msg, URL url) {
        return "thrift";
    }
}
