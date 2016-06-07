/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ArquivoControl {
    File                file;
    
    FileReader          fileReader;
    BufferedReader      lerArquivo;
    LineNumberReader    linhaLeitura;
    
    /**
     * Construtor da class
     * @param nomeArquivo Arquivo a ser aberto
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ArquivoControl(String nomeArquivo) throws FileNotFoundException, IOException
    {
        fileReader      = new FileReader(nomeArquivo);
        file            = new File(nomeArquivo);
        lerArquivo      = new BufferedReader(fileReader);
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
    
    /**
     * Obtém o número de linhas de um arquivo
     * @return Numero de linhas do arquivo
     * @throws IOException 
     */
    public int getNumeroLinhas() throws IOException
    {
        linhaLeitura    = new LineNumberReader(new FileReader(file));
        linhaLeitura.skip(file.length());
        
        return linhaLeitura.getLineNumber();
    }
}
