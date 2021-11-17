package utilTest;

import br.com.planet.util.log.Log;

public class logTest {

    public void logTest() {

        for (int j = 0; j < 1; j++) {
            Log log = Log.getInstance();
            log.open();
            log.write("******************************************");
            for (int i = 0; i < 1000; i++) {
                log.write("Teste de log");
            }
            log.close();
        }
    }
}
