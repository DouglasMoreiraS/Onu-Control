
import br.com.planet.util.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextFiberUpdateTest {

    public String url = "http://192.168.3.1";

    public void teste() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        while (true) {
            try {
                this.logar(driver);

                driver.get("http://192.168.3.1/upgrade.asp");

                driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr/th/input")).sendKeys("C:\\\\firmwares\\\\nextfiber\\\\v1.0.8.tar");

                driver.findElement(By.xpath("/html/body/form/div[2]/input[1]")).click();

                driver.switchTo().alert().accept();

                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                while (!driver.findElement(By.xpath("/html/body/div/div/div[2]")).getText().equals("100%")) {
                }

                Thread.sleep(10000);
                int cont = 0;

                String log = Utils.getAtualDate() + " start";

                while (true) {
                    System.out.println(cont);
                    try {
                        this.logar(driver);
                        break;
                    } catch (Exception e) {
                    }
                    cont++;
                }
                System.out.println(cont);
                log = log.concat(Utils.getAtualDate() + " finish: " + cont + System.lineSeparator() + " ************" + System.lineSeparator());

                //saveLog(log);
                for (String s : driver.getWindowHandles()) {
                    System.out.println(s);
                }

                List<String> abas = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(abas.get(1));
                driver.close();
                driver.switchTo().window(abas.get(0));
                

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public boolean logar(WebDriver driver) {
        try {

            driver.get(url);
            if (driver.getTitle().equals("XPON HGU")) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys("admin");
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys("@#Pl4n3t#@");
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public void saveLog(String log) throws IOException {

        FileWriter arq = new FileWriter("C:\\firmwares\\nextfiber\\log.txt", true);
        PrintWriter pwriter = new PrintWriter(arq);
        pwriter.write(log);
        pwriter.close();
    }

}
