package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import java.util.concurrent.TimeUnit;
import br.com.planet.model.bean.Equipamento;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SumecControle extends Controle {

    public SumecControle(boolean condition) {
        super(condition);
        driver = new ChromeDriver(options);

        this.url = "http://192.168.101.1";
        this.login = "adminisp";
        this.senha = "adminisp";
        this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.SUMEC));
      
        this.tipo = 0;
        this.urlSn = "http://192.168.101.1/status.asp";
        this.urlFirmware = "http://192.168.101.1/status.asp";
        this.urlPon = "http://192.168.101.1/status_pon.asp";
        this.xpathSn = "/html/body/blockquote/form[1]/table[1]/tbody/tr[3]/td[2]/font";
        this.xpathFirmware = "/html/body/blockquote/form[1]/table[1]/tbody/tr[5]/td[2]/font";
        this.xpathPon = "/html/body/blockquote/table[2]/tbody/tr[7]/td[2]/font";
    }

    @Override
    public boolean logar() throws Exception {
        try {
            driver.get("http://192.168.101.1");

            if (driver.getTitle().equals("BroadBand Device Webserver")) {
                return true;
            }

            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("adminisp");
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("adminisp");
            driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

            try {
                driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("adminisp");
                return false;
            } catch (Exception e) {
                if (e.getMessage().contains("ERR_CONNECTION_REFUSED")) {
                    return false;
                }

                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro SUMEC logar: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void reset() throws Exception {

        try {
            driver.get("http://192.168.101.1/saveconf.asp");
            driver.findElement(By.xpath("/html/body/blockquote/table[2]/tbody/tr[3]/td[2]/font/input")).click();
            driver.switchTo().alert().accept();

            Thread.sleep(60000);
            System.out.println("Saiu do sleep");
            while (true) {
                try {
                    this.logar();
                    break;
                } catch (Exception e) {
                }
            }
            this.atualizarInformacoes();
        } catch (Exception e) {
            System.out.println("Erro SUMEC reset: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void logout() throws Exception {
        try {
            driver.get("http://192.168.101.1/admin/logout.asp");
            driver.findElement(By.xpath("/html/body/blockquote/form/input[1]")).click();

            driver.switchTo().alert().accept();

        } catch (Exception e) {
            System.out.println("Erro SUMEC logout: " + e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public boolean needUpdate() {
        return false;
    }

}
