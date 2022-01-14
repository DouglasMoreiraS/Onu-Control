package br.com.planet.view.equipamentos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import br.com.planet.controlers.Controle;
import br.com.planet.exception.OldFirmwareException;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.model.bean.Modelo;
import br.com.planet.model.tablemodel.RemoteAcessTableModel;
import javax.swing.JPanel;
import br.com.planet.src.PainelImagemFundo;
import br.com.planet.util.TrayIconDemo;
import br.com.planet.view.crud.HistoricoView;
import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class AcessView extends javax.swing.JFrame {

    static final int NO_SIGNAL = 0;
    static final int CONNECT = 1;
    static final int UPDATE = 2;
    static final int RESET = 3;

    Controle control;
    int keyConnection;

    Thread ping;

    int flagUpdate;
    int flagReset;
    int flagConnect;

    public AcessView(Controle control) {

        initComponents();
        this.control = control;
        this.flagConnect = 0;
        this.getPainelImg().setImg(control.getM().getEquipamento().getModelo().getImage()); //Setando a imagem do modelo.
        this.setTitle(control.getM().getEquipamento().getModelo().getNome()); //Setando o nome do modelo no title do jFrame.
        
        if (control.getM().getEquipamento().getModelo().getTipo() == Modelo.ROUTER){
            this.lblPon.setVisible(false);
            this.lblPonStatus.setVisible(false);
        }
            
        
//         Esses dois comandos são para quebrar a linha do txtObservação
        txtObservacao.setLineWrap(true);
        txtObservacao.setWrapStyleWord(false);

        controlaTela("init");
        windowListener();
        conexãoListener();
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
        lblPonStatus = new javax.swing.JLabel();
        btnPpoe = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPatrimonio = new javax.swing.JTextField();
        cbAtivo = new javax.swing.JCheckBox();
        lblModelo = new javax.swing.JTextField();
        lblFirmware = new javax.swing.JTextField();
        lblSn = new javax.swing.JTextField();
        lblPon = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnConectar = new javax.swing.JButton();
        cbNavegador = new javax.swing.JCheckBox();
        painelImagemFundo = new br.com.planet.src.PainelImagemFundo();
        conexaoIcon = new br.com.planet.src.PainelImagemFundo();
        cbAutoUpdate = new javax.swing.JCheckBox();
        cbAutoReset = new javax.swing.JCheckBox();
        cbAutoConnect = new javax.swing.JCheckBox();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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
                .addContainerGap(13, Short.MAX_VALUE))
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

        lblPonStatus.setText("Pon Status:");

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
                                    .addComponent(lblPonStatus))
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
                .addGap(30, 30, 30)
                .addComponent(panelHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelInformacoesLayout.setVerticalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
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
                            .addComponent(lblPonStatus)
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

        cbNavegador.setText("Navegador");

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

        conexaoIcon.setMaximumSize(new java.awt.Dimension(10, 10));
        conexaoIcon.setMinimumSize(new java.awt.Dimension(10, 10));
        conexaoIcon.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout conexaoIconLayout = new javax.swing.GroupLayout(conexaoIcon);
        conexaoIcon.setLayout(conexaoIconLayout);
        conexaoIconLayout.setHorizontalGroup(
            conexaoIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        conexaoIconLayout.setVerticalGroup(
            conexaoIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        cbAutoUpdate.setText("Atualizar automaticamente (Se disponível)");

        cbAutoReset.setText("Resetar automaticamente");

        cbAutoConnect.setText("Conectar Automaticamente (Beta)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbNavegador, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbAutoReset))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(conexaoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(159, 159, 159)
                                        .addComponent(cbAutoConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(86, 86, 86)))
                        .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbAutoUpdate)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbAutoUpdate)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(cbAutoReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbNavegador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(conexaoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConectar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAutoConnect)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                control.open(cbNavegador.isSelected());
                if (conectar()) {
                    preencherCampos();

                    if (cbAutoUpdate.isSelected()) {
                        if (control.needUpdate()) {
                            atualizar();
                        }
                    }

                    if (cbAutoReset.isSelected()) {
                        control.reset();
                    }

                    controlaTela("ready");

                    new TrayIconDemo().displayTray(lblModelo.getText(), "Done", control.getM().getEquipamento().getModelo().getImage().getImage());
                    JOptionPane.showMessageDialog(AcessView.this, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (OldFirmwareException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                control.close();
                controlaTela("start");
            } catch (Exception e) {
                e.printStackTrace();
                int resposta = JOptionPane.showConfirmDialog(this, "Erro na conexão. Tentar novamente?");

                if (resposta == JOptionPane.YES_OPTION) {
                    flagConnect = 0;
                }

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

                controlaTela("start");
                this.btnSalvar.setText("Salvar");
                control.close();

                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(10000);
                            flagConnect = 0;
                        } catch (InterruptedException e) {
                        }
                    }
                }).start();
            } catch (PatrimonioViolationException e) {

                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                this.btnSalvar.setText("Salvar");
                this.controlaTela("ready");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar", "Erro", JOptionPane.ERROR_MESSAGE);

                controlaTela("start");
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
                new TrayIconDemo().displayTray(lblModelo.getText(), "Done", control.getM().getEquipamento().getModelo().getImage().getImage());
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
                new TrayIconDemo().displayTray(lblModelo.getText(), "Done", control.getM().getEquipamento().getModelo().getImage().getImage());
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
            }

        }).start();
    }//GEN-LAST:event_btnPpoeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnPpoe;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUpdateFirmware;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JCheckBox cbAutoConnect;
    private javax.swing.JCheckBox cbAutoReset;
    private javax.swing.JCheckBox cbAutoUpdate;
    private javax.swing.JCheckBox cbNavegador;
    private br.com.planet.src.PainelImagemFundo conexaoIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblFirmware;
    private javax.swing.JLabel lblHistoricoInfo;
    private javax.swing.JTextField lblModelo;
    private javax.swing.JTextField lblPon;
    private javax.swing.JLabel lblPonStatus;
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
                cbAutoReset.setEnabled(false);
                cbAutoUpdate.setEnabled(false);
                cbAutoConnect.setEnabled(false);
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
                cbAutoReset.setEnabled(true);
                cbAutoUpdate.setEnabled(true);
                cbAutoConnect.setEnabled(true);
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
                cbAutoReset.setEnabled(true);
                cbAutoUpdate.setEnabled(true);
                cbAutoConnect.setEnabled(true);
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
                cbAutoReset.setEnabled(true);
                cbAutoUpdate.setEnabled(true);
                cbAutoConnect.setEnabled(true);

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

                this.btnPpoe.setVisible(control.isPpoe());
                System.out.println(control.isPpoe());
                this.btnSalvar.setEnabled(false);
                this.btnSalvar.setEnabled(false);
                this.btnReset.setEnabled(false);
                this.btnUpdateFirmware.setEnabled(false);
                this.txtObservacao.setEnabled(false);
                this.txtPatrimonio.setEnabled(false);

                this.keyConnection = 0;
            }
            
            case "reset" -> {
                this.controlaTela("wait");
                this.btnReset.setText("Resetando...");
            }
            
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
                this.controlaTela("ready");
                this.flagUpdate = 0;
            }
        }
    }

    private void resetar() throws Exception {
        this.btnReset.setText("Resetando...");
        controlaTela("wait");
        this.flagReset = 1;

        try {
            control.reset();
            this.preencherCampos();
        } catch (Exception e) {
            throw e;
        } finally {
            this.btnReset.setText("Resetar Configurações");
            controlaTela("ready");
            flagReset = 0;
        }
    }

    /**
     * Esse windowListener evita que resquicios do driver fiquem ativos na
     * memória (chromedriver.exe e chrome.exe por exemplo)
     *
     */
    void windowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
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

                if (control != null) {
                    control.close();
                }

                ping.interrupt();

                controlaTela("init");
                AcessView.this.dispose();

            }
        });
    }

    private void conexãoListener() {
        ImageIcon connected = new ImageIcon(System.getProperty("user.dir") + "//images//icons//connected.png");
        ImageIcon noConnected = new ImageIcon(System.getProperty("user.dir") + "//images//icons//noconnected.png");
        ImageIcon connecting = new ImageIcon(System.getProperty("user.dir") + "//images//icons//connecting.png");
        try {
            InetAddress adress = InetAddress.getByName(control.getHost());
            ping = new Thread(() -> {
                while (true) {

                    if (Thread.interrupted()) {
                        System.out.println("Interrompida");
                        break;
                    }
                    try {
                        if (adress.isReachable(3000)) {
                            conexaoIcon.setImg(connected);

                            if (cbAutoConnect.isSelected()) {
                                cbAutoConnect.setSelected(false);
                                btnConectarActionPerformed(null);
                            }
                        } else {
                            conexaoIcon.setImg(noConnected);
                        }
                        conexaoIcon.repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(AcessView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            ping.start();

        } catch (UnknownHostException ex) {
            Logger.getLogger(AcessView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
