package com.kpi.zaranik.template.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AudioController {

    @GetMapping(value = "/audio1.mp3")
    public ResponseEntity<Resource> getAudio() {
        return ResponseEntity.status(200).body(new FileSystemResource("audio1.mp3"));
    }

}
