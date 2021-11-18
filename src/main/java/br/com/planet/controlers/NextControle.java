package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import java.util.concurrent.TimeUnit;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.FirmwarePath;
import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextControle extends Controle {

    private final String senha2;
    private final String senha3;
    private final String urlWifiConfig;

    public NextControle() {
        super();
        loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\nextfiber.properties");
        tipo = NextControle.ONT_TYPE;

        this.senha2 = properties.getProperty("p.pass1");
        this.senha3 = properties.getProperty("p.pass2");
        this.urlWifiConfig = properties.getProperty("p.url.wifi_config");

    }

    public boolean pingar() {
        try {
            driver.get(url);
            if (this.driver.getTitle().equals(title)) {
                return true;
            }
            return false;
        } catch (WebDriverException e) {
            return false;
        }

    }

    @Override
    public boolean logar() throws WebDriverException {
        try {
            driver.get(url);
            if (driver.getTitle().equals(title)) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys(senha);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();

            driver.get(url);
            if (driver.getTitle().equals(title)) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys(senha2);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();

            driver.get(url);

            if (driver.getTitle().equals(title)) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys(senha3);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();

            return driver.getTitle().equals(title);

        } catch (WebDriverException e) {
            System.out.println("Erro NextFiber logar: " + e.getMessage());
            throw new WebDriverException(e);
        }
    }

    public void updateFirmware() throws WebDriverException {
        try {
            driver.get(urlUpdate);

            driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr/th/input")).sendKeys(this.firmwarePath);

            driver.findElement(By.xpath("/html/body/form/div[2]/input[1]")).click();

            driver.switchTo().alert().accept();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            while (!driver.findElement(By.xpath("/html/body/div/div/div[2]")).getText().equals("100%")) {
            }

            Thread.sleep(60000);

            while (true) {
                try {
                    this.logar();
                    break;
                } catch (WebDriverException e) {
                }

            }

            this.m.setUpdate(true);
            this.atualizarInformacoes();

        } catch (WebDriverException e) {
            System.out.println("Next Fiber Erro Update Firmware" + e.getMessage());
            throw new WebDriverException(e);
        } catch (InterruptedException ex){
            
        }

    }

    public void reset() throws WebDriverException {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get(urlReset);

            driver.findElement(By.xpath("/html/body/form[3]/div/table/tbody/tr/td/input[1]")).click();

            driver.switchTo().alert().accept();

            Thread.sleep(60000);
            this.m.setReset(true);
            this.logar();
            this.atualizarInformacoes();
            this.setWifiPassword();
        } catch (WebDriverException e) {
            System.out.println("NextFiber erro reset: " + e.getMessage());
            throw new WebDriverException(e);
        } catch (InterruptedException ex){
            
        }

    }

    public void setWifiPassword() throws WebDriverException {
        try {
            driver.get(urlWifiConfig);

            driver.findElement(By.xpath("/html/body/form/div[1]/table[4]/tbody/tr[8]/td/input[2]")).click();
            driver.findElement(By.xpath("/html/body/form/div[1]/table[4]/tbody/tr[8]/td/input[1]")).clear();
            driver.findElement(By.xpath("/html/body/form/div[1]/table[4]/tbody/tr[8]/td/input[1]")).sendKeys(senha2);

            driver.findElement(By.xpath("/html/body/form/div[2]/input[3]")).click();

        } catch (WebDriverException e) {
            System.out.println("NextFiber erro setWifiPass: " + e.getMessage());
            throw new WebDriverException(e);
        }
    }

    public void ppoe() {
        try {
            driver.get(urlPPOE);

            driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[3]/td/input")).clear();
            driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[3]/td/input")).sendKeys(ppoeVlan);
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[1]/td/input")).clear();
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[1]/td/input")).sendKeys(ppoeUser);
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[2]/td/input[1]")).clear();
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[2]/td/input[1]")).sendKeys(ppoePass);
            driver.findElement(By.xpath("/html/body/form/div[8]/input[5]")).click();

        } catch (WebDriverException e) {
            System.out.println("Erro Next PPOE: " + e.getMessage());
        }
    }

    public void getFirmware() throws WebDriverException {
        try {
            driver.get(urlFirmware);
            m.getEquipamento().setFirmware(driver.findElement(By.xpath(xpathFirmware)).getText());

            if (m.getEquipamento().getFirmware().toLowerCase().equals("v1.0.3")) {
                System.out.println("Aparelho Novo");
                m.setObservacao("Aparelho Novo");
            }

        } catch (WebDriverException e) {
            System.out.println(getClass().getName() + " getFirmware Erro: " + e.getMessage());
            throw new WebDriverException(e);
        }
    }

}
