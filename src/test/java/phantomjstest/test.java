/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phantomjstest;

import java.util.ArrayList;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class test {
    
    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
         System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\data\\chrome\\chromedriver.exe");

        options = new ChromeOptions();
        options.setBinary(System.getProperty("user.dir") + "\\data\\chrome\\bin\\chrome.exe"); //Setando path do navegador
        options.addArguments("user-data-dir=" + System.getProperty("user.dir") + "\\data\\chrome\\profile"); //Setando o perfil do chrome pre-criado
        options.addArguments("start-maximized");
        
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        ((JavascriptExecutor)driver).executeScript("window.open('');");
         driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
         
    }

}
