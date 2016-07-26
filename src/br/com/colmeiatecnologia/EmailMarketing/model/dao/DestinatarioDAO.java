/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model.dao;

import br.com.colmeiatecnologia.EmailMarketing.model.EmailModel;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
@Entity
@Table(name = "destinatarios")
public class DestinatarioDAO extends EmailModel{
    @Id
    @GeneratedValue
    private Long codigo;
    
    public DestinatarioDAO(String email)
    {
        super(email);
    }
    
    public DestinatarioDAO(String email, String nome)
    {
        super(email, nome);
    }
}
