package br.com.planet.view.equipamentos;

import br.com.planet.controlers.HuaweiControle;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class HuaweiEchoView extends EquipamentoView {

    public HuaweiEchoView() {
        super(true);
        try {
            getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/huaweiecho.png")));
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public void setControl() {
        this.control = new HuaweiControle(getCbNavegador());
    }

}
