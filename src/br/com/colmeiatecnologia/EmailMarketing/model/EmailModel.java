/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class EmailModel {
    private String email;
    private String nome;
    
    public EmailModel(String email)
    {
        this.email = email.trim().toLowerCase();
    }
    
    public EmailModel(String email, String nome)
    {
        this.email  = email.trim().toLowerCase();
        this.nome   = nome;
    }
    public String getEmail()
    {
        return email;
    }

    public String getNome()
    {
        return nome;
    }
    
    public static boolean validaEmail(String em)
    {       
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		Matcher m = p.matcher(em); 
        
		if (m.find())
            return true;
		else
            return false;
    }
}
