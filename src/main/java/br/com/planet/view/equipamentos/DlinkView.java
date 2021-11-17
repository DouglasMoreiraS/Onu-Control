package br.com.planet.view.equipamentos;

import br.com.planet.controlers.DlinkControle;
import br.com.planet.util.ImagesUtil;

public class DlinkView extends EquipamentoView {

    public DlinkView() {
        super(true);
        this.control = new DlinkControle();
        this.getPainelImg().setImg(ImagesUtil.getImgIcon(control.getM().getEquipamento().getModelo()));
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
    }
}
