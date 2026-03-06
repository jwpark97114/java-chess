package com.Chess;
import com.pieces.*;
import static com.utils.StringUtils.appendNewLine;
import static com.utils.StringUtils.convertPosToIndices;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Board {

    private List<Piece> whitePieces;
    private List<Piece> blackPieces;
    private List<Piece> piecesOnBoard;

    private final List<List<Piece>> gameBoard = new ArrayList<>();




    public Board(){
        for(int i = 0 ; i < 8; i++){
            List<Piece> tmp = new ArrayList<>();
            this.gameBoard.add(tmp);
        }
    }

    public void initialize(){
        for(int i=0; i <8; i++){
            this.gameBoard.set(i, new ArrayList<>());
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

    public Piece findPiece(String position){
        int[] indices = convertPosToIndices(position);
        return this.gameBoard.get(indices[0]).get(indices[1]);
    }
    public Piece findPiece(int i , int j){
        return this.gameBoard.get(i).get(j);
    }

    public Piece findPiece(int[] position){
        return this.gameBoard.get(position[0]).get(position[1]);
    }

    public void initializeEmpty(){

        for(int i =0; i < 8; i++){
            this.gameBoard.set(i, new ArrayList<>());
            for(int j = 0; j < 8; j ++){
                this.gameBoard.get(i).set(j, Piece.createBlank());
            }
        }

    }

    public void move(String position, Piece piece){
        int[] coords = convertPosToIndices(position);
        this.gameBoard.get(coords[0]).set(coords[1],piece);
    }

    public void move(String currentPosition, String targetPosition){
        int[] currentIndices = convertPosToIndices(currentPosition);
        int[] targetIndices = convertPosToIndices(targetPosition);
        Piece targetPiece = findPiece(currentPosition);
        this.gameBoard.get(targetIndices[0]).set(targetIndices[1],targetPiece);
        this.gameBoard.get(currentIndices[0]).set(currentIndices[1],Piece.createBlank());
    }

    public void move(int[] currentPosition, int[] targetPosition){
        Piece movingPiece = findPiece(currentPosition);
        this.gameBoard.get(targetPosition[0]).set(targetPosition[1],movingPiece);
        this.gameBoard.get(currentPosition[0]).set(currentPosition[1],Piece.createBlank());

    }

    private void loadLists(){
        this.whitePieces = new ArrayList<>();
        this.blackPieces = new ArrayList<>();
        this.piecesOnBoard = new ArrayList<>();

        for(int i =0; i < 8; i++){
            for(int j =0; j <8; j ++){
                Piece tmp = this.gameBoard.get(i).get(j);
                if(tmp.getColor() == Color.BLACK){
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
        Comparator<Piece> scoreCompare = Comparator.comparingDouble(Piece::getScore);
        Collections.sort(this.blackPieces,scoreCompare);
        Collections.sort(this.whitePieces,scoreCompare);
        Collections.sort(this.piecesOnBoard,scoreCompare);
    }
}
