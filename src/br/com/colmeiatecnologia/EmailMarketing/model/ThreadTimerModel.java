/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.colmeiatecnologia.EmailMarketing.model;

import br.com.colmeiatecnologia.EmailMarketing.model.dao.RemetenteDAO;
import br.com.colmeiatecnologia.EmailMarketing.view.Principal;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ThreadTimerModel
{
    private Timer timer;

    /**
     * Construtor
     * @param remetente
     * @param mensagem
     * @param janelaPrincipal 
     */
    public ThreadTimerModel(
                                RemetenteDAO remetente,
                                MensagemModel mensagem,
                                Principal janelaPrincipal
                            )
    {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ThreadEnviaEmail  (
                                                            remetente, 
                                                            mensagem,
                                                            janelaPrincipal
                                                        ), 0, 3600*1000);
    }
}
