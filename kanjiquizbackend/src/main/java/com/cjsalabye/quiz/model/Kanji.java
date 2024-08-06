package com.cjsalabye.quiz.model;

import jakarta.persistence.*;

@Entity
public class Kanji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kanji;
    private String reading;

    @Column(columnDefinition = "TEXT")
    private String meaning;

    //TODO: setters and getters

    public void setId(Long id) {
        this.id = id;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Long getId() {
        return id;
    }

    public String getKanji() {
        return kanji;
    }

    public String getReading() {
        return reading;
    }

    public String getMeaning() {
        return meaning;
    }
}
