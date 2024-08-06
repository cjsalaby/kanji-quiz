package com.cjsalabye.quiz.repository;

import com.cjsalabye.quiz.model.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KanjiRepository extends JpaRepository<Kanji, Long> {
    Kanji findByKanji(String kanji);
}
