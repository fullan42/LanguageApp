package com.cs491.languageapp.controller;

import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.request.CreateWordRequest;
import com.cs491.languageapp.entity.response.CreateWordResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import com.cs491.languageapp.service.WordService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word") // local host 8080ne gidip /word yazdığın zaman wordun methodları gelicek yani bu method bize wordun pathini çiziyor
public class WordController {
    private final WordService wordService;
    @GetMapping // api ile ilişki kulduğun request
    public ResponseEntity<List<Word>> getAll(){
        return new ResponseEntity<>( wordService.getAll(), HttpStatus.OK); // iki kere oluşturulmasının sebebi anlayered arcitechture
    }
   @PostMapping
    public ResponseEntity<CreateWordResponse> create(@RequestBody CreateWordRequest createWordRequest){
        return new ResponseEntity<>(wordService.create(createWordRequest),HttpStatus.CREATED);


    }
    @GetMapping("/getByLevelA1")
    public ResponseEntity<List<WordResponse>> getByLevelA1(@RequestParam int number){
        return new ResponseEntity<>(wordService.getByLevelA1(number),HttpStatus.OK);
    }
    @GetMapping("/getByLevelA2")
    public ResponseEntity<List<WordResponse>> getByLevelA2(@RequestParam int number){
        return new ResponseEntity<>(wordService.getByLevelA2(number),HttpStatus.OK);
    }
    @GetMapping("/getByLevelB1")
    public ResponseEntity<List<WordResponse>> getByLevelB1(@RequestParam int number){
        return new ResponseEntity<>(wordService.getByLevelB1(number),HttpStatus.OK);
    }
    @GetMapping("/getByLevelB2")
    public ResponseEntity<List<WordResponse>> getByLevelB2(int number){
        return new ResponseEntity<>(wordService.getByLevelB2(number),HttpStatus.OK);
    }
}
