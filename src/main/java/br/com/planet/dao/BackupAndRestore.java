package br.com.planet.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;

public class BackupAndRestore {

    public static final void backup() {

        try {
            List<Manutencao> listM = new ManutencaoDAO().listar();

            DataBase dba = DataBase.getInstance();

            //  dba.salvar(listM);
            System.out.println("Finish");
        } catch (Exception e) {
            System.out.println("Erro backup: " + e.getMessage());
            e.printStackTrace();
        }
    }

       /* public static final List<Manutencao> restore() throws IOException {
    
        List<Manutencao> listM = DataBase.getInstance().restore();
        System.out.println(listM.size());
        
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
        return listM;
    }
    }*/

}
