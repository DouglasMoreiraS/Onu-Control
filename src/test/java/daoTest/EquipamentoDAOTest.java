package daoTest;

import br.com.planet.dao.BackupAndRestore;
import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ModeloDAO;
import java.util.ArrayList;
import java.util.List;
import br.com.planet.model.bean.*;
import br.com.planet.model.bean.Manutencao;
import org.junit.Test;

public class EquipamentoDAOTest {

    public void teste() throws Exception{
        
        
       /* List<Manutencao> listM = BackupAndRestore.restore();
        
        List <Equipamento> listE = new ArrayList<>();
        for (Manutencao m : listM){
            int key = 0;
            if (!listE.isEmpty()){
                for (Equipamento ee : listE){
                    if (ee.getSn().equals(m.getEquipamento().getSn())){
                        key = 1;
                        break;
                    }
                }
            }
            if (key == 0){
                listE.add(m.getEquipamento());
            }
            
    }
         System.out.println(listM.size());
         System.out.println(listE.size());
            
            
            for (Equipamento e : listE){
                Equipamento.salvar(e);
            }
            
            for (Manutencao m : listM){
                Manutencao.salvar(m);
            }
            */
    }
}
