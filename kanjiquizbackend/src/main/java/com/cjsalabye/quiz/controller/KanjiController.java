package com.cjsalabye.quiz.controller;

import com.cjsalabye.quiz.model.Kanji;
import com.cjsalabye.quiz.service.KanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/kanji")
@CrossOrigin
public class KanjiController {

    @Autowired
    private KanjiService kanjiService;

    @GetMapping("/random")
    public Kanji getRandomKanji() {
        return kanjiService.getRandomKanji();
    }

    @GetMapping("/{deck}")
    public List<Kanji> getKanjiByDeck(@PathVariable String deck) {
        return kanjiService.loadKanjiDeck(deck);
    }

}
