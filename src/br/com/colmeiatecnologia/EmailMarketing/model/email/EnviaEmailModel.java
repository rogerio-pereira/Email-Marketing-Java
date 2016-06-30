/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model.email;

import br.com.colmeiatecnologia.EmailMarketing.model.EmailModel;
import java.util.ArrayList;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class EnviaEmailModel{
    protected static Email email;
    
    public void setHost(String host)
    {
        email.setHostName(host);
    }
    
    public void setPorta(int porta)
    {
        email.setSmtpPort(porta);
    }
    
    public void setAssunto(String assunto)
    {
        email.setSubject(assunto);
    }
    
    public void setSSL(boolean ssl)
    {
        email.setSSL(ssl);
    }
    
    public void setAutenticacao(String usuario, String senha)
    {
        email.setAuthentication(usuario, senha);
    }
    
    public void setMensagem(String mensagem) throws EmailException
    {
        email.setMsg(mensagem);
    }
    
    public void setRemetente(EmailModel remetente) throws EmailException
    {
        if(remetente.getNome() == null || remetente.getNome() == "" || remetente.getNome().isEmpty())
            email.setFrom(remetente.getEmail());
        else
            email.setFrom(remetente.getEmail(), remetente.getNome());
        
        email.addReplyTo("no-reply@"+remetente.getEmail().split("@")[1]);
    }
    
    public void adicionaDestinatario(EmailModel destinatario) throws EmailException
    {        
        if(destinatario.getNome() == null || destinatario.getNome() == "" || destinatario.getNome().isEmpty())
            email.addTo(destinatario.getEmail());
        else
            email.addTo(destinatario.getEmail(), destinatario.getNome());
    }
    
    public String envia() throws EmailException
    {
        return email.send();
    }
}
