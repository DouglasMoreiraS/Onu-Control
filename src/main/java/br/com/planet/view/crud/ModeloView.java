package br.com.planet.view.crud;

import br.com.planet.control.ModeloControl;
import br.com.planet.util.Utils;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModeloView extends javax.swing.JDialog {

    ModeloControl control;
    Frame parent;

    public ModeloView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        control = new ModeloControl();
        initComponents();
        this.tblModelos.setModel(control.getTableModel());
        manipulaTela("iniciar");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        painelImagemFundo1 = new br.com.planet.src.PainelImagemFundo();
        lblModelo = new javax.swing.JLabel();
        txtModeloPesquisa = new javax.swing.JTextField();
        btnLimparFiltro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnListarModelos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModelos = new javax.swing.JTable();
        painelCriacao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelTopo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelImagemFundo1Layout = new javax.swing.GroupLayout(painelImagemFundo1);
        painelImagemFundo1.setLayout(painelImagemFundo1Layout);
        painelImagemFundo1Layout.setHorizontalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        painelImagemFundo1Layout.setVerticalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        lblModelo.setText("Modelo:");

        txtModeloPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModeloPesquisaKeyReleased(evt);
            }
        });

        btnLimparFiltro.setText("Limpar Filtro");
        btnLimparFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelImagemFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTopoLayout.createSequentialGroup()
                        .addComponent(lblModelo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelTopoLayout.createSequentialGroup()
                        .addComponent(txtModeloPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelTopoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModeloPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimparFiltro)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelTopoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelImagemFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnDeletar.setText("Deletar");
        btnDeletar.setMaximumSize(new java.awt.Dimension(77, 25));
        btnDeletar.setMinimumSize(new java.awt.Dimension(77, 25));
        btnDeletar.setPreferredSize(new java.awt.Dimension(77, 25));

        btnEditar.setText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(77, 25));
        btnEditar.setMinimumSize(new java.awt.Dimension(77, 25));
        btnEditar.setPreferredSize(new java.awt.Dimension(77, 25));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnListarModelos.setText("Listar Equipamentos");
        btnListarModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarModelosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListarModelos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarModelos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(this.tblModelos.getModel().getRowCount() + " Modelos registrados"));

        tblModelos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblModelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblModelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblModelos);

        jLabel1.setText("Modelo:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(77, 25));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCriacaoLayout = new javax.swing.GroupLayout(painelCriacao);
        painelCriacao.setLayout(painelCriacaoLayout);
        painelCriacaoLayout.setHorizontalGroup(
            painelCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCriacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCriacaoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCriacaoLayout.createSequentialGroup()
                        .addGap(0, 71, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        painelCriacaoLayout.setVerticalGroup(
            painelCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCriacaoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(painelCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addGroup(painelCriacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelCriacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelCriacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelTopo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloPesquisaKeyReleased
        atualizaTbl();
    }//GEN-LAST:event_txtModeloPesquisaKeyReleased

    private void btnLimparFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFiltroActionPerformed
        this.txtModeloPesquisa.setText("");
    }//GEN-LAST:event_btnLimparFiltroActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        manipulaTela("editar");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnListarModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarModelosActionPerformed
        this.control.equipamentoList(parent);
    }//GEN-LAST:event_btnListarModelosActionPerformed

    private void tblModelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModelosMouseClicked
        this.control.setModeloSelecionado(tblModelos.getSelectedRow());
        String path = Utils.getImgIcon(control.getModeloSelecionado().getNome());
        this.painelImagemFundo1.setImg(new ImageIcon(getClass().getResource(path)));
        this.painelImagemFundo1.repaint();

        this.txtModelo.setText(control.getModeloSelecionado().getNome());

        this.manipulaTela("selecionar");
    }//GEN-LAST:event_tblModelosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        manipulaTela("iniciar");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (this.txtModelo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "O campo modelo não pode ser nulo", "Salvar", JOptionPane.WARNING_MESSAGE);
        } else if (this.txtModelo.getText().equals(control.getModeloSelecionado().getNome())) {
            JOptionPane.showMessageDialog(this, "O nome não pode ser igual ao anterior", "Salvar", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                this.control.getModeloSelecionado().setNome(txtModelo.getText());
                this.control.salvar();
                JOptionPane.showMessageDialog(this, "Salvo com sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage(), "Salvar", JOptionPane.WARNING_MESSAGE);
            } finally {
                manipulaTela("iniciar");
                atualizaTbl();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimparFiltro;
    private javax.swing.JButton btnListarModelos;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JPanel painelCriacao;
    private br.com.planet.src.PainelImagemFundo painelImagemFundo1;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JTable tblModelos;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtModeloPesquisa;
    // End of variables declaration//GEN-END:variables

    void manipulaTela(String estado) {

        switch (estado) {

            case "iniciar" -> {

                this.txtModeloPesquisa.setEnabled(true);
                this.btnLimparFiltro.setEnabled(true);

                this.tblModelos.setEnabled(true);

                this.txtModelo.setEnabled(false);
                this.btnSalvar.setEnabled(false);
                this.btnCancelar.setEnabled(false);

                this.btnEditar.setEnabled(true);
                this.btnDeletar.setEnabled(false);

            }

            case ("editar") -> {
                this.txtModeloPesquisa.setEnabled(false);
                this.btnLimparFiltro.setEnabled(false);

                this.tblModelos.setEnabled(false);

                this.txtModelo.setEnabled(true);
                this.btnSalvar.setEnabled(true);
                this.btnCancelar.setEnabled(true);

                this.btnListarModelos.setEnabled(false);
                this.btnEditar.setEnabled(false);
                this.btnDeletar.setEnabled(false);

            }

            case ("selecionar") -> {
                this.txtModeloPesquisa.setEnabled(true);
                this.btnLimparFiltro.setEnabled(true);

                this.tblModelos.setEnabled(true);

                this.txtModelo.setEnabled(false);
                this.btnSalvar.setEnabled(false);
                this.btnCancelar.setEnabled(false);

                this.btnListarModelos.setEnabled(true);
                this.btnEditar.setEnabled(true);
                this.btnDeletar.setEnabled(true);
            }

        }

    }

    void atualizaTbl() {
        control.buscar(txtModeloPesquisa.getText());

        this.tblModelos.setModel(control.getTableModel());
    }

}
