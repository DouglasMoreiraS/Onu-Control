package br.com.planet.view.equipamentos;

import br.com.planet.controlers.EasyLinkControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class EasyLinkView extends EquipamentoView{

    public EasyLinkView() {
        super(false);
        this.getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/easylink.png")));
        this.setTitle(Equipamento.EASY_LINK);
    }
    

    @Override
    public void setControl() {
        control = new EasyLinkControle(getCbNavegador());
    }
    
}
