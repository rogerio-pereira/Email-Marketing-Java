/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model.email;

import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class EnviaEmailSimplesModel extends EnviaEmailModel{
    public EnviaEmailSimplesModel()
    {
        this.email = new SimpleEmail();
    }
}
