/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model.email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class SendAttachmentEmail extends SendMail{
    MultiPartEmail email = new MultiPartEmail();
    
    @Override
    public void setMensagem(String mensagem) throws EmailException
    {
        email.setMsg(mensagem);
    }

    public void adicionaAnexo(String arquivo, String descricao, String nome) throws EmailException
    {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(arquivo); //caminho da imagem
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(descricao);
        attachment.setName(nome);
        
        email.attach(attachment);
    }
}
