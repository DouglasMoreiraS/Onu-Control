package br.com.planet.util;

import br.com.planet.model.bean.Modelo;
import javax.swing.ImageIcon;

public class ImagesUtil {
    
    private static String path = System.getProperty("user.dir") + "//images//";
    
    public static final ImageIcon getImgIcon(Modelo model){
        System.out.println(path + model.getNome());
        return new ImageIcon(path + model.getNome() +".png");
    }
    
    
}
