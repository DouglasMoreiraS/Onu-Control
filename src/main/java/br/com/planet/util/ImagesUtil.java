package br.com.planet.util;

import br.com.planet.model.bean.Modelo;
import javax.swing.ImageIcon;

public class ImagesUtil {
    
    private static String path = System.getProperty("user.dir") + "//images//";
    
    public static final ImageIcon getImgIcon(String model){
        System.out.println(path + model);
        return new ImageIcon(path + model +".png");
    }
    
    
}
