package ViewTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTeste {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC_PLANET\\Documents\\NetBeansProjects\\AutomacaoSeleniumMaven\\chromedriver.exe");

        WebDriver d = new ChromeDriver();

        d.get("http:\\192.168.1.1");
        System.out.println("Login: "+ d.getTitle());
        d.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input")).sendKeys("admin");
        d.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("1234");

        Thread.sleep(3000);

        d.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/input[1]")).click();
        Thread.sleep(5000);
        System.out.println(d.findElement(By.xpath("/html/head/title")).getText());
    }

}
