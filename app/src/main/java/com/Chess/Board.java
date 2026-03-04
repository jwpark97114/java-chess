package com.Chess;
import com.pieces.*;
import static com.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Piece> pieceList = new ArrayList<>();
    private final List<Piece> whitePieceList = new ArrayList<>();
    private final List<Piece> blackPieceList = new ArrayList<>();
    private final String[] gameBoard = new String[8];
    private int pieceCount = 0;

    public void add(Piece piece, String color){
        if(color.equalsIgnoreCase("white")){
            this.whitePieceList.add(piece);
        }
        else{
            this.blackPieceList.add(piece);
        }
        this.pieceList.add(piece);
        pieceCount ++;
    }

    private void addInitialPieces(){

    }

    public void initialize(){
        for(int i =0; i<this.gameBoard.length; i++){
            switch (i){
                case 0 ->{
                    Piece tmp;
                    String color = "white";
                    StringBuilder row = new StringBuilder();
                    tmp = Piece.createWhiteRook();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    tmp = Piece.createWhiteKnight();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    tmp = Piece.createWhiteBishop();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    tmp = Piece.createWhiteQueen();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    tmp = Piece.createWhiteKing();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    tmp = Piece.createWhiteBishop();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    tmp = Piece.createWhiteKnight();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    tmp = Piece.createWhiteRook();
                    this.add(tmp,color);
                    row.append(tmp.getRepresentation());
                    row.append(appendNewLine(""));
                    this.gameBoard[i] = row.toString();
                }
                case 1 -> {
                    StringBuilder row = new StringBuilder();
                    String color = "white";
                    for(int j =0; j < this.gameBoard.length; j++){
                        Piece tmp = Piece.createWhitePawn();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                    }
                    row.append(appendNewLine(""));
                    this.gameBoard[i] = row.toString();
                }
                case 6 -> {
                    StringBuilder row = new StringBuilder();
                    String color ="black";
                    for(int j =0; j < this.gameBoard.length; j++){
                        Piece tmp = Piece.createBlackPawn();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                    }
                    row.append(appendNewLine(""));
                    this.gameBoard[i] = row.toString();
                }
                case 7 ->{
                    {
                        Piece tmp;
                        StringBuilder row = new StringBuilder();
                        String color = "black";
                        tmp = Piece.createBlackRook();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        tmp = Piece.createBlackKnight();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        tmp = Piece.createBlackBishop();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        tmp = Piece.createBlackQueen();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        tmp = Piece.createBlackKing();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        tmp = Piece.createBlackBishop();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        tmp = Piece.createBlackKnight();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        tmp = Piece.createBlackRook();
                        this.add(tmp,color);
                        row.append(tmp.getRepresentation());
                        row.append(appendNewLine(""));
                        this.gameBoard[i] = row.toString();
                    }
                }
                default -> {
                    this.gameBoard[i] = "........";
                }
            }
        }

    }

    public int pieceCount(){
        return this.pieceCount;
    }

    public String showBoard(){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < this.gameBoard.length; i++){
            sb.append(appendNewLine(this.gameBoard[i]));
        }
        return sb.toString();
    }
}
