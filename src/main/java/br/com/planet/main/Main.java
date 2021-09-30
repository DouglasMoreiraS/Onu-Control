package br.com.planet.main;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import br.com.planet.view.View;
import br.com.planet.util.hibernate.HibernateUtil;
import br.com.planet.util.hibernate.HibernateProperties;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import org.hibernate.HibernateException;

public class Main {

    public static void main(String[] args) {

        if (!HibernateProperties.verificarProperties()) {
            JOptionPane.showMessageDialog(null, "O arquivo de propriedades do banco de dados não foi localizado ou não está acessivel", "DBA Acess", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        try {

            HibernateUtil.getSessionFactory();

        } catch (HibernateException e) {
              JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar se conectar ao banco de dados, o sistema será encerrado", "DBA Acess", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
       
        }

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        View view = new View();
        view.main(args);
    }

}
