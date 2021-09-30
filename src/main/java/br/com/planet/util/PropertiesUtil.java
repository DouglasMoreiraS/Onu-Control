package br.com.planet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtil {

    public static final Properties getProperties(String path) {

        FileInputStream fis = null;
        try {
            File file = new File(path);
            fis = new FileInputStream(file);

            Properties p = new Properties();
            p.load(fis);

            return p;
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found Exception em PropertiesUtil: " + ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.out.println("IOException em PropertiesUtil: " + ex.getMessage());
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void saveProperties(Properties p, String path) {

        try {
            FileOutputStream fos = new FileOutputStream(new File(path));
            p.store(fos, "teste");

            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
