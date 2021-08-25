package taskkill;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class TaskKillTest {
    
    @Test
    public void testTask(){
        
        try {
            Process p =  Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
            p =  Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
          
        } catch (IOException ex) {
            Logger.getLogger(TaskKillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
