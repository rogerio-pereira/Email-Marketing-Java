/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.control.view;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class TextAreaControl {
    public static void insereConteudo(JTextArea campo, ArrayList<String> linhas)
    {
        for(String linha: linhas)
            campo.setText(campo.getText()+linha+"\n");
    }
}
