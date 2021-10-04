package br.com.planet.util;

import br.com.planet.model.bean.Propriedades;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtil {

    public static String PROPERTIES_DIRECTORY = System.getProperty("user.dir") + "\\data\\equipConfig";
    public static String PPOE_PROPERTIES_DIRECTORY = System.getProperty("user.dir") + "\\data\\ppoe.properties";

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
    public static void saveProperties(Propriedades p) {

        try {
            FileOutputStream fos = new FileOutputStream(new File(p.getPath()));
            objectToProperties(p).store(fos, "teste");

            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Propriedades> getAllEquipamentProperties() {
        List<Propriedades> prop = new ArrayList<>();

        File folder = new File(PROPERTIES_DIRECTORY);

        for (File f : folder.listFiles()) {
            Propriedades p = propertiesToObject(getProperties(f.getAbsolutePath()));
            p.setPath(f.getAbsolutePath());
            prop.add(p);
        }
        return prop;
    }

    private static Properties objectToProperties(Propriedades p){
        Properties pp = getProperties(p.getPath());
        
        pp.setProperty("name", p.getName());
        pp.setProperty("p.url.main", p.getUrlMain());
        pp.setProperty("p.user", p.getUsuario());
        pp.setProperty("p.pass", p.getSenha());
        pp.setProperty("p.pass1", p.getSenha1());
        pp.setProperty("p.pass2", p.getSenha2());
        pp.setProperty("p.url.firmware", p.getUrlFirmware());
        pp.setProperty("p.url.upgrade", p.getUrlFirmwareUpdate());
        pp.setProperty("p.url.pon", p.getUrlPonStatus());
        pp.setProperty("p.url.sn", p.getUrlSn());
        pp.setProperty("p.url.ppoe_config", p.getUrlPPOEConfig());
        pp.setProperty("p.url.reset", p.getUrlResetPage());
        pp.setProperty("p.url.wifi_config", p.getUrlWifiConfig());
        pp.setProperty("p.xpath.firmware", p.getXpathFirmware());
        pp.setProperty("p.xpath.pon", p.getXpathPonStatus());
        pp.setProperty("p.xpath.sn", p.getXpathSn());
        pp.setProperty("p.title", p.getTitlePage());
        pp.setProperty("p.firmware.path", p.getFirmwarePath());
        pp.setProperty("p.firmware.atual", p.getRecentFirmware());
        
        return pp;
    }
    
    private static Propriedades propertiesToObject(Properties p) {
        
        Propriedades pp = new Propriedades();
        pp.setName(p.getProperty("name"));
        
        pp.setUrlMain(p.getProperty("p.url.main"));

        pp.setUsuario(p.getProperty("p.user"));
        pp.setSenha(p.getProperty("p.pass"));
        pp.setSenha1(p.getProperty("p.pass1"));
        pp.setSenha2(p.getProperty("p.pass2"));
        
        pp.setUrlFirmware(p.getProperty("p.url.firmware"));
        pp.setUrlFirmwareUpdate(p.getProperty("p.url.upgrade"));
        pp.setUrlPonStatus(p.getProperty("p.url.pon"));
        pp.setUrlSn(p.getProperty("p.url.sn"));
        pp.setUrlPPOEConfig(p.getProperty("p.url.ppoe_config"));
        pp.setUrlResetPage(p.getProperty("p.url.reset"));
        pp.setUrlWifiConfig(p.getProperty("p.url.wifi_config"));
        
        pp.setXpathFirmware(p.getProperty("p.xpath.firmware"));
        pp.setXpathPonStatus(p.getProperty("p.xpath.pon"));
        pp.setXpathSn(p.getProperty("p.xpath.sn"));

        pp.setTitlePage(p.getProperty("p.title"));
        pp.setFirmwarePath(p.getProperty("p.firmware.path"));
        pp.setRecentFirmware(p.getProperty("p.firmware.atual"));
        
        
        return pp;
    }

}
