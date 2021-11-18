package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class TpLinkWR840NControle extends Controle {

    public TpLinkWR840NControle() {
        super();
        timeout = 10;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\tplink.properties");
        tipo = Controle.ROUTER_TYPE;
        this.m.setObservacao("Comodato");

    }

    public boolean logar() throws WebDriverException {

        try {
            driver.get(url);

            String xpathLogin1 = "//*[@id=\"pc-setPwd-new\"]";
            String xpathLogin2 = "//*[@id=\"pc-setPwd-confirm\"]";

            String xpathLogin = "//*[@id=\"pc-login-password\"]";

            if (Utils.existsElement(driver, xpathLogin1) && driver.findElement(By.xpath(xpathLogin1)).isDisplayed()) {
                driver.findElement(By.xpath(xpathLogin1)).clear();
                driver.findElement(By.xpath(xpathLogin1)).sendKeys(senha);
                driver.findElement(By.xpath(xpathLogin2)).clear();
                driver.findElement(By.xpath(xpathLogin2)).sendKeys(senha);
                driver.findElement(By.xpath("//*[@id=\"pc-setPwd-btn\"]")).click();
            } else if (Utils.existsElement(driver, xpathLogin)) {
                driver.findElement(By.xpath(xpathLogin)).clear();
                driver.findElement(By.xpath(xpathLogin)).sendKeys(senha);

                driver.findElement(By.xpath("//*[@id=\"pc-login-btn\"]")).click();
            }

            if (Utils.existsElement(driver, "//*[@id=\"confirm-yes\"]")) {

                for (int tries = 2; tries != 0; tries--) {
                    try {
                        driver.findElement(By.xpath("//*[@id=\"confirm-yes\"]")).click();
                    } catch (WebDriverException e) {

                    }
                }
            }

            if (Utils.existsElement(driver, "//*[@id=\"advanced\"]")) {
                System.out.println("Existe");
                return true;
            } else {
                System.out.println("Nao existe");
                return false;
            }

        } catch (WebDriverException e) {
            System.out.println("Erro TPLINK logar: " + e.getMessage());
            this.writeLog("logar", e.getMessage());
            throw e;
        }

    }

    public void getPon() {
    }

    @Override
    public void getSn() throws WebDriverException {
        try {
            this.sendMeMainPage();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[3]/a")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[3]/ul/li[2]/a")).click();
            //*[@id="menuTree"]/li[3]/ul/li[4]/a

            WebElement sn = driver.findElement(By.xpath("//*[@id=\"lanMacAddress\"]"));

            String serial = sn.getAttribute("value");
            System.out.println(serial);

            m.getEquipamento().setSn(serial);
            System.out.println(m.getEquipamento().getSn());
        } catch (WebDriverException e) {
            System.out.println("Erro TPLINK getSn: " + e.getMessage());
            this.writeLog("getSn", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            this.writeLog("getSn", ex.getMessage());
        }

    }

    public void getFirmware() throws WebDriverException {
        try {
            sendMeMainPage();

            Thread.sleep(1000);

            WebElement firm = driver.findElement(By.xpath("//*[@id=\"bot_sver\"]"));
            String firmware = firm.getAttribute("innerText");
            System.out.println(firmware);

            m.getEquipamento().setFirmware((firmware.substring(firmware.indexOf(":") + 1, firmware.indexOf("Rel."))).trim());

        } catch (WebDriverException e) {
            System.out.println("Erro TPLINK getFirmware: " + e.getMessage());
            this.writeLog("getFirmware", e.getMessage());
            throw e;
        }catch (InterruptedException ex){
            
        }
    }

    public void updateFirmware() {
        try {
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[9]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[9]/ul/li[3]/a")).click();
            WebElement firmwarePathElement = driver.findElement(By.xpath("//*[@id=\"filename\"]"));
            firmwarePathElement.sendKeys(firmwarePath);
            driver.findElement(By.xpath("//*[@id=\"t_upgrade\"]")).click();
        } catch (WebDriverException e) {
            System.out.println("Erro TPLINK WR840N updateFirmware: " + e.getMessage());
            this.writeLog("updateFirmware", e.getMessage());
        }
    }

    private void sendMeMainPage() {
        try {
            driver.get(url);
            if (Utils.existsElement(driver, "//*[@id=\"advanced\"]")) {
                for (int tries = 2; tries >= 0; tries--) {
                    try {
                        driver.findElement(By.xpath("//*[@id=\"advanced\"]")).click();
                    } catch (NoSuchElementException e) {

                    }
                }
            }
        } catch (WebDriverException e) {
            System.out.println("Erro TPLINK Main Page: " + e.getMessage());
            this.writeLog("sendMeMainPage", e.getMessage());

            throw e;
        }

    }

}
