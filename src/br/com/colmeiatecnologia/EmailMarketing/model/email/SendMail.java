/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model.email;

import br.com.colmeiatecnologia.EmailMarketing.model.EmailModel;
import java.util.Collection;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public abstract class SendMail {
    private Email                   email;
    private String                  host;
    private String                  usuario;
    private String                  senha;
    private String                  assunto;
    private String                  mensagem;
    private boolean                 ssl;
    private int                     porta;
    private EmailModel              remetente;
    private Collection<EmailModel>  destinatarios;
    
    public void setHost(String host)
    {
        email.setHostName(host);
    }
    
    public void adicionaDestinatario(EmailModel emailModel) throws EmailException
    {
        if(!emailModel.getNome().equals(""))
            email.addTo(emailModel.getEmail(), emailModel.getNome());
        else
            email.addTo(emailModel.getEmail());
    }
    
    public void setRemetente(EmailModel emailModel) throws EmailException
    {
        if(!emailModel.getNome().equals(""))
            email.setFrom(emailModel.getEmail(), emailModel.getNome());
        else
            email.setFrom(emailModel.getEmail());
    }
    
    public void setAssunto(String assunto)
    {
        email.setSubject(assunto);
    }
    
    public void setPorta(int porta)
    {
        email.setSmtpPort(porta);
    }
    
    public void setSSL(boolean ssl)
    {
        email.setSSL(ssl);
    }
    
    public void setAutenticacao(String usuario, String senha)
    {
        email.setAuthentication(usuario, senha);
    }
    
    public String envia() throws EmailException
    {
        return email.send();
    }
    
    public abstract void setMensagem(String mensagem) throws EmailException;
}
