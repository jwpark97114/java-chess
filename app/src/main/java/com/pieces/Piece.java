package com.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Piece {

    protected char representationCharacter;
    protected Color color;
    protected double score;
    protected Type type;
//    private Piece(Color color, double score){
//        this.representationCharacter = '.';
//        this.color = color;
//        this.score = score;
//    }

    public Color getColor(){
        return this.color;
    }


    public char getRepresentation(){
        return this.representationCharacter;
    }

    public Type getType(){
        return this.type;
    }

    public boolean isBlack(){
        return this.color.equals(Color.BLACK);
    }

    public boolean isWhite(){
        return this.color.equals(Color.WHITE);
    }

    public double getScore(){
        return this.score;
    }

//    public boolean verifyMovePosition(int[] curPos, int[] tagetPos){
//        int[][] moves = possibleMoves(curPos);
//        for(int[] move : moves){
//            if((move[0] == tagetPos[0])&&(move[1]==tagetPos[1])){
//                return true;
//            }
//        }
//        return false;
//    }

    protected boolean withinBounds(int x, int y){
            return ((x <8) && ( x >= 0))&&((y<8) &&(y>=0));
    }
    protected void addStraightMoves(int[] curPos, List<int[]> moves, Direction d){
        int x = curPos[0];
        int y = curPos[1];
        int direction_x = d.getXDegree();
        int direction_y = d.getYDegree();

        while(withinBounds(x+direction_x,y+direction_y)){
            moves.add(new int[]{x + direction_x, y+ direction_y });
            x = direction_x + x;
            y = direction_y + y;
        }
    }

    protected void directionBasedMoves(int[] curPos, List<int[]> moves, List<Direction> directions){
        int i = curPos[0];
        int j = curPos[1];
        for(Direction d :directions){
            int x = d.getXDegree();
            int y = d.getYDegree();
            if(withinBounds(x+i,y+j)){
                moves.add(new int[]{x+i,y+j});
            }
        }
    }

    abstract public List<int[]> possibleMoves(int[] curPos);


    public static Piece createWhitePawn(){
        return new Pawn(Color.WHITE);
    }
    public static Piece createBlackPawn(){
        return new Pawn(Color.BLACK);
    }
    public static Piece createWhiteKnight(){
        return new Knight(Color.WHITE);
    }
    public static Piece createBlackKnight(){
        return new Knight(Color.BLACK);
    }
    public static Piece createWhiteKing(){
        return new King(Color.WHITE);
    }
    public static Piece createBlackKing(){
        return new King(Color.BLACK);
    }
    public static Piece createWhiteQueen(){
        return new Queen(Color.WHITE);
    }
    public static Piece createBlackQueen(){
        return new Queen(Color.BLACK);
    }
    public static Piece createWhiteRook(){
        return new Rook(Color.WHITE);
    }
    public static Piece createBlackRook(){
        return new Rook(Color.BLACK);
    }
    public static Piece createWhiteBishop(){
        return new Bishop(Color.WHITE);
    }
    public static Piece createBlackBishop(){
        return new Bishop(Color.BLACK);
    }
    public static Piece createBlank(){
        return new BlankPiece();
    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(this.color,this.getType());
//    }
//    @Override
//    public boolean equals(Object obj){
//        return (this.getType() == ((Piece)obj).getType()) && (this.getColor() == ((Piece)obj).getColor());
//    }

}
