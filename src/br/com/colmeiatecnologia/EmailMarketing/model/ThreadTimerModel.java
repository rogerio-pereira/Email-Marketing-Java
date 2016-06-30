/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model;

import br.com.colmeiatecnologia.EmailMarketing.view.Principal;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ThreadTimerModel
{
    private Timer timer;
    ArrayList<String> dest;

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
    public ThreadTimerModel(
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
        timer = new Timer();
        timer.scheduleAtFixedRate(new ThreadEnviaEmail  (
                                                            usuario, 
                                                            senha, 
                                                            hostSmtp, 
                                                            assunto, 
                                                            mensagem, 
                                                            porta, 
                                                            maximoEnvio, 
                                                            autenticacao, 
                                                            remetente, 
                                                            destinatarios,
                                                            janelaPrincipal
                                                        ), 0, 3600*1000);
    }
}
