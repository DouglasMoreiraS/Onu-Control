package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.FirmwarePath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

public class EasyLinkControle extends Controle {

    public EasyLinkControle(boolean visible) {
        super(visible);
        driver = new ChromeDriver(options);
        this.url = "http://192.168.101.8";
        login = "admin";
        login = "admin";
        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.EASY_LINK));

        this.firmwareAtualVersion = "2.0.2.190711140646";

        this.urlSn = "http://192.168.101.8/status.asp";
        this.urlFirmware = "http://192.168.101.8/status.asp";
        this.urlPon = "http://192.168.101.8/status_pon.asp";

        this.xpathSn = "/html/body/blockquote/form[1]/table[2]/tbody/tr[4]/td[2]/font";
        this.xpathFirmware = "/html/body/blockquote/form[1]/table[1]/tbody/tr[4]/td[2]/font";
        this.xpathPon = "/html/body/blockquote/table[2]/tbody/tr[7]/td[2]/font";

    }

    @Override
    public boolean logar() throws Exception {

        try {

            driver.get(url);

            if (driver.getTitle().equals("BroadBand Device Webserver")) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys("admin");
            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[3]/td[3]/font/input")).sendKeys("admin");
            driver.findElement(By.xpath("/html/body/blockquote/form/center/table/tbody/tr/td/table/tbody/tr[5]/td[3]/input")).click();
            try {
                driver.get(url);
                driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys("admin");
                return false;
            } catch (Exception e) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro EasyLInk logar " + e.getMessage());
            throw e;
        }
    }

    public void logout() throws Exception {
        try {
            driver.get("http://192.168.101.8/admin/logout.asp");
            driver.findElement(By.xpath("/html/body/blockquote/form/input[1]")).click();
            Alert popup = driver.switchTo().alert();
            popup.accept();
        } catch (Exception e) {
            System.out.println("Erro EasyLink logout: " + e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public void reset() throws Exception {
        try {
            driver.get("http://192.168.101.8/saveconf.asp");
            driver.findElement(By.xpath("/html/body/blockquote/table[2]/tbody/tr[3]/td[2]/font/input")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(60000);
            this.start();
        } catch (Exception e) {
            System.out.println("Erro EasyLink Reset: " + e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public void updateFirmware() throws Exception {
        try {

            driver.get("http://192.168.101.8/upgrade.asp");
            driver.findElement(By.xpath("/html/body/blockquote/form/table[2]/tbody/tr/td/font/input")).sendKeys(FirmwarePath.EASY_LINK);
            driver.findElement(By.xpath("/html/body/blockquote/form/p/input[1]")).click();

            try {
                Alert popup;
                popup = driver.switchTo().alert();
                popup.accept();
            } catch (NoAlertPresentException e) {
            }

            Thread.sleep(60000);
            while (true) {
                try {
                    this.logar();
                    this.atualizarInformacoes();
                    break;
                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
            System.out.println("Erro EasyLink UpdateFirmware: " + e.getMessage());
            throw e;
        }
    }

    public boolean needUpdate() {
        return !firmwareAtualVersion.equals(m.getEquipamento().getFirmware());
    }

}
