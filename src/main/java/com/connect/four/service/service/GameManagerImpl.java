package com.connect.four.service.service;

import com.connect.four.service.common.Coin;
import com.connect.four.service.entity.Game;
import com.connect.four.service.common.GameStatus;
import com.connect.four.service.entity.Player;
import com.connect.four.service.dtos.ResponseDTO;
import com.connect.four.service.exception.InvalidGamePlayException;
import com.connect.four.service.repository.GameRepository;
import com.connect.four.service.utility.IdGenerator;

import java.util.Objects;

public class GameManagerImpl implements GameManager {

    private static final String GAME = "game";
    private static final String PLAYER = "player";

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private GameRepository gameRepository;

    public Game createNewGame(String color) {
        Game game = new Game();
        game.setId(idGenerator.generateId(GAME));
        game.setPlayerOne(createPlayer(color));
        game.setPlayerTwo(createPlayer(getPlayerTwoColor(color)));
        game.setStatus(GameStatus.STARTED);

        return game;
    }

    public ResponseDTO play(String gameId, String userId, int column) {
        Game game = gameRepository.getById(gameId);
        validateMove(game, userId, column);
        addCoin(game, userId, column);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setGame(game);
        responseDTO.setIsSuccess(true);
        if (calculateWinner(game)) {
            responseDTO.setMessage("Valid");
        }
        else {
            responseDTO.setMessage(game.getPlayer(userId).getCoinColor() + " Wins");
        }

        return responseDTO;
    }

    private void validateGame(Game game) {
        if (game.getStatus().equals(GameStatus.COMPLETED)) {
            throw new InvalidGamePlayException("Game is completed");
        }
    }

    private void validateMove(Game game, String userId, int column) {
        validateUser(game, userId);
    }

    private void validateUser(Game game, String userId) {
        //Validate if correct userId for current Game.
        if (!game.getPlayerOne().getId().equals(userId) || !game.getPlayerTwo().getId().equals(userId)) {
            throw new InvalidGamePlayException("User not found with Id: " + userId);
        }

        //Validate if correct user turn.
        if (game.getLastPlayedColor().equals(game.getPlayer(userId).getCoinColor())) {
            throw new InvalidGamePlayException("Wrong user turn, other user should play");
        }

    }

    private void addCoin(Game game, String userId, int column) {
        Coin[][] board = game.getBoard();
        Coin coin = game.getPlayer(userId).getCoinColor();

        if (Objects.isNull(board[0][column])) {
            throw new InvalidGamePlayException("Column is full");
        }

        for (int row = 5; row > 0; row--) {
            if (Objects.isNull(board[row][column])) {
                board[row][column] = coin;
                game.setLastPlayedRow(row);
                game.setLastPlayedColumn(column);
            }
        }
    }

    private boolean calculateWinner(Game game) {
        int row = game.getLastPlayedRow();
        int col = game.getLastPlayedColumn();
        Coin[][] board = game.getBoard();

        if (validateRow(board, row, col) || validateColumn(board, row, col) || validateDiagonal(board, row, col)) {
            game.setStatus(GameStatus.COMPLETED);
            return true;
        }

        return false;
    }

    private boolean validateRow(Coin[][] board, int row, int col) {
        return false;
    }

    private boolean validateColumn(Coin[][] board, int row, int col) {
        return false;
    }

    private boolean validateDiagonal(Coin[][] board, int row, int col) {
        return false;
    }

    private Player createPlayer(String color) {
        return new Player(idGenerator.generateId(PLAYER), Coin.valueOf(color));
    }

    private String getPlayerTwoColor(String playerOneColor) {
        if (playerOneColor.equals("YELLOW")) {
            return "RED";
        }
        else {
            return "YELLOW";
        }
    }
}
