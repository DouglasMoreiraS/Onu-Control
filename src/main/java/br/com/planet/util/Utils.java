package br.com.planet.util;

import br.com.planet.model.bean.Equipamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Utils {

    public static String THIS_DIRECTORY = System.getProperty("user.dir");

    public static boolean existsElement(WebDriver driver, String xpath) {
        try {
            //           driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static boolean displayedElement(WebDriver driver, String xpath) {

        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            if (element.isDisplayed()){
                System.out.println("Elemento displayed");
            }
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }

    }

    public static final String getAtualDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return (dtf.format(LocalDateTime.now()));
    }

}
