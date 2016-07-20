/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model;

import br.com.colmeiatecnologia.EmailMarketing.model.dao.RemetenteDAO;
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
    private RemetenteDAO        remetente;
    private MensagemModel       mensagem;
    
    private EnviaEmailHtmlModel email;
    
    private int                 sucessos;
    private int                 falhas;
    private String              emailsNaoEnviados;
    
    private Estatisticas        estatisticas;
    
    private Principal           janelaPrincipal;
    
    /**
     * Construtor
     * @param remetente
     * @param mensagem
     * @param janelaPrincipal 
     */
    public ThreadEnviaEmail (
                                RemetenteDAO remetente,
                                MensagemModel mensagem,
                                Principal janelaPrincipal
                            )
    {
        this.remetente          = remetente;
        this.mensagem           = mensagem;
        this.janelaPrincipal    = janelaPrincipal;
        
        this.sucessos           = 0;
        this.falhas             = 0;
        this.emailsNaoEnviados  = "";
        
        estatisticas = new Estatisticas();
        estatisticas.setVisible(true);
        estatisticas.setTotalDestinatarios(remetente.getDestinatarios().size());
        estatisticas.setEmail(remetente.getRemetente().getEmail());
        estatisticas.setAssunto(mensagem.getAssunto());
    }
    
    @Override
    public void run() 
    {
        int contadorEnvios = 0;
        
        while(contadorEnvios <= remetente.getMaximoEnvio())
        {
            while(!remetente.getDestinatarios().isEmpty())
            {
                if(contadorEnvios >= remetente.getMaximoEnvio())
                    break;
                
                EmailModel remetenteAtual = (EmailModel)remetente.getDestinatarios().toArray()[0];
                
                try {
                    enviaEmail(remetenteAtual);
                    this.sucessos++;
                }
                catch (Exception e) {
                    this.falhas++;
                    this.emailsNaoEnviados = emailsNaoEnviados+remetenteAtual.getEmail()+"\n";
                }
                
                //Apaga destinatario atual da lista de destinatários
                remetente.getDestinatarios().remove(remetente.getDestinatarios().toArray()[0]);
                
                estatisticas.atualizaTela(this.sucessos, this.falhas, this.emailsNaoEnviados);

                contadorEnvios++;
            }

            contadorEnvios++;
        }

        if(remetente.getDestinatarios().isEmpty())
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
                                                this.remetente, 
                                                this.mensagem, 
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
        email.setAssunto(mensagem.getAssunto());
        email.setAutenticacao(remetente.getUsuario(), remetente.getSenha());
        email.setHost(remetente.getHostSmtp());
        email.setPorta(remetente.getPortaSmtp());
        email.setSSL(remetente.getAutenticacao());
        email.setRemetente(remetente.getRemetente());
        email.adicionaDestinatario(new EmailModel(destinatario.getEmail()));
        email.setMensagem(mensagem.getMensagem());
        email.envia();
    }
}
