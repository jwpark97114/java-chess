package com.Chess;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class GameEngine {
    public static void main(String[] args) {

        Map<String, Consumer<String[]>> commands = new HashMap<>();

        Board chessBoard = new Board();
        chessBoard.initialize();

        commands.put("move", (arrString) -> chessBoard.move(arrString[0], arrString[1]));
        commands.put("init", (arrString)->{
            chessBoard.initialize();
        });

        Scanner userScanner = new Scanner(System.in);
        String input ="";
        System.out.println(chessBoard.showBoard());
        while(!(input = userScanner.nextLine()).equalsIgnoreCase("exit")){

            String[] inputSlices = input.split(" ");
            String[] param = (Arrays.copyOfRange(inputSlices,1,inputSlices.length));
            commands.get(inputSlices[0]).accept(param);
            System.out.println(chessBoard.showBoard());
        }
    }
}
