/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.colmeiatecnologia.EmailMarketing;

import br.com.colmeiatecnologia.EmailMarketing.control.view.ControladorLookAndFeel;
import br.com.colmeiatecnologia.EmailMarketing.view.Principal;

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
        new Principal().setVisible(true);
    }
    
}
