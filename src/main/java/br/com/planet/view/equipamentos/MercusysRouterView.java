package br.com.planet.view.equipamentos;

import br.com.planet.controlers.MercusysRouterControle;

public class MercusysRouterView extends EquipamentoView{

    public MercusysRouterView() {
        super (false);
        this.control = new MercusysRouterControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
        
    }
    
}
