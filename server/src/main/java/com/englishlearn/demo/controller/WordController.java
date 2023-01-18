package com.englishlearn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.englishlearn.demo.model.entity.Word;

import com.englishlearn.demo.service.WordService;

import java.util.Collection;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/all-word")
    public Collection<Word> allWord() {
        return wordService.getAll().stream().collect(Collectors.toList());
    }

}
