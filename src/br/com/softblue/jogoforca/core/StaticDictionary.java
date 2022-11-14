package br.com.softblue.jogoforca.core;

import java.util.List;

public class StaticDictionary  extends Dictionary{

    private List<String> words = List.of("Casa", "Computador", "Caneta", "Carro");
    private int currentIndex = -1;

    // retornando um objeto Word com a palavra no índice atual
    @Override
    public Word nextWord() {
        currentIndex = (currentIndex + 1) % words.size();
        return new Word(words.get(currentIndex));
    }

    @Override
    public String getName() {
        return "Estático";
    }
}
