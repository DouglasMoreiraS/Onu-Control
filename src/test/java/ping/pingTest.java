package ping;

import br.com.planet.controlers.ChimaControle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class pingTest {

    public void teste(){
        ChimaControle controle = new ChimaControle(true);
        
        int cont = 0;
        while (true){
            try {
                if (controle.pingar()){
                    System.out.println(cont + ": true");
                } else {
                    System.out.println(cont +": False");
                }
                Thread.sleep(3);
                cont++;
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            
            
        }
        
    }
    
}