package br.com.planet.view.equipamentos;

import br.com.planet.controlers.ZyxelControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ZyxelView extends AcessView {

    public ZyxelView() {
        super(new ZyxelControle());
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/zyxel.png")));
        
    }


    @Override
    boolean conectar() throws Exception {
        try {
            if (!((ZyxelControle)control).identificar()) {
                controlaBar(AcessView.CONNECT);

                while (true) {
                    String senha = JOptionPane.showInputDialog(this, "Senha: ", "Senha");

                    if (senha == null) {
                        controlaTela("start");
                        return false;
                    }

                    ((ZyxelControle) control).setSenha(senha);

                    if (!((ZyxelControle) control).logar()) {
                        JOptionPane.showMessageDialog(this, "Senha incorreta", "Logar", JOptionPane.WARNING_MESSAGE);
                    } else {
                        break;
                    }
                }
            }
            if (control.start()) {
                controlaBar(AcessView.CONNECT);
                return true;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
