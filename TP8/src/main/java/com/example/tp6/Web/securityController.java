package com.example.tp6.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class securityController {

    @GetMapping("/403")
    public String notAuthorized(){
        return "403";
    }
}
