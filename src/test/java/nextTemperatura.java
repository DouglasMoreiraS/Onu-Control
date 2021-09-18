
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class nextTemperatura {

    @Test
    public void testeUsoCPu() {

        String url = "http://192.168.3.1";
        String login = "admin";
        String senha = "@#Pl4n3t#@";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver;
        driver = new ChromeDriver(options);

        try {
            driver.get(url);
            if (!driver.getTitle().equals("XPON HGU")) {
                driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys(login);
                driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys(senha);
                driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();
            }

        } catch (Exception e) {
            System.out.println("Erro NextFiber logar: " + e.getMessage());
        }
        
        int cont =0;
        while (true){
            cont++;
            driver.get(url +"/status.asp");
            System.out.println(cont +": " +driver.findElement(By.xpath("/html/body/form[1]/div[1]/div[2]/table/tbody/tr[5]/td")).getText());
            driver.navigate().refresh();
        }
        
    }

}
