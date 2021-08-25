package br.com.planet.view.equipamentos;

import br.com.planet.controlers.TpLinkControlador;
import br.com.planet.model.bean.Equipamento;

public class TpLinkView extends EquipamentoView{

    public TpLinkView() {
        super(false);
        setTitle(Equipamento.TP_LINK);
    }
    
    @Override
    public void setControl(){
        this.control = new TpLinkControlador(getCbNavegador());
    }
    
    
}
