package com.Chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {

    @Test
    public void create() throws Exception{
        Board newBoard = new Board();
        Pawn whitePawn = new Pawn(Pawn.WHITE_COLOR);
        newBoard.add(whitePawn);
        assertThat(1).isEqualTo(newBoard.size());
        assertThat(whitePawn).isEqualTo(newBoard.findPawn(0));

        Pawn blackPawn = new Pawn(Pawn.BLACK_COLOR);
        newBoard.add(blackPawn);
        assertThat(2).isEqualTo(newBoard.size());
        assertThat(blackPawn).isEqualTo(newBoard.findPawn(1));

    }
}
