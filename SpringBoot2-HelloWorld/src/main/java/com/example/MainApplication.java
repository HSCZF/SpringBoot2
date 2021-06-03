package com.example;

import ch.qos.logback.core.db.DBHelper;
import com.example.bean.Pet;
import com.example.bean.User;
import com.example.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类：启动类所在的包是最顶部的包，
 * 也不能直接放在main/java文件下，
 * 启动类所在的包是最顶部的包，
 * springboot 的启动类必须要放在其他包的外层。
 *
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // 启动主类，固定写法
        // SpringApplication.run(MainApplication.class, args);
        // 1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

//        // 2、查看容器里面的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//
//        // 3、从容器中获取组件
//        Pet pet1 = run.getBean("pet1", Pet.class);   // 自定义@bean名
//        Pet pet2 = run.getBean("pet1", Pet.class);   // 多次获取验证组件是否为单实例的，打印true就是
//        System.out.println("组件：" + (pet1 == pet2));
//
//        MyConfig myConfig = run.getBean(MyConfig.class);
//        // 4、myConfig：com.example.config.MyConfig$$EnhancerBySpringCGLIB$$1e2f259b@7ea4d397
//        System.out.println("myConfig：" + myConfig);
//
//        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
//        // 保持组件单实例
//        User user = myConfig.userTest();
//        User user1 = myConfig.userTest();
//        System.out.println("user和user1比较："+(user == user1));
//
//        User user2 = run.getBean("userTest", User.class);
//        Pet pet = run.getBean("pet1", Pet.class);
//        System.out.println("用户的宠物："+(user2.getPet() == pet));
//
//        // 5、获取组件: 测试MyConfig中的@Import
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("========================================================================");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        DBHelper dbHelper = run.getBean(DBHelper.class);
//        System.out.println(dbHelper);

    }
}
