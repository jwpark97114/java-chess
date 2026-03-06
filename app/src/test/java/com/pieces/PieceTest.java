package com.pieces;


import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @Test
    public void getRepresentationalPerPiece() throws Exception{
        assertThat(Piece.createWhitePawn().getRepresentation()).isEqualTo('p');
        assertThat(Piece.createBlackPawn().getRepresentation()).isEqualTo('P');
        assertThat(Piece.createWhiteKnight().getRepresentation()).isEqualTo('n');
        assertThat(Piece.createBlackKnight().getRepresentation()).isEqualTo('N');
        assertThat(Piece.createWhiteKing().getRepresentation()).isEqualTo('k');
        assertThat(Piece.createBlackKing().getRepresentation()).isEqualTo('K');
        assertThat(Piece.createWhiteQueen().getRepresentation()).isEqualTo('q');
        assertThat(Piece.createBlackQueen().getRepresentation()).isEqualTo('Q');
        assertThat(Piece.createWhiteRook().getRepresentation()).isEqualTo('r');
        assertThat(Piece.createBlackRook().getRepresentation()).isEqualTo('R');
        assertThat(Piece.createWhiteBishop().getRepresentation()).isEqualTo('b');
        assertThat(Piece.createBlackBishop().getRepresentation()).isEqualTo('B');
    }


    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), "PAWN");
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), "KNIGHT");
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), "ROOK");
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), "BISHOP");
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), "QUEEN");
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), "KING");

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isEqualTo(false);
        assertThat(blank.isBlack()).isEqualTo(false);
        assertThat(blank.getType()).isEqualTo("BLANKPIECE");

    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, String type) {
        assertThat(whitePiece.isWhite()).isEqualTo(true);
        assertThat(whitePiece.getType()).isEqualTo(type);
        assertThat(blackPiece.isBlack()).isEqualTo(true);
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}


