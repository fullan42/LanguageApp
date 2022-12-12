package com.cs491.languageapp.repostory;

import com.cs491.languageapp.entity.Level;
import com.cs491.languageapp.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository <Word,Integer> {//generic method

    List<Word> findByLevel(Level level);

}
