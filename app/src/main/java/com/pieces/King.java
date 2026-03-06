package com.pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    public King(Color color){
        super.color = color;
        if(color == Color.BLACK){
            super.representationCharacter = 'K';
        }
        else{
            super.representationCharacter = 'k';
        }
        super.score = 0.0;
    }

    @Override
    public List<int[]> possibleMoves(int [] curPos){

        List<int[]> moves = new ArrayList<>();
        directionBasedMoves(curPos,moves,Direction.everyDirection());
        return moves;
    }

}
