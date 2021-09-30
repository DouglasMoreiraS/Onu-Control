package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.Utils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChimaControle extends Controle {

    public ChimaControle(boolean condition) {
        super(condition);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.CHIMA));

        this.loadProperties(Utils.PROPERTIES_DIRECTORY + "\\chima.properties");

    }

    @Override
    public boolean logar() throws Exception {

        try {
            driver.get(url);

            if (driver.getTitle().equals(title)) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[3]/td[3]/font/input")).sendKeys(senha);
            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[4]/td[3]/input")).click();

            try {
                driver.get(url);
                driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys(login);
                return false;
            } catch (Exception e) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro Chima logar: " + e.getMessage());
            throw new Exception(e);
        }

    }

    @Override
    public void reset() throws Exception {
        try {
            driver.get(urlReset);
            driver.findElement(By.xpath("/html/body/blockquote/table[2]/tbody/tr[3]/td[2]/font/input")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(60000);
            this.start();
        } catch (Exception e) {
            System.out.println("Erro Chima Reset: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public boolean needUpdate() {
        return false;
    }

}
