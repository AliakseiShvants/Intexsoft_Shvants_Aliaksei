package com.shvants.UrlShorter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView index(){
        Map<String, String> fullNameMap = new HashMap<>();
        fullNameMap.put("user", "Aliaksei Shvants");
        return new ModelAndView("index", fullNameMap);
    }
}
