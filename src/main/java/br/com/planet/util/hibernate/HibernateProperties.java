package br.com.planet.util.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HibernateProperties {

    private static final String PATH = System.getProperty("user.dir") + "//config.properties";
    private String host;
    private String login;
    private String pass;

    public static HibernateProperties getProperties() throws FileNotFoundException, IOException {

        HibernateProperties retorno = new HibernateProperties();
        Properties p = new Properties();
        FileInputStream file = new FileInputStream(PATH);

        p.load(file);

        retorno.host = p.getProperty("p.server.host");
        retorno.login = p.getProperty("p.server.login");
        retorno.pass = p.getProperty("p.server.password");

        return retorno;
    }

    public static boolean verificarProperties() {
        System.out.println(PATH);

        try {
            FileInputStream file = new FileInputStream(PATH);
            return true;

        } catch (FileNotFoundException ex) {
            return false;
        }

    }

    public  String getHost() {
        return host;
    }

    public  String getLogin() {
        return login;
    }

    public  String getPass() {
        return pass;
    }

}
