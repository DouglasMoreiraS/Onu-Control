package br.com.planet.view.equipamentos;

import br.com.planet.controlers.ChimaControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class ChimaView extends EquipamentoView{

    public ChimaView() {
        super(false);
        this.getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/chima.png")));
        this.setTitle(Equipamento.CHIMA);
    }
    

    @Override
    public void setControl() {
        control = new ChimaControle(getCbNavegador());
    }
    
}
