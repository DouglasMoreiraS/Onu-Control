package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Mercusys12gControle extends Controle {

    public Mercusys12gControle() {
        super();
        timeout = 3;
        super.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\mercusysa12g.properties");
    }

    public boolean logar() throws WebDriverException {

        try {
            driver.get(url);

            if (Utils.existsElement(driver, "//*[@id=\"pwd\"]")) {
                driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys(senha);
                driver.findElement(By.xpath("//*[@id=\"pwdConf\"]")).sendKeys(senha);
                driver.findElement(By.xpath("//*[@id=\"sub\"]/i")).click();

                for (int tries = 1; tries != 0; tries--) {
                    try {
                        driver.findElement(By.xpath("//*[@id=\"wizardCon\"]/ul/span")).click();
                    } catch (WebDriverException e) {
                    }
                }

            } else {
                driver.findElement(By.xpath("//*[@id=\"lgPwd\"]")).sendKeys(senha);
                driver.findElement(By.xpath("//*[@id=\"loginSub\"]/i")).click();

                if (Utils.existsElement(driver, "//*[@id=\"loginError\"]")) {
                    if (driver.findElement(By.xpath("//*[@id=\"loginError\"]")).isDisplayed()) {
                        //      throw new LoginException("Aparelho precisa ser resetado manualmente para ser acessado");
                    }
                }
            }
            return true;
        } catch (WebDriverException e) {
            throw e;
        }
    }

    public void getSn() throws WebDriverException {
        try {
            driver.findElement(By.xpath("//*[@id=\"headFunc\"]/li[2]")).click();

            for (int tries = 2; tries != 0; tries--) {
                try {
                    driver.findElement(By.xpath("//*[@id=\"netWorkData_menu1\"]")).click();
                    
                    m.getEquipamento().setSn(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mac\"]"))).getText());
                    //*[@id="netWorkData_menu1"]
                } catch (WebDriverException e) {
                    System.out.println("tried " + tries + " times");
                }
            }
           
        } catch (WebDriverException e) {
            System.out.println(Utils.getAtualDate() + "Erro Mercusys getSn: " + e.getMessage());
            throw e;
        }
    }

    public void getFirmware() throws WebDriverException {
        try {
            driver.findElement(By.xpath("//*[@id=\"headFunc\"]/li[2]")).click();

            String firmware = "Unknow";

            for (int tries = 2; tries != 0; tries--) {
                try {
                    firmware = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"softVersion\"]"))).getText();
                } catch (WebDriverException e) {
                }
            }
            m.getEquipamento().setFirmware(firmware.substring(firmware.indexOf(":") + 1, firmware.indexOf("Rel")));
        } catch (WebDriverException e) {
            System.out.println(Utils.getAtualDate() + "Erro Mercusys getFirmware: " + e.getMessage());
            throw e;
        }
    }

    public void getPon() {

    }

    public void ppoe() {

        try {

            driver.findElement(By.xpath("//*[@id=\"headFunc\"]/li[2]")).click();

            for (int tries = 1; tries != 0; tries--) {
                try {
                    driver.findElement(By.xpath("//*[@id=\"netWorkData_menu1\"]")).click();
                } catch (WebDriverException e) {
                }
            }
            while (true) {

                try {
                    driver.findElement(By.xpath("//*[@id=\"netWorkData_menu0\"]")).click();
                    break;
                } catch (WebDriverException e) {
                }
            }

            driver.findElement(By.xpath("//*[@id=\"wanSel\"]")).click();

            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"selOptsUlwanSel\"]/li[3]")).click();

            driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(ppoeUser);
            driver.findElement(By.xpath("//*[@id=\"psw\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"psw\"]")).sendKeys(ppoePass);

            driver.findElement(By.xpath("//*[@id=\"save\"]/i")).click();

        } catch (WebDriverException e) {
            e.printStackTrace();
            System.out.println(Utils.getAtualDate() + " Erro Mercusys ppoe: " + e.getMessage());
        } catch (InterruptedException ex) {
        }

    }

    public boolean needUpdate() {
        return false;
    }
}
