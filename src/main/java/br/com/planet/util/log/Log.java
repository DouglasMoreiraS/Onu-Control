package br.com.planet.util.log;

public class Log {
    
    private static final String LOG_PATH = System.getProperty("System.dir") + "/log/logFile.txt";

    private static Log log;
    
    public static synchronized Log getInstance(){
        if (log == null){
            log = new Log();
        }
        return log;
    }
    
    private Log() {
        
    }
    
    
    
    
}
