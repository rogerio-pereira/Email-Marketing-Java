/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.colmeiatecnologia.EmailMarketing.model.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class EnviaEmailHtmlModel extends EnviaEmailAnexoModel
{
    public EnviaEmailHtmlModel()
    {
        this.email = new HtmlEmail();
    }

    @Override
    public void setMensagem(String mensagem) throws EmailException
    {
        HtmlEmail.class.cast(email).setHtmlMsg(mensagem);
        HtmlEmail.class.cast(email).setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");
        HtmlEmail.class.cast(email).setCharset("UTF-8");
    }
}
