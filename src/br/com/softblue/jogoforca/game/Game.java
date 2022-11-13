package br.com.softblue.jogoforca.game;

import br.com.softblue.jogoforca.core.Config;
import br.com.softblue.jogoforca.core.Dictionary;
import br.com.softblue.jogoforca.core.InvalidCharacterException;
import br.com.softblue.jogoforca.core.Word;
import br.com.softblue.jogoforca.ui.UI;

import java.util.HashSet;
import java.util.Set;

public class Game {

    // método que inicia o jogo
    public void start() {

        UI.print("Bem Vindo ao Jogo da Forca!");
        Dictionary dictionary = Dictionary.getInstance(); // instanciando a classe Dictionary
        Word word = dictionary.nextWord();  // retornando uma palavra aleatória do dicionário
        UI.print("A palavra tem " + word.size() + " letras");  // imprimindo o tamanho da palavra
        Set<Character> usedChard = new HashSet<>(); // armazenando nesse conjunto todas as letras do usuario ja escolheu
        int errorCount = 0;
        int maxErrors = Integer.parseInt(Config.get("maxErrors"));
        UI.print("Você pode errar no máximo " + maxErrors + " vezes");
        UI.printNewLine();

        while (true) {
            UI.print(word);
            UI.printNewLine();
            char c;

            try {
                c = UI.readChar("Digite uma letra:");

                // verificando se o usuário já usou a letra
                if (usedChard.contains(c)) {
                    throw new InvalidCharacterException("Esta letra ja foi utilizada");
                }
                usedChard.add(c);

                // verificando se a palavra possui o caractere proposto pelo o usuario
                if (word.hasChar(c)) {
                    UI.print("Você acertou uma letra!");
                } else {
                    errorCount++;

                    // verificando se o usuário já cometeu 5 erros
                    if (errorCount < maxErrors) {
                        UI.print("Você errou! Você ainda pode errar " + (maxErrors - errorCount) + " vez(es)");
                    }
                }
                UI.printNewLine();

                // verificando se a palavra foi descoberta
                if (word.discovered()) {
                    UI.print("PARABÉNS! Você acertou a palavra completa: " + word.getOriginalWord());
                    UI.print("FIM DE JOGO");
                    break; //  quebrando o loop depois que o usuario ganhar
                }

                // verificando se o usuário já cometeu 5 erros
                if (errorCount  == maxErrors) {
                    UI.print("Você perdeu o jogo! A palavra correta era: " + word.getOriginalWord());
                    UI.print("FIM DE JOGO");
                    break; //  quebrando o loop se o usuario errar 5 vezes
                }

            } catch (InvalidCharacterException e) {
                UI.print(e.getMessage());
                UI.printNewLine();
            }
        }
    }
}
