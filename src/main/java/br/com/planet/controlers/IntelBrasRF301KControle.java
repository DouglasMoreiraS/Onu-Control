package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IntelBrasRF301KControle extends Controle {

    public IntelBrasRF301KControle() {
        super();
        timeout = 5;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\intelbras301k.properties");

    }
    
    private boolean primeiraConfiguracao(){
        
        try{
            
            driver.findElement(By.xpath("//*[@id=\"dhcp\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
            
            return true;
        }catch (WebDriverException e){
            System.out.println("Erro IntelBras primeiraConfiguracao: " + e.getMessage());
            this.writeLog("logar", e.getMessage());
            throw e;
        }
    }

    public boolean logar() throws WebDriverException {

        try {
            driver.get(url);
            
            if (Utils.existsElement(driver, "//*[@id=\"dhcp\"]")){
                primeiraConfiguracao();
                return true;
            }
            String xpathLogin = "//*[@id=\"login-password\"]";

            if (Utils.existsElement(driver, xpathLogin) && driver.findElement(By.xpath(xpathLogin)).isDisplayed()) {
                driver.findElement(By.xpath(xpathLogin)).clear();
                driver.findElement(By.xpath(xpathLogin)).sendKeys(senha);
                driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
                return true;
            } else {
                return true;
            }

        } catch (WebDriverException e) {
            System.out.println("Erro IntelBras logar: " + e.getMessage());
            this.writeLog("logar", e.getMessage());
            throw e;
        }
    }

    public void getPon() {
    }

    @Override
    public void getSn() throws WebDriverException {
        try {

            WebElement button = driver.findElement(By.xpath("//*[@id=\"system\"]"));

            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click()", button);
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }
            
            Thread.sleep(1000);
            
            WebElement sn = driver.findElement(By.xpath("//*[@id=\"macCurrenWrap\"]"));
            
            
            String serial = sn.getText();
            System.out.println("value: " + serial);
            
            m.getEquipamento().setSn(serial.substring(serial.indexOf(":") +2));
            
            System.out.println(m.getEquipamento().getSn());
        } catch (WebDriverException e) {
            System.out.println("Erro IntelBras getSn: " + e.getMessage());
            this.writeLog("getSn", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            Logger.getLogger(IntelBrasRF301KControle.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getFirmware() throws WebDriverException {
        try {

            WebElement button = driver.findElement(By.xpath("//*[@id=\"system\"]"));

            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click()", button);
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }
            
            Thread.sleep(1000);
            
            WebElement firm = driver.findElement(By.xpath("//*[@id=\"firmwareVision\"]"));
            String firmware = firm.getAttribute("innerText");
            System.out.println(firm.getAttribute("innerText") + " - innerText");
            System.out.println(firmware);

            m.getEquipamento().setFirmware(firmware);

        } catch (WebDriverException e) {
            System.out.println("Erro IntelBras getFirmware: " + e.getMessage());
            this.writeLog("getFirmware", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            Logger.getLogger(IntelBrasRF301KControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateFirmware() {
        try {
            WebElement button = driver.findElement(By.xpath("//*[@id=\"system\"]"));

            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click()", button);
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }

            driver.findElement(By.xpath("//*[@id=\"upgrade\"]")).click();
            
            WebElement firmwarePathElement = driver.findElement(By.xpath("//*[@id=\"inportFile\"]"));
            firmwarePathElement.sendKeys(firmwarePath);
            
            driver.findElement(By.xpath("//*[@id=\"upgrade\"]")).click();
            
            try {
                driver.switchTo().alert().accept();
            } catch (NoAlertPresentException e) {
                System.out.println(e.getMessage());
            }

        } catch (WebDriverException e) {
            System.out.println("Erro TPLINK WR840N updateFirmware: " + e.getMessage());
            this.writeLog("updateFirmware", e.getMessage());
        }
    }

}
