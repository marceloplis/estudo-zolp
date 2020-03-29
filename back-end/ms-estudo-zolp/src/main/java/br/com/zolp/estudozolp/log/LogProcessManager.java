package br.com.zolp.estudozolp.log;

import br.com.zolp.estudozolp.util.Constants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Classe responsável por efetuar a criação do correlationID do processamento atual.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
@Scope("prototype")
public class LogProcessManager {

    public final UUID createUUID() {

        UUID correlationID = UUID.randomUUID();
        Thread.currentThread().setName(Constants.STR_UUID + correlationID.toString());

        return correlationID;
    }

}
