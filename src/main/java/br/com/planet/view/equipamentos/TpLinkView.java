package br.com.planet.view.equipamentos;

import br.com.planet.controlers.TpLinkWR840NControle;

public class TpLinkView extends EquipamentoView{

    public TpLinkView() {
        super(false);
        this.control = new TpLinkWR840NControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
    }
    
    
}
