package shuqi.dubbotest.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author linyang on 18/4/20.
 */
@Activate(value = {"value1"}, group = {"value"})
public class ValueActivateExtImpl implements ActivateExt1 {
    public String echo(String msg) {
        return msg;
    }
}
