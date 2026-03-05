package com.Chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class GameEngine {
    public static void main(String[] args) {

        Map<String, Consumer<String[]>> commands = new HashMap<>();

        Scanner userScanner = new Scanner(System.in);
        String input ="";
        while(!(input = userScanner.nextLine()).equalsIgnoreCase("exit")){
            // use input
        }
    }
}
