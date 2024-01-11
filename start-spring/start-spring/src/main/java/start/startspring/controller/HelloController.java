package start.startspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 이 url에 매핑
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    // MVC
    // http://localhost:8080/hello?name=spring!
    // 실행하고 마우스 우클릭으로 코드 봤을 때 코드 보임
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // http://localhost:8080/hello-string?name=spring!
    // 실행하고 마우스 우클릭으로 코드 봤을 때 코드 안보임
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // API
    // http://localhost:8080/hello-api?name=spring!
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello(); // 귀찮을땐, Ctrl+Shift+Enter 치면 자동 완성
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
