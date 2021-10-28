package br.com.planet.view.equipamentos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import br.com.planet.controlers.Controle;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.tablemodel.RemoteAcessTableModel;
import javax.swing.JPanel;
import br.com.planet.src.PainelImagemFundo;
import br.com.planet.view.crud.HistoricoView;
import javax.swing.ImageIcon;

public class EquipamentoView extends javax.swing.JFrame {

    static final int NO_SIGNAL = 0;
    static final int CONNECT = 1;
    static final int UPDATE = 2;
    static final int RESET = 3;

    Controle control;
    int keyConnection;

    Thread chima;
    Thread chimaPing;

    int flagUpdate;
    int flagReset;

    public EquipamentoView() {
        initComponents();
    }

    public EquipamentoView(boolean ppoe) {
        initComponents();
        btnPpoe.setVisible(ppoe);

        txtObservacao.setLineWrap(true); // para quebrar a linha
        txtObservacao.setWrapStyleWord(false);

        controlaTela("init");

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                String message = "";
                int resposta;
                if (flagUpdate == 1) {
                    message = "O equipamento está em processo de atualização, tem certeza que deseja fechar?";
                } else if (flagReset == 1) {
                    message = "O equipamento está em processo de reset, tem certeza que deseja fechar?";
                }

                if (!message.equals("")) {
                    resposta = JOptionPane.showConfirmDialog(null, message);

                    if (resposta == JOptionPane.CANCEL_OPTION || resposta == JOptionPane.NO_OPTION) {
                        return;
                    }
                }

                if (chima != null) {
                    if (chima.isAlive()) {
                        chima.stop();
                    }
                }

                if (chimaPing != null) {
                    if (chimaPing.isAlive()) {
                        chimaPing.stop();
                    }
                }

                if (control != null) {
                    control.close();
                }

                controlaTela("init");
                EquipamentoView.this.dispose();

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        panelInformacoes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdateFirmware = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        panelHistorico = new javax.swing.JPanel();
        lblHistoricoInfo = new javax.swing.JLabel();
        btnHistorico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnPpoe = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPatrimonio = new javax.swing.JTextField();
        cbAtivo = new javax.swing.JCheckBox();
        lblModelo = new javax.swing.JTextField();
        lblFirmware = new javax.swing.JTextField();
        lblSn = new javax.swing.JTextField();
        lblPon = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        barConnection = new javax.swing.JProgressBar();
        btnConectar = new javax.swing.JButton();
        cbAutoConfig = new javax.swing.JCheckBox();
        painelImagemFundo = new br.com.planet.src.PainelImagemFundo();
        cbNavegador = new javax.swing.JCheckBox();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(586, 497));
        setMinimumSize(new java.awt.Dimension(586, 497));
        setResizable(false);

        panelInformacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelInformacoes.setMaximumSize(new java.awt.Dimension(562, 322));
        panelInformacoes.setMinimumSize(new java.awt.Dimension(562, 322));
        panelInformacoes.setPreferredSize(new java.awt.Dimension(562, 322));

        jLabel1.setText("Modelo:");

        jLabel2.setText("Firmware:");

        jLabel3.setText("Serial Number:");

        btnUpdateFirmware.setText("Atualizar Firmware");
        btnUpdateFirmware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFirmwareActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setMaximumSize(new java.awt.Dimension(77, 25));
        btnSalvar.setMinimumSize(new java.awt.Dimension(77, 25));
        btnSalvar.setPreferredSize(new java.awt.Dimension(77, 25));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnReset.setText("Resetar Configurações");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        panelHistorico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Historico"));
        panelHistorico.setMaximumSize(new java.awt.Dimension(212, 296));
        panelHistorico.setMinimumSize(new java.awt.Dimension(212, 296));
        panelHistorico.setPreferredSize(new java.awt.Dimension(212, 296));

        lblHistoricoInfo.setText("X registros desse equipamento.");

