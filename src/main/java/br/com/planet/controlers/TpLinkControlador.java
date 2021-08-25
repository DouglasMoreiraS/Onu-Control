package br.com.planet.controlers;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TpLinkControlador extends Controle {

    public TpLinkControlador(boolean condition) {
        super(condition);
        this.url = "http://192.168.0.1";
        this.senha = "admin";
        this.driver = new ChromeDriver(options);
        m.getEquipamento().setModelo(new ModeloDAO().buscar(Equipamento.TP_LINK));
        tipo = Controle.ROUTER_TYPE;

    }

    public boolean logar() throws Exception {

        try {
            driver.get(url);
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/span[1]")).click();
            driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/input[2]")).sendKeys(senha);

            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div/button")).click();

            if (Utils.existsElement(driver, "/html/body/div[4]/div/div[4]/div/div[2]/div/div[2]/button")) {
                driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/div[2]/div/div[2]/button")).click();
            }

            if (Utils.existsElement(driver, "/html/body/div[1]/div[1]/div[2]/div[1]/ul/li[3]/span[2]")) {
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/ul/li[3]/span[2]")).click();
            }

            return true;
        } catch (Exception e) {
            System.out.println("Erro TPLINK logar: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void getSn() throws Exception {
        try {
            this.sendMeMainPage();

            m.getEquipamento().setSn(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1]/div/form[1]/div[1]/div[1]/input")).getText());
            System.out.println(m.getEquipamento().getSn());
        } catch (Exception e) {
            System.out.println("Erro TPLINK getSn: " + e.getMessage());
            throw e;
        }

    }

    public void getFirmware() throws Exception {
        try {
            sendMeMainPage();

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/div/ul/li[9]/a")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/div/ul/li[9]/ul/li[3]/a")).click();

            String firmware = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div[2]/form/div[1]/input")).getText();
            System.out.println(firmware);
          // m.getEquipamento().setFirmware(firmware.substring(firmware.indexOf(":" + 1), firmware.indexOf("Build")));
        } catch (Exception e) {
            System.out.println("Erro TPLINK getFirmware: " + e.getMessage());
            throw e;
        }
    }

    void atualizarInformacoes() throws Exception {
        try {
            this.getSn();
            this.getFirmware();
            this.findHistorico();
            this.getPatrimonio();
        } catch (Exception e) {
            throw (e);
        }
    }

    private void sendMeMainPage() {
        try {
            driver.get(url);
            if (Utils.existsElement(driver, "/html/body/div[1]/div[1]/div[2]/div[1]/ul/li[3]/span[2]")) {
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/ul/li[3]/span[2]")).click();
            }
        } catch (Exception e) {
            System.out.println("Erro TPLINK Main Page: " + e.getMessage());
            throw e;
        }

    }

}
