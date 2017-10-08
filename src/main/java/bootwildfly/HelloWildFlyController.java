package bootwildfly;

import bootwildfly.model.Element;
import bootwildfly.model.Greeting;
import bootwildfly.model.Question;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController {

    @RequestMapping("hello")
    public String sayHello(){
        return ("Hello, SpringBoot on My Mack");
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }
    @RequestMapping("/Question")
    public Question getQuestion(@RequestParam(value="name", defaultValue="World") String name) {
        Question question = new Question();
        question.setAnswer("test answer");
        question.setSuggestions(new String[]{"suggestion 1", "suggestion 2"});
        Element el1 = new Element();
        el1.setContent("content");
        el1.setVisible(true);
        Element el2 = new Element();
        el2.setContent("content2");
        el2.setVisible(false);
        question.setElements(new Element[]{el1, el2});

        return question;
    }

}