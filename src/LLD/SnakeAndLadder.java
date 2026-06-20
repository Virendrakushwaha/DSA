package LLD;

import java.util.List;

public class SnakeAndLadder {
//    Design and implement a LLD.Snake & LLD.Ladder game in Java. The game runs on the console.
//    Focus on clean class design and SOLID principles — a working game with bad design scores less than
//    a well-designed incomplete one.
//
//            Functional Requirements
//
//	•	2 to 4 players with names
//	•	LLD.Board is 10×10 (cells 1 to 100)
//            •	Snakes and Ladders are configured at the start (positions hardcoded in main)
//	•	LLD.Player rolls one 6-sided die per turn
//	•	Landing on snake’s head → slide to tail; landing on ladder’s base → climb to top
//	•	Overshoot rule: if roll takes player beyond 100, position stays unchanged
//	•	First player to reach exactly 100 wins; game stops immediately
//	•	Print each turn: player name, roll value, old position → new position, and if a snake/ladder was hit


}

class Player{
    private String name;
    private String oldPos;
    private String newPos;
    private Dice rollValue;
}

class Snake{
    private int snakeId;
    private int headPos;
    private int tailPos;
}

class Ladder{
    private int ladderId;
    private int headPos;
    private int tailPos;
}

enum Dice{
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);
    private final int value;
         Dice(int value){
             this.value = value;
         }

         public int getValue(){
             return value;
    }
}

class Game{
    private String gameId;
    private Board board;
    private List<Player> playerList;
}

class Board{
    private int size;
    private List<Integer> positions;
    private Dice possibleValue;
    private List<Snake> snakes;
    private List<Ladder> ladder;
}