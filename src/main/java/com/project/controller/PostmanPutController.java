package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostmanPutController {

    @Autowired
    CoderRepository repository;

    @PutMapping("/putCoder")
    public Coder putCoder(@RequestBody Coder coder) {

        repository.save(coder);
        return coder;

    }

    @PutMapping("/updateCoder")
    public Coder updateCoder(@RequestBody Coder coder) {

        Optional<Coder> optionalCoder = repository.findById(coder.getId());

        if (optionalCoder.isPresent()) {
            repository.save(coder);
            return coder;
        } else {
            return new Coder();
        }

    }

}
