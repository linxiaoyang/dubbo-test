package com.shuqi.dubbotest.spi;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import shuqi.dubbotest.spi.adaptive.AdaptiveExt2;

/**
 * @author linyang on 18/4/18.
 */
public class AdaptiveTest {

    /**
     * @SPI("dubbo") 如果在spi中没有体现，那么需要在url中有所体现
     */
    @Test
    public void test1() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());
        URL url = URL.valueOf("test://localhost/test?adaptive.ext2=cloud");
        System.out.println(adaptiveExtension.echo("d", url));
    }


    /**
     * @SPI + URL 的链接中增加指定的参数
     */
    @Test
    public void test2() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());
        URL url = URL.valueOf("test://localhost/test?adaptive.ext2=dubbo");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * 通过制定的扩展的名称获取
     */
    @Test
    public void test3() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        //可以通过指定名称来动态切换需要的类
        AdaptiveExt2 adaptiveExtension = loader.getExtension("cloud");
        System.out.println(adaptiveExtension.getClass());
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * @SPI + 增加了一个新类，使用@Adaptive注解修饰，使用@Adaptive注解的类
     */
    @Test
    public void test4() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        //可以通过指定名称来动态切换需要的类
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * @SPI("dubbo") + 增加了一个新类，使用@Adaptive注解修饰，使用@Adaptive注解的类
     */
    @Test
    public void test5() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        //可以通过指定名称来动态切换需要的类
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    //结论：使用@Adaptive注解的类，优先使用。如果没有修饰的，使用spi指定的默认的那个

    /**
     * @SPI("dubbo") 默认的就是dubbo
     */
    @Test
    public void test6() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        System.out.println(loader.getDefaultExtensionName());
    }


    /**
     * @SPI("dubbo")
     * @Adaptive({"t"})
     */
    @Test
    public void test7() {
        URL url = URL.valueOf("test://localhost/test?t=cloud");
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        //可以通过指定名称来动态切换需要的类
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());
        System.out.println(adaptiveExtension.echo("d", url));
    }


}
