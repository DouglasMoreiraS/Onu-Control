package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class TpLinkControlador extends Controle {

    public TpLinkControlador(boolean condition) {
        super(condition);
        timeout = 10;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\tplink.properties");

        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.TP_LINK));
        tipo = Controle.ROUTER_TYPE;

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

            if (Utils.existsElement(driver, "//*[@id=\"confirm-yes\"]") && driver.findElement(By.xpath("//*[@id=\"confirm-yes\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[@id=\"confirm-yes\"]")).click();
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

        /*   try {
            driver.get(url);
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/span[1]")).click();
            driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/input[2]")).sendKeys(senha);

            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div/button")).click();

            if (Utils.existsElement(driver, "/html/body/div[4]/div/div[4]/div/div[2]/div/div[2]/button")) {
                driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/div[2]/div/div[2]/button")).click();
            }

            if (Utils.existsElement(driver, "/html/body/div[1]/div[1]/div[2]/div[1]/ul/li[3]/span[2]")) {
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/ul/li[3]/span[2]")).click();
            }

            return true;
        } catch (Exception e) {
            System.out.println("Erro TPLINK logar: " + e.getMessage());
            throw e;
        }*/
    }

    public void getPon() {
    }

    @Override
    public void getSn() throws Exception {
        try {
            this.sendMeMainPage();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[3]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[3]/ul/li[2]/a")).click();
            //*[@id="menuTree"]/li[3]/ul/li[4]/a

            WebElement sn = driver.findElement(By.xpath("//*[@id=\"lanMacAddress\"]"));

            if (sn.isDisplayed()) {
                System.out.println("SN ativo");
                System.out.println("1 =" + sn.getAttribute("innerText"));
                System.out.println("2 =" + sn.getAttribute("textContent"));
                System.out.println("3 =" + sn.getAttribute("innerHTML"));
                System.out.println("4 =" + sn.getAttribute("value"));
            } else {
                System.out.println("Nao ");
            }
            String serial = sn.getAttribute("value");
            System.out.println(serial);

            m.getEquipamento().setSn(serial);
            System.out.println(m.getEquipamento().getSn());
        } catch (Exception e) {
            System.out.println("Erro TPLINK getSn: " + e.getMessage());
            throw e;
        }

    }

    public void getFirmware() throws Exception {
        try {
            sendMeMainPage();

            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[9]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"menuTree\"]/li[9]/ul/li[3]/a")).click();

            WebElement firm = driver.findElement(By.xpath("//*[@id=\"bot_sver\"]"));
            String firmware = firm.getAttribute("innerText");
            System.out.println(firmware);

            m.getEquipamento().setFirmware(firmware.substring(firmware.indexOf(":") + 1, firmware.indexOf("Build")));
            //m.getEquipamento().setFirmware(firmware);

            WebElement firmwarePath = driver.findElement(By.xpath("//*[@id=\"filename\"]"));

            if (firmwarePath.isDisplayed()) {
                System.out.println("is Displayed");
            }
            if (firmwarePath.isEnabled()) {
                System.out.println("is Enabled");
            }
            if (firmwarePath.isSelected()) {
                System.out.println("is Selected");
            }
            /*
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                js.executeScript("arguments[0].removeAttribute('readonly', 'readonly')", firmwarePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
             */
            firmwarePath.sendKeys("C:\\Users\\PC_PLANET\\Desktop\\TL-WR840N(BRWISP)v6_3.16.0_0.9.1_up_boot(190312)_2019-03-12_17.16.59.bin");

            driver.findElement(By.xpath("//*[@id=\"t_upgrade\"]")).click();

            System.out.println("Atualizando...");

        } catch (Exception e) {
            System.out.println("Erro TPLINK getFirmware: " + e.getMessage());
            throw e;
        }
    }

    public void updateFirmware() {

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
