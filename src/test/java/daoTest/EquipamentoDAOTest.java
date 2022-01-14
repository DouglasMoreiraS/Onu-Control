package daoTest;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import org.junit.Test;

public class EquipamentoDAOTest {

    public void teste() throws Exception{
        
        Equipamento e = new EquipamentoDAO().buscar("00-5F-67-5C-AA-0E");
        
        Manutencao m = new Manutencao(e);
        
        m.setId(3864);
        m.setData("TESTE");
        
        new ManutencaoDAO().salvar(m);
        
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
