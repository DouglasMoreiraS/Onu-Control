package br.com.planet.view.equipamentos;

import br.com.planet.controlers.SumecControle;
import javax.swing.ImageIcon;

public class SumecView extends EquipamentoView {

    public SumecView() {
        super(false);
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/sumec.png")));
        this.control = new SumecControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
    }

}
