package br.com.planet.view.equipamentos;

import br.com.planet.controlers.DlinkControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class DlinkView extends EquipamentoView {

    public DlinkView() {
        super(false);
        this.getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/dlink.png")));
        this.setTitle(Equipamento.DLINK);
    }

    @Override
    public void setControl() {
        control = new DlinkControle(getCbNavegador());
    }
    

}
