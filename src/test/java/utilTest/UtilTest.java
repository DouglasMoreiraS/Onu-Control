package utilTest;

import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.model.bean.Manutencao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class UtilTest {

    @Test
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
