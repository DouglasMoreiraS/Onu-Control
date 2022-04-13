package daoTest;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Modelo;
import org.junit.Test;


public class ModeloDAOTest {
    @Test
    public void salvar() throws Exception{
        
      Modelo ac5 = new ModeloDAO().buscar("Tenda AC5");
      Modelo ac8 = new ModeloDAO().buscar("Tenda AC8");
        
      ac5.setTipo(Modelo.ROUTER);
      new ModeloDAO().editar(ac5);
      
      ac8.setTipo(Modelo.ROUTER);
      new ModeloDAO().editar(ac8);
      
      
  /*    Modelo modelo = new ModeloDAO().buscar("D-link DIR-842");
      modelo.setNome("Dlink DIR-842");
      Modelo.salvar(modelo);
    */  
    }
}
