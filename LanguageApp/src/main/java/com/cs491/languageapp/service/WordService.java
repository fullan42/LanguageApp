package com.cs491.languageapp.service;

import com.cs491.languageapp.entity.Convertor.WordConverter;
import com.cs491.languageapp.entity.Level;
import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.request.CreateWordRequest;
import com.cs491.languageapp.entity.response.CreateWordResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import com.cs491.languageapp.repostory.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // service oldugu belli olsun word servesi newliyor
@RequiredArgsConstructor // private final diye tanımladığımız classların başka classlarda çalıştırılmasına olanak sağlayan annotation
public class WordService {

    private final WordRepository wordRepository;
    private final WordConverter wordConverter;
    public List<Word> getAll(){ // get all methodu böyle yapılıyor

        return wordRepository.findAll();
    }


    public CreateWordResponse create(CreateWordRequest request){

        Word word=new Word(request.getName(),request.getMean(),request.getLevel());

        Word save = wordRepository.save(word);
        return wordConverter.convert(save);// dışarıdan cağırdığımız methodun içine userrepository.save alıp direkt database kaydedebiliyoruz
    }
    public List<WordResponse> getByLevelA1(int number){
        List<WordResponse> wordResponse = new ArrayList<>();
        List<Word> byLevelA1 = wordRepository.findByLevel(Level.A1);
        List<WordResponse> convert = wordConverter.convert(byLevelA1);
        for(int i=0; i<number;i++){
            wordResponse.add(convert.get(i));
        }
        return wordResponse;
    }
    public List<WordResponse> getByLevelA2(int number){
        List<WordResponse> wordResponse = null;
        List<Word> byLevelA2 = wordRepository.findByLevel(Level.A2);
        List<WordResponse> convert = wordConverter.convert(byLevelA2);

        for(int i = 0; i<number; i++){
            wordResponse.add(convert.get(i));
        }
        return wordResponse;
    }
    public List<WordResponse> getByLevelB1(int number){
        List<WordResponse> wordResponse = null;
        List<Word> byLevelB1 = wordRepository.findByLevel(Level.B1);
        List<WordResponse> convert = wordConverter.convert(byLevelB1);
        for(int i=0; i<number;i++){
            wordResponse.add(convert.get(i));
        }
        return wordResponse;
    }
    public List<WordResponse> getByLevelB2(int number){
        List<WordResponse> wordResponse = null;
        List<Word> byLevelB2 = wordRepository.findByLevel(Level.B2);
        List<WordResponse> convert = wordConverter.convert(byLevelB2);
        for(int i=0; i<number;i++){
            wordResponse.add(convert.get(i));
        }
        return wordResponse;
    }

}
