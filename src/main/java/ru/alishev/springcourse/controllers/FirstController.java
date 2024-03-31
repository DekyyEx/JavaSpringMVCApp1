package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
@RequestMapping("/first")
public class FirstController {
    private static final Logger logger = Logger.getLogger(ru.alishev.springcourse.controllers.FirstController.class.toString());

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        logger.info("Hello, " + name + " " + surname);
        model.addAttribute("massage", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {
        double result = switch (action) {
            case "multiplication" -> a * b;
            case "division" -> a / (double) b;
            case "subtraction" -> a - b;
            case "addition" -> a + b;
            default -> 0;
        };

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
