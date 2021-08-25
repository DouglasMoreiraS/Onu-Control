package br.com.planet.src.ping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ping {

    String url;
    String title;

    public static boolean ping(String url, String title) {
        try {

            WebDriver d = new ChromeDriver(new ChromeOptions().setHeadless(true));
            d.get(url);
            if (d.getTitle().equals(title)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
