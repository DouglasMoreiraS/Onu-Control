package br.com.planet.util.hibernate;

import java.util.Properties;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Firmware;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.model.bean.Modelo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                HibernateProperties propriedades = HibernateProperties.getProperties();
                
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
               // settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, propriedades.getHost());
                settings.put(Environment.USER, propriedades.getLogin());
                settings.put(Environment.PASS, propriedades.getPass());
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Equipamento.class);
                configuration.addAnnotatedClass(Manutencao.class);
                configuration.addAnnotatedClass(Modelo.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
