package br.com.planet.controlers;

import br.com.planet.dao.DataBase;
import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.util.Utils;
import java.util.ArrayList;
import java.util.List;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Controle {

    public final static int ONU_TYPE = 0;
    public final static int ONT_TYPE = 1;
    public final static int ROUTER_TYPE = 2;

    ManutencaoDAO dao;

    WebElement txtLogin;
    WebElement txtSenha;
    WebElement btnLogin;
    WebElement macAdress;
    String macAdressURL;
    String title;

    String xpathPon;
    String xpathFirmware;
    String xpathSn;

    String urlPon;
    String urlFirmware;
    String urlSn;

    ChromeOptions options;
    WebDriver driver;

    Manutencao m;
    List<Manutencao> historico;

    String url = "";
    String login;
    String senha;
    int tipo;

    String firmwareAtualVersion;

    String endereco;
    
    boolean headless;

    public Controle(boolean headless) {
        this.headless = headless;
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.setHeadless(!headless);
        historico = new ArrayList();
        m = new Manutencao();
    }

    public boolean start() throws Exception {
        try {

            if (logar()) {
                atualizarInformacoes();
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    public boolean pingar() throws Exception {

        try {
            driver.get(url);
            if (driver.getTitle().equals(title));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void getPon() throws Exception {
        try {
            driver.get(urlPon);
            m.setPon(driver.findElement(By.xpath(xpathPon)).getText());
        } catch (Exception e) {
            System.out.println(getClass().getName() + " getPon Erro: " + e.getMessage());
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public void getFirmware() throws Exception {
        try {
            driver.get(urlFirmware);
            m.getEquipamento().setFirmware(driver.findElement(By.xpath(xpathFirmware)).getText());
        } catch (Exception e) {
            System.out.println(getClass().getName() + " getFirmware Erro: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public void getSn() throws Exception {
        try {
            driver.get(urlSn);
            m.getEquipamento().setSn(driver.findElement(By.xpath(xpathSn)).getText());
        } catch (Exception e) {
            System.out.println(getClass().getName() + " getSn Erro: " + e.getMessage());
            e.printStackTrace();
            throw new Exception(e);

        }
    }

    public boolean logar() throws Exception {
        try {
            this.driver.get(url);

            this.txtLogin.sendKeys(this.login);
            this.txtSenha.sendKeys(this.senha);
            this.btnLogin.click();
            return true;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void open() {
        try {
            options.setHeadless(headless);
            driver = new ChromeDriver(options);
        } catch (Exception e){
            System.out.println("Erro ao abrir: " + e.getMessage());
        }
    }

    public void close() {
        try {
     //       Thread.sleep(3);
            driver.quit();
        } catch (Exception e) {
            System.out.println("Erro ao fechar: " + e.getMessage());
        }
    }

    public void save() throws Exception, PatrimonioViolationException {
        try {
            m.setData(Utils.getAtualDate());
            Equipamento.salvar(m.getEquipamento());
            dao.salvar(m);
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            throw new Exception(e);
        }
    }

    public String getFirmwareAtualVersion() {
        return firmwareAtualVersion;
    }

    public void restart() {
        this.close();
        this.driver = new ChromeDriver(options);
        this.driver.get(url);
    }

    public Manutencao getM() {
        return m;
    }

    public void findHistorico() {
        this.dao = new ManutencaoDAO();
        historico = dao.listarPorEquipamento(m.getEquipamento());
    }

    public String getLastMaintance() {
        if (historico.isEmpty()) {
            return "";
        }
        return historico.get(historico.size() - 1).getData();
    }

    public List<Manutencao> getHistorico() {
        return historico;
    }

    public void reset() throws Exception {
        
    }

    public boolean needUpdate() {
        return !m.getEquipamento().getFirmware().equals(firmwareAtualVersion);
    }

    public void updateFirmware() throws Exception {
    }

    void atualizarInformacoes() throws Exception {
        try {
            this.getSn();
            this.getPon();
            this.getFirmware();
            this.findHistorico();
            this.getPatrimonio();
            this.getStatus();
        } catch (Exception e) {
            throw (e);
        }
    }

    public void ppoe() {
    }

    void getPatrimonio() {
        Equipamento e = new EquipamentoDAO().buscar(m.getEquipamento().getSn());

        if (e != null) {
            this.m.getEquipamento().setPatrimonio(e.getPatrimonio());
            System.out.println("Patrimonio = " + m.getEquipamento().getPatrimonio());
        }

    }

    public void getStatus() {
        Equipamento e = new EquipamentoDAO().buscar(m.getEquipamento().getSn());
        if (e != null) {
            this.m.getEquipamento().setStatus(e.isStatus());
        } else {
            this.m.getEquipamento().setStatus(true);
        }
    }
    
    private void capturarEndereco(){
    }

}
