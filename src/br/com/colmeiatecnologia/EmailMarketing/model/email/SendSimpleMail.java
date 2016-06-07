/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model.email;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class SendSimpleMail extends SendMail{
    SimpleEmail email = new SimpleEmail();
    
    @Override
    public void setMensagem(String mensagem) throws EmailException
    {
        email.setMsg(mensagem);
    }
    
}
