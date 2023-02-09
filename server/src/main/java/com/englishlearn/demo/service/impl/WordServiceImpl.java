package com.englishlearn.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.englishlearn.demo.model.entity.Word;
import com.englishlearn.demo.model.entity.repository.WordRepository;
import com.englishlearn.demo.service.WordService;

@Service
@Component
public class WordServiceImpl implements WordService {
    
    @Autowired
    private WordRepository wordRep;

    @Override
    public void addWord(Word word) {
        // Word saveWord = wordRep.saveAndFlush(word);
        // return saveWord;
        wordRep.saveAndFlush(word);
    }

    @Override
    public void deleteWord(Long id) {
        wordRep.deleteById(id);
    }

    @Override
    public Word getById(Long id) {
        return wordRep.findById(id).get();
    }

    @Override
    public Word editWord(Word word){
        return wordRep.saveAndFlush(word);
    }

    @Override
    public List<Word> getAll() {
        return wordRep.findAll();
    }

    @Override
    public boolean existsWord(Long id) {
        return wordRep.existsById(id);
    }

}
