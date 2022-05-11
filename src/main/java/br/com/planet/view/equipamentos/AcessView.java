package br.com.planet.view.equipamentos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import br.com.planet.controlers.Controle;
import br.com.planet.exception.OldFirmwareException;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.model.bean.Modelo;
import javax.swing.JPanel;
import br.com.planet.src.PainelImagemFundo;
import br.com.planet.util.TrayIconDemo;
import br.com.planet.view.crud.HistoricoView;
import javax.swing.ImageIcon;

public class AcessView extends javax.swing.JFrame {

    static final int NO_SIGNAL = 0;
    static final int CONNECT = 1;
    static final int UPDATE = 2;
    static final int RESET = 3;

    Controle control;
    int keyConnection;

    Thread ping;
    Thread tConnect;
    Thread tUpdate;
    Thread tReset;
    Thread tPpoe;

    int flagUpdate;
    int flagReset;
    int flagConnect;
    int flagPing;

    public AcessView(Controle control) {

        initComponents();
        this.control = control;
        this.flagConnect = 0;
        this.getPainelImg().setImg(control.getM().getEquipamento().getModelo().getImage()); //Setando a imagem do modelo.
        this.setTitle(control.getM().getEquipamento().getModelo().getNome()); //Setando o nome do modelo no title do jFrame.

        if (control.getM().getEquipamento().getModelo().getTipo() == Modelo.ROUTER) { //Desativando campo PON status para roteadores
            this.lblPon.setVisible(false);
            this.lblPonStatus.setVisible(false);
            this.btnPonRefresh.setVisible(false);
        }

//         Esses dois comandos são para quebrar a linha do txtObservação
        txtObservacao.setLineWrap(true);
        txtObservacao.setWrapStyleWord(false);

        controlaTela("init");
        windowListener();
        conexãoListener();
        ping.start();
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
        btnReset = new javax.swing.JButton();
        panelHistorico = new javax.swing.JPanel();
        lblHistoricoInfo = new javax.swing.JLabel();
        btnHistorico = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblPonStatus = new javax.swing.JLabel();
        btnPpoe = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPatrimonio = new javax.swing.JTextField();
        cbAtivo = new javax.swing.JCheckBox();
        lblModelo = new javax.swing.JTextField();
        lblFirmware = new javax.swing.JTextField();
        lblSn = new javax.swing.JTextField();
        lblPon = new javax.swing.JTextField();
        btnPonRefresh = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEquipamentoObs = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnConectar = new javax.swing.JButton();
        cbNavegador = new javax.swing.JCheckBox();
        painelImagemFundo = new br.com.planet.src.PainelImagemFundo();
        conexaoIcon = new br.com.planet.src.PainelImagemFundo();
        cbAutoUpdate = new javax.swing.JCheckBox();
        cbAutoReset = new javax.swing.JCheckBox();
        cbAutoConnect = new javax.swing.JCheckBox();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(586, 429));
        setMinimumSize(new java.awt.Dimension(586, 429));
        setResizable(false);

        panelInformacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelInformacoes.setMaximumSize(new java.awt.Dimension(573, 297));
        panelInformacoes.setMinimumSize(new java.awt.Dimension(573, 297));
        panelInformacoes.setPreferredSize(new java.awt.Dimension(573, 297));
        panelInformacoes.setRequestFocusEnabled(false);

        jLabel1.setText("Modelo:");
        jLabel1.setMaximumSize(new java.awt.Dimension(78, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(78, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(78, 16));

        jLabel2.setText("Firmware:");
        jLabel2.setMaximumSize(new java.awt.Dimension(78, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(78, 16));
        jLabel2.setPreferredSize(new java.awt.Dimension(78, 16));

        jLabel3.setText("Serial Number:");

        btnUpdateFirmware.setText("Atualizar Firmware");
        btnUpdateFirmware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFirmwareActionPerformed(evt);
            }
        });

