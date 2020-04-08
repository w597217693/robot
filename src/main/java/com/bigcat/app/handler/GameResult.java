package com.bigcat.app.handler;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GameResult {
    private boolean isWin = false;
    private BigDecimal odds;
}
