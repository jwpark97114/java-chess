package com.Chess;
import com.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private final List<Pawn> pawnList = new ArrayList<>();
    private final List<Pawn> whitePawnList = new ArrayList<>();
    private final List<Pawn> blackPawnList = new ArrayList<>();
    private final char[][] gameBoard = new char[8][8];

    public void add(Pawn piece){
        this.pawnList.add(piece);
        this.size ++;
    }

    public int size(){
        return this.size;
    }

    public Pawn findPawn(int index){
        return this.pawnList.get(index);
    }

    public void initialize(){

        for(int i =0; i< this.gameBoard.length; i++){
            for(int j=0; j<this.gameBoard[0].length; j++){
                switch(i){
                    case 1 -> {
                        this.gameBoard[i][j] = Pawn.WHITE_REPRESENTATION;
                        Pawn tmp = new Pawn();
                        this.whitePawnList.add(tmp);
                        this.pawnList.add(tmp);
                    }
                    case 6 -> {
                            this.gameBoard[i][j] = Pawn.BLACK_REPRESENTATION;
                            Pawn tmp = new Pawn("black",Pawn.BLACK_REPRESENTATION);
                            this.blackPawnList.add(tmp);
                            this.pawnList.add(tmp);
                    }
                    default -> this.gameBoard[i][j] = '.';
                }
            }
        }

    }

    public String getWhitePawnsResult(){
        StringBuilder sb = new StringBuilder();
        for(Pawn p : this.whitePawnList){
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public String getBlackPawnsResult(){
        StringBuilder sb = new StringBuilder();
        for(Pawn p : this.blackPawnList){
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < this.gameBoard.length; i++){
            for(char c : this.gameBoard[i]){
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
