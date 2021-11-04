package br.com.planet.view.equipamentos;

import br.com.planet.controlers.TpLinkC20Controle;
import br.com.planet.controlers.TpLinkWR840NControle;
import br.com.planet.model.bean.Equipamento;

public class TpLinkC20View extends EquipamentoView{

    public TpLinkC20View() {
        super(false);
        setTitle(Equipamento.TP_LINK1);
    }
    
    @Override
    public void setControl(){
        this.control = new TpLinkC20Controle(getCbNavegador());
    }
    
    
}
