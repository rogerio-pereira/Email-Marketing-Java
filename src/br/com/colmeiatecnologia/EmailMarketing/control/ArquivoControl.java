/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ArquivoControl {
    FileReader arquivo;
    BufferedReader lerArquivo;
    
    /**
     * Construtor da class
     * @param nomeArquivo Arquivo a ser aberto
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ArquivoControl(String nomeArquivo) throws FileNotFoundException, IOException
    {
        arquivo     = new FileReader(nomeArquivo);
        lerArquivo  = new BufferedReader(arquivo);
    }
    
    /**
     * Obtem o conteudo do arquivo aberto
     * @return ArrayList<String> contendo cada linha do arquivo
     * @throws IOException 
     */
    public ArrayList<String> getConteudoArquivoTexto() throws IOException
    {
        ArrayList<String> conteudoArquivo = new ArrayList<String>();
        String linha = lerArquivo.readLine();
        
        while (linha != null) {
            conteudoArquivo.add(linha);
 
            linha = lerArquivo.readLine(); // lê da segunda até a última linha
        }
        
        return conteudoArquivo;
    }
}
