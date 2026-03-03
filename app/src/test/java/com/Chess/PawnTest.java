package com.Chess;


import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;


public class PawnTest {

     void verifyPawn(final String color){
        Pawn newPawn = new Pawn(color);
        assertThat(newPawn.getColor()).isEqualTo(color);
    }

    @Test
    void create(){
        verifyPawn("White");
        verifyPawn("Black");
    }
}
