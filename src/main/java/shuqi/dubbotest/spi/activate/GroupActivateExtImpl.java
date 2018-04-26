package shuqi.dubbotest.spi.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author linyang on 18/4/20.
 */
@Activate(group = {"group1", "group2"})
public class GroupActivateExtImpl implements ActivateExt1 {
    public String echo(String msg) {
        return msg;
    }
}
