package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import org.openqa.selenium.By;

public class SumecControle extends Controle {

    public SumecControle() {
        super();
        timeout = 10;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\sumec.properties");
    }

    @Override
    public boolean logar() throws Exception {
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

        } catch (Exception e) {
            System.out.println("Erro SUMEC logar: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void reset() throws Exception {

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
        } catch (Exception e) {
            System.out.println("Erro SUMEC reset: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void logout() throws Exception {
        try {
            driver.get("http://192.168.101.1/admin/logout.asp");
            driver.findElement(By.xpath("/html/body/blockquote/form/input[1]")).click();

            driver.switchTo().alert().accept();

        } catch (Exception e) {
            System.out.println("Erro SUMEC logout: " + e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public boolean needUpdate() {
        return false;
    }

}
