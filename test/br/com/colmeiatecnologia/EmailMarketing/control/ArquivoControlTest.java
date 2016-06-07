/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ArquivoControlTest {
    private static FileWriter       fileWriter;
    private static PrintWriter      printWriter;
    private static File             file;
    private        ArquivoControl   controlador;
    
    @BeforeClass
    public static void iniciaClasseTeste() {
        try {
            file        = new File("arquivoTeste.txt");
            fileWriter  = new FileWriter("arquivoTeste.txt");
            printWriter = new PrintWriter(fileWriter);
            
            printWriter.println("Teste");
            printWriter.println("Teste 2");
            
            fileWriter.close();
        }
        catch (IOException ex) {
            System.out.println("Não foi possivel ler o arquivo arquivoTeste.txt");
        }
    }

    @AfterClass
    public static void finalizaClasseTeste() {
        file.delete();
    }
    
    @Before
    public void iniciaTeste() {
        try {
            controlador = new ArquivoControl("arquivoTeste.txt");
        }
        catch (IOException ex) {
            System.out.println("Não foi possivel ler o arquivo arquivoTeste.txt");
        }
    }
    
    @After
    public void finalizaTeste() {
    }
    
    @Test(expected=RuntimeException.class)
    public void testaContrutorArquivoNull()
    {
        try {
            ArquivoControl c = new ArquivoControl(null);
        }
        catch (IOException ex) {
            Logger.getLogger(ArquivoControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test(expected=FileNotFoundException.class)
    public void testaContrutorArquivoVazio() throws FileNotFoundException, IOException
    {
        ArquivoControl c = new ArquivoControl("");
    }
    
    @Test(expected=FileNotFoundException.class)
    public void testaContrutorArquivoNaoExistente() throws FileNotFoundException, IOException
    {
        ArquivoControl c = new ArquivoControl("arquivoTeste2.txt");
    }
    
    @Test
    public void leArquivoTest() throws IOException
    {
        ArrayList<String> linhas    = controlador.getConteudoArquivoTexto();
        String conteudo             = "";
        String conteudoArq          = "TesteTeste 2";
                
        for(String linha: linhas)
            conteudo = conteudo + linha;
        
        assertEquals(conteudoArq, conteudo);
    }
    
    @Test
    public void getNumeroDeLinhasArquivo() throws IOException
    {
        int linhas = controlador.getNumeroLinhas();
        
        assertEquals(linhas, 2);
    }
}