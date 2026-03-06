package com.Chess;

import com.pieces.Direction;
import com.pieces.Piece;
import static com.utils.StringUtils.convertPosToIndices;
import com.pieces.Color;
import java.util.List;
import com.pieces.Type;

public class ChessGame {

    private Board chessBoard;
    private boolean isWhiteTurn = true;

    public void setChessBoard(Board newBoard){
        this.chessBoard = newBoard;
    }

    private boolean isPawnLimitationsCleared(Piece movingPiece, Piece targetPiece, int[] position1, int[] position2){

        int[] offset = new int[]{position1[0] - position2[0], position1[1] - position2[1]};

        boolean isTargetEmpty = targetPiece.getColor().equals(Color.NOCOLOR);

        if(Direction.diagonalDirection().stream().anyMatch(a->((a.getXDegree() == offset[0]) && (a.getYDegree() == offset[1])))){
            //Diagonal movement must be enemy
            if((targetPiece.getColor() != movingPiece.getColor())&& !(isTargetEmpty)){
                return true;
            }
            return false;
        }
        //this is straight movement now there must be nothing
        else{
            if(isTargetEmpty){
                return true;
            }
            return false;
        }

    }

    private boolean isRightTurn(Piece p){
        if(isWhiteTurn){
            return p.getColor().equals(Color.WHITE);
        }
        else{
            return p.getColor().equals(Color.BLACK);
        }

    }

    private boolean isCollisionCleared(int[] position1, int[] position2) {
        // Check every piece between its target and origin -> if collision return false
        int[] offsets = new int[]{position2[0] - position1[0], position2[1] - position1[1]};
        int abs_divisor0 = Math.abs(offsets[0]);
        int abs_divisor1 = Math.abs(offsets[1]);
        if(abs_divisor0 != 0){
            offsets[0] = offsets[0] / abs_divisor0;
        }
        if(abs_divisor1 != 0){
            offsets[1] = offsets[1] / abs_divisor1;
        }

        Direction dir = Direction.everyDirection().stream().filter(d ->(d.getXDegree() == offsets[0] && d.getYDegree() == offsets[1])).findFirst().get();

        int tmp_0 = position1[0];
        int tmp_1 = position1[1];

        while(true){
            tmp_0 = tmp_0 + dir.getXDegree();
            tmp_1 = tmp_1 + dir.getYDegree();
            if((tmp_0 == position2[0]) && (tmp_1 == position2[1])){
                return true;
            }
            if(!chessBoard.findPiece(tmp_0,tmp_1).getType().equals(Type.NO_PIECE)){
                break;
            }
        }


        return false;

    }


    public void move(String pos1, String pos2){
        int[] position1 = convertPosToIndices(pos1);
        int[] position2 = convertPosToIndices(pos2);
        Piece movingPiece = chessBoard.findPiece(position1);

        if(!isRightTurn(movingPiece)){
            return;
        }

        List<int[]> possibleMoves = movingPiece.possibleMoves(position1);
        if(possibleMoves.stream().noneMatch(a->(a[0] == position2[0] && a[1] == position2[1]))){
            return;
        }
        Piece targetPiece = chessBoard.findPiece(position2);
        if(movingPiece.getColor() == targetPiece.getColor()){
            return;
        }

//         If pawn and its diagonal check if there is opponent piece in that position
        boolean pieceWiseClear = switch(movingPiece.getType()){
            case Type.PAWN -> isPawnLimitationsCleared(movingPiece,targetPiece,position1,position2);
            case ROOK, QUEEN, BISHOP -> isCollisionCleared(position1,position2);
            default -> true;
        };

        if(pieceWiseClear){
            chessBoard.move(position1, position2);
            if(targetPiece.getType().equals(Type.KING)){
                gameSet();
                this.chessBoard.initialize();
            }
            this.isWhiteTurn = !this.isWhiteTurn;
        }

    }

    private void gameSet(){
        String player;
        if(isWhiteTurn){
            player = "         W H I T E ";
        }
        else{
            player="         B L A C K ";
        }
        System.out.println("        G A M E   S E T        ");
        System.out.println(player + " W I N        ");
    }

    public double calculatePoint(Color color){
        double scoreSum = 0.0;
        for(int j =0 ; j < 8; j++){
            boolean hasPawn = false;
            for(int i =0; i < 8; i++){
                Piece tmpPiece = this.chessBoard.findPiece(i,j);
                if(tmpPiece.getColor() == color){
                    double score = tmpPiece.getScore();
                    if(tmpPiece.getType().equals(Type.PAWN)){
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
