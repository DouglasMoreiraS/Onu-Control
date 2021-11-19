package br.com.planet.controlers;

import br.com.planet.exception.SemConexaoException;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.util.FirmwarePath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.planet.util.Utils;
import org.openqa.selenium.WebDriverException;

public class ZyxelControle extends Controle {

    private String model;

    public ZyxelControle() {
        super();
        driver = new ChromeDriver(options);
        this.login = "admin";
        this.senha = "1234";
        this.url = "http://192.168.1.1";
        this.title = "login";


        this.urlSn = "http://192.168.1.1/cgi-bin/status_deviceinfo.asp";
        this.urlFirmware = "http://192.168.1.1/cgi-bin/status_deviceinfo.asp";
        this.urlPon = "http://192.168.1.1/cgi-bin/status_deviceinfo.asp";

        this.xpathSn = "html/body/form/table[1]/tbody/tr[5]/td[5]";
        this.xpathFirmware = "html/body/form/table[1]/tbody/tr[3]/td[5]";
        this.xpathPon = "/html/body/form/table[2]/tbody/tr[6]/td[5]";

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
            if ((driver.getTitle().equals("login")) && (Utils.existsElement(driver, "/html/body/form/div/table/tbody/tr/td/table[5]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input"))) {
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

    public void identificar() {

        try {
            driver.get(url);
            this.model = driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr/td/table[3]/tbody/tr/td[2]/font")).getText();
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
        }catch (InterruptedException ex){
            return false;
        }

    }


    @Override
    public void updateFirmware() throws WebDriverException {

        try {

            String file;

            if (this.model.equals("PMG2005-T20B")) {
                file =FirmwarePath.ZYXEL_PMG2005_T20B;
            } else {
                file =FirmwarePath.ZYXEL_PMG2005_T20D;
            }

            driver.get("http://192.168.1.1/cgi-bin/tools_update.asp");

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
        }catch (InterruptedException ex){
            
        }
    }

    public void reset() throws  WebDriverException {
        try {
            driver.get("http://192.168.1.1/cgi-bin/tools_system.asp");
            driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[4]/td[5]/input")).click();

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
        }catch (InterruptedException ex){
            
        }
    }

    @Override
    public boolean needUpdate() {
        try {
            driver.get("http://192.168.1.1/cgi-bin/status_deviceinfo.asp");

            if (this.model.equals("PMG2005-T20B")) {
                return !driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td[5]")).getText().equals("V1.00(ABNK.2)b9_C0");

            } else {
                return !driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td[5]")).getText().equals("V1.00(ABUT.1)b1_C0");
            }
        } catch (Exception e) {
            System.out.println("Erro Zyxel NeedUpdate: " + e.getMessage());

        }
        return false;
    }

    public Manutencao getM() {
        return m;
    }

    public String getLastMaintance() {

        if (historico.isEmpty()) {
            return "";
        }

        return historico.get(historico.size() - 1).getData();
    }

    public String getModel() {
        return model;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
