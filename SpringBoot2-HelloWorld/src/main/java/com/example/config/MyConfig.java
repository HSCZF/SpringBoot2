package com.example.config;


import ch.qos.logback.core.db.DBHelper;
import com.example.bean.Car;
import com.example.bean.Pet;
import com.example.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Configuration: 告诉SpringBoot这是一个配置类 == 配置文件
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法，默认为true
 * Full(proxyBeanMethods = true)  【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 * Lite(proxyBeanMethods = false)  【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖
 * 组件依赖必须使用Full模式默认。其他默认是否Lite模式
 * 4、@Import({User.class, DBHelper.class})
 * 给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
 * 5、@EnableConfigurationProperties(Car.class)：
 * 开启Car配置属性功能
 * 把这个Car这个组件自动注册到组件中
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * userTest：bean.xml下配置的id
     * 自定义组件名可以这样写：@Bean("uu")
     *
     * @return
     * @Bean：给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值，就是组件在容器中的实例 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     */
    @Bean
    public User userTest() {
        User user = new User("张三", 18);
        user.setPet(petTest());
        return user;
    }

    /**
     * petTest：bean.xml下配置的id
     *
     * @return
     * @Bean：给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值，就是组件在容器中的实例
     */
    @Bean("pet1")
    public Pet petTest() {
        return new Pet("宠物");
    }


}
