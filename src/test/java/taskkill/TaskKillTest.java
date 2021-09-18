package taskkill;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openjdk.jol.vm.VM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskKillTest {
    
    @Test
    public void testTask(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        
        System.out.println("Endereço: " + VM.current().addressOf(driver));
        /*
        try {
            Process p =  Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
            p =  Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
          
        } catch (IOException ex) {
            Logger.getLogger(TaskKillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
    
}
