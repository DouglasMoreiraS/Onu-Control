package br.com.planet.view.equipamentos;

import br.com.planet.controlers.ZyxelControle;
import br.com.planet.model.bean.Equipamento;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ZyxelView extends EquipamentoView {

    public ZyxelView() {
        super(false);
        getPainelImg().setImg(new ImageIcon(getClass().getResource("/images/zyxel.png")));
    }

    @Override
    public void setControl() {
        this.control = new ZyxelControle(getCbNavegador());
    }

    @Override
    boolean conectar() throws Exception {

        try {
            ((ZyxelControle) control).identificar();
            if (((ZyxelControle) control).getModel().equals("PMG2005-T20D")) {
                controlaBar(EquipamentoView.CONNECT);

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
                controlaBar(EquipamentoView.CONNECT);
                control.findHistorico();
                preencherCampos();
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }
}
