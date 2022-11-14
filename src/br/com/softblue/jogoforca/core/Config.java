package br.com.softblue.jogoforca.core;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties props = new Properties();

    // bloco estático, executado quando a classe é carregada
    static {
        try {
            props.load(Config.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // obtem o valor da propriedade com o nome fornecido
    public static String get(String name) {
        return props.getProperty(name);
    }

    //  método que define o número máximo de erros
    public static void setMaxErrors(String maxErrors) {
        props.setProperty("maxErrors", maxErrors);
    }

}
