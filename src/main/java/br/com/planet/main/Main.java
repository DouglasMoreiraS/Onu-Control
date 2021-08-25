package br.com.planet.main;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import br.com.planet.view.View;
import java.io.File;
import java.io.IOException;
import br.com.planet.util.HibernateUtil;
import br.com.planet.util.ImagesPath;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        View view = new View();
        view.main(args);
    }

}
