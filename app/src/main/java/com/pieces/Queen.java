package com.pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public Queen(Color color){
        super.color = color;
        if(color == Color.BLACK){
            super.representationCharacter = 'Q';
        }
        else{
            super.representationCharacter = 'q';
        }
        super.score = 9.0;
        super.type = Type.QUEEN;
    }


    @Override
    public List<int[]> possibleMoves(int [] curPos){
        List<int[]> moves = new ArrayList<>();
        for(Direction d :Direction.everyDirection()){
            addStraightMoves(curPos,moves,d);
        }
        return moves;
    }


}
