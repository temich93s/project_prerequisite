package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloworld1 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println("helloworld1 message: " + helloworld1.getMessage());
        HelloWorld helloworld2 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println("helloworld2 message: " + helloworld2.getMessage());
        System.out.println("(helloworld1 == helloworld2) is " + (helloworld1 == helloworld2));

        Cat cat1 = applicationContext.getBean(Cat.class);
        cat1.setMessage("Meow1!");
        System.out.println("cat1 message: " + cat1.getMessage());
        Cat cat2 = applicationContext.getBean(Cat.class);
        cat2.setMessage("Meow2!");
        System.out.println("cat2 message: " + cat2.getMessage());
        System.out.println("(cat1 == cat2) is " + (cat1 == cat2));

        Dog dog1 = applicationContext.getBean(Dog.class);
        System.out.println("dog1 message: " + dog1.getMessage());
        Dog dog2 = applicationContext.getBean(Dog.class);
        System.out.println("dog2 message: " + dog2.getMessage());
        System.out.println("(dog1 == dog2) is " + (dog1 == dog2));
    }
}