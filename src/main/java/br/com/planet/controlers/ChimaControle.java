package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChimaControle extends Controle {

    public ChimaControle(boolean condition) {
        super(condition);
        driver = new ChromeDriver(options);
        url = "http://192.168.250.1";
        login = "admin";
        senha = "admin";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.CHIMA));
        
        this.urlSn = "http://192.168.250.1/status.asp";
        this.urlFirmware = "http://192.168.250.1/status.asp";
        this.urlPon = "http://192.168.250.1/status_pon.asp";

        this.xpathSn = "/html/body/blockquote/form[1]/table[2]/tbody/tr[4]/td[2]/font";
        this.xpathFirmware = "/html/body/blockquote/form[1]/table[1]/tbody/tr[4]/td[2]/font";
        this.xpathPon = "/html/body/blockquote/table[2]/tbody/tr[7]/td[2]/font";
    }

    @Override
    public boolean logar() throws Exception {

        try {
            driver.get("http://192.168.250.1");

            if (driver.getTitle().equals("BroadBand Device Webserver")) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys("admin");
            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[3]/td[3]/font/input")).sendKeys("admin");
            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[4]/td[3]/input")).click();

            try {
                driver.get("http://192.168.250.1");
                driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys("admin");
                return false;
            } catch (Exception e) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro Chima logar: " + e.getMessage()  );
            throw new Exception(e);
        }

    }

    public void logout() throws Exception {
        try {
            driver.get("http://192.168.250.1/admin/logout.asp");
            driver.findElement(By.xpath("/html/body/blockquote/form/input[1]")).click();
            Alert popup = driver.switchTo().alert();
            popup.accept();
        } catch (Exception e) {
            System.out.println("Erro Chima logout: " + e.getMessage());
            throw new Exception(e);
        }
    }
    
    @Override
    public void reset() throws Exception {
        try {
            driver.get("http://192.168.250.1/saveconf.asp");
            driver.findElement(By.xpath("/html/body/blockquote/table[2]/tbody/tr[3]/td[2]/font/input")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(60000);
            this.start();
        } catch (Exception e) {
            System.out.println("Erro Chima Reset: " + e.getMessage());
            throw new Exception(e);
        }
    }
    public boolean needUpdate(){
        return false;
    }

}
