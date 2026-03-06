package com.Chess;

import com.pieces.Color;
import com.pieces.Piece;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static com.utils.StringUtils.appendNewLine;



public class BoardTest {
    private Board board;
    private ChessGame game;

    @BeforeEach
    public void setup() {
        board = new Board();
        game = new ChessGame();
        game.setChessBoard(board);
    }

    @Test
    public void create() throws Exception {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertThat(ChessView.showBoard(board)).isEqualTo(appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"));

    }


    @Test
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook());
    }

    @Test
    public void move() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);
        assertThat(board.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(targetPosition)).isEqualTo(Piece.createWhitePawn());

    }

    @Test
    public void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(game.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(game.calculatePoint(Color.WHITE)).isEqualTo(7.0);
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }


}
