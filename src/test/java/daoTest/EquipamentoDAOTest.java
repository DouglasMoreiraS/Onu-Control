package daoTest;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.model.bean.Equipamento;
import java.util.List;
import org.junit.Test;

public class EquipamentoDAOTest {
    
    public void teste() throws Exception {

        List<Equipamento> eq = new EquipamentoDAO().listar();

        for (int i = 0; i < eq.size(); i++) {
            if (eq.get(i).getPatrimonio() != null) {
                if (!eq.get(i).getPatrimonio().isEmpty()) {
                    eq.get(i).setPatrimonio(eq.get(i).getPatrimonio().replace("p", ""));
                    eq.get(i).setPatrimonio(eq.get(i).getPatrimonio().replace("P", ""));
                    System.out.println(eq.get(i).getModelo().getNome() + "("+eq.get(i).getSn()+"): " + eq.get(i).getPatrimonio());
                    Equipamento.salvar(eq.get(i));
                }
            }
        }

    }
}
