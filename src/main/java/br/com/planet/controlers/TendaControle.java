package br.com.planet.controlers;

import br.com.planet.util.PropertiesUtil;
import br.com.planet.util.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class TendaControle extends Controle {

    File src;
    File dst;

    String pathBackup = System.getProperty("user.dir") + "\\data\\tenda\\backup";
    String pathPrincipal = System.getProperty("user.dir") + "\\data\\tenda\\final";

    public TendaControle(String properties) {
        super();
        timeout = 4;
        this.loadProperties(PropertiesUtil.PROPERTIES_DIRECTORY + "\\" + properties);

    }

    public boolean logar() throws WebDriverException {

        try {
            String xpathLogin = "//*[@id=\"login-password\"]";
            String xpathBar = "//*[@id=\"status\"]";

            driver.get(url);

            if (Utils.existsElement(driver, "//*[@id=\"dhcp\"]")) {

                driver.findElement(By.xpath("//*[@id=\"dhcp\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"save\"]")).click();

                return true;
            } else if (Utils.existsElement(driver, xpathLogin) && driver.findElement(By.xpath(xpathLogin)).isDisplayed()) {
                driver.findElement(By.xpath(xpathLogin)).clear();
                driver.findElement(By.xpath(xpathLogin)).sendKeys(senha);
                driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
                return true;
            } else if (Utils.existsElement(driver, xpathBar)) {
                return true;
            } else {
                return false;
            }

        } catch (WebDriverException e) {
            System.out.println("Erro IntelBras logar: " + e.getMessage());
            this.writeLog("logar", e.getMessage());
            return false;
        }
    }

    public void getPon() {
    }

    @Override
    public void getSn() throws WebDriverException {
        try {

            WebElement button = driver.findElement(By.xpath("//*[@id=\"system\"]"));

            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click()", button);
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }

            Thread.sleep(1000);

            WebElement sn = driver.findElement(By.xpath("//*[@id=\"macCurrenWrap\"]"));

            String serial = sn.getText();
            System.out.println("value: " + serial);

            m.getEquipamento().setSn(serial.substring(serial.indexOf(":") + 2));

            System.out.println(m.getEquipamento().getSn());
        } catch (WebDriverException e) {
            System.out.println("Erro IntelBras getSn: " + e.getMessage());
            this.writeLog("getSn", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            Logger.getLogger(TendaControle.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getFirmware() throws WebDriverException {
        try {

            WebElement button = driver.findElement(By.xpath("//*[@id=\"system\"]"));

            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click()", button);
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }

            Thread.sleep(1000);

            WebElement firm = driver.findElement(By.xpath("//*[@id=\"firmwareVision\"]"));
            String firmware = firm.getAttribute("innerText");
            System.out.println(firm.getAttribute("innerText") + " - innerText");
            System.out.println(firmware);

            m.getEquipamento().setFirmware(firmware);

        } catch (WebDriverException e) {
            System.out.println("Erro IntelBras getFirmware: " + e.getMessage());
            this.writeLog("getFirmware", e.getMessage());
            throw e;
        } catch (InterruptedException ex) {
            Logger.getLogger(TendaControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateFirmware() {
        try {

            String snFormatada = m.getEquipamento().getSn().replace(":", "");

            Runtime.getRuntime().exec("cmd /c start " + System.getProperty("user.dir") + "\\data\\tenda\\19216816.lnk");

            src = new File(pathBackup);
            dst = new File(pathPrincipal);

            if (dst.exists()) {
                deleteDirectory(dst);
            }

            copyDirectory(src, dst);

            File f[] = dst.listFiles();

            for (File ff : f) {
                if (ff.getName().contains("RouterCfm")) {
                    ff.renameTo(new File(dst.getAbsolutePath() + "/RouterCfm_" + snFormatada + ".cfg"));
                    break;
                }
            }

            Process p = Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\data\\tenda\\run.bat");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            System.out.println(input.readLine());

            Runtime.getRuntime().exec("cmd /c start " + System.getProperty("user.dir") + "\\data\\tenda\\19216802.lnk");

            while (!logar()) {
            }
            atualizarInformacoes();

        } catch (WebDriverException | IOException e) {
            System.out.println("Erro: Tenda updateFirmware: " + e.getMessage());
            this.writeLog("updateFirmware", e.getMessage());
        } finally {
            try {
                Runtime.getRuntime().exec("cmd /c start " + System.getProperty("user.dir") + "\\data\\tenda\\19216802.lnk");
            } catch (IOException ex) {
            }
        }
    }

    void copyDirectory(File srcDir, File dstDir) throws IOException {
        if (srcDir.isDirectory()) {
            if (!dstDir.exists()) {
                dstDir.mkdir();
            }
            String[] children = srcDir.list();
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(srcDir, children[i]),
                        new File(dstDir, children[i]));
            }
        } else {
            Files.copy(Paths.get(srcDir.getAbsolutePath()), Paths.get(dstDir.getAbsolutePath()));
        }
    }

    void deleteDirectory(File dst) {

        File files[] = dst.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                deleteDirectory(f);
            }
            f.delete();
        }
        dst.delete();
    }

}
