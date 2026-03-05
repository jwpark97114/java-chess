package com.Chess;

import static com.utils.StringUtils.appendNewLine;

public class ChessView {


    public static String showBoard( Board chessBoard){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < 8; i++){
            for(int j=0; j < 8; j++){
                sb.append(chessBoard.findPiece(i,j).getRepresentation());
            }
            sb.append(appendNewLine(""));
        }
        return sb.toString();
    }
}
