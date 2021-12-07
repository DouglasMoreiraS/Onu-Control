
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PROJETOS
 */
public class ZTEf601test {

    public void teste() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://192.168.1.1/");

        driver.findElement(By.xpath("//*[@id=\"Frm_Username\"]")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id=\"Frm_Password\"]")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id=\"LoginId\"]")).click();

        //GETSn
        driver.switchTo().frame("mainFrame");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"Frm_SerialNumber\"]")).getText());
        System.out.println("");

        //GETFirmware
        System.out.println(driver.findElement(By.xpath("//*[@id=\"Frm_SoftwareVer\"]")).getText());

        //GETPon
        driver.findElement(By.xpath("//*[@id=\"menu0\"]/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"Frm_RxPower\"]")).getText());

    }

}
