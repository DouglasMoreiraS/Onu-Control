package utilTest;

import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.model.bean.Manutencao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class UtilTest {

    public void wifiNames() throws IOException {
        ArrayList<String> ssids = new ArrayList<String>();
        ArrayList<String> signals = new ArrayList<String>();
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "netsh wlan show all");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line.contains("SSID") || line.contains("Signal")) {
                if (!line.contains("BSSID")) {
                    if (line.contains("SSID") && !line.contains("name") && !line.contains("SSIDs")) {
                        line = line.substring(8);
                        ssids.add(line);

                    }
                }
                if (line.contains("Signal")) {
                    line = line.substring(30);
                    signals.add(line);

                }

                if (signals.size() == 7) {
                    break;
                }

            }

        }
        for (int i = 1; i < ssids.size(); i++) {
            System.out.println("SSID name == " + ssids.get(i) + "   and its signal == " + signals.get(i));
        }
    }

    public void teste() throws ParseException {

        List<Manutencao> lista = new ManutencaoDAO().listar();
        int i = 0;

        for (Manutencao m : lista) {
            if (m.getData().startsWith("2021")) {
                i++;
            }
        }
        System.out.println(i);

        i = 0;

        for (Manutencao m : lista) {

            if (!m.getData().startsWith("2021")) {
                i++;
            }

        }
        System.out.println(i);

    }

}
