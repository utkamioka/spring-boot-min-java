package com.example.kamioka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss zzz");

    @RequestMapping(path = "/hello")
    public String hello(Model model, HttpServletRequest req) {
        System.out.println(this.getClass().getPackage().getName() + ".HelloController.hello()");
        model.addAttribute("date", ZonedDateTime.now().format(FORMATTER));
        model.addAttribute("request_id", req.getAttribute("Request-Id"));
        return "hello";
    }

    @RequestMapping(path = "/hello-submit")
    public String helloSubmit(@ModelAttribute("foo") String foo, Model model, HttpServletRequest req) {
        model.addAttribute("date", foo);
        model.addAttribute("request_id", req.getAttribute("Request-Id"));
        return "hello";
    }
}
