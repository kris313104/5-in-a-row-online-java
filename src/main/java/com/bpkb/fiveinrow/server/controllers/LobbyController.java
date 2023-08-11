package com.bpkb.fiveinrow.server.controllers;

import com.bpkb.fiveinrow.server.runner.ServerHost;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LobbyController {
    private final String roomCode = ServerHost.getRoomCode();
    private int playerCount = 0;


    @GetMapping("/{roomCode}/create")
    public boolean createLobby(Model model) {
        playerCount += 1;
        return true;
    }

    @GetMapping(value = "/{roomCode}/join")
    public boolean joinLobby(Model model) {
        boolean returnValue = false;

        playerCount += 1;
        if (checkPlayerCount()) {
            returnValue = true;
        }
        return returnValue;
    }

    private boolean checkPlayerCount() {
        boolean returnValue = false;
        if (playerCount == 2) {
            returnValue = true;
        }
        return returnValue;
    }
}
