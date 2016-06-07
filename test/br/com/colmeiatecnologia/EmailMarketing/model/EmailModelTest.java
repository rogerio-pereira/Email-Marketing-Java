/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class EmailModelTest {
    private static EmailModel email;
    
    @Test
    public void validaEmailVazio()
    {
        email = new EmailModel("");
        
        assertEquals(false, email.validaEmail());
    }

    @Test
    public void validaEmailSemArroba()
    {
        email = new EmailModel("teste");
        
        assertEquals(false, email.validaEmail());
    }

    @Test
    public void validaEmailComArroba()
    {
        email = new EmailModel("teste@");
        
        assertEquals(false, email.validaEmail());
    }

    @Test
    public void validaEmailComDominio()
    {
        email = new EmailModel("teste@teste");
        
        assertEquals(false, email.validaEmail());
    }

    @Test
    public void validaEmailComCategoriaDominio()
    {
        email = new EmailModel("teste@teste.com");
        
        assertEquals(true, email.validaEmail());
    }
    
    @Test
    public void validaEmailComCategoriaDominio2()
    {
        email = new EmailModel("teste@teste.comm");
        
        assertEquals(true, email.validaEmail());
    }
    
    @Test
    public void validaEmailComCategoriaELocalidade()
    {
        email = new EmailModel("teste@teste.com.br");
        
        assertEquals(true, email.validaEmail());
    }
    
    @Test
    public void validaEmailComCategoria2ELocalidade()
    {
        email = new EmailModel("teste@teste.org.brdsa");
        
        assertEquals(true, email.validaEmail());
    }
}