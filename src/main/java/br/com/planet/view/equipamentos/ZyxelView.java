package br.com.planet.view.equipamentos;

import br.com.planet.controlers.ZyxelControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ZyxelView extends AcessView {

    String senha;

    public ZyxelView() {
        super(new ZyxelControle());
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/zyxel.png")));
        senha = "";

    }

    @Override
    boolean conectar() throws Exception {
        try {
            if (!((ZyxelControle) control).identificar()) {

                while (true) {
                    senha = JOptionPane.showInputDialog(this, "Senha: ", senha);

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
