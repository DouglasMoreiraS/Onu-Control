package br.com.planet.view.equipamentos;

import br.com.planet.controlers.NextControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;

public class NextFiber extends EquipamentoView {
    
  
    public NextFiber(){
        super(true);
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/nextfiber.png")));
         this.control = new NextControle();
        this.setTitle(control.getM().getEquipamento().getModelo().getNome());
    }
}
