package br.com.planet.util;

import br.com.planet.model.bean.Equipamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Utils {

    public static boolean existsElement(WebDriver driver, String xpath) {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static final String getAtualDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return (dtf.format(LocalDateTime.now()));
    }

    public static final String getImgIcon(String modelo) {

        switch (modelo) {
            case Equipamento.ZYXEL -> {
                return ("/images/zyxel.png");
            }
            case Equipamento.NEXT_FIBER -> {
                return "/images/nextfiber.png";
            }
            case Equipamento.HUAWEI_ECO -> {
                return "/images/huaweiecho.png";
            }
            case Equipamento.DLINK -> {
                return "/images/dlink.png";
            }
            case Equipamento.CHIMA -> {
                return "/images/chima.png";
            }
            case Equipamento.SUMEC -> {
                return "/images/sumec.png";
            }
            case Equipamento.EASY_LINK ->{
                return "/images/easylink.png";
            }
            default->{
                return "";
            }
        }
    }
}
