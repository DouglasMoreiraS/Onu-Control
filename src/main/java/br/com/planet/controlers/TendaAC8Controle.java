package br.com.planet.controlers;

import org.openqa.selenium.*;

public class TendaAC8Controle extends TendaControle{
    
    public TendaAC8Controle(){
        super("tendaac8.properties");
    }
    
        public void reset(){
        try{
            
            driver.findElement(By.xpath("/html/body/div[2]/input")).sendKeys("C:\\firmwares\\tenda\\ac8\\ac8 firmware preset.bin");
            
        }catch (WebDriverException e){
            e.printStackTrace();
            throw e;
        }
    }
    
}
