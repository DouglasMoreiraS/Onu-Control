package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import java.util.concurrent.TimeUnit;
import br.com.planet.model.bean.Equipamento;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.planet.util.Utils;

public class DlinkControle extends Controle {

    String url2;
    String wifiName;

    public DlinkControle(boolean condition) {
        super(condition);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.url = "http://192.168.0.1/";
        this.login = "admin";
        this.senha = "1234";
        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.DLINK));
        this.m.getEquipamento().setTipo(Controle.ROUTER_TYPE);
        this.firmwareAtualVersion = "1.0.0";

    }

    public boolean start() throws Exception {
        try {
            if (logar()) {
                getFirmware();
                getSn();
                getPatrimonio();
                getStatus();
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro DLINK Start: " + e.getMessage());
            throw (e);
        }
    }

    public boolean logar() throws Exception {
        try {
            driver.get(url);

            if (Utils.existsElement(driver, "html/body/div[1]/div[3]/div/div/div[2]/a")) {

                primeiraConfiguracao();
                Thread.sleep(3000);
                this.restart();
                driver.get(url);
            }

            if (Utils.existsElement(driver, "/html/body/div[8]/div[2]/form/div[1]/div[1]/label/div[1]")) {
                this.login = "Admin";
                this.senha = "@#Pl4n3t#@";
            }

            if (Utils.existsElement(driver, "/html/body/div[1]/div[4]/div/div/div/form/div/div[1]/span")) {
                txtLogin = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/form/label[1]/div[1]/div/input"));
                txtSenha = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/form/label[2]/div[1]/div/input"));
                btnLogin = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/div/button[1]"));
            } else {

                txtLogin = driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div[1]/label/div[1]/div/input"));

                if (Utils.existsElement(driver, "//*[@id=\"ngdialog1\"]/div[2]/form/div[1]/div[1]/label/div[1]/div/input")) {
                    txtSenha = driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div[1]/div[1]/label/div[1]/div/input"));
                } else {
                    txtSenha = driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div[1]/label[2]/div[1]/div/input"));
                }
                btnLogin = driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div[2]/button[1]"));
            }
            txtLogin.sendKeys(login);
            txtSenha.sendKeys(senha);

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            btnLogin.click();

            Thread.sleep(3000);

            if (Utils.existsElement(driver, "/html/body/div[1]/div[3]/div/div/div[2]/div[2]/button[1]")) {
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[2]/button[1]")).click();
            }

            if (Utils.existsElement(driver, "html/body/div[1]/div[3]/div/div/div[2]/a")) {
                primeiraConfiguracao();
            }

            try {
                txtLogin.sendKeys(login);
                return false;
            } catch (Exception e) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro DLINK InternalLogar: " + e.getMessage());
            throw e;
        }
    }

    public void getSn() throws Exception {
        try {
            driver.get("http://192.168.0.1/admin/index.html#/summary");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement sn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mblock\"]/div[2]/div/div/div/div[1]/div[7]/span[2]")));
            m.getEquipamento().setSn(sn.getText());
            System.out.println(m.getEquipamento().getSn());
        } catch (Exception e) {
            System.out.println("Erro DLINK getSN: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void getFirmware() throws Exception {
        try {

            driver.get("http://192.168.0.1/admin/index.html#/summary");

            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement firmwareElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[3]/span[2]/a")));
            String firmware = firmwareElement.getText();

            if (firmware.equals("")) {
                this.m.getEquipamento().setFirmware("Unknown");
                return;
            } else if (firmware.equals(firmwareAtualVersion)) {
                firmware = firmware.concat(" (Preset)");
            }
            this.m.getEquipamento().setFirmware(firmware);

        } catch (Exception e) {
            System.out.println("Erro DLINK getFirmware " + e.getMessage());
            throw e;
        }
    }

    public void updateFirmware() throws Exception {

        try {
            if (!headless) {
                options.setHeadless(false);
                this.restart();
                this.logar();
            }

            driver.get("http://192.168.0.1/admin/index.html#/system/firmware");

            WebDriverWait wait = new WebDriverWait(driver, 9999);

            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mblock\"]/div[2]/div/ui-view/div/div/div/div/div[3]/form/div/button")));

            button.click();

            Thread.sleep(3000);

            while (Utils.existsElement(driver, "/html/body/div[4]/div/nw-auto-progress-bar/div/div[3]")) {
            }

            this.m.setObservacao("Preset Installed");

            this.m.setUpdate(true);

            this.headless = true;
            this.restart();
            this.login = "Admin";
            this.senha = "@#Pl4n3t#@";
            this.logar();
            this.getFirmware();

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public boolean needPreset() {
        try {

            if (m.getEquipamento().getFirmware() == null) {
                return true;
            }

            return !m.getEquipamento().getFirmware().contains(firmwareAtualVersion);
        } catch (Exception e) {
            System.out.println("Erro Dlink NeedPreset: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean needUpdate() {
        return !m.getEquipamento().getFirmware().contains("1.0.0");
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    private void primeiraConfiguracao() throws Exception {
        try {
            //botoes
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/a")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/ul/li[1]/a")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/div/button[1]")).click();

            //campos senha
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement campoSenha1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div/form/div[3]/label[1]/div[1]/div/input")));

            if (Utils.existsElement(driver, "/html/body/div[1]/div[3]/div/div/form/div[3]/label[1]/div[1]/div/input")) {
                campoSenha1.sendKeys(senha);
                driver.findElement((By.name("confirmPassword"))).sendKeys(senha);

                //apply
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/a[2]")).click();
            }

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ppoe(){
        
        try {
            
            driver.get(url+ "admin/index.html#/network/wan/info");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/div/div/div[2]/div/div[2]/div[1]/button[1]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[1]/div[1]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[1]/div[1]/div/input")).sendKeys("k");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[2]/div[1]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[2]/div[1]/div/input")).sendKeys("k");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[3]/div/div/button")).click();
            
        } catch (Exception e) {
            System.out.println("Erro Dlink PPOE: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        
    }
    
}