        btnReset.setText("Resetar Configurações");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        panelHistorico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Historico"));
        panelHistorico.setMaximumSize(new java.awt.Dimension(254, 290));
        panelHistorico.setMinimumSize(new java.awt.Dimension(254, 290));
        panelHistorico.setPreferredSize(new java.awt.Dimension(254, 290));

        lblHistoricoInfo.setText("X registros desse equipamento.");

        btnHistorico.setText("Ver Histórico Completo");
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        jLabel5.setText("Observação sobre o processo:");

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        txtObservacao.setMaximumSize(new java.awt.Dimension(232, 84));
        txtObservacao.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(txtObservacao);

        btnSalvar.setText("Salvar");
        btnSalvar.setMaximumSize(new java.awt.Dimension(77, 25));
        btnSalvar.setMinimumSize(new java.awt.Dimension(77, 25));
        btnSalvar.setPreferredSize(new java.awt.Dimension(77, 25));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHistoricoLayout = new javax.swing.GroupLayout(panelHistorico);
        panelHistorico.setLayout(panelHistoricoLayout);
        panelHistoricoLayout.setHorizontalGroup(
            panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoricoLayout.createSequentialGroup()
                .addGroup(panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHistoricoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHistorico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHistoricoInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
                    .addGroup(panelHistoricoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelHistoricoLayout.setVerticalGroup(
            panelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHistoricoInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jLabel4.setText("Observação:");
        jLabel4.setMaximumSize(new java.awt.Dimension(78, 16));
        jLabel4.setMinimumSize(new java.awt.Dimension(78, 16));
        jLabel4.setName(""); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(78, 16));

        lblPonStatus.setText("Pon Status:");
        lblPonStatus.setMaximumSize(new java.awt.Dimension(78, 16));
        lblPonStatus.setMinimumSize(new java.awt.Dimension(78, 16));
        lblPonStatus.setPreferredSize(new java.awt.Dimension(78, 16));

        btnPpoe.setText("PPOE");
        btnPpoe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPpoeActionPerformed(evt);
            }
        });

        jLabel7.setText("Patrimonio:");

