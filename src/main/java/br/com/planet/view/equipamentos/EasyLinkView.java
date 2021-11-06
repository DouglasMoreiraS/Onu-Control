package br.com.planet.view.equipamentos;

import br.com.planet.controlers.EasyLinkControle;
import javax.swing.ImageIcon;

public class EasyLinkView extends EquipamentoView{

    public EasyLinkView() {
        super(false);
        this.getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/easylink.png")));
        this.control = new EasyLinkControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
    }
    

    
}
