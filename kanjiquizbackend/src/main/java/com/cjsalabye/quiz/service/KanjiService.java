package com.cjsalabye.quiz.service;

import com.cjsalabye.quiz.model.Kanji;
import com.cjsalabye.quiz.model.KanjiData;
import com.cjsalabye.quiz.repository.KanjiRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Kanji> loadKanjiDeck(String deck) {
        ObjectMapper objectMapper = new ObjectMapper();
        String filename = String.format("kanji/%s.json", deck);

        try {
            KanjiData kanjiData = objectMapper.readValue(new ClassPathResource(filename).getFile(), KanjiData.class);

            return kanjiData.getCards().stream().map(card -> {
                Kanji kanji = new Kanji();
                kanji.setKanji(card.getQuestion());
                kanji.setReading(card.getAnswer().get(0)); // Assuming there's at least one answer
                kanji.setMeaning(card.getMeaning());
                return kanji;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }

    }

}
