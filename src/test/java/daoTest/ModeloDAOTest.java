package daoTest;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Modelo;
import org.junit.Test;


public class ModeloDAOTest {
    public void salvar(){
        
        new ModeloDAO().salvar(new Modelo("Dlink DIR-841"));
        
    }
}
