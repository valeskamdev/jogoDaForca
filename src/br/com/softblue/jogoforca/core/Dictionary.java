package br.com.softblue.jogoforca.core;

import br.com.softblue.jogoforca.game.GameException;
import br.com.softblue.jogoforca.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

    private static final String FILE_NAME = "dicionario.txt"; // constante que armazena o nome do arquivo que contém as palavras
    private List<String> words = new ArrayList<String>();  // Criando uma lista de strings


    private void load() {

       try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {  // lendo arquivo da pasta source

           // lendo o arquivo linha por linha e adicionando cada linha à lista
           while (scanner.hasNextLine()) {  // verificando se existe uma próxima linha no arquivo
               String word = scanner.nextLine().trim();  // trim() removendo espacos em branco
               words.add(word);  // adicionando a palavra na lista
           }

           // verificando se a lista está vazia. Se estiver, lança uma exceção
           if (words.size() == 0) {
               throw new GameException("Lista de palavras não pode ser vazia");
           }
       }
    }

    // retorna uma palavra aleatória da lista de palavras
    public Word nextWord() {
       int posicao = RandomUtils.newRandomNumber(0, words.size());  // gerando um número aleatório entre 0 e o tamanho da lista
        return new Word(words.get(posicao));  // criando um objeto Word com a palavra que foi selecionada aleatoriamente
    }
}
