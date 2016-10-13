package com.le.matrix.template;

import com.le.matrix.template.facade.HelloWorld5Facade;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by linzhanbo on 2016/10/10.
 */
public class TestConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-context.xml"});
        context.start();
        HelloWorld5Facade wfacade = (HelloWorld5Facade) context.getBean("helloWorld5Service");
        String result = wfacade.sayHello("Tom");
        System.out.println("result:" + result);
        System.out.println("Press any key to exit.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
