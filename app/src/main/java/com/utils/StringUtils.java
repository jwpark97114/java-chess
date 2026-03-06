package com.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils(){

    }

    public static int[] convertPosToIndices(String position){
        char colChar = position.charAt(0);
        int rank = 8 - Integer.parseInt(position.substring(1));
        int col = colChar - 'a';
        return new int[]{rank, col};
    }

    public static String appendNewLine(String s){
        return s + NEWLINE;
    }

}
