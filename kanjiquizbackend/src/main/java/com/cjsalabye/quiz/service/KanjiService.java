package com.cjsalabye.quiz.service;

import com.cjsalabye.quiz.model.Kanji;
import com.cjsalabye.quiz.repository.KanjiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KanjiService {

    @Autowired
    private KanjiRepository kanjiRepository;

    public List<Kanji> getAllKanji() {
        return kanjiRepository.findAll();
    }

    public Kanji getRandomKanji() {
        List<Kanji> kanjis = kanjiRepository.findAll();
        if(kanjis.isEmpty()) {
            return null;
        }

        int randomIndex = (int) (Math.random() * kanjis.size());
        return kanjis.get(randomIndex);
    }

}
