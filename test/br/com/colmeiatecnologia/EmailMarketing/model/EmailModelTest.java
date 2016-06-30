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
        assertEquals(false, email.validaEmail(""));
    }

    @Test
    public void validaEmailSemArroba()
    {
        assertEquals(false, email.validaEmail("teste"));
    }

    @Test
    public void validaEmailComArroba()
    {
        assertEquals(false, email.validaEmail("teste@"));
    }

    @Test
    public void validaEmailComDominio()
    {
        assertEquals(false, email.validaEmail("teste@teste"));
    }

    @Test
    public void validaEmailComCategoriaDominio()
    {
        assertEquals(true, email.validaEmail("teste@teste.com"));
    }
    
    @Test
    public void validaEmailComCategoriaDominio2()
    {
        assertEquals(true, email.validaEmail("teste@teste.comm"));
    }
    
    @Test
    public void validaEmailComCategoriaELocalidade()
    {
        assertEquals(true, email.validaEmail("teste@teste.com.br"));
    }
    
    @Test
    public void validaEmailComCategoria2ELocalidade()
    {
        assertEquals(true, email.validaEmail("teste@teste.org.brdsa"));
    }
}