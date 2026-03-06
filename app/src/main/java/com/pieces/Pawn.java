package com.pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(Color color){
        super.color = color;
        if(color == Color.BLACK){
            super.representationCharacter = 'P';
        }
        else{
            super.representationCharacter = 'p';
        }
        super.score = 1.0;
        super.type = Type.PAWN;
    }

    @Override
    public List<int[]> possibleMoves(int [] curPos){

        List<int[]> moves = new ArrayList<>();
        List<Direction> dirs = switch (super.color){
            case BLACK -> Direction.blackPawnDirection();
            default -> Direction.whitePawnDirection();
        };
        directionBasedMoves(curPos,moves,dirs);
        return moves;
    }



}
