package br.com.softblue.jogoforca.utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    // gerando um número aleatório entre min e max
    public static int newRandomNumber(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
