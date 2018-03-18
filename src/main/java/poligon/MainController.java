package poligon;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import poligon.model.Greeting;

@RestController
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World! it is me Dinek";
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }

//    @RequestMapping("/question")
//    public Question getQuestion(@RequestParam(value="name", defaultValue="World") String name) {
//        Question question = new Question();
//        question.setAnswer("test answer");
//        question.setSuggestions(new String[]{"suggestion 1", "suggestion 2"});
//        Element el1 = new Element();
//        el1.setContent("content");
//        el1.setVisible(true);
//        Element el2 = new Element();
//        el2.setContent("content2");
//        el2.setVisible(false);
//        question.setElements(new Element[]{el1, el2});
//
//        return question;
//    }
}

