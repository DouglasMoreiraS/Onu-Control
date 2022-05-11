package br.com.planet.main;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import br.com.planet.view.View;
import br.com.planet.util.hibernate.HibernateUtil;
import br.com.planet.util.hibernate.HibernateProperties;
import br.com.planet.view.LoadView;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import org.hibernate.HibernateException;

public class Main {

    public static void main(String[] args) {
        LoadView frame = new LoadView();
        
        
        frame.setVisible(true);
        frame.getLblInfo().setText("Verificando Integridade...");
        frame.getPbLoading().setValue(30);

        if (!HibernateProperties.verificarProperties()) {
            JOptionPane.showMessageDialog(null, "O arquivo de propriedades do banco de dados não foi localizado ou não está acessivel", "DBA Acess", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        frame.getLblInfo().setText("Obtendo conexão com Banco de Dados...");
        frame.getPbLoading().setValue(60);

        try {

            HibernateUtil.getSessionFactory();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar se conectar ao banco de dados, o sistema será encerrado", "DBA Acess", JOptionPane.WARNING_MESSAGE);
            System.exit(0);

        }

        frame.getLblInfo().setText("Configurando Layout...");
        frame.getPbLoading().setValue(90);

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        frame.getPbLoading().setValue(100);
        frame.setVisible(false);
        
        View view = new View();
        view.main(args);
    }

}
