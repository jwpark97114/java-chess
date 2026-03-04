package com.pieces;


import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.pieces.Piece.Type;


public class PieceTest {

    @Test
    public void getRepresentationalPerPiece() throws Exception{
        assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }


    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isEqualTo(false);
        assertThat(blank.isBlack()).isEqualTo(false);
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);

    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isEqualTo(true);
        assertThat(whitePiece.getType()).isEqualTo(type);
        assertThat(blackPiece.isBlack()).isEqualTo(true);
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}


