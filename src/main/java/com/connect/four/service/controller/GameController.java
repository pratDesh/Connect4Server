package com.connect.four.service.controller;

import com.connect.four.service.common.Coin;
import com.connect.four.service.entity.Game;
import com.connect.four.service.dtos.ResponseDTO;
import com.connect.four.service.exception.InvalidGamePlayException;
import com.connect.four.service.service.GameManager;
import com.sun.istack.internal.NotNull;

@RestController
public class GameController {

    private GameManager gameManager;

    @RequestMapping("/start", method = RequestMethod.GET)
    public ResponseDTO createNewGame(@RequestParam @NotNull String color) {

        //Validate color selected by user.
        validateColor(color);

        Game game = gameManager.createNewGame(color);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setGame(game);
        responseDTO.setIsSuccess(true);
        responseDTO.setMessage("New Game created successfully");

        return responseDTO;
    }

    private void validateColor(String color) {
        try {
            Coin.valueOf(color);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid color selected");
        }
    }

    @RequestMapping("/{gameId}/play/{userId}/{column}", method = RequestMethod.PUT)
    public ResponseDTO playMove(@PathVariable @NotNull String gameId, @PathVariable @NotNull String userId, @PathVariable @NotNull int column) {

        if (column > 6 || column < 0) {
            throw new InvalidGamePlayException("Column selected is invalid");
        }

        return gameManager.play(gameId, userId, column);

    }

}
