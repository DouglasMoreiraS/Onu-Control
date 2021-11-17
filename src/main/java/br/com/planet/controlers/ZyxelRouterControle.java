package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZyxelRouterControle extends Controle{

    public ZyxelRouterControle(boolean headless) {
        super();
        this.url = "http://192.168.1.1/";
        this.login = "admin";
        this.senha = "@#Pl4n3t#@";
        this.driver = new ChromeDriver(options);
    }
    
    @Override 
    public boolean logar()throws Exception{ 
        
        try {
            driver.get(url);
            
            driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/div/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[2]/div/div[1]/input[1]")).sendKeys(senha);
            driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[4]/button")).click();
        } catch (Exception e){
            
        }
        return false;
    }

    
}
