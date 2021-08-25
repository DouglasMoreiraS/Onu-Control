package br.com.planet.view.equipamentos;

import br.com.planet.controlers.NextControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class NextFiber extends EquipamentoView {
    
  
    public NextFiber(){
        super(true);
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/nextfiber.png")));
        this.setTitle(Equipamento.NEXT_FIBER);
    }

    @Override
    public void setControl(){
        this.control = new NextControle(this.getCbNavegador());
    }
    
}
