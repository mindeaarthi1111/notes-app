package com.springbootproject.notesapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping("/hello")
    public String Hello()
    {
        return "App is working";
    }
}
