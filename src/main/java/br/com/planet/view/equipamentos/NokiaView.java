package br.com.planet.view.equipamentos;

import br.com.planet.controlers.HuaweiControle;
import br.com.planet.controlers.NokiaControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class NokiaView extends EquipamentoView {
    
    
    public NokiaView() {
        super(true);
        //getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/nokia.png")));
        this.setTitle("Nokia");
        
    }
    
    @Override
    public void setControl(){
        this.control = new NokiaControle(getCbNavegador());
    }
    
}
