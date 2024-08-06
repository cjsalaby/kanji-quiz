package com.cjsalabye.quiz.controller;

import com.cjsalabye.quiz.model.Player;
import com.cjsalabye.quiz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/leaderboard")
    public List<Player> getLeaderboard() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/save")
    public Player savePlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

}
