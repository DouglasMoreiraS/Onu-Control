package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

public class ZTEF601Controle extends Controle {

    public ZTEF601Controle() {
        super();
        timeout = 5;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\zte_f601.properties");

    }

    @Override
    public boolean logar() throws WebDriverException {

        try {
            driver.get(url);

            if (Utils.existsElement(driver, "//*[@id=\"content\"]/div[2]/div[3]/a")) {
                return true;
            }

            driver.findElement(By.xpath("//*[@id=\"Frm_Username\"]")).sendKeys(login);
            driver.findElement(By.xpath("//*[@id=\"Frm_Password\"]")).sendKeys(senha);
            driver.findElement(By.xpath("//*[@id=\"LoginId\"]")).click();
            this.m.setObservacao("Aparelho Novo");
            try {
                driver.findElement(By.xpath("//*[@id=\"Frm_Username\"]")).sendKeys(login);
                return false;
            } catch (Exception e) {
                return true;
            }

        } catch (WebDriverException e) {
            System.out.println("Erro ZTE F601 logar: " + e.getMessage());
            this.writeLog("logar", e.getMessage());
            throw new WebDriverException(e);

        }

    }

    @Override
    public void reset() throws WebDriverException {
        try {
            driver.get(urlReset);
            driver.findElement(By.xpath("/html/body/blockquote/table[2]/tbody/tr[3]/td[2]/font/input")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(60000);
            this.start();
        } catch (WebDriverException e) {
            System.out.println("Erro Chima Reset: " + e.getMessage());
            throw new WebDriverException(e);
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public void getSn() throws WebDriverException {

        try {
            driver.switchTo().frame("mainFrame");
            this.m.getEquipamento().setSn(driver.findElement(By.xpath("//*[@id=\"Frm_PonSerialNumber\"]")).getText());
        } catch (WebDriverException e) {
            System.out.println("Erro ZTE F601 getSn:  " + e.getMessage());
            this.writeLog("getSn", e.getMessage());
        }

    }

    @Override
    public void getFirmware() throws WebDriverException {

        try {
            driver.navigate().refresh();
            driver.switchTo().frame("mainFrame");
            this.m.getEquipamento().setFirmware(driver.findElement(By.xpath("//*[@id=\"Frm_SoftwareVer\"]")).getText());
            System.out.println(driver.findElement(By.xpath("By.xpath(//*[@id=\"Frm_SoftwareVer\"]")));
        } catch (WebDriverException e) {
            System.out.println("Erro ZTE F601 getFirmware:  " + e.getMessage());
            this.writeLog("getFirmware", e.getMessage());
        }
    }

    @Override
    public void getPon() throws WebDriverException {
        try {
            driver.findElement(By.xpath("//*[@id=\"menu0\"]/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();
            this.m.setPon(driver.findElement(By.xpath("//*[@id=\"Frm_RxPower\"]")).getText());
        } catch (WebDriverException e) {

        }
    }

    public boolean needUpdate() {
        return false;
    }

}
