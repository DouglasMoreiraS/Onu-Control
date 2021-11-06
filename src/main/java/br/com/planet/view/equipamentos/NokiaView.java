package br.com.planet.view.equipamentos;

import br.com.planet.controlers.NokiaControle;

public class NokiaView extends EquipamentoView {

    public NokiaView() {
        super(true);
        //getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/nokia.png")));
        this.control = new NokiaControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
    }


}
