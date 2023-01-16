package com.englishlearn.demo.model.entity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.englishlearn.demo.model.entity.Word;

@Repository
public interface WordRepository extends JpaRepository <Word, Long> {
    
}
