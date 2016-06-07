/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.colmeiatecnologia.EmailMarketing.control.ArquivoControlTest;
import br.com.colmeiatecnologia.EmailMarketing.model.EmailModelTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
                        ArquivoControlTest.class,
                        EmailModelTest.class
                    })
public class AllTests {
}