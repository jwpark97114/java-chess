package com.pieces;
import com.pieces.Color;
import java.util.ArrayList;
import java.util.List;

public class BlankPiece extends Piece {

    public BlankPiece(){
        super.representationCharacter ='.';
        super.color = Color.NOCOLOR;
        super.score = 0.0;
    }

    @Override
    public List<int[]> possibleMoves(int [] curPos){

        return null;
    }


}
