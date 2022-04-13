package br.com.planet.view;

import br.com.planet.view.equipamentos.*;
import br.com.planet.controlers.*;
import br.com.planet.dao.BackupAndRestore;
import br.com.planet.model.bean.Modelo;
import br.com.planet.util.GraficoEquipamentos;
import br.com.planet.view.crud.EquipamentoViewTest;
import br.com.planet.view.crud.HistoricoView;
import br.com.planet.view.crud.ModeloView;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class View extends javax.swing.JFrame {

    EquipamentoViewTest eqView;
    HistoricoView hisView;
    ModeloView modeloView;

    AcessView huaweiView;
    ZyxelView zyxelView;
    AcessView chimaView;
    AcessView nextView;
    AcessView sumecView;
    AcessView tpLinkView;
    AcessView tpLinkc20View;
    AcessView easyLinkView;
    AcessView dlink842View;
    AcessView dlink841View;
    AcessView dlink615View;
    AcessView mercusysac12gView;
    AcessView mercusysMW301RView;
    AcessView nokiaView;
    AcessView zte601View;
    AcessView rf301View;
    AcessView ac5View;
    AcessView ac8View;

    public View() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        painelImagemFundo1.setImg(new ImageIcon(getClass().getResource("/images/background.png")));
        atualizaRodape();
        setaGrafico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelImagemFundo1 = new br.com.planet.src.PainelImagemFundo();
        panelGrafico = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu21 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenu22 = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenu24 = new javax.swing.JMenu();
        jMenu29 = new javax.swing.JMenu();
        dlink841AcessMenu2 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenu26 = new javax.swing.JMenu();
        dlink841AcessMenu = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenu25 = new javax.swing.JMenu();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu27 = new javax.swing.JMenu();
        jMenu28 = new javax.swing.JMenu();
        dlink841AcessMenu1 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenu30 = new javax.swing.JMenu();
        jMenu31 = new javax.swing.JMenu();
        dlink841AcessMenu3 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenu32 = new javax.swing.JMenu();
        dlink841AcessMenu4 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu23 = new javax.swing.JMenu();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        menuListarTabela = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ONT Facility");
        setMinimumSize(new java.awt.Dimension(1211, 1021));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelImagemFundo1Layout = new javax.swing.GroupLayout(painelImagemFundo1);
        painelImagemFundo1.setLayout(painelImagemFundo1Layout);
        painelImagemFundo1Layout.setHorizontalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );
        painelImagemFundo1Layout.setVerticalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        getContentPane().add(painelImagemFundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 780));

        jMenu5.setText("Equipamentos");

        jMenu6.setText("Roteadores");

        jMenu4.setText("TPLink");

        jMenu16.setText("TPLink WR840N");

        jMenuItem21.setText("Acesso Remoto");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem21);

        jMenuItem22.setText("Historico");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem22);

        jMenu4.add(jMenu16);

        jMenu19.setText("TPLink Archer C20");

        jMenuItem30.setText("Acesso Remoto");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem30);

        jMenuItem31.setText("Historico");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem31);

        jMenu4.add(jMenu19);

        jMenu6.add(jMenu4);

        jMenu21.setText("Mercusys");

        jMenu18.setText("Mercusys AC12G");

        jMenuItem25.setText("Acesso Remoto");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem25);

        jMenuItem26.setText("Historico");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem26);

        jMenu21.add(jMenu18);

        jMenu22.setText("Mercusys MW301R");

        jMenuItem34.setText("Acesso Remoto");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem34);

        jMenuItem35.setText("Historico");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem35);

        jMenu21.add(jMenu22);

        jMenu6.add(jMenu21);

        jMenu24.setText("Dlink ");

        jMenu29.setText("Dlink DIR-615");

        dlink841AcessMenu2.setText("Acesso Remoto");
        dlink841AcessMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlink841AcessMenu2ActionPerformed(evt);
            }
        });
        jMenu29.add(dlink841AcessMenu2);

        jMenuItem43.setText("Historico");
        jMenu29.add(jMenuItem43);

        jMenu24.add(jMenu29);

        jMenu26.setText("Dlink DIR-841");

        dlink841AcessMenu.setText("Acesso Remoto");
        dlink841AcessMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlink841AcessMenuActionPerformed(evt);
            }
        });
        jMenu26.add(dlink841AcessMenu);

        jMenuItem41.setText("Historico");
        jMenu26.add(jMenuItem41);

        jMenu24.add(jMenu26);

        jMenu25.setText("Dlink DIR-842");

        jMenuItem38.setText("Acesso Remoto");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem38);

        jMenuItem39.setText("Historico");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem39);

        jMenu24.add(jMenu25);

        jMenu6.add(jMenu24);

        jMenu27.setText("IntelBras");

        jMenu28.setText("RF301K");

        dlink841AcessMenu1.setText("Acesso Remoto");
        dlink841AcessMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlink841AcessMenu1ActionPerformed(evt);
            }
        });
        jMenu28.add(dlink841AcessMenu1);

        jMenuItem42.setText("Historico");
        jMenu28.add(jMenuItem42);

        jMenu27.add(jMenu28);

        jMenu6.add(jMenu27);

        jMenu30.setText("Tenda");

        jMenu31.setText("Ac5");

        dlink841AcessMenu3.setText("Acesso Remoto");
        dlink841AcessMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlink841AcessMenu3ActionPerformed(evt);
            }
        });
        jMenu31.add(dlink841AcessMenu3);

        jMenuItem44.setText("Historico");
        jMenu31.add(jMenuItem44);

        jMenu30.add(jMenu31);

        jMenu32.setText("Ac8");

        dlink841AcessMenu4.setText("Acesso Remoto");
        dlink841AcessMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlink841AcessMenu4ActionPerformed(evt);
            }
        });
        jMenu32.add(dlink841AcessMenu4);

        jMenuItem45.setText("Historico");
        jMenu32.add(jMenuItem45);

        jMenu30.add(jMenu32);

        jMenu6.add(jMenu30);

        jMenu5.add(jMenu6);

        jMenu8.setText("ONUs");

        jMenu13.setText("Chima");

        jMenuItem15.setText("Acesso Remoto");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem15);

        jMenuItem16.setText("Histórico");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem16);

        jMenu8.add(jMenu13);

        jMenu14.setText("Zyxel");

        jMenuItem17.setText("Acesso Remoto");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem17);

        jMenuItem18.setText("Histórico");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem18);

        jMenu8.add(jMenu14);

        jMenu15.setText("Sumec");

        jMenuItem19.setText("Acesso Remoto");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem19);

        jMenuItem20.setText("Histórico");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem20);

        jMenu8.add(jMenu15);

        jMenu17.setText("EasyLink");

        jMenuItem23.setText("Acesso Remoto");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem23);

        jMenuItem24.setText("Histórico");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem24);

        jMenu8.add(jMenu17);

        jMenu23.setText("ZTE F601");

        jMenuItem36.setText("Acesso Remoto");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem36);

        jMenuItem37.setText("Histórico");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem37);

        jMenu8.add(jMenu23);

        jMenu5.add(jMenu8);

        jMenu9.setText("ONTs");

        jMenu10.setText("NextFIber");

        jMenuItem10.setText("Acesso Remoto");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem10);

        jMenuItem11.setText("Histórico");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem11);

        jMenu9.add(jMenu10);

        jMenu11.setText("Huawei EchoLife");

        jMenuItem9.setText("Acesso Remoto");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem9);

        jMenuItem12.setText("Histórico");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem12);

        jMenu9.add(jMenu11);

        jMenu12.setText("Huawei GPON");

        jMenuItem13.setText("Acesso Remoto");
        jMenu12.add(jMenuItem13);

        jMenuItem14.setText("Histórico");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem14);

        jMenu9.add(jMenu12);

        jMenu20.setText("Nokia G-140W-C");

        jMenuItem32.setText("Acesso Remoto");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem32);

        jMenuItem33.setText("Histórico");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem33);

        jMenu9.add(jMenu20);

        jMenu5.add(jMenu9);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Equipamentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem27.setText("Modelos");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem27);

        menuListarTabela.setText("Histórico");
        menuListarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarTabelaActionPerformed(evt);
            }
        });
        jMenu1.add(menuListarTabela);

        jMenuItem5.setText("Backup");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Restore");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Opções");

        jMenuItem2.setText("Liberar Memoria");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem28.setText("PPOE");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem28);

        jMenuItem29.setText("Propriedades Equipamentos");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem29);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1382, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuListarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarTabelaActionPerformed
        if (hisView == null) {
            hisView = new HistoricoView(this, false);
        }
        hisView.setVisible(false);
        hisView.setVisible(true);
    }//GEN-LAST:event_menuListarTabelaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (eqView == null) {
            eqView = new EquipamentoViewTest();
        }
        eqView.setVisible(false);
        eqView.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        BackupAndRestore.backup();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if (huaweiView == null) {
            huaweiView = new AcessView(new HuaweiControle());
        }
        huaweiView.setVisible(false);
        huaweiView.setVisible(true);

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        if (zyxelView == null) {
            zyxelView = new ZyxelView();
        }
        zyxelView.setVisible(false);
        zyxelView.setVisible(true);

    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if (chimaView == null) {
            chimaView = new AcessView(new ChimaControle());
        }

        chimaView.setVisible(false);
        chimaView.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (nextView == null) {
            nextView = new AcessView(new NextControle());
        }

        nextView.setVisible(false);
        nextView.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        if (sumecView == null) {
            sumecView = new AcessView(new SumecControle());
        }
        sumecView.setVisible(false);
        sumecView.setVisible(true);

    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        if (tpLinkView == null) {
            tpLinkView = new AcessView(new TpLinkWR840NControle());
        }
        tpLinkView.setVisible(false);
        tpLinkView.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        if (easyLinkView == null) {
            easyLinkView = new AcessView(new EasyLinkControle());
        }

        easyLinkView.setVisible(false);
        easyLinkView.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        new HistoricoView(this, false, Modelo.TP_LINK).setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        new HistoricoView(this, false, Modelo.CHIMA).setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        new HistoricoView(this, false, Modelo.ZYXEL).setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        new HistoricoView(this, false, Modelo.SUMEC).setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        new HistoricoView(this, false, Modelo.EASY_LINK).setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new HistoricoView(this, false, Modelo.NEXT_FIBER).setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new HistoricoView(this, false, Modelo.HUAWEI_ECO).setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        new HistoricoView(this, false, Modelo.HUAWEI_ECO).setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        if (mercusysac12gView == null) {
            mercusysac12gView = new AcessView(new Mercusys12gControle());
        }
        mercusysac12gView.setVisible(false);
        mercusysac12gView.setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed


    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        new HistoricoView(this, false, Modelo.MERCUSYS_ROUTER_AC12G).setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        int resposta = JOptionPane.showConfirmDialog(null, "Esse processo irá encerrar todas as conexões ativas,"
                + " verifique se nenhum equipamento está conectado ou em processo de "
                + "                                         atualização/reset antes de continuar");

        if (resposta == JOptionPane.YES_OPTION) {

            try {
                Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
                Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
                JOptionPane.showMessageDialog(this, "Drivers finalizados com sucesso", "Finalização de Drivers", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao tentar finalizar os Drivers ativos", "Finalização de Drivers", JOptionPane.WARNING_MESSAGE);
            }

        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        if (modeloView == null) {
            modeloView = new ModeloView(this, false);
        }
        modeloView.setVisible(false);
        modeloView.setVisible(true);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        PpoeConfigView view = new PpoeConfigView();
        view.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        new br.com.planet.view.PropertiesView(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        if (tpLinkc20View == null) {
            tpLinkc20View = new AcessView(new TpLinkC20Controle());
        }
        tpLinkc20View.setVisible(false);
        tpLinkc20View.setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        if (nokiaView == null) {
            nokiaView = new AcessView(new NokiaControle());
        }
        nokiaView.setVisible(false);
        nokiaView.setVisible(true);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        if (mercusysMW301RView == null) {
            mercusysMW301RView = new AcessView(new MercusysMW301RControle());
        }
        mercusysMW301RView.setVisible(false);
        mercusysMW301RView.setVisible(true);

    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        if (zte601View == null) {
            zte601View = new AcessView(new ZTEF601Controle());
        }
        zte601View.setVisible(false);
        zte601View.setVisible(true);

    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        if (dlink842View == null) {
            dlink842View = new AcessView(new Dlink842Controle());
        }
        this.dlink842View.setVisible(false);
        this.dlink842View.setVisible(true);
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void dlink841AcessMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlink841AcessMenuActionPerformed
        if (dlink841View == null) {
            dlink841View = new AcessView(new Dlink841Controle());
        }
        this.dlink841View.setVisible(false);
        this.dlink841View.setVisible(true);

    }//GEN-LAST:event_dlink841AcessMenuActionPerformed

    private void dlink841AcessMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlink841AcessMenu1ActionPerformed
        if (rf301View == null) {
            rf301View = new AcessView(new IntelBrasRF301KControle());
        }
        this.rf301View.setVisible(false);
        this.rf301View.setVisible(true);
    }//GEN-LAST:event_dlink841AcessMenu1ActionPerformed

    private void dlink841AcessMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlink841AcessMenu2ActionPerformed
        if (dlink615View == null) {
            dlink615View = new AcessView(new Dlink615Controle());
        }
        this.dlink615View.setVisible(false);
        this.dlink615View.setVisible(true);
    }//GEN-LAST:event_dlink841AcessMenu2ActionPerformed

    private void dlink841AcessMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlink841AcessMenu3ActionPerformed
        if (ac5View == null) {
            ac5View = new AcessView(new TendaAC5Controle());
        }
        this.ac5View.setVisible(false);
        this.ac5View.setVisible(true);
    }//GEN-LAST:event_dlink841AcessMenu3ActionPerformed

    private void dlink841AcessMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlink841AcessMenu4ActionPerformed
        if (ac8View == null) {
            ac8View = new AcessView(new TendaAC8Controle());
        }
        this.ac8View.setVisible(false);
        this.ac8View.setVisible(true);
    }//GEN-LAST:event_dlink841AcessMenu4ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf Dark".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dlink841AcessMenu;
    private javax.swing.JMenuItem dlink841AcessMenu1;
    private javax.swing.JMenuItem dlink841AcessMenu2;
    private javax.swing.JMenuItem dlink841AcessMenu3;
    private javax.swing.JMenuItem dlink841AcessMenu4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu27;
    private javax.swing.JMenu jMenu28;
    private javax.swing.JMenu jMenu29;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu30;
    private javax.swing.JMenu jMenu31;
    private javax.swing.JMenu jMenu32;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem menuListarTabela;
    private br.com.planet.src.PainelImagemFundo painelImagemFundo1;
    private javax.swing.JPanel panelGrafico;
    // End of variables declaration//GEN-END:variables

    private void atualizaRodape() {

    }

    private void setaGrafico() {
        JFreeChart jfc;
        GraficoEquipamentos grafico = new GraficoEquipamentos();

        jfc = ChartFactory.createPieChart("Equipamentos", grafico.graficoContagem(), true, true, true);

        ChartPanel myChartPanel = new ChartPanel(jfc, true); //criei o painel de grafico colocando meu grafico previamente gerado
        myChartPanel.setSize(panelGrafico.getWidth(), panelGrafico.getHeight()); //setei o tamanho do grafico conforme o painel que usarei
        myChartPanel.setVisible(true);
        panelGrafico.removeAll(); //removi todos os componentes que podem estar no meu painel
        panelGrafico.add(myChartPanel);
        panelGrafico.revalidate(); // revalidei meu painel, para que ele se atualize
        panelGrafico.repaint();

    }
}
