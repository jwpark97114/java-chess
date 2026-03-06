package com.Chess;

import com.pieces.Piece;
import static com.utils.StringUtils.convertPosToIndices;
import com.pieces.Color;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChessGame {

    private int pieceCount = 0;
    private Board chessBoard;

    public void setChessBoard(Board newBoard){
        this.chessBoard = newBoard;
    }

    public void move(String pos1, String pos2){
        int[] position1 = convertPosToIndices(pos1);
        int[] position2 = convertPosToIndices(pos2);
        Piece movingPiece = chessBoard.findPiece(position1);
        List<int[]> possibleMoves = movingPiece.possibleMoves(position1);
        if(possibleMoves.stream().noneMatch(a->(a[0] == position2[0] && a[1] == position2[1]))){
            return;
        }
        Piece targetPiece = chessBoard.findPiece(position2);
        if(movingPiece.getColor() == targetPiece.getColor()){
            return;
        }
        chessBoard.move(position1, position2);
    }

    public double calculatePoint(Color color){
        double scoreSum = 0.0;
        for(int j =0 ; j < 8; j++){
            boolean hasPawn = false;
            for(int i =0; i < 8; i++){
                Piece tmpPiece = this.chessBoard.findPiece(i,j);
                if(tmpPiece.getColor() == color){
                    double score = tmpPiece.getScore();
                    if(tmpPiece.getType().equalsIgnoreCase("PAWN")){
                        if(hasPawn){
                            score = score / 2;
                        }
                        hasPawn = true;
                    }
                    scoreSum += score;
                }
            }
        }

        return scoreSum;
    }
}
