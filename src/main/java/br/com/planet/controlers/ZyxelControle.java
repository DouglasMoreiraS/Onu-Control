package br.com.planet.controlers;

import br.com.planet.exception.SemConexaoException;
import br.com.planet.util.PropertiesUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import br.com.planet.util.Utils;
import org.openqa.selenium.WebDriverException;

public class ZyxelControle extends Controle {

    private String model;
    private String firmwareT20D;
    private String firmwarePathT20D;

    public ZyxelControle() {
        super();
        loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\zyxel.properties");

        firmwareT20D = properties.getProperty("p.firmware.atual1");
        firmwarePathT20D = properties.getProperty("p.firmware.path1");

    }

    public boolean pingar() {
        try {
            driver.get(url);
            return this.driver.getTitle().equals("login");

        } catch (SemConexaoException e) {
            return false;
        }

    }

    public boolean isLoged() {
        try {
            this.driver.get(url);
            if ((driver.getTitle().equals(title)) && (Utils.existsElement(driver, "/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input"))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            if (e.getMessage().contains("ERR_CONNECTION_TIMED_OUT")) {
                return false;
            }

            e.printStackTrace();
        }
        return false;
    }

    public boolean identificar() {

        try {
            driver.get(url);
            this.model = driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[3]/tbody/tr/td[2]/font")).getText();
            return model.equals("PMG2005-T20B");
        } catch (Exception e) {
            throw new SemConexaoException(e.getMessage());
        }
    }

    @Override
    public boolean logar() throws WebDriverException {
        try {

            if (isLoged()) {
                return true;
            }

            this.driver.get(url);

            driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input")).sendKeys(this.login);
            driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys(this.senha);

            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td/input[1]")).click();
            return true;
        } catch (WebDriverException e) {
            System.out.println("Erro Zyxel InternalLogar: " + e.getMessage());
            throw new WebDriverException(e);
        } catch (InterruptedException ex) {
            return false;
        }

    }

    @Override
    public void updateFirmware() throws WebDriverException {

        try {

            String file;

            if (this.model.equals("PMG2005-T20B")) {
                file = firmwarePath;
            } else {
                file = firmwarePathT20D;
            }

            driver.get(urlUpdate);

            Alert popup = driver.switchTo().alert();
            popup.accept();

            driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td[5]/input[2]")).click();

            driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[4]/td[5]/input")).sendKeys(file);

            driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[3]/input[1]")).click();

            try {
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
        } catch (WebDriverException e) {
            System.out.println("Erro Zyxel Update Firmware: " + e.getMessage());
            throw new WebDriverException(e);
        } catch (InterruptedException ex) {

        }
    }

    public void reset() throws WebDriverException {
        try {
            driver.get(urlReset);
            driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[4]/td[5]/input")).click();
            driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[6]/td[5]/input")).click();
            driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[3]/input[4]")).click();
            

            Alert popup = driver.switchTo().alert();
            popup.accept();

            Thread.sleep(60000);

            while (true) {
                try {
                    this.logar();
                    this.atualizarInformacoes();
                    break;
                } catch (Exception e) {
                }
            }

            this.logar();
            System.out.println("Passei aqui");
        } catch (WebDriverException e) {
            System.out.println("Erro Zyxel Update Reset: " + e.getMessage());
            throw new WebDriverException(e);
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public boolean needUpdate() {
        try {
            driver.get("http://192.168.1.1/cgi-bin/status_deviceinfo.asp");

            if (this.model.equals("PMG2005-T20B")) {
                return !driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td[5]")).getText().equals(firmwareAtualVersion);

            } else {
                return !driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td[5]")).getText().equals(firmwareT20D);
            }
        } catch (Exception e) {
            System.out.println("Erro Zyxel NeedUpdate: " + e.getMessage());

        }
        return false;
    }

    public String getModel() {
        return model;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
