package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import java.util.concurrent.TimeUnit;
import br.com.planet.model.bean.Equipamento;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.planet.util.Utils;
import org.openqa.selenium.WebElement;

public class HuaweiControle extends Controle {

    public HuaweiControle(boolean condition) {
        super(condition);
        loadProperties(Utils.PROPERTIES_DIRECTORY + "\\huawei.properties");
        timeout = 5;
        this.tipo = Controle.ONT_TYPE;
        m.getEquipamento().setModelo(Equipamento.HUAWEI_ECO);
    }

    
    public boolean pingar() throws Exception{
        try {
            driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            driver.get(url);
            driver.getTitle();
            return driver.getTitle().equals(title);

        } catch (Exception e) {
            System.out.println(Utils.getAtualDate() + " ERRO: Huawei Eco pingar: " + e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public boolean logar() throws Exception {
        try {
            driver.get(url);
            driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[3]/input")).clear();
            driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[3]/input")).sendKeys(login);

            driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/input")).sendKeys(senha);

            driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/button")).click();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: Huawei Eco logar: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void getPon() throws Exception {
        try {
            driver.navigate().refresh();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/ul/li[7]")).click();
            driver.switchTo().frame(driver.findElement(By.id("frameContent")));
            m.setPon(driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[4]/td[2]")).getText());
        } catch (Exception e) {
            System.out.println("ERRO: Huawei Eco getPon: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void getFirmware() throws Exception {
        try {
            driver.navigate().refresh();
            driver.switchTo().frame(driver.findElement(By.id("frameContent")));
            m.getEquipamento().setFirmware(driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[7]/td[2]")).getText());
        } catch (Exception e) {
            System.out.println("ERRO: Huawei Eco getFirmware: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void getSn() throws Exception {
        try {
            driver.navigate().refresh();
            driver.switchTo().frame(driver.findElement(By.id("frameContent")));
            String sn = driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[4]/td[2]")).getText();
            m.getEquipamento().setSn(sn.substring(sn.indexOf("(") + 1, sn.indexOf(")")));
            System.out.println("MAC: " + m.getEquipamento().getSn());
        } catch (Exception e) {
            System.out.println("ERRO: Huawei Eco getSn: " + e.getMessage());
            throw new Exception(e);
        }
    }

    private void getId() throws Exception {

        try {
            driver.navigate().refresh();
            driver.switchTo().frame(driver.findElement(By.id("frameContent")));
            String id = (driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[3]/td[2]")).getText());
            m.setObservacao(id.substring(id.indexOf(":") + 1, id.indexOf("/CHIP")));
        } catch (Exception e) {
            System.out.println("ERRO: Huawei Eco getID: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void reset() throws Exception {

        try {
            driver.navigate().refresh();

            driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/ul/li[11]/div[2]")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/ul/li[4]")).click();
            
            driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/iframe")));
            driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td/input[1]")).click();
            driver.switchTo().alert().accept();
            Thread.sleep(60000);
            driver.navigate().refresh();
            
            while (true){
                try {
                    this.logar();
                    break;
                } catch (Exception e) {
                }
            }
            
            this.atualizarInformacoes();
        } catch (Exception e) {
            System.out.println("ERRO: Huawei Eco Reset (InterruptedException): " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void setId(String id) {
        if (m.getObservacao() != null) {
            m.setObservacao(m.getObservacao() + id);
        } else {
            m.setObservacao(id);
        }
    }
    
    public void ppoe(){
        try{
            driver.navigate().refresh();
           
            driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/ul/li[3]/div[2]")).click();
            driver.switchTo().frame(driver.findElement(By.id("frameContent")));
            
            
            WebElement lan1 = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/div/input"));
            WebElement lan2 = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/div/input"));
            WebElement lan3 = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[3]/div/input"));
            WebElement lan4 = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[4]/div/input"));
            
            if (!lan1.isSelected())
                lan1.click();
            
            if (!lan2.isSelected())
                lan2.click();
            
            if (!lan3.isSelected())
                lan3.click();
            
            if (!lan4.isSelected())
                lan4.click();
            
            driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td/button[1]")).click();
            
            driver.navigate().refresh();
            
            driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/ul/li[2]/div[2]")).click();
            driver.switchTo().frame(driver.findElement(By.id("frameContent")));
            driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/input[1]")).click();
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[6]/td[2]/span[2]/input")).click();
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[7]/td[2]/select")).click();
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[7]/td[2]/select/option[3]")).click();
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[11]/td[2]/input")).sendKeys(ppoeVlan);
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[17]/td[2]/input")).clear();
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[17]/td[2]/input")).sendKeys(ppoeUser);
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[18]/td[2]/input")).clear();
            driver.findElement(By.xpath("/html/body/form/div[2]/table/tbody[1]/tr[18]/td[2]/input")).sendKeys(ppoePass);
            driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/input[2]")).click();
        }catch (Exception e){
            e.printStackTrace();
            throw (e);
        }
    }
}
