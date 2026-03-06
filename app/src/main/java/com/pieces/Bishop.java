package com.pieces;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(Color color){
        super.color = color;
        if(color == Color.BLACK){
            super.representationCharacter = 'B';
        }
        else{
            super.representationCharacter = 'b';
        }
        super.score = 3.0;
    }


    @Override
    public List<int[]> possibleMoves(int [] curPos){
        List<int[]> moves = new ArrayList<>();
        for(Direction d :Direction.diagonalDirection()){
            addStraightMoves(curPos,moves,d);
        }
        return moves;
    }


}
