package daoTest;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Modelo;
import org.junit.Test;


public class ModeloDAOTest {
    public void salvar() throws Exception{
        
      // new ModeloDAO().salvar(new Modelo("Dlink DIR-615"));
        
      Modelo modelo = new ModeloDAO().buscar("D-link DIR-842");
      modelo.setNome("Dlink DIR-842");
      Modelo.salvar(modelo);
      
    }
}
