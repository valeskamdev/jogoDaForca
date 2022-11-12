package br.com.softblue.jogoforca.core;

import java.util.HashSet;
import java.util.Set;

public class Word {

    private static final char SECRET_CHAR = '_';
    private String originalWord;
    private Set<Character> foundChars = new HashSet<>();  // conjeuto, nao permitindo elementos duplicados
    private Set<Character> wordChars = new HashSet<>();


    public Word(String originalWord) {
        this.originalWord = originalWord.toUpperCase();

        char[] chars = this.originalWord.toCharArray();  // convertendo a string em um array de caracteres

        // adicionando cada caractere da palavra a um conjunto, sem repeticoes (da classe Set)
        for (char c : chars) {
            wordChars.add(c);
        }
    }

    //  retorna o comprimento da palavra
    public int size() {
        return originalWord.length();
    }

    /* método retorna true se a letra estiver na palavra e false se não estiver,
     com parametros: letter – a letra que o usuário adivinhou */
    public boolean hasChar(char letter) {

        letter = Character.toUpperCase(letter);  // convertendo a letra para maiúscula, garantindo encontrar tambem letras minúsculas
        int posicao = originalWord.indexOf(letter);  // retorna o índice da letra da palavra

        // verificar se a letra está na palavra
        if (posicao > -1) {
            foundChars.add(letter);  // adicionando a letra ao conjunto de caracteres encontrados
            return true;
        }
        return false;
    }

    // método que retorna a palavra com as letras encontradas e não encontradas
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();  // uma classe que permite construir uma string concatenando outras strings

        char[] lettersArray = originalWord.toCharArray();

        // obtendo a posição do caractere
        for ( int i = 0; i < lettersArray.length; i++) {
            char c = lettersArray[i];

            // verificando se a letra está no conjunto de letras encontradas
            if(foundChars.contains(c)) {
                sb.append(c);
            }else {
                sb.append(SECRET_CHAR);
            }
            sb.append(" ");
        }
        return sb.toString();  // convertendo o objeto "StringBuilder" em um objeto "String"
    }

    // se os caracteres encontrados forem iguais ao conjunto, fim de jogo
    public boolean discovered() {
       return foundChars.equals(wordChars);  // comparando os dois conjuntos
    }

    // método que retorna a palavra
    public String getOriginalWord() {
        return originalWord;
    }
}
