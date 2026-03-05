package com.pieces;

import java.util.Objects;

public class Piece {

    public enum Color{
        WHITE,
        BLACK,
        NOCOLOR;
    }

    public enum Type{
        PAWN('p',1.0),
        ROOK('r', 5.0),
        KNIGHT('n',2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0),
        NO_PIECE('.', 0);

        private final char representation;
        private final double score;

        Type(char rep, double score){
            this.representation = rep;
            this.score = score;
        }

        public char getWhiteRepresentation(){
            return this.representation;
        }

        public char getBlackRepresentation(){
            return Character.toUpperCase(this.representation);
        }

        public double getScore(){
            return this.score;
        }

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    private final char representationCharacter;
    private final Color color;
    private final Type type;

    private Piece(Color color, Type type){
        this.color = color;
        switch(this.color){
            case Color.WHITE -> this.representationCharacter = type.getWhiteRepresentation();
            default -> this.representationCharacter = type.getBlackRepresentation();
        }
        this.type = type;
    }


    public Color getColor(){
        return this.color;
    }

    public Type getType(){
        return this.type;
    }

    public char getRepresentation(){
        return this.representationCharacter;
    }

    public String getName(){
        return this.type.toString();
    }

    public boolean isBlack(){
        return this.color.equals(Color.BLACK);
    }

    public boolean isWhite(){
        return this.color.equals(Color.WHITE);
    }

    private static Piece createWhite(Type type){
        return new Piece(Color.WHITE,type);
    }

    private static Piece createBlack(Type type){
        return new Piece(Color.BLACK,type);
    }

    public static Piece createWhitePawn(){
        return createWhite(Type.PAWN);
    }
    public static Piece createBlackPawn(){
        return createBlack(Type.PAWN);
    }
    public static Piece createWhiteKnight(){
        return createWhite(Type.KNIGHT);
    }
    public static Piece createBlackKnight(){
        return createBlack(Type.KNIGHT);
    }
    public static Piece createWhiteKing(){
        return createWhite(Type.KING);
    }
    public static Piece createBlackKing(){
        return createBlack(Type.KING);
    }
    public static Piece createWhiteQueen(){
        return createWhite(Type.QUEEN);
    }
    public static Piece createBlackQueen(){
        return createBlack(Type.QUEEN);
    }
    public static Piece createWhiteRook(){
        return createWhite(Type.ROOK);
    }
    public static Piece createBlackRook(){
        return createBlack(Type.ROOK);
    }
    public static Piece createWhiteBishop(){
        return createWhite(Type.BISHOP);
    }
    public static Piece createBlackBishop(){
        return createBlack(Type.BISHOP);
    }

    public static Piece createBlank(){
        return new Piece(Color.NOCOLOR,Type.NO_PIECE);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.color,this.getType());
    }

    @Override
    public boolean equals(Object obj){
        return (this.getType() == ((Piece)obj).getType()) && (this.getColor() == ((Piece)obj).getColor());
    }

}
