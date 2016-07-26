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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Controla operações relativas ao banco de dados
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class BancoDeDados {
    private static EntityManagerFactory    factory;
    private static EntityManager           manager;

    /**
     * Retorna o Entity Manager criado
     * @return Entity Manager criado
     */
    public static EntityManager getManager()
    {
        return manager;
    }
    
    /**
	 * Cria o banco de dados se nao existir
     * @throws java.sql.SQLException
     * @throws ExceptionInInitializerError
	 */
	public static void iniciaBanco() throws SQLException, ExceptionInInitializerError, IOException, FileNotFoundException
	{
        criaTabelas();
        carregaBanco();
	}
    
    private static void criaTabelas() throws SQLException, IOException, FileNotFoundException
    {
        HashMap config  = Conexao.getConfigBD();
        String user		= config.get("user").toString();
        String password	= config.get("password").toString();
        String server	= config.get("server").toString();
        String port		= config.get("port").toString();
        String database	= config.get("database").toString();

        Connection  conexao = DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/",user,password);
        Statement   stmt    = conexao.createStatement();

        String query = "CREATE DATABASE IF NOT EXISTS "+database+";";
        stmt.executeUpdate(query);

        conexao.close();
    }
    
    private static void carregaBanco() throws ExceptionInInitializerError, IOException, FileNotFoundException
    {
        factory = Persistence.createEntityManagerFactory("emailmarketing", Conexao.getConfigBDHibernate());
        manager = factory.createEntityManager();
    }
}
