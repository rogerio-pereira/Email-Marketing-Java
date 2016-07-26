/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.colmeiatecnologia.EmailMarketing;

import br.com.colmeiatecnologia.EmailMarketing.control.view.ControladorLookAndFeel;
import br.com.colmeiatecnologia.EmailMarketing.model.bd.BancoDeDados;
import br.com.colmeiatecnologia.EmailMarketing.view.Principal;
import br.com.colmeiatecnologia.EmailMarketing.view.Splash;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rogerio Eduardo Pereira
 */
public class EmailMarketing
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ControladorLookAndFeel.setLookAndFeel();
        
        Splash splash = new Splash();
        splash.setVisible(true);
        splash.ativaProgressBar(true);
        
        try 
        {   
            BancoDeDados.iniciaBanco();
            new Principal().setVisible(true);
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(  
                                            null, 
                                            "Arquivo e configurações não encontrado"+
                                            "\nErro: "+e.getMessage()+
                                            "\nCausa: "+e.getCause(), 
                                            "Erro!", 
                                            JOptionPane.ERROR_MESSAGE
                                        );
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(  
                                            null, 
                                            "Erro ao ler configurações"+
                                            "\nErro: "+e.getMessage()+
                                            "\nCausa: "+e.getCause(), 
                                            "Erro!", 
                                            JOptionPane.ERROR_MESSAGE
                                        );
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(  
                                            null, 
                                            "Erro ao criar banco de dados"+
                                            "\nErro: "+e.getMessage()+
                                            "\nCausa: "+e.getCause(), 
                                            "Erro!", 
                                            JOptionPane.ERROR_MESSAGE
                                        );
        }
        catch (ExceptionInInitializerError e) {
            JOptionPane.showMessageDialog(   
                                            null, 
                                            "Banco de dados nao encontrado"+
                                            "\nErro: "+e.getMessage()+
                                            "\nCausa: "+e.getCause(), 
                                            "Erro!", 
                                            JOptionPane.ERROR_MESSAGE
                                        );
        }
        catch(PersistenceException e)
        {
            JOptionPane.showMessageDialog(   
                                            null, 
                                            "Erro"+
                                            "\nErro: "+e.getMessage()+
                                            "\nCausa: "+e.getCause(), 
                                            "Erro!", 
                                            JOptionPane.ERROR_MESSAGE
                                        );
        }
        finally
        {
            splash.dispose();
        }
    }
    
}
