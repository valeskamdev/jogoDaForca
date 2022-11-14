package br.com.softblue.jogoforca.core;

// classe abstrata, não podendo ter objetos, apenas objeto da subclasse
public abstract class Dictionary {

    private static Dictionary instance;   // armazenar a instância da classe

    //criando uma classe com apenas um objeto
    // criando uma nova intancia se a instancia for nula
    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new FIleDictionary();
        }
        return instance;
    }

    // retorna uma palavra aleatória da lista de palavras
    public abstract Word nextWord();
    public abstract String getName();
}
