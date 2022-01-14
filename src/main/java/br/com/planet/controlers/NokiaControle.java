package br.com.planet.controlers;

import java.util.concurrent.TimeUnit;
import br.com.planet.util.PropertiesUtil;
import org.openqa.selenium.By;
import br.com.planet.util.Utils;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class NokiaControle extends Controle {

    public NokiaControle() {
        super();
        loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\nokia.properties");
        timeout = 5;
    }

    public boolean pingar() throws WebDriverException {
        try {
            driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            driver.get(url);
            driver.getTitle();
            return driver.getTitle().equals(title);

        } catch (WebDriverException e) {
            System.out.println(Utils.getAtualDate() + " ERRO: Nokia pingar: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean logar() throws WebDriverException {
        try {
            driver.get(url);
            driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(login);

            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(senha);

            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[1]/input")).click();
            return true;
        } catch (WebDriverException e) {
            System.out.println("ERRO: Nokia logar: " + e.getMessage());
            throw e;
        }
    }

    public void getPon() throws WebDriverException {
        try {
            driver.navigate().refresh();
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/tbody/tr[2]/td[3]/iframe")));
            m.setPon(driver.findElement(By.xpath("//*[@id=\"Table_pon5_2_table\"]")).getText());
        } catch (WebDriverException e) {
            System.out.println("ERRO: Nokia getPon: " + e.getMessage());
            throw e;
        }
    }

    public void getFirmware() throws WebDriverException {
        try {
            driver.navigate().refresh();
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/tbody/tr[2]/td[3]/iframe")));
            m.getEquipamento().setFirmware(driver.findElement(By.xpath("//*[@id=\"Table_base6_2_table\"]")).getText());
        } catch (Exception e) {
            System.out.println("ERRO: " + name + " getFirmware: " + e.getMessage());
            throw e;
        }
    }

    public void getSn() throws WebDriverException {
        try {
            driver.navigate().refresh();
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/tbody/tr[2]/td[3]/iframe")));
            m.getEquipamento().setSn(driver.findElement(By.xpath("//*[@id=\"Table_base4_2_table\"]")).getText());
        } catch (Exception e) {
            System.out.println("ERRO: Huawei Eco getSn: " + e.getMessage());
            throw e;
        }
    }

    public void reset() throws WebDriverException {

        try {
            driver.navigate().refresh();

            driver.findElement(By.xpath("//*[@id=\"top_menu\"]/ul/li[5]/a ")).click();

            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/tbody/tr[2]/td[3]/iframe")));
            driver.findElement(By.xpath("//*[@id=\"Restore_button\"]")).click();

            if (Utils.existsElement(driver, "//*[@id=\"status1\"]")) {

                driver.findElement(By.xpath("//*[@id=\"Restore_button\"]")).click();

            }
            /*driver.switchTo().alert().accept();
            Thread.sleep(60000);
            driver.navigate().refresh();*/

            while (true) {
                try {
                    this.logar();
                    break;
                } catch (Exception e) {
                }
            }

            this.atualizarInformacoes();
        } catch (WebDriverException e) {
            System.out.println("ERRO:" + name + " Reset : " + e.getMessage());
            throw e;
        }
    }

    public void ppoe() {
        try {
            driver.navigate().refresh();

            driver.findElement(By.xpath("//*[@id=\"top_menu\"]/ul/li[2]/a")).click();
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/tbody/tr[2]/td[3]/iframe")));

            WebElement newConnection = driver.findElement(By.xpath("//*[@id=\"WanConnectName_Select\"]"));
            newConnection.click();
            newConnection.findElement(By.xpath("//*[text()='New Connection']")).click();

            driver.findElement(By.xpath("//input[@value='pppoe']")).click();
            driver.findElement(By.xpath("//*[@id=\"WanServiceList_Select\"]/option[4]")).click();
            driver.findElement(By.xpath("//*[@id=\"cfg_wan\"]/table[1]/tbody[1]/tr[5]/td[2]/select/option[3]")).click();

            driver.findElement(By.xpath("//*[@id=\"WanUserName_Text\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"WanUserName_Text\"]")).sendKeys(ppoeUser);
            driver.findElement(By.xpath("//*[@id=\"WanPassword_Text\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"WanPassword_Text\"]")).sendKeys(ppoePass);

            driver.findElement(By.xpath("//*[@id=\"WanVlan_Enable\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"WanVlanID_Text\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"WanVlanID_Text\"]")).sendKeys(ppoeVlan);

            driver.findElement(By.xpath("//*[@id=\"WanMTU_Text\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"WanMTU_Text\"]")).sendKeys("1480");

            WebElement lan1 = driver.findElement(By.xpath("//*[@id=\"Wan_Port_CheckBox1\"]"));
            WebElement lan2 = driver.findElement(By.xpath("//*[@id=\"Wan_Port_CheckBox2\"]"));
            WebElement lan3 = driver.findElement(By.xpath("//*[@id=\"Wan_Port_CheckBox3\"]"));
            WebElement lan4 = driver.findElement(By.xpath("//*[@id=\"Wan_Port_CheckBox4\"]"));

            if (!lan1.isSelected()) {
                lan1.click();
            }

            if (!lan2.isSelected()) {
                lan2.click();
            }

            if (!lan3.isSelected()) {
                lan3.click();
            }

            if (!lan4.isSelected()) {
                lan4.click();
            }

            driver.findElement(By.xpath("//*[@id=\"Wan_SSID_CheckBox\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"Wan_SSID_CheckBox\"]")).click();

            driver.findElement(By.xpath("//*[@id=\"do_edit\"]")).click();

        } catch (WebDriverException e) {
            e.printStackTrace();
            throw (e);
        }
    }

    public void close() {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id=\"logout\"]")).click();
        super.close();
    }
}
