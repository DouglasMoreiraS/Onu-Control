package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

public class SumecControle extends Controle {

    public SumecControle() {
        super();
        timeout = 10;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\sumec.properties");
        this.m.getEquipamento().setTipo(Controle.ONU_TYPE);
    }

    @Override
    public boolean logar() throws WebDriverException {
        try {
            driver.get(url);

            if (driver.getTitle().equals(title)) {
                return true;
            }

            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(login);
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(senha);
            driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

            try {
                driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(login);
                return false;
            } catch (Exception e) {
                if (e.getMessage().contains("ERR_CONNECTION_REFUSED")) {
                    return false;
                }

                return true;
            }

        } catch (WebDriverException e) {
            System.out.println("Erro SUMEC logar: " + e.getMessage());
            throw new WebDriverException(e);
        }
    }

    public void reset() throws WebDriverException {

        try {
            driver.get(urlReset);
            driver.findElement(By.xpath("/html/body/blockquote/table[2]/tbody/tr[3]/td[2]/font/input")).click();
            driver.switchTo().alert().accept();

            Thread.sleep(60000);
            while (true) {
                try {
                    this.logar();
                    break;
                } catch (Exception e) {
                }
            }
            this.atualizarInformacoes();
        } catch (WebDriverException e) {
            System.out.println("Erro SUMEC reset: " + e.getMessage());
            throw new WebDriverException(e);
        }catch (InterruptedException ex){
            
        }
    }

    public void logout() throws WebDriverException {
        try {
            driver.get("http://192.168.101.1/admin/logout.asp");
            driver.findElement(By.xpath("/html/body/blockquote/form/input[1]")).click();

            driver.switchTo().alert().accept();

        } catch (WebDriverException e) {
            System.out.println("Erro SUMEC logout: " + e.getMessage());
            throw new WebDriverException(e);
        }
    }

    @Override
    public boolean needUpdate() {
        return false;
    }

}
