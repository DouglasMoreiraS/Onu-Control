package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

public class ChimaControle extends Controle {

    public ChimaControle() {
        super();
        timeout = 5;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\chima.properties");
        this.m.setObservacao("Aparelho Novo");
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
            driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[4]/td[3]/input")).click();

            try {
                driver.get(url);
                driver.findElement(By.xpath("/html/body/blockquote[1]/form/center/table/tbody/tr/td/table/tbody/tr[2]/td[3]/font/input")).sendKeys(login);
                return false;
            } catch (Exception e) {
                return true;
            }

        } catch (WebDriverException e) {
            System.out.println("Erro Chima logar: " + e.getMessage());
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
            System.out.println("Erro Chima Reset: " + e.getMessage());
            throw new WebDriverException(e);
        }catch(InterruptedException ex){
            
        }
    }

    public boolean needUpdate() {
        return false;
    }

}
