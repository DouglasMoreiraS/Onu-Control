
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.model.bean.Manutencao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC_PLANET
 */
public class ordenatorTest {

    public void comparator() {

        List<Manutencao> man = new ManutencaoDAO().listar();

        for (Manutencao m : man) {
            System.out.println(m.getData());
        }

        System.out.println("===================================");

        Collections.sort(man, new Comparator<Manutencao>() {
            public int compare(Manutencao o1, Manutencao o2) {
                 int retorno = 0;  
                try {
                   
                    
                    SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    
                    Date data1 = dtf.parse(o1.getData());
                    Date data2 = dtf.parse(o2.getData());
                    retorno = data1.compareTo(data2);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                return retorno;
            }
        });

        for (Manutencao m : man) {
            System.out.println(m.getData());
        }

    }

}
