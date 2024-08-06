package com.cjsalabye.quiz.repository;

import com.cjsalabye.quiz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerRepository extends JpaRepository<Player, Long> {

}
