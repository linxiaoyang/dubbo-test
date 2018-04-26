package shuqi.dubbotest.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author linyang on 18/4/20.
 */
@Activate(group = {"default_group"})
public class ActivateExt1Impl1 implements ActivateExt1 {

    public String echo(String msg) {
        return msg;
    }
}
