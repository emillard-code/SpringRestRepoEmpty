package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// @RestController makes it so that @ResponseBody is inherent in every controller method.
// This means that everything is returned as a JSON by default.
// (Hence returning the String of a HTML file name will not work)
@RestController
public class HomeController {

    @Autowired
    CoderRepository repository;

    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView("main.jsp");
        return mv;

    }

    // This endpoint is mainly called by the form in main.jsp.
    // Trying to use @RequestParam on an object will not work here.
    @GetMapping("/addCoder")
    public ModelAndView addCoder(Coder coder) {

        ModelAndView mv = new ModelAndView("main.jsp");
        repository.save(coder);
        return mv;

    }

    // This endpoint is mainly called by the form in main.jsp.
    @GetMapping("/getCoder")
    public ModelAndView getCoder(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("getCoder.jsp");
        Coder coder = repository.findById(id).orElse(new Coder());
        mv.addObject(coder);

        return mv;

    }

}