        btnHistorico.setText("Ver Histórico Completo");
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        tblHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tblHistorico);

        javax.swing.GroupLayout panelHistoricoLayout = new javax.swing.GroupLayout(panelHistorico);
        panelHistorico.setLayout(panelHistoricoLayout);
        panelHistoricoLayout.setHorizontalGroup(
            panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoricoLayout.createSequentialGroup()
                .addGroup(panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHistoricoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelHistoricoLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblHistoricoInfo))))
                    .addGroup(panelHistoricoLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnHistorico)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHistoricoLayout.setVerticalGroup(
            panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHistoricoInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistorico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Observação:");

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        jLabel5.setText("Pon Status:");

        btnPpoe.setText("PPOE");
        btnPpoe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPpoeActionPerformed(evt);
            }
        });

        jLabel7.setText("Patrimonio:");

        cbAtivo.setText("Ativo");

        lblModelo.setEditable(false);

        lblFirmware.setEditable(false);

        lblSn.setEditable(false);

        lblPon.setEditable(false);

        javax.swing.GroupLayout panelInformacoesLayout = new javax.swing.GroupLayout(panelInformacoes);
        panelInformacoes.setLayout(panelInformacoesLayout);
        panelInformacoesLayout.setHorizontalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacoesLayout.createSequentialGroup()
                        .addComponent(btnUpdateFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPpoe, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbAtivo, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelInformacoesLayout.createSequentialGroup()
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelInformacoesLayout.createSequentialGroup()
                                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFirmware, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelInformacoesLayout.createSequentialGroup()
                                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPatrimonio)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(panelHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelInformacoesLayout.setVerticalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelInformacoesLayout.createSequentialGroup()
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblSn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblPon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset)
                            .addComponent(btnUpdateFirmware))
                        .addGap(18, 18, 18)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPpoe)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMaximumSize(new java.awt.Dimension(447, 95));
        jPanel2.setMinimumSize(new java.awt.Dimension(447, 95));

        btnConectar.setText("Conectar");
        btnConectar.setAlignmentY(0.0F);
        btnConectar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        cbAutoConfig.setText("Configurar Automaticamente");

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

        cbNavegador.setText("Navegador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbAutoConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbNavegador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)))
                        .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbAutoConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbNavegador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConectar)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        controlaTela("init");
        controlaTela("wait");
        new Thread(() -> {
            if (control != null) {
                try {
                    control.close();
                } catch (Exception e) {
                }
            }

            try {
                setControl();
                control.open(cbNavegador.isSelected());
                if (conectar()) {
                    preencherCampos();

                    if (cbAutoConfig.isSelected()) {

                        if (control.needUpdate()) {
                            atualizar();
                        }
                        resetar();
                    }

                    controlaTela("ready");
                    JOptionPane.showMessageDialog(EquipamentoView.this, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();

                controlaBar(EquipamentoView.NO_SIGNAL);
                JOptionPane.showMessageDialog(this, "Erro de conexão: \n \n", "Erro", JOptionPane.WARNING_MESSAGE);
                control.close();
                controlaTela("start");
            }

        }).start();
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        new Thread(() -> {
            try {
                this.btnSalvar.setText("Salvando...");
                controlaTela("wait");
                this.control.getM().setObservacao(txtObservacao.getText());
                this.control.getM().getEquipamento().setPatrimonio(txtPatrimonio.getText());
                this.control.getM().getEquipamento().setStatus(cbAtivo.isSelected());
                control.save();

                JOptionPane.showMessageDialog(this, "Salvo com sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
            } catch (PatrimonioViolationException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao Salvar", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar", "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                controlaTela("start");
                controlaBar(NO_SIGNAL);
                this.btnSalvar.setText("Salvar");
                control.close();
            }

        }).start();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnUpdateFirmwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateFirmwareActionPerformed
        new Thread(() -> {
            try {
                atualizar();
                JOptionPane.showMessageDialog(this, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar", "Atualização", JOptionPane.ERROR_MESSAGE);
                control.close();
            } finally {

            }
        }).start();
    }//GEN-LAST:event_btnUpdateFirmwareActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        new Thread(() -> {
            try {
                resetar();
                JOptionPane.showMessageDialog(this, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao resetar configurações", "Resetar Configurações", JOptionPane.WARNING_MESSAGE);
            }
        }).start();

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        new HistoricoView(this, true, control.getM().getEquipamento().getModelo().getNome(), "", "", control.getM().getEquipamento().getSn(), false).setVisible(true);
    }//GEN-LAST:event_btnHistoricoActionPerformed

    private void btnPpoeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPpoeActionPerformed
        new Thread(() -> {
            controlaTela("wait");
            try {
                this.btnPpoe.setText("Configurando...");
                control.ppoe();
                JOptionPane.showMessageDialog(this, "PPOE configurado com sucesso", "PPOE", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao configurar PPOE", "PPOE", JOptionPane.WARNING_MESSAGE);
            } finally {
                this.btnPpoe.setText("PPOE");
                controlaTela("ready");
                controlaBar(EquipamentoView.CONNECT);
            }

        }).start();
    }//GEN-LAST:event_btnPpoeActionPerformed

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
            new EquipamentoView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barConnection;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnPpoe;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUpdateFirmware;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JCheckBox cbAutoConfig;
    private javax.swing.JCheckBox cbNavegador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblFirmware;
    private javax.swing.JLabel lblHistoricoInfo;
    private javax.swing.JTextField lblModelo;
    private javax.swing.JTextField lblPon;
    private javax.swing.JTextField lblSn;
    private br.com.planet.src.PainelImagemFundo painelImagemFundo;
    private javax.swing.JPanel panelHistorico;
    private javax.swing.JPanel panelInformacoes;
    private javax.swing.JTable tblHistorico;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPatrimonio;
    // End of variables declaration//GEN-END:variables

    boolean conectar() throws Exception {
        try {
            if (control.start()) {
                controlaBar(EquipamentoView.CONNECT);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw (e);
        }
    }

    void controlaTela(String estado) {

        switch (estado) {

            case "wait" -> {
                cbNavegador.setEnabled(false);
                cbAutoConfig.setEnabled(false);
                btnConectar.setEnabled(false);
                btnUpdateFirmware.setEnabled(false);
                btnReset.setEnabled(false);
                btnSalvar.setEnabled(false);
                btnPpoe.setEnabled(false);
                this.tblHistorico.setEnabled(false);
                this.lblHistoricoInfo.setEnabled(false);
                this.btnHistorico.setEnabled(false);
                this.txtObservacao.setEnabled(false);
                this.txtPatrimonio.setEnabled(true);
            }

            case "ready" -> {
                cbNavegador.setEnabled(true);
                cbAutoConfig.setEnabled(true);
                btnConectar.setEnabled(true);
                btnUpdateFirmware.setEnabled(control.needUpdate());
                btnReset.setEnabled(true);
                btnSalvar.setEnabled(true);
                btnPpoe.setEnabled(true);
                txtObservacao.setEnabled(true);
                txtPatrimonio.setEnabled(true);

                if (!this.control.getHistorico().isEmpty()) {
                    this.tblHistorico.setVisible(true);
                    this.lblHistoricoInfo.setVisible(true);
                    this.btnHistorico.setVisible(true);
                    this.panelInformacoes.setVisible(true);
                    this.panelHistorico.setEnabled(true);
                    this.tblHistorico.setEnabled(true);
                    this.lblHistoricoInfo.setEnabled(true);
                    this.btnHistorico.setEnabled(true);
                    this.lblHistoricoInfo.setText(control.getHistorico().size() + " registros desse equipamento");
                }

            }

            case "start" -> {
                cbNavegador.setEnabled(true);
                cbAutoConfig.setEnabled(true);
                btnConectar.setText("Conectar");
                btnConectar.setEnabled(true);
                this.panelInformacoes.setVisible(false);

                this.lblModelo.setText("");
                this.lblFirmware.setText("");
                this.lblPon.setText("");
                this.txtObservacao.setText("");
                this.txtPatrimonio.setText("");

                this.btnPpoe.setEnabled(false);
                this.btnSalvar.setEnabled(false);
                this.btnReset.setEnabled(false);
                this.btnUpdateFirmware.setEnabled(false);
                this.txtObservacao.setEnabled(false);
                this.txtPatrimonio.setEnabled(false);

            }

            case "init" -> {
                this.barConnection.setStringPainted(true);
                this.barConnection.setString("No Signal");
                this.cbAutoConfig.setEnabled(true);

                this.btnConectar.setEnabled(true);
                this.btnConectar.setText("Conectar");
                this.tblHistorico.setVisible(false);
                this.lblHistoricoInfo.setVisible(false);
                this.btnHistorico.setVisible(false);
                this.panelInformacoes.setVisible(false);

                this.lblModelo.setText("");
                this.lblFirmware.setText("");
                this.lblPon.setText("");
                this.txtObservacao.setText("");
                this.txtPatrimonio.setText("");

                this.btnSalvar.setEnabled(false);
                this.btnSalvar.setEnabled(false);
                this.btnReset.setEnabled(false);
                this.btnUpdateFirmware.setEnabled(false);
                this.txtObservacao.setEnabled(false);
                this.txtPatrimonio.setEnabled(false);

                this.keyConnection = 0;
            }
        }
    }

    void controlaBar(int state) {

        switch (state) {

            case 0:
                this.barConnection.setStringPainted(true);
                this.barConnection.setString("Sem sinal");
                this.barConnection.setValue(0);
                break;

            case 1:
                this.barConnection.setString("Conectado");
                this.barConnection.setValue(100);
                break;

            case 2:
                this.barConnection.setString("Atualizando...");
                this.barConnection.setValue(100);
                break;

            case 3:
                this.barConnection.setString("Resetando...");
                this.barConnection.setValue(100);
                break;
        }

    }

    private void carregarTabela() {
        this.tblHistorico.setModel(new RemoteAcessTableModel(control.getHistorico()));
    }

    public PainelImagemFundo getPainelImg() {
        return painelImagemFundo;
    }

    void preencherCampos() {

        lblModelo.setText(control.getM().getEquipamento().getModelo().getNome());
        lblFirmware.setText(control.getM().getEquipamento().getFirmware());
        lblPon.setText(control.getM().getPon());
        lblSn.setText(control.getM().getEquipamento().getSn());
        this.carregarTabela();

        if (!control.getHistorico().isEmpty()) {
            panelHistorico.setVisible(true);
        }

        txtObservacao.setText(control.getM().getObservacao());

        String patrimonio = control.getM().getEquipamento().getPatrimonio();

        if (patrimonio != null) {
            if (!patrimonio.equals("")) {
                txtPatrimonio.setText(patrimonio);
            }
        }

        cbAtivo.setSelected(control.getM().getEquipamento().isStatus());

        this.panelInformacoes.setVisible(true);

        this.btnConectar.setText("Reconectar");

    }

    public JPanel getPanelInformacoes() {
        return panelInformacoes;
    }

    public boolean getCbNavegador() {
        return cbNavegador.isSelected();
    }

    public void setControl() {
    }

    private void atualizar() throws Exception {
        if (this.control.needUpdate()) {
            this.controlaBar(UPDATE);
            this.controlaTela("wait");
            this.flagUpdate = 1;

            try {
                this.btnUpdateFirmware.setText("Atualizando...");
                control.updateFirmware();
                this.preencherCampos();
            } catch (Exception e) {
                throw e;
            } finally {
                this.btnUpdateFirmware.setText("Atualizar Firmware");
                this.controlaBar(CONNECT);
                this.controlaTela("ready");
                this.flagUpdate = 0;
            }
        }
    }

    private void resetar() throws Exception {
        controlaTela("wait");
        controlaBar(EquipamentoView.RESET);
        this.flagReset = 1;

        try {
            this.btnReset.setText("Resetando...");
            control.reset();
            this.preencherCampos();
        } catch (Exception e) {
            throw e;
        } finally {
            this.btnReset.setText("Resetar Configurações");
            controlaTela("ready");
            controlaBar(EquipamentoView.CONNECT);
            flagReset = 0;
        }
    }
}
