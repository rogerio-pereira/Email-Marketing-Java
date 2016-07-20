/*
 * Copyright (C) 2016 farofa
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.colmeiatecnologia.EmailMarketing.model.bd;

import java.util.List;
import javax.persistence.Query;

/**
 * Controla a persistencia no banco de dados
 * 
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public abstract class Persistencia
{    
    abstract public Long getCodigo();
    
    /**
     * Verifica se é um objeto novo ou uma alteração, então persiste o objeto
     * 
     * @return Status da Transação
     */
    public boolean salvar() throws Exception
    {
        Long codigo = getCodigo();
        
        if(codigo == null)
            return cadastrar();
        else
            return atualizar();
    }
    
    /**
     * Cadastra o objeto no banco de dados
     * 
     * @return Status da Transação
     */
   public boolean cadastrar() throws Exception
   {
        BancoDeDados.getManager().getTransaction().begin();

        BancoDeDados.getManager().persist(this);

        BancoDeDados.getManager().getTransaction().commit();

        return true;
    }
   
   /**
     * Altera o objeto no banco de dados
     * 
     * @return Status da Transação
     */
    public boolean atualizar() throws Exception
    {
        BancoDeDados.getManager().getTransaction().begin();

        BancoDeDados.getManager().merge(this);

        BancoDeDados.getManager().getTransaction().commit();

        return true;
    }
    
    /**
     * Apaga o objeto no banco de dados
     * 
     * @return Status da Transação
     */
    public boolean apagar() throws Exception
    {
	BancoDeDados.getManager().getTransaction().begin();
			
        BancoDeDados.getManager().remove(this);

        BancoDeDados.getManager().getTransaction().commit();

        return true;
    }
    
    /**
     * Lista todos os items
     * 
     * @return Lista de objetos
     */
    public List lista()
    {
        Query   query	= BancoDeDados.getManager().createNamedQuery(this.getClass().getSimpleName()+".findAll");
        List    l	= query.getResultList();

        return l;
    }
    
    /**
     * Busca o item pelo codigo
     * 
     * @param codigo do item a ser buscado
     * @return objeto com o codigo
     */
    public Object buscaPeloCodigo(Long codigo)
    {
        Object o = BancoDeDados.getManager().find(this.getClass(), codigo);
        return o;
    }
}
