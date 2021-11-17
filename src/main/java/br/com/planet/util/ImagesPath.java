package br.com.planet.util;

import java.io.File;
import java.io.IOException;

public class ImagesPath {
    
    private static final String IMAGE_FOLDER = "\\images\\";
    
    
    
    public static final String getNextFiberFolder() throws IOException{
        return new File(".").getCanonicalPath() + IMAGE_FOLDER + "nextfiber.png";
    }
    public static final String getChimaFolder() throws IOException{
        return new File(".").getCanonicalPath() + IMAGE_FOLDER + "chima.png";
    }
    public static final String getHuaweiEchoLifeFolder() throws IOException{
        return new File(".").getCanonicalPath() + IMAGE_FOLDER + "huaweieco.png";
    }
    public static final String getZyxelFolder() throws IOException{
        return new File(".").getCanonicalPath() + IMAGE_FOLDER + "zyxel.png";
    }
    public static final String getSumecFolder() throws IOException{
        return new File(".").getCanonicalPath() + IMAGE_FOLDER + "sumec.png";
    }
    
}
