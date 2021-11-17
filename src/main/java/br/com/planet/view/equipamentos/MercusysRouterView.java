package br.com.planet.view.equipamentos;

import br.com.planet.controlers.Mercusys12gControle;

public class MercusysRouterView extends EquipamentoView{

    public MercusysRouterView() {
        super (true);
        this.control = new Mercusys12gControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
        
    }
    
}