        txtPatrimonio.setMaximumSize(new java.awt.Dimension(191, 22));
        txtPatrimonio.setMinimumSize(new java.awt.Dimension(191, 22));
        txtPatrimonio.setPreferredSize(new java.awt.Dimension(191, 22));
        txtPatrimonio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPatrimonioKeyTyped(evt);
            }
        });

        cbAtivo.setText("Ativo");

        lblModelo.setEditable(false);
        lblModelo.setMaximumSize(new java.awt.Dimension(191, 22));
        lblModelo.setMinimumSize(new java.awt.Dimension(191, 22));
        lblModelo.setPreferredSize(new java.awt.Dimension(191, 22));

        lblFirmware.setEditable(false);
        lblFirmware.setMaximumSize(new java.awt.Dimension(191, 22));
        lblFirmware.setMinimumSize(new java.awt.Dimension(191, 22));
        lblFirmware.setPreferredSize(new java.awt.Dimension(191, 22));

        lblSn.setEditable(false);
        lblSn.setMaximumSize(new java.awt.Dimension(191, 22));
        lblSn.setMinimumSize(new java.awt.Dimension(191, 22));
        lblSn.setPreferredSize(new java.awt.Dimension(191, 22));

        lblPon.setEditable(false);
        lblPon.setMaximumSize(new java.awt.Dimension(156, 22));
        lblPon.setMinimumSize(new java.awt.Dimension(156, 22));
        lblPon.setPreferredSize(new java.awt.Dimension(156, 22));

        btnPonRefresh.setText("R");
        btnPonRefresh.setToolTipText("Recarregar Status Pon");

        txtEquipamentoObs.setColumns(20);
        txtEquipamentoObs.setRows(5);
        txtEquipamentoObs.setToolTipText("");
        jScrollPane3.setViewportView(txtEquipamentoObs);

        jLabel8.setText("p");

        javax.swing.GroupLayout panelInformacoesLayout = new javax.swing.GroupLayout(panelInformacoes);
        panelInformacoes.setLayout(panelInformacoesLayout);
        panelInformacoesLayout.setHorizontalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPonStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInformacoesLayout.createSequentialGroup()
                                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPatrimonio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFirmware, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
                            .addComponent(lblPon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbAtivo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateFirmware, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(btnPpoe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(panelHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelInformacoesLayout.setVerticalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacoesLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addGap(12, 12, 12)
                                .addComponent(lblPonStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                                .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFirmware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacoesLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdateFirmware)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPpoe))))
                    .addComponent(panelHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMaximumSize(new java.awt.Dimension(573, 114));
        jPanel2.setMinimumSize(new java.awt.Dimension(573, 114));

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
                        .addComponent(conexaoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(cbAutoConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNavegador, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAutoReset)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbAutoUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                                .addComponent(cbAutoConnect)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        controlaTela("init");
        controlaTela("wait");
        btnConectar.setText("Conectando...");
        tConnect = new Thread(() -> {

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
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Erro na conexão. Tentar novamente?");

                    if (resposta == JOptionPane.YES_OPTION) {
                        this.btnConectarActionPerformed(null);
                    } else {
                        control.close();
                        controlaTela("start");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                int resposta = JOptionPane.showConfirmDialog(this, "Erro na conexão. Tentar novamente?");

                if (resposta == JOptionPane.YES_OPTION) {
                    this.btnConectarActionPerformed(null);
                } else {
                    control.close();
                    controlaTela("start");
                }

                //  JOptionPane.showMessageDialog(this, "Erro de conexão: \n \n", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        });
        tConnect.start();
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.btnSalvar.setText("Salvando...");
        controlaTela("wait");

        new Thread(() -> {
            try {
                this.control.getM().setObservacao(txtObservacao.getText());
                this.control.getM().getEquipamento().setPatrimonio(txtPatrimonio.getText());
                this.control.getM().getEquipamento().setStatus(cbAtivo.isSelected());
                this.control.getM().getEquipamento().setObservacao(txtEquipamentoObs.getText());
                control.save();
                control.close();

                this.btnSalvar.setText("Salvar");
                controlaTela("start");
                JOptionPane.showMessageDialog(this, "Salvo com sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);

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
        tUpdate = new Thread(() -> {
            try {
                atualizar();
                JOptionPane.showMessageDialog(this, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                new TrayIconDemo().displayTray(lblModelo.getText(), "Done", control.getM().getEquipamento().getModelo().getImage().getImage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar", "Atualização", JOptionPane.ERROR_MESSAGE);
                control.close();
            } finally {

            }
        });
        tUpdate.start();
    }//GEN-LAST:event_btnUpdateFirmwareActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        tReset = new Thread(() -> {
            try {
                resetar();
                JOptionPane.showMessageDialog(this, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                new TrayIconDemo().displayTray(lblModelo.getText(), "Done", control.getM().getEquipamento().getModelo().getImage().getImage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao resetar configurações", "Resetar Configurações", JOptionPane.WARNING_MESSAGE);
            }
        });
        tReset.start();

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        new HistoricoView(this, true, control.getM().getEquipamento().getModelo().getNome(), "", "", control.getM().getEquipamento().getSn(), false).setVisible(true);
    }//GEN-LAST:event_btnHistoricoActionPerformed

    private void btnPpoeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPpoeActionPerformed
        tPpoe = new Thread(() -> {
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

        });
        tPpoe.start();
    }//GEN-LAST:event_btnPpoeActionPerformed

    private void txtPatrimonioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatrimonioKeyTyped
        String numbers = "0123456789";
        if (!numbers.contains(evt.getKeyChar() + "")){
            evt.consume();
        }
    }//GEN-LAST:event_txtPatrimonioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnPonRefresh;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lblFirmware;
    private javax.swing.JLabel lblHistoricoInfo;
    private javax.swing.JTextField lblModelo;
    private javax.swing.JTextField lblPon;
    private javax.swing.JLabel lblPonStatus;
    private javax.swing.JTextField lblSn;
    private br.com.planet.src.PainelImagemFundo painelImagemFundo;
    private javax.swing.JPanel panelHistorico;
    private javax.swing.JPanel panelInformacoes;
    private javax.swing.JTextArea txtEquipamentoObs;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPatrimonio;
    // End of variables declaration//GEN-END:variables

    boolean conectar() throws Exception {
        try {
            if (control.start()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw e;
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
                btnPonRefresh.setEnabled(false);
                btnReset.setEnabled(false);
                btnSalvar.setEnabled(false);
                btnPpoe.setEnabled(false);

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
                btnPonRefresh.setEnabled(true);
                btnSalvar.setEnabled(true);
                btnPpoe.setEnabled(true);
                txtObservacao.setEnabled(true);
                txtPatrimonio.setEnabled(true);

                this.txtEquipamentoObs.setVisible(true);
                this.txtEquipamentoObs.setEnabled(true);

                if (!this.control.getHistorico().isEmpty()) {
                    this.lblHistoricoInfo.setVisible(true);
                    this.btnHistorico.setVisible(true);
                    this.btnHistorico.setEnabled(true);
                }

            }

            case "start" -> {
                cbNavegador.setEnabled(true);
                cbAutoReset.setEnabled(true);
                cbAutoUpdate.setEnabled(true);
                cbAutoConnect.setEnabled(true);
                btnPonRefresh.setEnabled(true);
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
                cbNavegador.setEnabled(true);
                cbAutoReset.setEnabled(true);
                cbAutoUpdate.setEnabled(true);
                cbAutoConnect.setEnabled(true);

                this.btnConectar.setEnabled(true);
                this.btnConectar.setText("Conectar");
                this.btnPonRefresh.setEnabled(false);
                this.lblHistoricoInfo.setVisible(false);
                this.btnHistorico.setVisible(false);
                this.panelInformacoes.setVisible(false);

                this.lblModelo.setText("");
                this.lblFirmware.setText("");
                this.lblPon.setText("");
                this.txtObservacao.setText("");
                this.txtPatrimonio.setText("");

                this.btnPpoe.setVisible(control.isPpoe());
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

    public PainelImagemFundo getPainelImg() {
        return painelImagemFundo;
    }

    void preencherCampos() {

        lblModelo.setText(control.getM().getEquipamento().getModelo().getNome());
        lblFirmware.setText(control.getM().getEquipamento().getFirmware());
        lblPon.setText(control.getM().getPon());
        lblSn.setText(control.getM().getEquipamento().getSn());

        if (!control.getHistorico().isEmpty()) {
            this.lblHistoricoInfo.setText(control.getHistorico().size() + " registros desse equipamento");
        }

        txtObservacao.setText(control.getM().getObservacao());
        System.out.println(control.getM().getEquipamento().getObservacao());
        txtEquipamentoObs.setText(control.getM().getEquipamento().getObservacao());

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
     */
    void windowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(() -> {
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

                    ping.suspend();

                    controlaTela("init");
                    AcessView.this.dispose();
                }).start();
            }
        });
    }

    private void conexãoListener() {

        flagPing = 1;

        ImageIcon connected = new ImageIcon(System.getProperty("user.dir") + "//images//icons//connected.png");
        ImageIcon noConnected = new ImageIcon(System.getProperty("user.dir") + "//images//icons//noconnected.png");
        ImageIcon connecting = new ImageIcon(System.getProperty("user.dir") + "//images//icons//connecting.png");

        conexaoIcon.setImg(connecting);

        ping = new Thread(() -> {
            while (flagPing == 1) {
                if (control.pingar()) {
                    conexaoIcon.setImg(connected);
                    if (cbAutoConnect.isSelected()) {
                        cbAutoConnect.setSelected(false);
                        btnConectarActionPerformed(null);
                    }
                } else {
                    conexaoIcon.setImg(connecting);
                }
                conexaoIcon.repaint();
            }
            ping.suspend();
        });
    }

    @Override
    public void setVisible(boolean condition) {
        if (condition == true) {
            flagPing = 1;
            ping.resume();
        } else {
            flagPing = 0;
        }
        super.setVisible(condition);

    }

}
