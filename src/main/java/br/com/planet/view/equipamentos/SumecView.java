package br.com.planet.view.equipamentos;

import br.com.planet.controlers.SumecControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class SumecView extends EquipamentoView{
    
    public SumecView(){
        super(false);
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/sumec.png")));
        this.setTitle(Equipamento.SUMEC);
    }
    
    @Override
    public void setControl(){
        this.control = new SumecControle(getCbNavegador());
    }
    
}
