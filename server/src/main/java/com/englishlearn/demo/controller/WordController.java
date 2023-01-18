package com.englishlearn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // http://localhost:8080/all-word/add?englishWord=hola&translatedWord=aloha

    @PostMapping("/all-word/add")
    public Word addWord(Word word) {
        return wordService.addWord(word);
    }

    @DeleteMapping("/all-word/delete")
    public void removeWord(@RequestParam Long id) {
        wordService.deleteWord(id);
    }

    // http://localhost:8080/all-word/edit/1?englishWord=ahola&translatedWord=loha

    @PatchMapping("/all-word/edit/{id}")
    public Word editWord(@PathVariable Long id,
            @RequestParam(value = "englishWord", required = true) String englishWord,
            @RequestParam(value = "translatedWord", required = true) String translatedWord) {

        Word word = wordService.getById(id);
        word.setEnglishWord(englishWord);
        word.setTranslatedWord(translatedWord);
        return wordService.editWord(word);

    }

}
