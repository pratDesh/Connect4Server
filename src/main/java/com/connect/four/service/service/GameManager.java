package com.connect.four.service.service;

import com.connect.four.service.entity.Game;
import com.connect.four.service.dtos.ResponseDTO;

public interface GameManager {

    Game createNewGame(String color);

    ResponseDTO play(String gameId, String userId, int column);
}
