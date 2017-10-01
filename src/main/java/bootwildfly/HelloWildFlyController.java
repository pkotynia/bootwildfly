package bootwildfly;

import hello.KotlinHelloKt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static hello.JavaHello.getHelloStringFromKotlin;

@RestController
public class HelloWildFlyController {


    @RequestMapping("hello")
    public String sayHello(){

        return "hello " + getHelloStringFromKotlin() + KotlinHelloKt.getHelloStringFromJava();
    }
}