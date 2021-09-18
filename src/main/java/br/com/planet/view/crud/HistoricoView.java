package br.com.planet.view.crud;

import br.com.planet.control.HistoricoControl;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.util.PlainDocumentLimitado;
import br.com.planet.util.Utils;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.xml.bind.ValidationException;

public class HistoricoView extends javax.swing.JDialog {

    HistoricoControl control;
    Frame parent;

    public HistoricoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        control = new HistoricoControl();
        initComponents();
        initComponents2();

    }

    public HistoricoView(java.awt.Frame parent, boolean modal, String equipamento) {
        super(parent, modal);
        this.parent = parent;
        control = new HistoricoControl();
        initComponents();
        initComponents2();
        cbModelo.setSelectedItem(equipamento);

        atualizarTbl();

    }

    public HistoricoView(java.awt.Frame parent, boolean modal, String equipamento, String data, String observacao, String snEquipamento, boolean filtrar) {
        super(parent, modal);
        this.parent = parent;
        control = new HistoricoControl();
        initComponents();
        initComponents2();

        if (!equipamento.isEmpty()) {
            cbModelo.setSelectedItem(equipamento);
        }

        txtData.setText(data);
        txtObservacao.setText(observacao);
        txtSnEquip.setText(snEquipamento);
        cbFiltro.setSelected(filtrar);

        atualizarTbl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLimpaFiltro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbModelo = new javax.swing.JComboBox<>();
        painelImagemFundo = new br.com.planet.src.PainelImagemFundo();
        txtData = new javax.swing.JTextField();
        cbFiltro = new javax.swing.JCheckBox();
        txtSnEquip = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jpanelTitulo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        btnExportarSelecionados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnLimpaFiltro.setText("Limpar Filtro");
        btnLimpaFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaFiltroActionPerformed(evt);
            }
        });

        jLabel4.setText("Observação");

        txtObservacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObservacaoKeyReleased(evt);
            }
        });

        jLabel2.setText("Data");

        jLabel1.setText("Modelo:");

        cbModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbModeloItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelImagemFundoLayout = new javax.swing.GroupLayout(painelImagemFundo);
        painelImagemFundo.setLayout(painelImagemFundoLayout);
        painelImagemFundoLayout.setHorizontalGroup(
            painelImagemFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        painelImagemFundoLayout.setVerticalGroup(
            painelImagemFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataKeyReleased(evt);
            }
        });

        cbFiltro.setText("Filtrar por equipamento");
        cbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroItemStateChanged(evt);
            }
        });

        txtSnEquip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSnEquipKeyReleased(evt);
            }
        });

        jLabel5.setText("Equipamento (SN)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSnEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpaFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSnEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpanelTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(this.tblHistorico.getModel().getRowCount()+ " equipamentos Registrados"));

        tblHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistorico);

        javax.swing.GroupLayout jpanelTituloLayout = new javax.swing.GroupLayout(jpanelTitulo);
        jpanelTitulo.setLayout(jpanelTituloLayout);
        jpanelTituloLayout.setHorizontalGroup(
            jpanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jpanelTituloLayout.setVerticalGroup(
            jpanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnExportarSelecionados.setText("Exportar Selecionados");
        btnExportarSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarSelecionadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExportarSelecionados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnExportarSelecionados))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpaFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaFiltroActionPerformed
        this.cbModelo.setSelectedIndex(0);
        this.txtData.setText("");
        this.txtObservacao.setText("");
        this.txtSnEquip.setText("");
        atualizarTbl();
    }//GEN-LAST:event_btnLimpaFiltroActionPerformed

    private void cbModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbModeloItemStateChanged
        atualizarTbl();
    }//GEN-LAST:event_cbModeloItemStateChanged

    private void tblHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoricoMouseClicked
        this.control.setHistoricoSelecionado(tblHistorico.getSelectedRow());
        String path = Utils.getImgIcon(control.getHistoricoSelecionado().getEquipamento().getModelo().getNome());
        this.painelImagemFundo.setImg(new ImageIcon(getClass().getResource(path)));
        this.painelImagemFundo.repaint();
        this.btnDeletar.setEnabled(true);
    }//GEN-LAST:event_tblHistoricoMouseClicked

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        /*    try {
           int a = JOptionPane.showConfirmDialog(null,"Deseja excluir o equipamento");
            if (a == (JOptionPane.YES_OPTION)) {
                if (eqControl.deletar()){
                    JOptionPane.showMessageDialog(this, "Equipamento Deletado", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                    atualizarTbl();
                } else {
                    JOptionPane.showMessageDialog(this, "Existem registros desse equipamento, exclua-os primeiro", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                    eqControl.historico(parent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode != KeyEvent.VK_DELETE && keyCode != KeyEvent.VK_BACK_SPACE) {

            if (this.txtData.getText().length() == 2) {
                this.txtData.setText(this.txtData.getText() + "/");
            }

            if (this.txtData.getText().length() == 5) {
                String data = this.txtData.getText().substring(3, 5);
                System.out.println(data);
                if (!data.equals("20")) {
                    this.txtData.setText(this.txtData.getText() + "/");
                }
            }
        }
    }//GEN-LAST:event_txtDataKeyPressed

    private void cbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroItemStateChanged
        atualizarTbl();
    }//GEN-LAST:event_cbFiltroItemStateChanged

    private void btnExportarSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarSelecionadosActionPerformed
        if (tblHistorico.getSelectedRows().length != 0) {

            String path = "";

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res = chooser.showOpenDialog(this);
            if (res == JFileChooser.APPROVE_OPTION) {
                try {
                    path = chooser.getSelectedFile().getAbsolutePath();
                    control.exportarExcel(path, tblHistorico.getSelectedRows());
                    JOptionPane.showMessageDialog(this, "Exportado com sucesso", "Exportar Histórico", JOptionPane.INFORMATION_MESSAGE);
                } catch (ValidationException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao exportar registros: " + ex.getMessage(), "Exportar Histórico", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao exportar registros: " + ex.getMessage(), "Exportar Histórico", JOptionPane.WARNING_MESSAGE);
                }
            }

        }
    }//GEN-LAST:event_btnExportarSelecionadosActionPerformed

    private void txtDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyReleased
        String chars = "0123456789";
        if (!chars.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        atualizarTbl();
    }//GEN-LAST:event_txtDataKeyReleased

    private void txtObservacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacaoKeyReleased
        atualizarTbl();
    }//GEN-LAST:event_txtObservacaoKeyReleased

    private void txtSnEquipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSnEquipKeyReleased
        atualizarTbl();
    }//GEN-LAST:event_txtSnEquipKeyReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            HistoricoView dialog = new HistoricoView(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnExportarSelecionados;
    private javax.swing.JButton btnLimpaFiltro;
    private javax.swing.JCheckBox cbFiltro;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelTitulo;
    private br.com.planet.src.PainelImagemFundo painelImagemFundo;
    private javax.swing.JTable tblHistorico;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtSnEquip;
    // End of variables declaration//GEN-END:variables

    public void alimentarcbModelo() {
        String[] modelos = control.getModelos();
        cbModelo.addItem("Todos");

        for (String s : modelos) {
            cbModelo.addItem(s);
        }

    }

    private void atualizarTbl() {
        String modelo = "";

        if (!cbModelo.getSelectedItem().toString().equals("Todos")) {
            modelo = cbModelo.getItemAt(cbModelo.getSelectedIndex());

            this.painelImagemFundo.setImg(new ImageIcon(getClass().getResource(Utils.getImgIcon(modelo))));
            this.painelImagemFundo.repaint();
        }

        String data = txtData.getText();
        String obs = txtObservacao.getText().trim();
        String snEquip = txtSnEquip.getText().trim();

        int filtro = 0;

        if (cbFiltro.isSelected()) {
            filtro = 1;
        }

        control.buscar(new String[]{modelo, data, obs, snEquip}, filtro);

        this.tblHistorico.setModel(control.getTableModel());

        jpanelTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, this.tblHistorico.getModel().getRowCount() + " equipamentos Registrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    }

    private void initComponents2() {
        tblHistorico.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.tblHistorico.setModel(control.getTableModel());
        this.alimentarcbModelo();
        this.txtData.setDocument(new PlainDocumentLimitado(10));
    }
}
