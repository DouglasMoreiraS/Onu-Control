package br.com.planet.view.crud;

import br.com.planet.control.EquipamentoControl;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.exception.SerialNumberViolationException;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class EquipamentoViewTest extends javax.swing.JFrame {

    private static final String EDIT = "edit";
    private static final String DEFAULT = "default";

    EquipamentoControl control;

    int btnEditarState = 0;

    public EquipamentoViewTest() {
        control = new EquipamentoControl();
        initComponents();
        initComponents2();
        controlaTela(DEFAULT);
        valueChanged();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtPesquisaSn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbModelo = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        btnLimpaFiltro = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPesquisaPatrimonio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPesquisaFirmware = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipamentos = new javax.swing.JTable();
        panelBotoesGrafico = new javax.swing.JPanel();
        btnPatrimonio = new javax.swing.JToggleButton();
        btnFirmware = new javax.swing.JToggleButton();
        btnStatus = new javax.swing.JToggleButton();
        panelGrafico = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        painelImagemFundo1 = new br.com.planet.src.PainelImagemFundo();
        txtModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPatrimonio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFirmware = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbStatus = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtPesquisaSn.setMinimumSize(new java.awt.Dimension(56, 24));
        txtPesquisaSn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaSnActionPerformed(evt);
            }
        });
        txtPesquisaSn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaSnKeyReleased(evt);
            }
        });

        jLabel8.setText("Modelo:");

        cbModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbModeloItemStateChanged(evt);
            }
        });

        cbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStatusItemStateChanged(evt);
            }
        });

        btnLimpaFiltro.setText("Limpar Filtro");
        btnLimpaFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaFiltroActionPerformed(evt);
            }
        });

        jLabel9.setText("Status");

        jLabel10.setText("Patrimonio");

        txtPesquisaPatrimonio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaPatrimonioKeyReleased(evt);
            }
        });

        jLabel11.setText("Firmware");

        txtPesquisaFirmware.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaFirmwareKeyReleased(evt);
            }
        });

        jLabel12.setText("Serial Number");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisaSn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisaFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisaPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpaFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaSn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpaFiltro)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

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
        tblEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEquipamentosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipamentos);

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

        panelGrafico.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelGrafico.setMinimumSize(new java.awt.Dimension(580, 432));
        panelGrafico.setName(""); // NOI18N
        panelGrafico.setPreferredSize(new java.awt.Dimension(580, 432));
        panelGrafico.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBotoesGraficoLayout = new javax.swing.GroupLayout(panelBotoesGrafico);
        panelBotoesGrafico.setLayout(panelBotoesGraficoLayout);
        panelBotoesGraficoLayout.setHorizontalGroup(
            panelBotoesGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesGraficoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBotoesGraficoLayout.createSequentialGroup()
                        .addComponent(btnPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206)
                        .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBotoesGraficoLayout.setVerticalGroup(
            panelBotoesGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesGraficoLayout.createSequentialGroup()
                .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBotoesGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPatrimonio)
                    .addComponent(btnFirmware)
                    .addComponent(btnStatus))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotoesGrafico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotoesGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        jLabel1.setText("Modelo");

        jLabel2.setText("Patrimonio");

        jLabel3.setText("Serial Number");

        jLabel4.setText("Firmware");

        jLabel5.setText("Status");

        rbStatus.setText("Ativo");
        rbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStatusActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tblHistorico);

        jLabel6.setText("Histórico do equipamento");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane3.setViewportView(txtObs);

        jLabel7.setText("Observações do equipamento");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rbStatus)
                        .addGap(17, 343, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(painelImagemFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelImagemFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbStatusActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (btnEditarState == 0) {
            btnEditarState = 1;
            controlaTela(EDIT);
        } else {
            try {
                btnEditarState = 0;
                control.getEquipamentoSelecionado().setPatrimonio(txtPatrimonio.getText());
                control.getEquipamentoSelecionado().setStatus(rbStatus.isSelected());
                control.getEquipamentoSelecionado().setObservacao(txtObs.getText());
                control.salvar(1);
                JOptionPane.showInputDialog(this, "Salvo com sucesso!");
                controlaTela(DEFAULT);
            } catch (PatrimonioViolationException ex) {
                JOptionPane.showInputDialog(this, "Esse patrimonio já está cadastrado", "Erro de patrimonio", JOptionPane.WARNING_MESSAGE);
            } catch (SerialNumberViolationException ex) {
                JOptionPane.showInputDialog(this, "Esse SN já foi cadastrado", "Serial Number", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisaSnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaSnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaSnActionPerformed

    private void txtPesquisaSnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaSnKeyReleased
        atualizarTbl();
        atualizarGrafico();
    }//GEN-LAST:event_txtPesquisaSnKeyReleased

    private void cbModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbModeloItemStateChanged

        if (cbModelo.getSelectedItem().toString().equals("Todos")) {
            btnFirmware.setEnabled(false);
        } else {
            btnFirmware.setEnabled(true);
        }
        atualizarTbl();
        atualizarGrafico();
    }//GEN-LAST:event_cbModeloItemStateChanged

    private void cbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStatusItemStateChanged
        atualizarTbl();
        atualizarGrafico();
    }//GEN-LAST:event_cbStatusItemStateChanged

    private void btnLimpaFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaFiltroActionPerformed
        this.cbModelo.setSelectedIndex(0);
        this.txtPesquisaFirmware.setText("");
        this.txtPesquisaSn.setText("");
        this.txtPesquisaPatrimonio.setText("");
        atualizarTbl();
        atualizarGrafico();
    }//GEN-LAST:event_btnLimpaFiltroActionPerformed

    private void txtPesquisaPatrimonioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaPatrimonioKeyReleased
        atualizarTbl();
        atualizarGrafico();
    }//GEN-LAST:event_txtPesquisaPatrimonioKeyReleased

    private void txtPesquisaFirmwareKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaFirmwareKeyReleased
        atualizarTbl();
        atualizarGrafico();
    }//GEN-LAST:event_txtPesquisaFirmwareKeyReleased

    private void btnPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatrimonioActionPerformed
        btnFirmware.setSelected(false);
        btnStatus.setSelected(false);
        atualizarGrafico();
    }//GEN-LAST:event_btnPatrimonioActionPerformed

    private void btnFirmwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirmwareActionPerformed
        btnPatrimonio.setSelected(false);
        btnStatus.setSelected(false);
        atualizarGrafico();
    }//GEN-LAST:event_btnFirmwareActionPerformed

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
        btnPatrimonio.setSelected(false);
        btnFirmware.setSelected(false);
        atualizarGrafico();
    }//GEN-LAST:event_btnStatusActionPerformed

    private void tblEquipamentosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipamentosMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEquipamentosMouseReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        controlaTela(DEFAULT);
        btnEditarState = 0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(() -> {
            new EquipamentoViewTest().setVisible(true);
        });
    }

    private void valueChanged() {
        tblEquipamentos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                if (tblEquipamentos.getSelectedRow() >= 0) {
                    control.setEquipamentoSelecionado(tblEquipamentos.getSelectedRow());
                    preencherCampos();
                }
            }

        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JToggleButton btnFirmware;
    private javax.swing.JButton btnLimpaFiltro;
    private javax.swing.JToggleButton btnPatrimonio;
    private javax.swing.JToggleButton btnStatus;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private br.com.planet.src.PainelImagemFundo painelImagemFundo1;
    private javax.swing.JPanel panelBotoesGrafico;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JRadioButton rbStatus;
    private javax.swing.JTable tblEquipamentos;
    private javax.swing.JTable tblHistorico;
    private javax.swing.JTextField txtFirmware;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtPatrimonio;
    private javax.swing.JTextField txtPesquisaFirmware;
    private javax.swing.JTextField txtPesquisaPatrimonio;
    private javax.swing.JTextField txtPesquisaSn;
    private javax.swing.JTextField txtSn;
    // End of variables declaration//GEN-END:variables

    private void controlaTela(String STATE) {
        switch (STATE) {
            case EquipamentoViewTest.EDIT:
                cbModelo.setEnabled(false);
                txtPesquisaFirmware.setEnabled(false);
                txtPesquisaPatrimonio.setEnabled(false);
                txtPesquisaSn.setEnabled(false);
                cbStatus.setEnabled(false);
                btnLimpaFiltro.setEnabled(false);
                tblEquipamentos.setEnabled(false);

                txtPatrimonio.setEnabled(true);
                rbStatus.setEnabled(true);
                txtObs.setEnabled(true);
                btnEditar.setText("Salvar");
                btnCancelar.setVisible(true);
                break;

            case EquipamentoViewTest.DEFAULT:
                cbModelo.setEnabled(true);
                txtPesquisaFirmware.setEnabled(true);
                txtPesquisaPatrimonio.setEnabled(true);
                txtPesquisaSn.setEnabled(true);
                cbStatus.setEnabled(true);
                btnLimpaFiltro.setEnabled(true);
                tblEquipamentos.setEnabled(true);

                txtModelo.setEnabled(false);
                txtPatrimonio.setEnabled(false);
                txtSn.setEnabled(false);
                txtFirmware.setEnabled(false);
                rbStatus.setEnabled(false);
                txtObs.setEnabled(false);
                btnEditar.setText("Editar");
                btnCancelar.setVisible(false);
                break;
        }
    }

    private void preencherCampos() {
        painelImagemFundo1.setImg(control.getEquipamentoSelecionado().getModelo().getImage());
        painelImagemFundo1.repaint();

        txtModelo.setText(control.getEquipamentoSelecionado().getModelo().getNome());
        txtPatrimonio.setText(control.getEquipamentoSelecionado().getPatrimonio());
        txtSn.setText(control.getEquipamentoSelecionado().getSn());
        txtFirmware.setText(control.getEquipamentoSelecionado().getFirmware());
        txtObs.setText(control.getEquipamentoSelecionado().getObservacao());
        rbStatus.setSelected(control.getEquipamentoSelecionado().isStatus());
        tblHistorico.setModel(control.getHistoricoTableModel());

    }

    public void alimentarComboBoxes() {
        String[] modelos = control.getModelos();
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
        }

        String sn = txtPesquisaSn.getText().trim();
        String firmware = txtPesquisaFirmware.getText().trim();
        String patrimonio = txtPesquisaPatrimonio.getText().trim();
        int status = cbStatus.getSelectedIndex();

        control.buscar(new String[]{sn, modelo, firmware, patrimonio}, status);
        this.tblEquipamentos.setModel(control.getTableModel());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, this.tblEquipamentos.getModel().getRowCount() + " equipamentos Registrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        atualizarGrafico();
    }

    private void atualizarGrafico() {
        String titulo;
        JFreeChart grafico;

        if (cbModelo.getSelectedItem().toString().equals("Todos")) {
            titulo = "Equipamentos Registrados";

            if (btnPatrimonio.isSelected()) {
                titulo = titulo.concat(" (Patrimonio)");
                grafico = control.getGrafico("patrimonio");
            } else if (btnStatus.isSelected()) {
                titulo = titulo.concat(" (Status)");
                grafico = control.getGrafico("status");
            } else {
                grafico = control.getGrafico("contagem");
            }
        } else {

            titulo = cbModelo.getSelectedItem().toString();

            if (btnStatus.isSelected()) {
                titulo = titulo.concat(" - Status");
                grafico = control.getGrafico("status");
            } else if (btnPatrimonio.isSelected()) {
                titulo = titulo.concat(" - Patrimonio");
                grafico = control.getGrafico("patrimonio");

            } else if (btnFirmware.isSelected()) {
                titulo = titulo.concat(" - Firmware");
                grafico = control.getGrafico("firmware");
            } else {
                grafico = control.getGrafico("contagem");
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
        this.tblEquipamentos.setModel(control.getTableModel());

        this.alimentarComboBoxes();
        this.atualizarGrafico();
        btnFirmware.setEnabled(false);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.pack();
    }

}
