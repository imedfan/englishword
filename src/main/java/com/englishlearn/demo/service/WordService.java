package com.englishlearn.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.englishlearn.demo.model.entity.Word;

@Service
public interface WordService {

    Word addWord(Word word);
    void deleteWord(Long id);
    Word getById(Long id);
    Word editWord(Word word);
    List<Word> getAll();
    boolean existsWord(Long id);
    
    
}
