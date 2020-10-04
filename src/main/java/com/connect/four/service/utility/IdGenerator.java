package com.connect.four.service.utility;

import java.util.UUID;

public class IdGenerator {

    private static final String GAME = "game";
    private static final String PLAYER = "player";
    private static final String GAME_ID = "gm";
    private static final String PLAYER_ID = "ply";

    public String generateId(String type) {
        if (type.equals(GAME)) {
            return GAME_ID + getUniqueId();
        }
        else if (type.equals(PLAYER)) {
            return PLAYER_ID + getUniqueId();
        }
        return null;
    }

    private String getUniqueId() {
        return UUID.randomUUID().toString();
    }
}

