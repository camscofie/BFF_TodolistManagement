package edu.kit.tm.cm.tlm.tlmuibff.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/")
    public String redirect() {
        return "redirect:/swagger-ui.html";
    }
}
