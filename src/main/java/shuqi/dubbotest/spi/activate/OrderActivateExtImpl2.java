package shuqi.dubbotest.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author linyang on 18/4/20.
 */
@Activate(order = 1, group = {"order"})
public class OrderActivateExtImpl2 implements ActivateExt1 {
    public String echo(String msg) {
        return msg;
    }
}
