package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api")
public class DemoController {

    @RequestMapping(value = "/replace/{word1}/{word2}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> replaceWord(@PathVariable String word1, @PathVariable String word2, @RequestParam("text") String text) {
        String resultString = "";
        String[] replaceWord = text.split(" ");
        for (String newWord : replaceWord) {
            if (newWord.equalsIgnoreCase(word1)) {
                resultString = text.replace(newWord, word2);
                return new ResponseEntity<>(resultString.trim(), HttpStatus.OK);
            }
        }
        resultString = "Word Not found";
        return new ResponseEntity<>(resultString.trim(), HttpStatus.NOT_FOUND);
    }
}
