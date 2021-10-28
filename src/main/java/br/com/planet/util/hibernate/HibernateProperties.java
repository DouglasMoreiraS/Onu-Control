package br.com.planet.util.hibernate;

import br.com.planet.util.PropertiesUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HibernateProperties {

    private static final String PATH = System.getProperty("user.dir") + "//data//config.properties";
    private String host;
    private String login;
    private String pass;

    public static HibernateProperties getProperties() throws FileNotFoundException, IOException {

        HibernateProperties retorno = new HibernateProperties();
        Properties p = PropertiesUtil.getProperties(PATH);

        if (p != null) {

            retorno.host = p.getProperty("p.server.host");
            System.out.println(retorno.host);
            retorno.login = p.getProperty("p.server.login");
            retorno.pass = p.getProperty("p.server.password");

            return retorno;
        } else {
            return null;
        }
    }

    public static boolean verificarProperties() {
        return PropertiesUtil.getProperties(PATH) != null;
    }

    public String getHost() {
        return host;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

}
