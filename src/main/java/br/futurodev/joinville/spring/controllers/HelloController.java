package br.futurodev.joinville.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("say")
    public String sayHello2() {
        return "Saying hello: \"Hellooooo\"";
    }

    @GetMapping("say/{name}")
    public String sayHelloTo(@PathVariable String name, String message) {
        return "Hello " + name + " \\o/: " + message;
    }

}
