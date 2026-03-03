package com.Chess;

import com.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {

    public void verifyBoard(Board board, int pawnColor, int index){
        Pawn newPawn = new Pawn(pawnColor);
        board.add(newPawn);
        assertThat(index+1).isEqualTo(board.size());
        assertThat(newPawn).isEqualTo(board.findPawn(index));
    }

    @Test
    public void create() throws Exception{
        Board newBoard = new Board();
        verifyBoard(newBoard, Pawn.WHITE_COLOR, 0);
        verifyBoard(newBoard, Pawn.BLACK_COLOR, 1);
    }

    @DisplayName("Make sure pawns are in correct lines")
    @Test
    public void initialize() throws Exception{
        Board newBoard = new Board();
        newBoard.initialize();
        assertThat(newBoard.getWhitePawnsResult()).isEqualTo("PPPPPPPP");
        assertThat(newBoard.getBlackPawnsResult()).isEqualTo("pppppppp");
    }


}
