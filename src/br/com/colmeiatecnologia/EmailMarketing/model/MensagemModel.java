/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class MensagemModel {
    private String assunto;
    private String mensagem;
    
    public MensagemModel(String assunto, String mensagem)
    {
        this.assunto = assunto;
        this.mensagem = mensagem;
    }
    
    public String getAssunto()
    {
        return assunto;
    }

    public void setAssunto(String assunto)
    {
        this.assunto = assunto;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }
}
