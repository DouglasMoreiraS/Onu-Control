package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.planet.util.Utils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriverException;

public class Dlink841Controle extends Controle {


    public Dlink841Controle() {
        super();
        timeout = 3;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\dlink841.properties");
        this.m.getEquipamento().setTipo(Controle.ROUTER_TYPE);
    }

    @Override
    public boolean logar() throws WebDriverException {

        try {

            driver.get(url);

            if (Utils.existsElement(driver, "html/body/div[1]/div[3]/div/div/div[2]/a")) {

                primeiraConfiguracao();

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

            //teste
            String checkBox = "//*[@id=\"ngdialog1\"]/div[2]/form/div[1]/div[1]/label/input";
            //*[@id="ngdialog1"]/div[2]/form/div[1]/div[1]/label/input

            if (Utils.existsElement(driver, checkBox)) {
                this.txtLogin.sendKeys(login1);
                this.txtSenha.sendKeys(senha);
                System.out.println("Login de preset");
            } else {
                txtLogin.sendKeys(login);
                txtSenha.sendKeys(senha);
                System.out.println("login comum");
            }

            System.out.println(login);
        //    Thread.sleep(500);
            btnLogin.click();

            Thread.sleep(1000);

            if (Utils.existsElement(driver, "/html/body/div[1]/div[3]/div/div/div[2]/div[2]/button[1]")) {
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[2]/button[1]")).click();
            }

            if (Utils.existsElement(driver, "html/body/div[1]/div[3]/div/div/div[2]/a")) {
                primeiraConfiguracao();
            }

            try {
                Thread.sleep(1000);
                txtLogin.sendKeys(login);
                return false;
            } catch (InterruptedException ex) {
                this.writeLog("logar", ex.getMessage());
                return false;
            } catch (WebDriverException e) {
                return true;
            }
        } catch (WebDriverException e) {
            System.out.println("Erro DLINK InternalLogar: " + e.getMessage());
            this.writeLog("logar", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            this.writeLog("logar", ex.getMessage());
            return false;
        }
    }

    public void getSn() throws WebDriverException {
        try {
            driver.get(urlSn);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement sn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mblock\"]/div[2]/div/div/div/div[1]/div[7]/span[2]")));
            m.getEquipamento().setSn(sn.getText());
            System.out.println(m.getEquipamento().getSn());
        } catch (WebDriverException e) {
            System.out.println("Erro DLINK getSN: " + e.getMessage());
            this.writeLog("getSn", e.getMessage());
            throw e;
        }
    }

    public void getFirmware() throws WebDriverException {
        try {

            driver.get(urlFirmware);

            WebDriverWait wait = new WebDriverWait(driver, 10);

            try {
                driver.switchTo().alert().accept();
            } catch (NoAlertPresentException e) {
                System.out.println(e.getMessage());
            }
            WebElement firmwareElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mblock\"]/div[2]/div/div/div/div[1]/div[3]/span[2]/a")));
            String firmware = firmwareElement.getText();

            if (firmware.equals("")) {
                this.m.getEquipamento().setFirmware("Unknown");
                return;
            } else if (firmware.equals(firmwareAtualVersion)) {
                firmware = firmware.concat(" (Preset)");
            }
            this.m.getEquipamento().setFirmware(firmware);

        } catch (WebDriverException e) {
            System.out.println("Erro DLINK getFirmware " + e.getMessage());
            this.writeLog("getFirmware", e.getMessage());
            throw e;
        }
    }

    public void updateFirmware() throws WebDriverException {

        try {
            if (headless == true) {
                options.setHeadless(false);
                this.restart();
                this.logar();
            }

            driver.get(urlUpdate);

            WebDriverWait wait = new WebDriverWait(driver, 9999);

            WebElement firmwarePathElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mblock\"]/div[2]/div/ui-view/div/div/div/div/div[3]/form/label/input")));
            firmwarePathElement.sendKeys(this.firmwarePath);

            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mblock\"]/div[2]/div/ui-view/div/div/div/div/div[3]/form/div/button")));

            button.click();

            Thread.sleep(3000);

            while (Utils.existsElement(driver, "/html/body/div[4]/div/nw-auto-progress-bar/div/div[3]")) {
            }

            this.m.setObservacao("Preset Installed");

            System.out.println(m.getObservacao());

            this.m.setUpdate(true);
            
            while (true) {
                try {
                    this.logar();
                    break;
                } catch (WebDriverException e) {

                }
            }
            this.atualizarInformacoes();

        } catch (WebDriverException e) {
            System.out.println("Erro DLink updateFirmware: " + e.getMessage());
            this.writeLog("updateFirmware", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            this.writeLog("updateFirmware", ex.getMessage());

        }
    }

    public boolean needUpdate() {
        try {

            if (m.getEquipamento().getFirmware() == null) {
                return true;
            }

            return !m.getEquipamento().getFirmware().contains(firmwareAtualVersion);
        } catch (WebDriverException e) {
            System.out.println("Erro Dlink NeedPreset: " + e.getMessage());
            this.writeLog("needUpdate", e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private void primeiraConfiguracao() throws WebDriverException {
        try {
            //botoes
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/a")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/ul/li[1]/a")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/div/button[1]")).click();

            //campos senha
            if (Utils.existsElement(driver, "/html/body/div[1]/div[3]/div/div/form/div[3]/label[1]/div[1]/div/input")) {

                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/form/div[3]/label[1]/div[1]/div/input")).sendKeys(senha);
                driver.findElement((By.name("confirmPassword"))).sendKeys(senha);

                //apply
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/a[2]")).click();
            }

            Thread.sleep(3000);
            this.restart();
            driver.get(url);
        } catch (WebDriverException e) {
            System.out.println("Erro Dlink Primeira Configuração: " + e.getMessage());
            this.writeLog("primeiraConfiguracao", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            this.writeLog("primeiraConfiguracao", ex.getMessage());
        }
    }

    public void ppoe() throws WebDriverException {

        try {

            driver.get(urlPPOE);

            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/div/div/div[2]/div/div[2]/div[1]/button[1]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[1]/div[1]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[1]/div[1]/div/input")).sendKeys(ppoeUser);

            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[2]/div[1]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[2]/div[2]/div/div[1]/div/label[2]/div[1]/div/input")).sendKeys(ppoePass);

            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/ui-view/ui-view/div/form/div[3]/div/div/button")).click();

        } catch (WebDriverException e) {
            System.out.println("Erro Dlink PPOE: " + e.getMessage());
            this.writeLog("ppoe", e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

    public void getPon() throws WebDriverException {
    }

}
