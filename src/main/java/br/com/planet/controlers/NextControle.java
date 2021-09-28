package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import java.util.concurrent.TimeUnit;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.FirmwarePath;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextControle extends Controle {

    private String senha2;
    private String senha3 = "HPF$6107#Zeus";

    public NextControle(boolean condition) {
        super(condition);
        this.url = "http://192.168.1.1";
        this.macAdressURL = url +"/status.asp";
        this.login = "admin";
        this.senha = "admin";
        this.senha2 = "@#Pl4n3t#@";
        this.driver = new ChromeDriver(options);
        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.NEXT_FIBER));
        tipo = NextControle.ONT_TYPE;

        this.firmwareAtualVersion = "V1.0.8";
        
        this.urlFirmware = url + "/status.asp";
        this.urlPon = url + "/status_pon.asp";
        this.urlSn = url + "/status.asp";
        
        this.xpathFirmware = "/html/body/form[1]/div[1]/div[2]/table/tbody/tr[3]/td";
        this.xpathPon = "/html/body/div[2]/div[2]/table/tbody/tr[5]/td";
        this.xpathSn = "/html/body/form[1]/div[2]/div[2]/table/tbody/tr[4]/td";
    }


    public boolean pingar() {
        try {
            driver.get(url);
            if (this.driver.getTitle().equals("XPON HGU")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean logar() throws Exception {
        try {
            driver.get(url);
            if (driver.getTitle().equals("XPON HGU")) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys(senha);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();

            driver.get(url);
            if (driver.getTitle().equals("XPON HGU")) {
                return true;
            }

            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys(senha2);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();

            driver.get(url);
            
            if (driver.getTitle().equals("XPON HGU")){
                return true;
            }
            
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys(login);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys(senha3);
            driver.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();
            
            return driver.getTitle().equals("XPON HGU");
            
        } catch (Exception e) {
            System.out.println("Erro NextFiber logar: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void updateFirmware() throws InterruptedException, Exception {
        try {
            driver.get(url+ "/upgrade.asp");

            driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr/th/input")).sendKeys(FirmwarePath.NEXT_FIBER_1_0_8);

            driver.findElement(By.xpath("/html/body/form/div[2]/input[1]")).click();

            driver.switchTo().alert().accept();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            while (!driver.findElement(By.xpath("/html/body/div/div/div[2]")).getText().equals("100%")) {
            }
            
            Thread.sleep(10000);


            while (true) {
                try {
                    this.logar();
                    break;
                } catch (Exception e) {
                }
            }
            this.m.setUpdate(true);
            this.atualizarInformacoes();
            
        } catch (Exception e) {
            System.out.println("Next Fiber Erro Update Firmware" + e.getMessage());
            throw new Exception(e);
        }

    }

   

    public void reset() throws Exception {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get(url + "/saveconf.asp");

            driver.findElement(By.xpath("/html/body/form[3]/div/table/tbody/tr/td/input[1]")).click();

            driver.switchTo().alert().accept();

            Thread.sleep(60000);
            this.m.setReset(true);
            this.logar();
            this.atualizarInformacoes();
            this.setWifiPassword();
        } catch (Exception e) {
            System.out.println("NextFiber erro reset: " + e.getMessage());
            throw new Exception(e);
        }

    }

    public void setWifiPassword() throws Exception {
        try {
            driver.get(url + "/wlwpa.asp");

            driver.findElement(By.xpath("/html/body/form/div[1]/table[4]/tbody/tr[8]/td/input[2]")).click();
            driver.findElement(By.xpath("/html/body/form/div[1]/table[4]/tbody/tr[8]/td/input[1]")).clear();
            driver.findElement(By.xpath("/html/body/form/div[1]/table[4]/tbody/tr[8]/td/input[1]")).sendKeys(senha2);
            
            driver.findElement(By.xpath("/html/body/form/div[2]/input[3]")).click();
            
        } catch (Exception e) {
            System.out.println("NextFiber erro setWifiPass: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public boolean needUpdate() {
        return !this.m.getEquipamento().getFirmware().equals(this.firmwareAtualVersion);
    }
    
    public void ppoe(){
        try{
            driver.get(url + "/multi_wan_generic.asp");
            
            driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[3]/td/input")).clear();
            driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[3]/td/input")).sendKeys("501");
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[1]/td/input")).clear();
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[1]/td/input")).sendKeys("geandson");
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[2]/td/input[1]")).clear();
            driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/table/tbody/tr[2]/td/input[1]")).sendKeys("geandson");
            driver.findElement(By.xpath("/html/body/form/div[8]/input[5]")).click();
            
        }catch (Exception e){
            System.out.println("Erro Next IPV6: " + e.getMessage());
        }
    }
    
}
