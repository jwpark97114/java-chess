package com.pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(Color color){
        super.color = color;
        if(color == Color.BLACK){
            super.representationCharacter = 'N';
        }
        else{
            super.representationCharacter = 'n';
        }
        super.score = 2.5;
        super.type = Type.KNIGHT;
    }

    @Override
    public List<int[]> possibleMoves(int [] curPos){

        List<int[]> moves = new ArrayList<>();
        directionBasedMoves(curPos,moves,Direction.knightDirection());
        return moves;
    }


}
