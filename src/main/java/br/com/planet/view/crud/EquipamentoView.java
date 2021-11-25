package br.com.planet.view.crud;

import br.com.planet.control.EquipamentoControl;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.exception.DeleteViolationException;
import br.com.planet.model.tablemodel.EquipamentoTableModel;
import br.com.planet.util.ImagesUtil;
import br.com.planet.util.Utils;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.xml.bind.ValidationException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class EquipamentoView extends javax.swing.JDialog {

    EquipamentoControl eqControl;
    Frame parent;
    DefaultPieDataset pieDataSet;

    public EquipamentoView(Frame parent, boolean modal) {
        super(parent, modal);
        eqControl = new EquipamentoControl();
        this.parent = parent;
        initComponents();
        initComponents2();

    }

    public EquipamentoView(Frame parent, boolean modal, String modelo) {
        super(parent, modal);
        eqControl = new EquipamentoControl();
        this.parent = parent;
        initComponents();
        initComponents2();
        this.cbModelo.setSelectedItem(modelo);
        this.atualizaGrafico();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLimpaFiltro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPatrimonio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFirmware = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbModelo = new javax.swing.JComboBox<>();
        painelImagemFundo = new br.com.planet.src.PainelImagemFundo();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jpanelTitulo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipamentos = new javax.swing.JTable();
        panelGrafico = new javax.swing.JPanel();
        lblRodape = new javax.swing.JLabel();
        panelBotoesGrafico = new javax.swing.JPanel();
        btnPatrimonio = new javax.swing.JToggleButton();
        btnFirmware = new javax.swing.JToggleButton();
        btnStatus = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        btnHistorico = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCriarEquipamento = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equipamentos Cadastrados");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnLimpaFiltro.setText("Limpar Filtro");
        btnLimpaFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaFiltroActionPerformed(evt);
            }
        });

        jLabel4.setText("Patrimonio");

        txtPatrimonio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatrimonioKeyReleased(evt);
            }
        });

        jLabel3.setText("Firmware");

        txtFirmware.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirmwareKeyReleased(evt);
            }
        });

        jLabel2.setText("Serial Number");

        txtSn.setMinimumSize(new java.awt.Dimension(56, 24));
        txtSn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSnActionPerformed(evt);
            }
        });
        txtSn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSnKeyReleased(evt);
            }
        });

        jLabel1.setText("Modelo:");

        cbModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbModeloItemStateChanged(evt);
            }
        });

        painelImagemFundo.setMaximumSize(new java.awt.Dimension(100, 100));
        painelImagemFundo.setMinimumSize(new java.awt.Dimension(100, 100));

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

        cbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStatusItemStateChanged(evt);
            }
        });

        jLabel5.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpaFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpaFiltro)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpanelTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(this.tblEquipamentos.getModel().getRowCount()+ " equipamentos Registrados"));

        tblEquipamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEquipamentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblEquipamentosFocusLost(evt);
            }
        });
        tblEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquipamentosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEquipamentosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipamentos);

        panelGrafico.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelGrafico.setMaximumSize(new java.awt.Dimension(362, 362));
        panelGrafico.setMinimumSize(new java.awt.Dimension(362, 362));
        panelGrafico.setName(""); // NOI18N
        panelGrafico.setLayout(new java.awt.BorderLayout());

        panelBotoesGrafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPatrimonio.setText("Patrimonio");
        btnPatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatrimonioActionPerformed(evt);
            }
        });

        btnFirmware.setText("Firmware");
        btnFirmware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirmwareActionPerformed(evt);
            }
        });

        btnStatus.setText("Status");
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesGraficoLayout = new javax.swing.GroupLayout(panelBotoesGrafico);
        panelBotoesGrafico.setLayout(panelBotoesGraficoLayout);
        panelBotoesGraficoLayout.setHorizontalGroup(
            panelBotoesGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesGraficoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotoesGraficoLayout.setVerticalGroup(
            panelBotoesGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesGraficoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotoesGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPatrimonio)
                    .addComponent(btnFirmware)
                    .addComponent(btnStatus))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpanelTituloLayout = new javax.swing.GroupLayout(jpanelTitulo);
        jpanelTitulo.setLayout(jpanelTituloLayout);
        jpanelTituloLayout.setHorizontalGroup(
            jpanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelTituloLayout.createSequentialGroup()
                .addGroup(jpanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelTituloLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addComponent(panelBotoesGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpanelTituloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpanelTituloLayout.setVerticalGroup(
            jpanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jpanelTituloLayout.createSequentialGroup()
                        .addComponent(panelBotoesGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHistorico.setText("Ver Histórico");
        btnHistorico.setEnabled(false);
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCriarEquipamento.setText("Criar Novo Equipamento");
        btnCriarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarEquipamentoActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar Selecionados");
        btnExportar.setEnabled(false);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCriarEquipamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorico)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHistorico)
                    .addComponent(btnEditar)
                    .addComponent(btnCriarEquipamento)
                    .addComponent(btnDeletar)
                    .addComponent(btnExportar))
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

    private void tblEquipamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipamentosMouseClicked
        if (tblEquipamentos.getSelectedRows().length != 0) {
            this.eqControl.setEquipamentoSelecionado(tblEquipamentos.getSelectedRow());
            this.painelImagemFundo.setImg(ImagesUtil.getImgIcon(eqControl.getEquipamentoSelecionado().getModelo().getNome()));
            this.painelImagemFundo.repaint();

            this.btnHistorico.setEnabled(true);
            this.btnEditar.setEnabled(true);
            this.btnExportar.setEnabled(true);
        } else {
            this.btnHistorico.setEnabled(false);
            this.btnEditar.setEnabled(false);
            this.btnExportar.setEnabled(false);
        }
    }//GEN-LAST:event_tblEquipamentosMouseClicked

    private void tblEquipamentosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblEquipamentosFocusLost
    }//GEN-LAST:event_tblEquipamentosFocusLost

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        this.eqControl.historico(parent);
    }//GEN-LAST:event_btnHistoricoActionPerformed

    private void txtSnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSnActionPerformed

    private void cbModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbModeloItemStateChanged

        if (cbModelo.getSelectedItem().toString().equals("Todos")) {
            btnFirmware.setEnabled(false);
        } else {
            btnFirmware.setEnabled(true);
        }
        atualizarTbl();
        atualizaGrafico();

    }//GEN-LAST:event_cbModeloItemStateChanged

    private void btnLimpaFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaFiltroActionPerformed
        this.cbModelo.setSelectedIndex(0);
        this.txtFirmware.setText("");
        this.txtSn.setText("");
        this.txtPatrimonio.setText("");
        atualizarTbl();
        atualizaGrafico();
    }//GEN-LAST:event_btnLimpaFiltroActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        eqControl.editar(parent);
        this.atualizarTbl();
        atualizaGrafico();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCriarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarEquipamentoActionPerformed
        eqControl.criar(parent);
        this.atualizarTbl();
        atualizaGrafico();
    }//GEN-LAST:event_btnCriarEquipamentoActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        int a = JOptionPane.showConfirmDialog(null, "Deseja excluir o equipamento?");
        if (a == (JOptionPane.YES_OPTION)) {
            try {
                eqControl.deletar();
                JOptionPane.showMessageDialog(this, "Equipamento Deletado", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                atualizarTbl();
                atualizaGrafico();

            } catch (DeleteViolationException e) {
                JOptionPane.showMessageDialog(this, "Existem registros desse equipamento, exclua-os primeiro", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                eqControl.historico(parent);
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void cbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStatusItemStateChanged
        atualizarTbl();
        atualizaGrafico();
    }//GEN-LAST:event_cbStatusItemStateChanged

    private void tblEquipamentosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipamentosMouseReleased

        if (tblEquipamentos.getSelectedRowCount() <= 1) {
            lblRodape.setText("Valor Selecionado: " + tblEquipamentos.getValueAt(tblEquipamentos.getSelectedRow(), tblEquipamentos.getSelectedColumn()).toString());
        } else {
            lblRodape.setText("Linhas Selecionadas: " + tblEquipamentos.getSelectedRowCount());
        }

    }//GEN-LAST:event_tblEquipamentosMouseReleased

    private void btnPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatrimonioActionPerformed
        btnFirmware.setSelected(false);
        btnStatus.setSelected(false);
        atualizaGrafico();

    }//GEN-LAST:event_btnPatrimonioActionPerformed

    private void btnFirmwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirmwareActionPerformed
        btnPatrimonio.setSelected(false);
        btnStatus.setSelected(false);
        atualizaGrafico();
    }//GEN-LAST:event_btnFirmwareActionPerformed

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
        btnPatrimonio.setSelected(false);
        btnFirmware.setSelected(false);
        atualizaGrafico();
    }//GEN-LAST:event_btnStatusActionPerformed

    private void txtSnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSnKeyReleased
        atualizarTbl();
        atualizaGrafico();
    }//GEN-LAST:event_txtSnKeyReleased

    private void txtFirmwareKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirmwareKeyReleased
        atualizarTbl();
        atualizaGrafico();
    }//GEN-LAST:event_txtFirmwareKeyReleased

    private void txtPatrimonioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatrimonioKeyReleased
        atualizarTbl();
        atualizaGrafico();
    }//GEN-LAST:event_txtPatrimonioKeyReleased

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed

         if (tblEquipamentos.getSelectedRows().length != 0) {

            String path = "";

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res = chooser.showOpenDialog(this);
            if (res == JFileChooser.APPROVE_OPTION) {
                try {
                    path = chooser.getSelectedFile().getAbsolutePath();
                    eqControl.exportarExcel(path, tblEquipamentos.getSelectedRows());
                    JOptionPane.showMessageDialog(this, "Exportado com sucesso", "Exportar Equipamentos", JOptionPane.INFORMATION_MESSAGE);
                } catch (ValidationException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao exportar registros: " + ex.getMessage(), "Exportar Equipamentos", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao exportar registros: " + ex.getMessage(), "Exportar Equipamentos", JOptionPane.WARNING_MESSAGE);
                }
            }

        }
        
    }//GEN-LAST:event_btnExportarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            EquipamentoView dialog = new EquipamentoView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCriarEquipamento;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JToggleButton btnFirmware;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnLimpaFiltro;
    private javax.swing.JToggleButton btnPatrimonio;
    private javax.swing.JToggleButton btnStatus;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelTitulo;
    private javax.swing.JLabel lblRodape;
    private br.com.planet.src.PainelImagemFundo painelImagemFundo;
    private javax.swing.JPanel panelBotoesGrafico;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JTable tblEquipamentos;
    private javax.swing.JTextField txtFirmware;
    private javax.swing.JTextField txtPatrimonio;
    private javax.swing.JTextField txtSn;
    // End of variables declaration//GEN-END:variables

    public void setTableModel(EquipamentoTableModel m) {
        this.tblEquipamentos.setModel(m);
    }

    public JTable getTblEquipamentos() {
        return tblEquipamentos;
    }

    public void alimentarComboBoxes() {
        String[] modelos = eqControl.getModelos();
        cbModelo.addItem("Todos");

        for (String s : modelos) {
            cbModelo.addItem(s);
        }

        cbStatus.addItem("Todos");
        cbStatus.addItem("Ativos");
        cbStatus.addItem("Desativados");

    }

    private void atualizarTbl() {
        String modelo = "";
        if (!cbModelo.getSelectedItem().toString().equals("Todos")) {
            modelo = cbModelo.getItemAt(cbModelo.getSelectedIndex());
            this.painelImagemFundo.setImg(ImagesUtil.getImgIcon(modelo));
            this.painelImagemFundo.repaint();
        }
        String sn = txtSn.getText().trim();
        String firmware = txtFirmware.getText().trim();
        String patrimonio = txtPatrimonio.getText().trim();
        int status = cbStatus.getSelectedIndex();

        eqControl.buscar(new String[]{sn, modelo, firmware, patrimonio}, status);
        this.tblEquipamentos.setModel(eqControl.getTableModel());

        jpanelTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, this.tblEquipamentos.getModel().getRowCount() + " equipamentos Registrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        atualizaGrafico();
    }

    private void atualizaGrafico() {
        String titulo;
        JFreeChart grafico;
        
        if (cbModelo.getSelectedItem().toString().equals("Todos")) {
            titulo = "Equipamentos Registrados";

            if (btnPatrimonio.isSelected()) {
                titulo = titulo.concat(" (Patrimonio)");
                grafico = eqControl.getGrafico("patrimonio");
            } else if (btnStatus.isSelected()) {
                titulo = titulo.concat(" (Status)");
                grafico = eqControl.getGrafico("status");
            } else {
                grafico = eqControl.getGrafico("");
            }
        } else {

            titulo = cbModelo.getSelectedItem().toString();

            if (btnStatus.isSelected()) {
                titulo = titulo.concat(" - Status");
                grafico = eqControl.getGrafico("status");
            } else if (btnPatrimonio.isSelected()) {
                titulo = titulo.concat(" - Patrimonio");
                grafico = eqControl.getGrafico("patrimonio");

            } else if (btnFirmware.isSelected()) {
                titulo = titulo.concat(" - Firmware");
                grafico = eqControl.getGrafico("firmware");
            } else {
                grafico = eqControl.getGrafico("contagem");
            }
        }
                

        //Peguei esse techo de codigo no GUJ, depois vou ler a documentação e aprimorar.
        ChartPanel myChartPanel = new ChartPanel(grafico, true); //criei o painel de grafico colocando meu grafico previamente gerado
        myChartPanel.setSize(panelGrafico.getWidth(), panelGrafico.getHeight()); //setei o tamanho do grafico conforme o painel que usarei
        myChartPanel.setVisible(true);
        panelGrafico.removeAll(); //removi todos os componentes que podem estar no meu painel
        panelGrafico.add(myChartPanel);
        panelGrafico.revalidate(); // revalidei meu painel, para que ele se atualize
        panelGrafico.repaint();

    }

    private void initComponents2() {
        this.tblEquipamentos.setModel(eqControl.getTableModel());

        this.alimentarComboBoxes();
        this.atualizaGrafico();
        btnFirmware.setEnabled(false);
    }

}
