package br.com.planet.view.equipamentos;

import br.com.planet.controlers.MercusysRouterControle;
import br.com.planet.model.bean.Equipamento;

public class MercusysRouterView extends EquipamentoView{

    public MercusysRouterView() {
        super (false);
        this.setTitle(Equipamento.MERCUSYS_ROUTER_AC12G);
    }
    
    
    public void setControl(){
        this.control = new MercusysRouterControle(this.getCbNavegador());
    }
    
    
}
