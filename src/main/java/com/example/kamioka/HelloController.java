package com.example.kamioka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss zzz");

    @Autowired
    private Counter counter;

    @RequestMapping(path = "/hello")
    public String hello(Model model, HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(Thread.currentThread() + ": " + this.getClass().getPackage().getName() + ".HelloController.hello()");
        model.addAttribute("counter", counter.getCount());
        model.addAttribute("date", ZonedDateTime.now().format(FORMATTER));
        model.addAttribute("request_id", resp.getHeader("Request-Id"));
        return "hello";
    }

    @RequestMapping(path = "/hello-submit")
    public String helloSubmit(@ModelAttribute("foo") String foo, Model model, HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(Thread.currentThread() + ": " + this.getClass().getPackage().getName() + ".HelloController.helloSubmit()");
        model.addAttribute("counter", counter.getCount());
        model.addAttribute("date", foo);
        model.addAttribute("request_id", resp.getHeader("Request-Id"));
        return "hello";
    }

    @RequestMapping(path = "/neko", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public Resource neko() {
        System.out.println(Thread.currentThread() + ": " + this.getClass().getPackage().getName() + ".HelloController.neko()");
        // なにもしないと、Content-Typeが"application/json"になるので、"application/octet-stream"を指定する。
        return new ClassPathResource("wagahaiwa_nekodearu");
    }

    @RequestMapping(path = "/neko.txt")
    @ResponseBody
    public Resource neko_txt() {
        System.out.println(Thread.currentThread() + ": " + this.getClass().getPackage().getName() + ".HelloController.neko_txt()");
        // "*.txt"だと、Content-Typeが強制的に"text/plain"になる。
        return new ClassPathResource("wagahaiwa_nekodearu.txt");
    }
}
