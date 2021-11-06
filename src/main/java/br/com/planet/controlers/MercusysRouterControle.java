package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import javax.security.auth.login.LoginException;
import org.openqa.selenium.By;

public class MercusysRouterControle extends Controle {

    public MercusysRouterControle() {
        super();
        timeout = 10;
        super.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY  +"\\mercusysa12g.properties");
        this.m.getEquipamento().setTipo(Controle.ROUTER_TYPE);
    }


    public boolean logar() throws Exception {

        try {
            driver.get(url);

            if (!Utils.existsElement(driver, "/html/body/div[6]/div[2]/ul/li[1]/div/span")) {
                driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul/li[3]/ul[1]/li[1]/input")).sendKeys(senha);
                driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul/li[3]/ul[2]/li[1]/input")).sendKeys(senha);
                driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul/li[4]/a/i")).click();

                driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/ul/li[4]/a/i")).click();
                driver.findElement(By.xpath("/html/body/div[10]/div/div/input[1]")).click();
                driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/ul/span/i")).click();
            } else {
                driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul/li[1]/ul/li[1]/input")).sendKeys(senha);
                driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul/li[2]/a/i")).click();

                if (!Utils.existsElement(driver, "/html/body/div[3]/div[1]/ul[1]/li[2]")) {
                    throw new LoginException("Aparelho precisa ser resetado manualmente para ser acessado");
                }

                //get sn
                //get Firmware
            }
            return true;
        } catch (Exception e) {

            throw e;
        }
    }

    public void getSn() throws Exception {
        try {
            driver.get(url);
            driver.findElement(By.xpath("/html/body/div[3]/div[1]/ul[1]/li[2]")).click();
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[1]/ul[1]/li[3]/label")).click();
            m.getEquipamento().setSn(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/fieldset/div/div/div[2]/ul[1]/li/label[2]")).getText());
        } catch (Exception e) {
            System.out.println(Utils.getAtualDate() + "Erro Mercusys getSn: " + e.getMessage());
            throw e;
        }
    }

    public void getFirmware() throws Exception {
        try {
            driver.get(url);
            String firmware = driver.findElement(By.xpath("/html/body/div[3]/div[3]/span[1]")).getText();
            m.getEquipamento().setFirmware(firmware.substring(firmware.indexOf(":") + 1, firmware.indexOf("Rel")));
        } catch (Exception e) {
            System.out.println(Utils.getAtualDate() + "Erro Mercusys getFirmware: " + e.getMessage());
            throw e;
        }
    }

    public void getPon() {

    }

    public boolean needUpdate(){
        return false;
    }
}
