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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Controle referente a conexão ao banco de dados
 * 
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class Conexao
{   
    /**
     * Obtem as configuracoes do Banco de dados
     * 
     * @return HashMap HashMap de Configurações
     */
   public static HashMap getConfigBD() throws FileNotFoundException, IOException
   {
        Map         cfg         = new HashMap();
        Properties	prop		= new Properties();
        InputStream input		= null;
        String		show_sql	= new String();
        String		user		= new String();
        String		password	= new String();
        String		server		= new String();
        String		port		= new String();
        String		database	= new String();
        
        //Abre arquivo de configurações
        input = new FileInputStream("config/bd_config.properties");

        //Obtem as informações do arquivo
        prop.load(input);

        //Seta as propriedades
        show_sql    = prop.getProperty("show_sql");
        user        = prop.getProperty("user");
        password    = prop.getProperty("password");
        server      = prop.getProperty("server");
        port        = prop.getProperty("port");
        database    = prop.getProperty("database");

        //Mapeia as propriedades
        cfg.put("show_sql", show_sql);
        cfg.put("user",     user);
        cfg.put("password", password);
        cfg.put("server",   server);
        cfg.put("port",     port);
        cfg.put("database", database);
        cfg.put("url",      "jdbc:mysql://"+server+":"+port+"/"+database);

        input.close();

        return (HashMap)cfg;
    }
   
    /**
     * Obtem as configuracoes do Banco de dados
     * 
     * @return HashMap HashMap de Configurações
     */
   public static HashMap getConfigBDHibernate() throws IOException, FileNotFoundException
   {
       Map cfg          = getConfigBD();
       Map cfgHibernate = new HashMap();
       
       
       String show_sql  = cfg.get("show_sql").toString();
       String user      = cfg.get("user").toString();
       String password  = cfg.get("password").toString();
       String server    = cfg.get("server").toString();
       String port      = cfg.get("port").toString();
       String database  = cfg.get("database").toString();
       String url       = cfg.get("url").toString();
       
       //Mapeia as propriedades
        cfgHibernate.put("hibernate.show_sql",               show_sql);
        cfgHibernate.put("javax.persistence.jdbc.user",      user);
        cfgHibernate.put("javax.persistence.jdbc.password",  password);
        cfgHibernate.put("javax.persistence.jdbc.url",       url);
        
        return (HashMap)cfgHibernate;
   }

   /**
    * Cria uma conexão para usar com relatórios
    * 
    * @return Conection conexão para ser usada em relatórios
    */
   public static Connection getConexaoReport()
   {
        Properties	prop        = new Properties();
        InputStream	input       = null;
        String		user        = new String();
        String		password    = new String();
        String		server      = new String();
        String		port        = new String();
        String		database    = new String();

        try {
            //Abre arquivo de configurações
            input = new FileInputStream("config/bd.config.properties");

            //Obtem as informações do arquivo
            prop.load(input);

            //Seta as propriedades
            user        = prop.getProperty("user");
            password    = prop.getProperty("password");
            server      = prop.getProperty("server");
            port        = prop.getProperty("port");
            database    = prop.getProperty("database");

            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = null;
            conexao = DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database+"",user, password);
            return conexao;
        } 
        catch (FileNotFoundException e) {
           return null;
        } 
        catch (IOException e) {
           return null;
        } 
        catch (ClassNotFoundException e) {
           return null;
        } 
        catch (SQLException e) {
           return null;
        }
    }
}
