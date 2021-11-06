package br.com.planet.controlers;

import br.com.planet.model.bean.Manutencao;
import org.openqa.selenium.chrome.ChromeDriver;

public class GponControle extends Controle{
    
    public GponControle(){
        super();
        this.url = "http://192.168.100.1";
        
        this.login = "telecomadmin";
        this.senha = "admintelecom";
        this.options.setHeadless(false);
        this.driver = new ChromeDriver(options);
        m = new Manutencao();
      //  m.getEquipamento().setModelo(Equipamento.HUAWEI_GPON);
        
    }
    
}
