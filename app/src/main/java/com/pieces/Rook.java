package com.pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    public Rook(Color color){
        super.color = color;
        if(color == Color.BLACK){
            super.representationCharacter = 'R';
        }
        else{
            super.representationCharacter = 'r';
        }
        super.score = 5.0;
    }

    @Override
    public List<int[]> possibleMoves(int [] curPos){
        List<int[]> moves = new ArrayList<>();
        for(Direction d :Direction.linearDirection()){
            addStraightMoves(curPos,moves,d);
        }
        return moves;
    }
}
