package test.herokut.testController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/main")
    public String main() {
        String str = "hello";

        return str;
    }
}
