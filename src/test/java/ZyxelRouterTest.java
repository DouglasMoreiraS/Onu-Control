
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZyxelRouterTest {

    public void teste() {

        WebDriverManager.chromedriver().setup();
        
        String url = "http://192.168.1.1/";
        String login = "admin";
        String senha = "@#Pl4n3t#@";

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/div/input")).sendKeys(login);
        driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[2]/div/div[1]/input[1]")).sendKeys(senha);
        driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[4]/button")).click();
    }

}
