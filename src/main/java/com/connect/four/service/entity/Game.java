package com.connect.four.service.entity;

import com.connect.four.service.common.Coin;
import com.connect.four.service.common.GameStatus;

import java.io.Serializable;

public class Game implements Serializable {

    private static final long serialVersionUID = -510545423217333343L;

    // Unique Game Id for each game.
    private String id;

    private Coin[][] board = new Coin[6][7];

    private Player playerOne;

    private Player playerTwo;

    private int lastPlayedRow;

    private int lastPlayedColumn;

    private GameStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coin[][] getBoard() {
        return board;
    }

    public void setBoard(Coin[][] board) {
        this.board = board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Coin getLastPlayedColor() {
        return this.board[this.lastPlayedRow][this.lastPlayedColumn];
    }

    public int getLastPlayedRow() {
        return lastPlayedRow;
    }

    public void setLastPlayedRow(int lastPlayedRow) {
        this.lastPlayedRow = lastPlayedRow;
    }

    public int getLastPlayedColumn() {
        return lastPlayedColumn;
    }

    public void setLastPlayedColumn(int lastPlayedColumn) {
        this.lastPlayedColumn = lastPlayedColumn;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getPlayer(String userId) {
        if (this.getPlayerOne().getId().equals(userId)) {
            return this.playerOne;
        }
        else if (this.getPlayerTwo().getId().equals(userId)) {
            return this.playerTwo;
        }

        return null;
    }
}
