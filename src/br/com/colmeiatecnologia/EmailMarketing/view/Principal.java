/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.view;


import br.com.colmeiatecnologia.EmailMarketing.control.ArquivoControl;
import br.com.colmeiatecnologia.EmailMarketing.control.view.TextAreaControl;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class Principal extends javax.swing.JFrame {

    /** Creates new form JanelaPrincipal */
    public Principal() {
        initComponents();
        addKeyAndContainerListenerRecursively(this);
        this.setLocationRelativeTo(null);
    }

    //BOTAO ESC E ENTER
    //LISTENERS DO FRAME
    //KEYLISTENER RECURSIVO (COLOCA EM TODOS OS COMPONENTES)
    private void addKeyAndContainerListenerRecursively(Component c) 
    {  
        try 
        {  
            c.addKeyListener((KeyListener) this);  
            if (c instanceof Container) 
            {  
                Container cont = (Container) c;  
                cont.addContainerListener((ContainerListener) this);  
                Component[] children = cont.getComponents();  
                for (int i = 0; i < children.length; i++) 
                {  
                    addKeyAndContainerListenerRecursively(children[i]);  
                }  
            }  
        } catch (Exception e) {  
            //Anuncie Aqui  
        }  
    }  
    
    //EVENTOS KEYLISTENER
    public void keyTyped(KeyEvent e) {}  
    public void keyReleased(KeyEvent e) {}  
    public void componentAdded(ContainerEvent e) {}  
    public void componentRemoved(ContainerEvent e) {}  
    public void keyPressed(KeyEvent e) 
    {
        //TECLA ESC
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buscaArquivo = new javax.swing.JFileChooser();
        painelDadosRemetente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoNomeRemetente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoEmailEnvio = new javax.swing.JTextField();
        painelConfiguracoesEmail = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textoHostSmtp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textoSenha = new javax.swing.JTextField();
        textoPorta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textoMaximoEnvio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textoAssunto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JScrollPane1 = new javax.swing.JScrollPane();
        textoMensagem = new javax.swing.JTextArea();
        botaoProcurarMensagem = new javax.swing.JButton();
        painelDestinatarios = new javax.swing.JPanel();
        botaoProcurarDestinatarios = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoDestinatarios = new javax.swing.JTextArea();
        painelEstatísticas = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textoTotalDestinatarios = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textoTotalSucesso = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textoTotalErros = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoEmailsComErro = new javax.swing.JTextArea();
        botaoIniciarEnvio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Email Marketing");

        painelDadosRemetente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Envio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Nome");

        textoNomeRemetente.setPreferredSize(new java.awt.Dimension(14, 32));

        jLabel2.setText("E-mail Envio");

        textoEmailEnvio.setPreferredSize(new java.awt.Dimension(80, 32));

        painelConfiguracoesEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configurações Envio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel3.setText("Host SMTP:");

        textoHostSmtp.setPreferredSize(new java.awt.Dimension(80, 32));

        jLabel4.setText("Porta");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Autenticação SSL");

        jLabel5.setText("Usuário");

        textoUsuario.setPreferredSize(new java.awt.Dimension(80, 32));

        jLabel6.setText("Senha");

        textoSenha.setPreferredSize(new java.awt.Dimension(80, 32));

        textoPorta.setMinimumSize(new java.awt.Dimension(14, 32));
        textoPorta.setName(""); // NOI18N
        textoPorta.setPreferredSize(new java.awt.Dimension(14, 32));

        jLabel13.setText("Máximo Envios");

        textoMaximoEnvio.setPreferredSize(new java.awt.Dimension(14, 32));

        javax.swing.GroupLayout painelConfiguracoesEmailLayout = new javax.swing.GroupLayout(painelConfiguracoesEmail);
        painelConfiguracoesEmail.setLayout(painelConfiguracoesEmailLayout);
        painelConfiguracoesEmailLayout.setHorizontalGroup(
            painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConfiguracoesEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelConfiguracoesEmailLayout.createSequentialGroup()
                        .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoPorta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoHostSmtp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(textoSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelConfiguracoesEmailLayout.createSequentialGroup()
                        .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(painelConfiguracoesEmailLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoMaximoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelConfiguracoesEmailLayout.setVerticalGroup(
            painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConfiguracoesEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoHostSmtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConfiguracoesEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textoMaximoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Assunto");

        textoAssunto.setPreferredSize(new java.awt.Dimension(80, 32));

        jLabel8.setText("Mensagem");

        textoMensagem.setColumns(20);
        textoMensagem.setLineWrap(true);
        textoMensagem.setWrapStyleWord(true);
        JScrollPane1.setViewportView(textoMensagem);

        botaoProcurarMensagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/colmeiatecnologia/EmailMarketing/view/img/zoom.png"))); // NOI18N
        botaoProcurarMensagem.setText("Procurar");
        botaoProcurarMensagem.setPreferredSize(new java.awt.Dimension(150, 32));
        botaoProcurarMensagem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoProcurarMensagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosRemetenteLayout = new javax.swing.GroupLayout(painelDadosRemetente);
        painelDadosRemetente.setLayout(painelDadosRemetenteLayout);
        painelDadosRemetenteLayout.setHorizontalGroup(
            painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosRemetenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosRemetenteLayout.createSequentialGroup()
                        .addComponent(JScrollPane1)
                        .addContainerGap())
                    .addGroup(painelDadosRemetenteLayout.createSequentialGroup()
                        .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelConfiguracoesEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelDadosRemetenteLayout.createSequentialGroup()
                                .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textoEmailEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(textoNomeRemetente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosRemetenteLayout.createSequentialGroup()
                        .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoProcurarMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))))
        );
        painelDadosRemetenteLayout.setVerticalGroup(
            painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosRemetenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNomeRemetente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoEmailEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelConfiguracoesEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosRemetenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(botaoProcurarMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane1))
        );

        painelDestinatarios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destinatários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        botaoProcurarDestinatarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/colmeiatecnologia/EmailMarketing/view/img/zoom.png"))); // NOI18N
        botaoProcurarDestinatarios.setText("Procurar");
        botaoProcurarDestinatarios.setPreferredSize(new java.awt.Dimension(150, 32));
        botaoProcurarDestinatarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoProcurarDestinatariosActionPerformed(evt);
            }
        });

        textoDestinatarios.setColumns(20);
        textoDestinatarios.setLineWrap(true);
        textoDestinatarios.setWrapStyleWord(true);
        jScrollPane2.setViewportView(textoDestinatarios);

        javax.swing.GroupLayout painelDestinatariosLayout = new javax.swing.GroupLayout(painelDestinatarios);
        painelDestinatarios.setLayout(painelDestinatariosLayout);
        painelDestinatariosLayout.setHorizontalGroup(
            painelDestinatariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDestinatariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDestinatariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDestinatariosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoProcurarDestinatarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        painelDestinatariosLayout.setVerticalGroup(
            painelDestinatariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDestinatariosLayout.createSequentialGroup()
                .addComponent(botaoProcurarDestinatarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelEstatísticas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estatisticas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel9.setText("Destinatários");

        textoTotalDestinatarios.setEditable(false);
        textoTotalDestinatarios.setFocusable(false);
        textoTotalDestinatarios.setPreferredSize(new java.awt.Dimension(14, 32));

        jLabel10.setText("Sucesso");

        textoTotalSucesso.setEditable(false);
        textoTotalSucesso.setFocusable(false);
        textoTotalSucesso.setPreferredSize(new java.awt.Dimension(80, 32));

        jLabel11.setText("Erro");

        textoTotalErros.setEditable(false);
        textoTotalErros.setFocusable(false);
        textoTotalErros.setPreferredSize(new java.awt.Dimension(14, 32));

        jLabel12.setText("E-mails com erro");

        textoEmailsComErro.setColumns(20);
        textoEmailsComErro.setLineWrap(true);
        textoEmailsComErro.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textoEmailsComErro);

        botaoIniciarEnvio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/colmeiatecnologia/EmailMarketing/view/img/dialog-accept.png"))); // NOI18N
        botaoIniciarEnvio.setText("Iniciar Envio");
        botaoIniciarEnvio.setPreferredSize(new java.awt.Dimension(150, 32));

        javax.swing.GroupLayout painelEstatísticasLayout = new javax.swing.GroupLayout(painelEstatísticas);
        painelEstatísticas.setLayout(painelEstatísticasLayout);
        painelEstatísticasLayout.setHorizontalGroup(
            painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEstatísticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(painelEstatísticasLayout.createSequentialGroup()
                        .addGroup(painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoTotalDestinatarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoTotalSucesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoTotalErros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelEstatísticasLayout.createSequentialGroup()
                        .addGroup(painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEstatísticasLayout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(botaoIniciarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelEstatísticasLayout.setVerticalGroup(
            painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEstatísticasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoIniciarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textoTotalDestinatarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textoTotalSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEstatísticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textoTotalErros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDadosRemetente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDestinatarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelEstatísticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDadosRemetente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelDestinatarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelEstatísticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoProcurarDestinatariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoProcurarDestinatariosActionPerformed
    {//GEN-HEADEREND:event_botaoProcurarDestinatariosActionPerformed
        conteudoArquivo = new ArrayList<String>();
        conteudoArquivo = buscaArquivo(txtFilter);
        TextAreaControl.insereConteudo(textoDestinatarios, conteudoArquivo);
        textoTotalDestinatarios.setText(String.valueOf(textoDestinatarios.getLineCount()));
    }//GEN-LAST:event_botaoProcurarDestinatariosActionPerformed

    private void botaoProcurarMensagemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoProcurarMensagemActionPerformed
    {//GEN-HEADEREND:event_botaoProcurarMensagemActionPerformed
        conteudoArquivo = new ArrayList<String>();
        conteudoArquivo = buscaArquivo(htmlFilter);
        TextAreaControl.insereConteudo(textoMensagem, conteudoArquivo);
    }//GEN-LAST:event_botaoProcurarMensagemActionPerformed

    /**
     * Le os dados do arquivo
     * @param filtro
     * @return ArrayList<String> contendo cada linha do arquivo
     */
    private ArrayList<String> buscaArquivo(FileNameExtensionFilter filtro)
    {
        try {
            buscaArquivo.setVisible(true);
            buscaArquivo.setFileFilter(filtro);

            int result = buscaArquivo.showOpenDialog(null); 

            if(result == JFileChooser.OPEN_DIALOG)
                return new ArquivoControl(buscaArquivo.getSelectedFile().toString()).getConteudoArquivoTexto();
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(  
                                            this, 
                                            "Arquivo não encontrado"+
                                            "\nErro: "+e.getMessage()+
                                            "\nCausa: "+e.getCause(), 
                                            "Erro!", 
                                            JOptionPane.ERROR_MESSAGE
                                        );
            return null;
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(  
                                            this, 
                                            "Erro ao ler o arquivo"+
                                            "\nErro: "+e.getMessage()+
                                            "\nCausa: "+e.getCause(), 
                                            "Erro!", 
                                            JOptionPane.ERROR_MESSAGE
                                        );
            return null;
        }
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane1;
    private javax.swing.JButton botaoIniciarEnvio;
    private javax.swing.JButton botaoProcurarDestinatarios;
    private javax.swing.JButton botaoProcurarMensagem;
    private javax.swing.JFileChooser buscaArquivo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelConfiguracoesEmail;
    private javax.swing.JPanel painelDadosRemetente;
    private javax.swing.JPanel painelDestinatarios;
    private javax.swing.JPanel painelEstatísticas;
    private javax.swing.JTextField textoAssunto;
    private javax.swing.JTextArea textoDestinatarios;
    private javax.swing.JTextField textoEmailEnvio;
    private javax.swing.JTextArea textoEmailsComErro;
    private javax.swing.JTextField textoHostSmtp;
    private javax.swing.JTextField textoMaximoEnvio;
    private javax.swing.JTextArea textoMensagem;
    private javax.swing.JTextField textoNomeRemetente;
    private javax.swing.JTextField textoPorta;
    private javax.swing.JTextField textoSenha;
    private javax.swing.JTextField textoTotalDestinatarios;
    private javax.swing.JTextField textoTotalErros;
    private javax.swing.JTextField textoTotalSucesso;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
    FileNameExtensionFilter txtFilter   = new FileNameExtensionFilter("TXT Files (*.txt)", "txt");
    FileNameExtensionFilter htmlFilter  = new FileNameExtensionFilter("HTML Files (*.html)", "html");
    
    ArrayList<String> conteudoArquivo;
}
