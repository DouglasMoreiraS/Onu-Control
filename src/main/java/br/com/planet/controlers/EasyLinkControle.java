package br.com.planet.controlers;

import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.PropertiesUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class EasyLinkControle extends Controle {

    public EasyLinkControle() {
        super();
        driver = new ChromeDriver(options);
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\easylink.properties");
    }

    @Override
    public boolean logar() throws WebDriverException {

        try {

            driver.get(url);

            if (driver.getTitle().equals(title)) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[3]/td[3]/font/input")).sendKeys(senha);
            driver.findElement(By.xpath("/html/body/blockquote/form/center/table/tbody/tr/td/table/tbody/tr[5]/td[3]/input")).click();
            try {
                driver.get(url);
                driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys(login);
                return false;
            } catch (Exception e) {
                return true;
            }
        } catch (WebDriverException e) {
            System.out.println("Erro EasyLInk logar " + e.getMessage());
            throw e;
        }
    }

    public void logout() throws WebDriverException {
        try {
            driver.get("http://192.168.101.8/admin/logout.asp");
            driver.findElement(By.xpath("/html/body/blockquote/form/input[1]")).click();
            Alert popup = driver.switchTo().alert();
            popup.accept();
        } catch (WebDriverException e) {
            System.out.println("Erro EasyLink logout: " + e.getMessage());
            throw new WebDriverException(e);
        }
    }

    @Override
    public void reset() throws WebDriverException {
        try {
            driver.get(urlReset);
            driver.findElement(By.xpath("/html/body/blockquote/table[2]/tbody/tr[3]/td[2]/font/input")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(60000);
            this.start();
        } catch (WebDriverException e) {
            System.out.println("Erro EasyLink Reset: " + e.getMessage());
            throw new WebDriverException(e);
        }catch (InterruptedException ex){
            
        }
    }

    @Override
    public void updateFirmware() throws WebDriverException {
        try {

            driver.get(urlUpdate);
            driver.findElement(By.xpath("/html/body/blockquote/form/table[2]/tbody/tr/td/font/input")).sendKeys(firmwarePath);
            driver.findElement(By.xpath("/html/body/blockquote/form/p/input[1]")).click();

            try {
                Alert popup;
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
            System.out.println("Erro EasyLink UpdateFirmware: " + e.getMessage());
            throw e;
        }catch (InterruptedException ex){
            
        }
    }

}
