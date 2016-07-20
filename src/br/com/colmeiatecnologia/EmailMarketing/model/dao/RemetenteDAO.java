/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model.dao;

import br.com.colmeiatecnologia.EmailMarketing.model.EmailModel;
import br.com.colmeiatecnologia.EmailMarketing.model.bd.Persistencia;
import java.util.Collection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class RemetenteDAO extends Persistencia {
    @Id
    @GeneratedValue
    private Long codigo;
    
    private EmailModel remetente;
    
    private String usuario;
    
    private String senha;
    
    private String hostSmtp;
    
    private int portaSmtp;
    
    private int maximoEnvio;
    
    private boolean autenticacao;
    
    @OneToMany
    private Collection<EmailModel> destinatarios;
    
    /**
     * Método Construtor
     */
    public RemetenteDAO()
    {
    }
    
    /**
     * Método Contrutor
     * @param remetente     Email de envio, Nome de Exibição
     * @param usuario       Usuário de Email
     * @param senha         Senha do email
     * @param hostSmtp      Host SMTP
     * @param portaSmtp     Porta SMTP
     * @param maximoEnvio   Maximo de Envios por hora
     * @param autenticacao  Autenticação de Segurança
     */
    public RemetenteDAO(EmailModel remetente, String usuario, String senha, String hostSmtp, int portaSmtp, int maximoEnvio, boolean autenticacao)
    {
        this.remetente = remetente;
        this.usuario = usuario;
        this.senha = senha;
        this.hostSmtp = hostSmtp;
        this.portaSmtp = portaSmtp;
        this.maximoEnvio = maximoEnvio;
        this.autenticacao = autenticacao;
    }
    
    /**
     * Método Contrutor
     * @param remetente     Email de envio, Nome de Exibição
     * @param usuario       Usuário de Email
     * @param senha         Senha do email
     * @param hostSmtp      Host SMTP
     * @param portaSmtp     Porta SMTP
     * @param maximoEnvio   Maximo de Envios por hora
     * @param autenticacao  Autenticação de Segurança
     * @param destinatarios Destinatarios de Email
     */
    public RemetenteDAO(EmailModel remetente, String usuario, String senha, String hostSmtp, int portaSmtp, int maximoEnvio, boolean autenticacao, Collection<EmailModel> destinatarios)
    {
        this.remetente = remetente;
        this.usuario = usuario;
        this.senha = senha;
        this.hostSmtp = hostSmtp;
        this.portaSmtp = portaSmtp;
        this.maximoEnvio = maximoEnvio;
        this.autenticacao = autenticacao;
        this.destinatarios = destinatarios;
    }
    
    
    
    @Override
    public Long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }

    public EmailModel getRemetente()
    {
        return remetente;
    }

    public void setRemetente(EmailModel remetente)
    {
        this.remetente = remetente;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getHostSmtp()
    {
        return hostSmtp;
    }

    public void setHostSmtp(String hostSmtp)
    {
        this.hostSmtp = hostSmtp;
    }

    public int getPortaSmtp()
    {
        return portaSmtp;
    }

    public void setPortaSmtp(int portaSmtp)
    {
        this.portaSmtp = portaSmtp;
    }

    public int getMaximoEnvio()
    {
        return maximoEnvio;
    }

    public void setMaximoEnvio(int maximoEnvio)
    {
        this.maximoEnvio = maximoEnvio;
    }

    public boolean getAutenticacao()
    {
        return autenticacao;
    }

    public void setAutenticacao(boolean autenticacao)
    {
        this.autenticacao = autenticacao;
    }
    public Collection<EmailModel> getDestinatarios()
    {
        return destinatarios;
    }

    public void setDestinatarios(Collection<EmailModel> destinatarios)
    {
        this.destinatarios = destinatarios;
    }
}
