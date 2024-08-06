package com.cjsalabye.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class KanjiData {

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getQuestionCreationStrategy() {
        return questionCreationStrategy;
    }

    public void setQuestionCreationStrategy(String questionCreationStrategy) {
        this.questionCreationStrategy = questionCreationStrategy;
    }

    public String getDictionaryLinkStrategy() {
        return dictionaryLinkStrategy;
    }

    public void setDictionaryLinkStrategy(String dictionaryLinkStrategy) {
        this.dictionaryLinkStrategy = dictionaryLinkStrategy;
    }

    public String getAnswerTimeLimitStrategy() {
        return answerTimeLimitStrategy;
    }

    public void setAnswerTimeLimitStrategy(String answerTimeLimitStrategy) {
        this.answerTimeLimitStrategy = answerTimeLimitStrategy;
    }

    public String getCardPreprocessingStrategy() {
        return cardPreprocessingStrategy;
    }

    public void setCardPreprocessingStrategy(String cardPreprocessingStrategy) {
        this.cardPreprocessingStrategy = cardPreprocessingStrategy;
    }

    public String getDiscordFinalAnswerListElementStrategy() {
        return discordFinalAnswerListElementStrategy;
    }

    public void setDiscordFinalAnswerListElementStrategy(String discordFinalAnswerListElementStrategy) {
        this.discordFinalAnswerListElementStrategy = discordFinalAnswerListElementStrategy;
    }

    public String getScoreAnswerStrategy() {
        return scoreAnswerStrategy;
    }

    public void setScoreAnswerStrategy(String scoreAnswerStrategy) {
        this.scoreAnswerStrategy = scoreAnswerStrategy;
    }

    public String getAdditionalAnswerWaitStrategy() {
        return additionalAnswerWaitStrategy;
    }

    public void setAdditionalAnswerWaitStrategy(String additionalAnswerWaitStrategy) {
        this.additionalAnswerWaitStrategy = additionalAnswerWaitStrategy;
    }

    public String getDiscordIntermediateAnswerListElementStrategy() {
        return discordIntermediateAnswerListElementStrategy;
    }

    public void setDiscordIntermediateAnswerListElementStrategy(String discordIntermediateAnswerListElementStrategy) {
        this.discordIntermediateAnswerListElementStrategy = discordIntermediateAnswerListElementStrategy;
    }

    public String getAnswerCompareStrategy() {
        return answerCompareStrategy;
    }

    public void setAnswerCompareStrategy(String answerCompareStrategy) {
        this.answerCompareStrategy = answerCompareStrategy;
    }

    public String getCommentFieldName() {
        return commentFieldName;
    }

    public void setCommentFieldName(String commentFieldName) {
        this.commentFieldName = commentFieldName;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    private String uniqueId;
    private String name;
    private String article;
    private String instructions;
    private String questionCreationStrategy;
    private String dictionaryLinkStrategy;
    private String answerTimeLimitStrategy;
    private String cardPreprocessingStrategy;
    private String discordFinalAnswerListElementStrategy;
    private String scoreAnswerStrategy;
    private String additionalAnswerWaitStrategy;
    private String discordIntermediateAnswerListElementStrategy;
    private String answerCompareStrategy;
    private String commentFieldName;
    private List<Card> cards;

    public static class Card {
        private String question;
        private List<String> answer;
        private String meaning;

        public void setQuestion(String question) {
            this.question = question;
        }

        public void setAnswer(List<String> answer) {
            this.answer = answer;
        }

        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }

        public String getQuestion() {
            return question;
        }

        public List<String> getAnswer() {
            return answer;
        }

        public String getMeaning() {
            return meaning;
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
