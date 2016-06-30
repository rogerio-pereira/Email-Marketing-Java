/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model;

import br.com.colmeiatecnologia.EmailMarketing.model.email.EnviaEmailHtmlModel;
import br.com.colmeiatecnologia.EmailMarketing.view.Estatisticas;
import br.com.colmeiatecnologia.EmailMarketing.view.Principal;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ThreadEnviaEmail extends TimerTask
{
    private String                  usuario;
    private String                  senha;
    private String                  hostSmtp;
    private String                  assunto;
    private String                  mensagem;
    private int                     porta;
    private int                     maximoEnvio;
    private boolean                 autenticacao;
    private EmailModel              remetente;
    private ArrayList<EmailModel>   destinatarios;
    
    private EnviaEmailHtmlModel     email;
    
    private int                     sucessos;
    private int                     falhas;
    private String                  emailsNaoEnviados;
    
    private Estatisticas            estatisticas;
    
    private Principal               janelaPrincipal;
    
    /**
     * Construtor
     * 
     * @param usuario           Usuario do email
     * @param senha             Senha do email
     * @param hostSmtp          Host SMTP
     * @param assunto           Assunto da Mensagem
     * @param mensagem          Mensagem a ser enviada
     * @param porta             Porta SMTP
     * @param maximoEnvio       Número máximo de envios por hora
     * @param autenticacao      Autenticação SSL
     * @param remetente         Remetente do Email
     * @param destinatarios     Lista de Destinatários
     * @param janelaPrincipal   JanelaPrincipal
     */
    public ThreadEnviaEmail (
                                String usuario, 
                                String senha, 
                                String hostSmtp, 
                                String assunto, 
                                String mensagem, 
                                int porta, 
                                int maximoEnvio, 
                                boolean autenticacao, 
                                EmailModel remetente, 
                                ArrayList<EmailModel> destinatarios,
                                Principal janelaPrincipal
                            )
    {
        this.usuario            = usuario;
        this.senha              = senha;
        this.hostSmtp           = hostSmtp;
        this.assunto            = assunto;
        this.mensagem           = mensagem;
        this.porta              = porta;
        this.maximoEnvio        = maximoEnvio;
        this.autenticacao       = autenticacao;
        this.remetente          = remetente;
        this.destinatarios      = destinatarios;
        this.janelaPrincipal    = janelaPrincipal;
        
        this.sucessos           = 0;
        this.falhas             = 0;
        this.emailsNaoEnviados  = "";
        
        estatisticas = new Estatisticas();
        estatisticas.setVisible(true);
        estatisticas.setTotalDestinatarios(destinatarios.size());
        estatisticas.setEmail(remetente.getEmail());
        estatisticas.setAssunto(assunto);
    }
    
    @Override
    public void run() 
    {
        int contadorEnvios = 0;
        
        while(contadorEnvios<=maximoEnvio)
        {
            while(!destinatarios.isEmpty())
            {
                if(contadorEnvios >= maximoEnvio)
                    break;
                
                try {
                    enviaEmail(destinatarios.get(0));
                    this.sucessos++;
                }
                catch (Exception e) {
                    this.falhas++;
                    this.emailsNaoEnviados = emailsNaoEnviados+destinatarios.get(0).getEmail()+"\n";
                }
                
                //Apaga destinatario atual da lista de destinatários
                destinatarios.remove(destinatarios.get(0));
                
                estatisticas.atualizaTela(this.sucessos, this.falhas, this.emailsNaoEnviados);

                contadorEnvios++;
            }

            contadorEnvios++;
        }

        if(destinatarios.isEmpty())
        {
            this.cancel();
            JOptionPane.showMessageDialog(
                                            estatisticas, 
                                            "O envio do email marketing foi finalizado", 
                                            "Finalizado", 
                                            JOptionPane.INFORMATION_MESSAGE
                                        );
            
            if(falhas > 0)
            {
                Object[] options = {"Não", "Sim"};
                int n = JOptionPane.showOptionDialog(
                                                        null,
                                                        "Deseja reenviar os emails que nao foram enviados?",
                                                        "Falha ao enviar alguns emails", 
                                                        JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, 
                                                        null, 
                                                        options, 
                                                        options[1]
                                                    );
                
                //Enviar novamente
                if(n == 1)
                {
                    janelaPrincipal.reenvia(
                                                this.usuario, 
                                                this.senha, 
                                                this.hostSmtp, 
                                                this.assunto, 
                                                this.mensagem, 
                                                this.porta, 
                                                this.maximoEnvio, 
                                                this.autenticacao, 
                                                this.remetente, 
                                                this.emailsNaoEnviados
                                            );
                }
            }
            
            estatisticas.dispose();
        }
    }
    
    /**
     * Envia email para o destinatario
     * @param destinatario Destinatario do email
     */
    public void enviaEmail(EmailModel destinatario) throws EmailException
    {
        email = new EnviaEmailHtmlModel();
        email.setAssunto(assunto);
        email.setAutenticacao(usuario, senha);
        email.setHost(hostSmtp);
        email.setPorta(porta);
        email.setSSL(autenticacao);
        email.setRemetente(remetente);
        email.adicionaDestinatario(new EmailModel(destinatario.getEmail()));
        email.setMensagem(mensagem);
        email.envia();
    }
}
