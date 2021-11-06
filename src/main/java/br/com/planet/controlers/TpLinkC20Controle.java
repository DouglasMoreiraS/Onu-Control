package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Modelo;
import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class TpLinkC20Controle extends Controle {

    public TpLinkC20Controle() {
        super();
        timeout = 10;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\tplinkc20.properties");
    }

    public boolean logar() throws Exception {

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

        } catch (Exception e) {
            System.out.println("Erro TPLINK logar: " + e.getMessage());
            throw e;
        }
    }

    public void getPon() {
    }

    @Override
    public void getSn() throws Exception {
        try {
            this.sendMeMainPage();

            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[2]/a")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[2]/ul/li[2]/a")).click();

            WebElement sn = driver.findElement(By.xpath("//*[@id=\"lanMacAddress\"]"));

            String serial = sn.getAttribute("value");

            m.getEquipamento().setSn(serial);
        } catch (Exception e) {
            System.out.println("Erro TPLINK getSn: " + e.getMessage());
            throw e;
        }

    }

    public void getFirmware() throws Exception {
        try {
            sendMeMainPage();

            WebElement firm = driver.findElement(By.xpath("//*[@id=\"bot_sver\"]"));
            String firmware = firm.getAttribute("innerText");
            System.out.println(firmware);

            m.getEquipamento().setFirmware(firmware.substring(firmware.indexOf(":") + 1, firmware.indexOf("Rel.")));

        } catch (Exception e) {
            System.out.println("Erro TPLINK getFirmware: " + e.getMessage());
            throw e;
        }
    }

    public void updateFirmware() {
        try {
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[9]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[9]/ul/li[3]/a")).click();
            WebElement firmwarePathElement = driver.findElement(By.xpath("//*[@id=\"filename\"]"));
            firmwarePathElement.sendKeys(firmwarePath);
            driver.findElement(By.xpath("//*[@id=\"t_upgrade\"]")).click();
        } catch (Exception e) {
            System.out.println("Erro TPLINK WR840N updateFirmware: " + e.getMessage());
        }
    }

    private void sendMeMainPage() {
        try {
            driver.get(url);
            if (Utils.existsElement(driver, "//*[@id=\"advanced\"]")) {
                driver.findElement(By.xpath("//*[@id=\"advanced\"]")).click();
            }
        } catch (Exception e) {
            System.out.println("Erro TPLINK Main Page: " + e.getMessage());
            throw e;
        }

    }

}
