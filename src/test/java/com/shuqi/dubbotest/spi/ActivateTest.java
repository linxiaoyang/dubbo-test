package com.shuqi.dubbotest.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import shuqi.dubbotest.spi.activate.ActivateExt1;

import java.util.List;


/**
 * @author linyang on 18/4/18.
 */
public class ActivateTest {

    /**
     * 默认实现
     */
    @Test
    public void testDefault() {
        ExtensionLoader<ActivateExt1> loader = ExtensionLoader.getExtensionLoader(ActivateExt1.class);
        URL url = URL.valueOf("test://localhost/test");
        //他会去加载默认的实现 根据default_group 查找对应的实现方法
        List<ActivateExt1> list = loader.getActivateExtension(url, new String[]{}, "default_group");
        //activateext1impl1-----------@com.alibaba.dubbo.common.extension.Activate(after=[], before=[],        value=[], order=0, group=[default_group])
        //找到key了再用spi找到对应的实现类
        System.out.println(list.size()); // 1
        // com.alibaba.dubbo.common.extensionloader.activate.impl.ActivateExt1Impl1
        System.out.println(list.get(0).getClass());
    }


    /**
     * group 实现的测试
     */
    @Test
    public void testGroup() {
        URL url = URL.valueOf("test://localhost/test");
        // group == group1  或者 group2
        List<ActivateExt1> list = ExtensionLoader.getExtensionLoader(ActivateExt1.class).getActivateExtension(url, new String[]{}, "group2");
        //group-----------@com.alibaba.dubbo.common.extension.Activate(after=[], before=[], value=[], order=0, group=[group1, group2])
        System.out.println(list.size());
        //com.alibaba.dubbo.common.extensionloader.activate.impl.GroupActivateExtImpl
        System.out.println(list.get(0).getClass());
    }


    /**
     * 测试 testValue
     */
    @Test
    public void testValue() {
        URL url = URL.valueOf("test://localhost/test");
        //根据   key = value1,group =  value
        //@Activate(value = {"value1"}, group = {"value"})来激活扩展
        url = url.addParameter("value1", "123");
        List<ActivateExt1> list = ExtensionLoader.getExtensionLoader(ActivateExt1.class).getActivateExtension(url, new String[]{}, "value");
        //value-----------@com.alibaba.dubbo.common.extension.Activate(after=[], before=[], value=[value1], order=0, group=[value])
        System.out.println(list.size());
        //com.alibaba.dubbo.common.extensionloader.activate.impl.ValueActivateExtImpl
        System.out.println(list.get(0).getClass());
    }


    /**
     * 测试 testOrder
     * 测试多group = order
     * 其中 int order() default 0;  排序字段
     */
    @Test
    public void testOrder() {
        URL url = URL.valueOf("test://localhost/test");
        List<ActivateExt1> list = ExtensionLoader.getExtensionLoader(ActivateExt1.class).getActivateExtension(url, new String[]{}, "order");
        //order1-----------@com.alibaba.dubbo.common.extension.Activate(after=[], before=[], value=[], order=2, group=[order])
        //order2-----------@com.alibaba.dubbo.common.extension.Activate(after=[], before=[], value=[], order=1, group=[order])
        System.out.println(list.size());
        //com.alibaba.dubbo.common.extensionloader.activate.impl.OrderActivateExtImpl2  因为order = 1，先输出
        System.out.println(list.get(0).getClass());
        //com.alibaba.dubbo.common.extensionloader.activate.impl.OrderActivateExtImpl1 order = 2
        System.out.println(list.get(1).getClass());
    }
}
