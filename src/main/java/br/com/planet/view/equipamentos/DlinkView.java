package br.com.planet.view.equipamentos;

import br.com.planet.controlers.DlinkControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class DlinkView extends EquipamentoView {

    public DlinkView() {
        super(true);
        this.getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/dlink.png")));
        this.control = new DlinkControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
    }
}
