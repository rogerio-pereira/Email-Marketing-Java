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
    private static String email;
    
    public EmailModel(String email)
    {
        this.email = email.trim().toLowerCase();
    }
    
    public static boolean validaEmail()
    {       
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		Matcher m = p.matcher(email); 
        
		if (m.find())
            return true;
		else
            return false;
    }
}
