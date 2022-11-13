package br.com.softblue.jogoforca.ui;

import br.com.softblue.jogoforca.core.InvalidCharacterException;

import java.util.Scanner;

public class UI {

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static char readChar(String text) throws  InvalidCharacterException{
        System.out.println(text + " ");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // verificando se o usuário digitou uma linha em branco
        if (line.trim().isEmpty()) {
            throw new InvalidCharacterException("Nenhuma letra foi digitada");
        }

        // verificando se o usuário digitou mais de um caractere
        if (line.length() > 1) {
            throw new InvalidCharacterException("Apenas uma letra deve ser digitada");
        }

        // obtendo o primeiro caractere da linha e transformando em char
        char c = line.charAt(0);

        // verificando se o caractere é uma letra.
        if (Character.isLetter(c)) {
            throw new InvalidCharacterException("Apenas letras devems er digitadas");
        }
        return c;
    }
}
