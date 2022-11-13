package br.com.softblue.jogoforca.game;

import br.com.softblue.jogoforca.core.Dictionary;
import br.com.softblue.jogoforca.core.Word;

public class Game {

    // método que inicia o jogo
    public void start() {

        // criando uma instância da classe Dictionary, existindo apenas uma instancia dessa classe, tornado unica
        Dictionary d1 = Dictionary.getInstance();
        System.out.println(d1);
        Word w1 = d1.nextWord();
        System.out.println(w1.getOriginalWord());
    }
}
