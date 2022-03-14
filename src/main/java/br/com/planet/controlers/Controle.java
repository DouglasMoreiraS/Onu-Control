package br.com.planet.controlers;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.util.Utils;
import java.util.ArrayList;
import java.util.List;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.log.Log;
import br.com.planet.view.equipamentos.AcessView;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Controle {

    ManutencaoDAO dao;

    WebElement txtLogin;
    WebElement txtSenha;
    WebElement btnLogin;
    WebElement macAdress;

    String xpathPon;
    String xpathFirmware;
    String xpathSn;

    String urlPon;
    String urlFirmware;
    String urlSn;
    String urlReset;
    String urlUpdate;
    String urlPPOE;

    ChromeOptions options;
    WebDriver driver;
    WebDriverWait wait;

    Manutencao m;
    List<Manutencao> historico;

    String url;
    String login;
    String login1;
    String senha;
    String senha2;
    String senha3;
    String title;

    String name;

    String firmwareAtualVersion;

    String endereco;

    String firmwarePath;

    boolean headless;

    Properties properties;

    String ppoeVlan;
    String ppoeUser;
    String ppoePass;

    int timeout;

    boolean ppoe;

    String path;

    public Controle() {
        driverFactory();
        // WebDriverManager.chromedriver().setup();
        // options = new ChromeOptions();

        /* Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.images", 2);
        options.setExperimentalOption("prefs", prefs);*/
        historico = new ArrayList();
        m = new Manutencao();
        timeout = 10;
    }

    public boolean start() throws WebDriverException {
        try {

            if (logar()) {
                atualizarInformacoes();
                findHistorico();
                getRegistro();
                return true;
            }
        } catch (WebDriverException e) {
            throw e;
        }
        return false;
    }

    public void getPon() throws WebDriverException {

        try {
            driver.get(urlPon);
            m.setPon(driver.findElement(By.xpath(xpathPon)).getText());
        } catch (WebDriverException e) {
            System.out.println(getClass().getName() + " getPon Erro: " + e.getMessage());
            this.writeLog("getPon", e.getMessage());
            throw e;
        }
    }

    public void getFirmware() throws WebDriverException {

        try {
            driver.get(urlFirmware);
            m.getEquipamento().setFirmware(driver.findElement(By.xpath(xpathFirmware)).getText());
        } catch (WebDriverException e) {
            System.out.println(getClass().getName() + " getFirmware Erro: " + e.getMessage());
            this.writeLog("getFirmware", e.getMessage());
            throw e;
        }
    }

    public void getSn() throws WebDriverException {
        try {
            driver.get(urlSn);
            m.getEquipamento().setSn(driver.findElement(By.xpath(xpathSn)).getText());
        } catch (WebDriverException e) {
            System.out.println(getClass().getName() + " getSn Erro: " + e.getMessage());
            this.writeLog("getSn", e.getMessage());
            throw e;

        }
    }

    public boolean logar() throws WebDriverException {
        try {
            this.driver.get(url);

            this.txtLogin.sendKeys(this.login);
            this.txtSenha.sendKeys(this.senha);
            this.btnLogin.click();
            return true;
        } catch (WebDriverException e) {
            this.writeLog("logar", e.getMessage());

            throw new WebDriverException(e);

        }
    }

    public void open(boolean headless) {
        try {
            m = new Manutencao();
            this.headless = !headless;
            options.setHeadless(this.headless);

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 30);

            this.loadProperties(this.path);
        } catch (WebDriverException e) {
            System.out.println("Erro ao abrir: " + e.getMessage());
            this.writeLog("open", e.getMessage());
        }
    }

    public void close() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (WebDriverException e) {
            System.out.println("Erro ao fechar: " + e.getMessage());
            this.writeLog("close", e.getMessage());
        }
    }

    public void save() throws Exception, PatrimonioViolationException {
        try {
            m.setData(Utils.getAtualDate());
            Equipamento.salvar(m.getEquipamento());
            dao.salvar(m);

        } catch (PatrimonioViolationException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            this.writeLog("salvar", e.getMessage());
            throw e;
        }
    }

    public String getFirmwareAtualVersion() {
        return firmwareAtualVersion;
    }

    public void restart() {
        this.close();
        this.open(!headless);
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

    public boolean needUpdate() {
        if (firmwarePath == null) {
            return false;
        }
        return !m.getEquipamento().getFirmware().equals(firmwareAtualVersion);
    }

    public void updateFirmware() throws WebDriverException {
    }

    public void reset() throws WebDriverException {

    }

    void atualizarInformacoes() throws WebDriverException {
        try {
            this.getSn();
            this.getFirmware();
            this.getPon();
            //    this.findHistorico();
            //  this.getRegistro();
        } catch (WebDriverException e) {
            throw e;
        }
    }

    public void ppoe() {
    }

    private void getRegistro() {
        Equipamento e = new EquipamentoDAO().buscar(m.getEquipamento().getSn());

        if (e != null) {
            this.m.getEquipamento().setPatrimonio(e.getPatrimonio());
            this.m.getEquipamento().setStatus(e.isStatus());
            this.m.getEquipamento().setObservacao(e.getObservacao());
        } else {
            this.m.getEquipamento().setStatus(true);
        }

    }

    protected void loadProperties(String path) {
        this.path = path;
        properties = PropertiesUtil.getProperties(path);

        this.url = properties.getProperty("p.url.main");

        this.login = properties.getProperty("p.user");
        this.login1 = properties.getProperty("p.user1");
        this.senha = properties.getProperty("p.pass");
        this.senha2 = properties.getProperty("p.pass1");
        this.senha3 = properties.getProperty("p.pass2");

        this.url = properties.getProperty("p.url.main");
        this.urlFirmware = properties.getProperty("p.url.firmware");
        this.urlUpdate = properties.getProperty("p.url.upgrade");
        this.urlPon = properties.getProperty("p.url.pon");
        this.urlSn = properties.getProperty("p.url.sn");
        this.urlPPOE = properties.getProperty("p.url.ppoe_config");
        this.urlReset = properties.getProperty("p.url.reset");

        this.xpathFirmware = properties.getProperty("p.xpath.firmware");
        this.xpathPon = properties.getProperty("p.xpath.pon");
        this.xpathSn = properties.getProperty("p.xpath.sn");

        this.title = properties.getProperty("p.title");

        this.firmwarePath = properties.getProperty("p.firmware.path");
        this.firmwareAtualVersion = properties.getProperty("p.firmware.atual");
        this.m.getEquipamento().setModelo(new ModeloDAO().buscar(properties.getProperty("name")));

        Properties p = PropertiesUtil.getProperties(PropertiesUtil.PPOE_PROPERTIES_DIRECTORY);
        ppoeVlan = p.getProperty("p.ppoe.vlan");
        ppoeUser = p.getProperty("p.ppoe.login");
        ppoePass = p.getProperty("p.ppoe.password");

    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public boolean isPpoe() {
        return (m.getEquipamento().getModelo().getTipo() != 0);
    }

    public void writeLog(String method, String description) {
        Log.getInstance().open();
        Log.getInstance().write("*******************************************");
        Log.getInstance().write(Utils.getAtualDate() + ": " + getClass().getName() + "." + method + "();");
        Log.getInstance().write("Descrição: " + description);
        Log.getInstance().write("*******************************************");
        Log.getInstance().close();

    }

    public String getHost() {
        return url.substring(7);
    }

    private void driverFactory() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\data\\chrome\\chromedriver.exe");

        this.options = new ChromeOptions();
        this.options.setBinary(System.getProperty("user.dir") + "\\data\\chrome\\bin\\chrome.exe"); //Setando path do navegador
        this.options.addArguments("user-data-dir=" + System.getProperty("user.dir") + "\\data\\chrome\\profile"); //Setando o perfil do chrome pre-criado
        this.options.addArguments("start-maximized");
    }

    public boolean pingar() {
        try {
            InetAddress adress = InetAddress.getByName(this.getHost());
            try {
                if (adress.isReachable(3000)) {
                    return true;
                }
                return false;
            } catch (IOException ex) {
                return false;
            }
        } catch (UnknownHostException ex) {
            return false;
        }
    }
}
