package com.Chess;

import com.pieces.Piece;

public class ChessGame {

    private int pieceCount = 0;
    private Board chessBoard;

    public void setChessBoard(Board newBoard){
        this.chessBoard = newBoard;
    }

//    public int pieceCount(){
//        return this.pieceCount;
//    }

//    public int countPiece(Piece.Color color, Piece.Type type){
//        int count = 0;
//        for(int i =0; i < 8; i++){
//            for(int j = 0; j <8; j++){
//                Piece p = this.chessBoard.findPiece(i,j);
//                if( (p.getColor() == color) && (p.getType() == type)){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//

    public double calculatePoint(Piece.Color color){
        double scoreSum = 0.0;
        for(int j =0 ; j < 8; j++){
            boolean hasPawn = false;
            for(int i =0; i < 8; i++){
                Piece tmpPiece = this.chessBoard.findPiece(i,j);
                if(tmpPiece.getColor() == color){
                    double score = tmpPiece.getType().getScore();
                    if(tmpPiece.getType()== Piece.Type.PAWN){
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
