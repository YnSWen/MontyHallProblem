package ru.shir;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {
    private static Map<Integer, Boolean> statistics = new HashMap<>();
    private static Random random = new Random();
    private static final int doorsCount = 3;


    public Game() {
    }


    /**
     * @param switchDoorChoice true - если нужно поменять выбор, false - не менять выбор
     * @return победа(true), проигрыш(false)
     */
    public static boolean round(boolean switchDoorChoice) {
        int winDoor = random.nextInt(doorsCount); //дверь за которой находится приз
        int firstChoiceDoor = random.nextInt(doorsCount); //первый выбор игрока
        int doorToOpen = random.nextInt(doorsCount); // дверь которую откроет ведущий

        while ((doorToOpen == winDoor) || (doorToOpen == firstChoiceDoor)) {
            doorToOpen = random.nextInt(doorsCount);
        } // ведущий не может открыть дверь с призом или дверь, которую выбрал игрок

        int switchDoor = 3 - firstChoiceDoor - doorToOpen; // дверь, которую откроет игрок, если решит
        // изменить свой выбор

        if (switchDoorChoice){
            return winDoor == switchDoor ;

        }
        return winDoor == firstChoiceDoor;
    }



    public static void run(int iterations){
        System.out.println("Игра была запущена " + iterations + " раз" + "\n");
        int countWins = 0;

        for (int i = 0; i < iterations; i++) {
            boolean result = round(true);
            if (result) {
                countWins++;
            }
            statistics.put(i, result);

        }
        System.out.println("Победы при смене выбора: " + countWins + "\n" +
                "Победы не меняя изначальный выбор: " + (1000 - countWins));


    }
}


