package br.com.planet.view.equipamentos;

import br.com.planet.controlers.HuaweiControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class HuaweiEchoView extends EquipamentoView {
    
    
    public HuaweiEchoView() {
        super(true);
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/huaweiecho.png")));
        this.setTitle(Equipamento.HUAWEI_ECO);
        
    }
    
    @Override
    public void setControl(){
        this.control = new HuaweiControle(getCbNavegador());
    }
    
}
