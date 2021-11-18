package br.com.planet.util.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {

    private static final String LOG_PATH = System.getProperty("user.dir") + "/log/logFile.txt";
    public static final String BREAK_LINE = "/r/n";

    private static Log log;
    private PrintWriter pw;
    private FileWriter fw;

    public static synchronized Log getInstance() {
        if (log == null) {
            log = new Log();
        }
        return log;
    }

    private Log() {

    }

    public void open() {
        try {
            File file = new File(LOG_PATH);
            if (!file.exists()) {
                System.out.println("Log nao existe, criando...");
                System.out.println(LOG_PATH);
                file.createNewFile();
            }

            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            pw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void fastWrite(String message) {
        Log.getInstance().open();
        Log.getInstance().write("************************");
        Log.getInstance().write(message);
        Log.getInstance().write("************************\n\n");
        Log.getInstance().close();
    }

    public void write(String message) {
        pw.println(message);
    }

}
