
import br.com.planet.controlers.Dlink841Controle;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PROJETOS
 */
public class Dlink841ControleTeste {

    //@Test
    public void teste() {

        Dlink841Controle dlink = new Dlink841Controle();
        dlink.open(true);
        dlink.start();
        
        System.out.println(dlink.getM().getEquipamento().getSn() + " " + dlink.getM().getEquipamento().getFirmware());

    }
}
