package br.com.softblue.jogoforca.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// classe abstrata, não podendo ter objetos, apenas objeto da subclasse
public abstract class Dictionary {

    private static Dictionary instance;   // armazenar a instância da classe


    // criando uma nova intancia se a instancia for nula
    // criando uma nova instância da classe que implementa a interface Dictionary
    public static Dictionary getInstance() {
        if (instance == null) {
            try {

                String dictionaryClassName = Config.get("dictionaryClassName");  // obtendo o nome da classe que implementa a interface Dictionary
                Class<?> clazz = Class.forName(dictionaryClassName);  // obtendo o objeto de classe que implementa a interface Dictionary
                Constructor<?> constructor = clazz.getConstructor();  // pegando o construtor da classe
                instance = (Dictionary) constructor.newInstance();  // nova instância da classe que implementa a interface Dictionary

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    // retorna uma palavra aleatória da lista de palavras
    public abstract Word nextWord();
    public abstract String getName();
}
