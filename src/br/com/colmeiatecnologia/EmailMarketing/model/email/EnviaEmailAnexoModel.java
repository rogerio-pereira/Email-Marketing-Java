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
public class EnviaEmailAnexoModel extends EnviaEmailSimplesModel{    
    public EnviaEmailAnexoModel()
    {
        this.email = new MultiPartEmail();
    }
    
    public void anexar(String caminho, String descricao, String nome) throws EmailException
    {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(caminho);
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(descricao);
        attachment.setName(nome);
        
        MultiPartEmail.class.cast(email).attach(attachment);
    }
}
