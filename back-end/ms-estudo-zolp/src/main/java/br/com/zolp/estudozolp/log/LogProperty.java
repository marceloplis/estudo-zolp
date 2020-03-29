package br.com.zolp.estudozolp.log;

import br.com.zolp.estudozolp.util.Constants;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.PropertyDefiner;

import java.io.File;

/**
 * Classe responsável por obter o caminho de gravacao do arquivo de log.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class LogProperty extends ContextAwareBase implements PropertyDefiner {

    @Override
    public String getPropertyValue() {
        return System.getProperty(Constants.USER_DIR) + File.separator + Constants.PASTA_LOGS + File.separator;
    }

}
