package com.Chess;
import com.pieces.*;
import static com.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();
    private List<Piece> piecesOnBoard = new ArrayList<>();

    private final List<List<Piece>> gameBoard = new ArrayList<>();
    private int pieceCount = 0;

    public Board(){
        for(int i = 0 ; i < 8; i++){
            List<Piece> tmp = new ArrayList<>();
            this.gameBoard.add(tmp);
        }
    }


    public void initialize(){
        for(int i=0; i <8; i++){
            List<Piece> tmp = this.gameBoard.get(i);
            switch(i){
                case 7 -> {
                    tmp.add(Piece.createWhiteRook());
                    tmp.add(Piece.createWhiteKnight());
                    tmp.add(Piece.createWhiteBishop());
                    tmp.add(Piece.createWhiteQueen());
                    tmp.add(Piece.createWhiteKing());
                    tmp.add(Piece.createWhiteBishop());
                    tmp.add(Piece.createWhiteKnight());
                    tmp.add(Piece.createWhiteRook());
                }
                case 6 ->{
                    for(int j=0; j < 8; j++){
                        tmp.add(Piece.createWhitePawn());
                    }
                }
                case 1 -> {
                    for(int j=0; j < 8; j++){
                        tmp.add(Piece.createBlackPawn());
                    }
                }
                case 0 -> {
                    tmp.add(Piece.createBlackRook());
                    tmp.add(Piece.createBlackKnight());
                    tmp.add(Piece.createBlackBishop());
                    tmp.add(Piece.createBlackQueen());
                    tmp.add(Piece.createBlackKing());
                    tmp.add(Piece.createBlackBishop());
                    tmp.add(Piece.createBlackKnight());
                    tmp.add(Piece.createBlackRook());
                }
                default -> {
                    for(int j=0; j < 8; j++){
                        tmp.add(Piece.createBlank());
                    }
                }

            }


        }
    }

    public int countPiece(Piece.Color color, Piece.Type type){
        int count = 0;
        for(List<Piece> rank : this.gameBoard){
            for(Piece p : rank){
                if( (p.getColor() == color) && (p.getType() == type)){
                    count++;
                }
            }
        }
        return count;
    }

    private int[] convertPosToIndices(String position){
        char colChar = position.charAt(0);
        int rank = 8 - Integer.parseInt(position.substring(1));
        int col = colChar - 'a';
        return new int[]{rank, col};
    }

    public Piece findPiece(String position){
        int[] indices = convertPosToIndices(position);
        return this.gameBoard.get(indices[0]).get(indices[1]);
    }

    public void initializeEmpty(){

        for(int i =0; i < 8; i++){
            List<Piece> tmp = this.gameBoard.get(i);
            for(int j = 0; j < 8; j ++){
                tmp.add(Piece.createBlank());
            }
        }

    }

    public void move(String position, Piece piece){
        int[] coords = convertPosToIndices(position);
        this.gameBoard.get(coords[0]).set(coords[1],piece);
    }

    public int pieceCount(){
        return this.pieceCount;
    }

    public double calculatePoint(Piece.Color color){
        double scoreSum = 0.0;

        for(int j =0 ; j < 8; j++){
            boolean hasPawn = false;
            for(int i =0; i < 8; i++){
                Piece tmpPiece = this.gameBoard.get(i).get(j);
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

    public String showBoard(){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < 8; i++){
            for(int j=0; j < 8; j++){
                sb.append(this.gameBoard.get(i).get(j).getRepresentation());
            }
            sb.append(appendNewLine(""));
        }
        return sb.toString();
    }


    private void loadLists(){
        for(int i =0; i < 8; i++){
            for(int j =0; j <8; j ++){
                Piece tmp = this.gameBoard.get(i).get(j);
                if(tmp.getColor() == Piece.Color.BLACK){
                    this.blackPieces.add(tmp);
                }
                else{
                    this.whitePieces.add(tmp);
                }
                this.piecesOnBoard.add(tmp);
            }
        }
    }

    public void sortPieces(){
        loadLists();
        Collections.sort(this.blackPieces, (a,b) -> Double.compare(a.getType().getScore(), b.getType().getScore()));
        Collections.sort(this.whitePieces, (a,b) -> Double.compare(a.getType().getScore(), b.getType().getScore()));
        Collections.sort(this.piecesOnBoard, (a,b) -> Double.compare(a.getType().getScore(), b.getType().getScore()));
    }
}
