package com.cjsalabye.quiz.config;

import com.cjsalabye.quiz.model.KanjiData;
import com.cjsalabye.quiz.model.Kanji;
import com.cjsalabye.quiz.repository.KanjiRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class KanjiInit {

    @Autowired
    private KanjiRepository kanjiRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                KanjiData kanjiData = objectMapper.readValue(new ClassPathResource("kanji/n1.json").getFile(), KanjiData.class);

                List<KanjiData.Card> cards = kanjiData.getCards();

                for(KanjiData.Card card : cards) {
                    Kanji kanji = new Kanji();
                    kanji.setKanji(card.getQuestion());
                    kanji.setReading(card.getAnswer().get(0));
                    kanji.setMeaning(card.getMeaning());
                    kanjiRepository.save(kanji);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
