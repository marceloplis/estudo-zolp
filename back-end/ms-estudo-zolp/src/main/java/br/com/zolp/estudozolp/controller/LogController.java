package br.com.zolp.estudozolp.controller;

import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.types.TipoLog;
import io.swagger.annotations.ApiOperation;
import org.slf4j.event.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Controller responsável pelas operações que efetuam o processamento
 *  dos logs no sistema. O controller disponibiliza as operações
 *  necessárias para consulta e exibição dos logs.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@RestController
public class LogController {

    /**
     * Habilita / Desabilita a exibição dos detalhes nos arquivos de log.
     *
     * @param ligaDetalhe
     * @return
     */
    @GetMapping(path = "/log/set/{ligaDetalhe}")
    @ApiOperation(value = "Habilita / Desabilita a exibição dos detalhes nos arquivos de log.",
    notes = "<br/><b>1</b>- Habilita exibição detalhada dos Logs.<br/><b>-1</b>- Desabilita exibição detalhada dos logs. ")
    public final String ligaDesligaLog(@PathVariable("ligaDetalhe") final int ligaDetalhe) {

        LogManager.log(Level.INFO, TipoLog.ENTRADA, LogController.class, "ligaDesligaLog");

        if  ( ligaDetalhe == 1 ) {
            LogManager.ligaDetalhe();
        }

        if  ( ligaDetalhe == -1 ) {
            LogManager.desligaDetalhe();
        }

        LogManager.log(Level.INFO, TipoLog.SAIDA, LogController.class, "ligaDesligaLog");

        return LogManager.getStatusLog();
    }

    /**
     * Exibe o status atual da exibição detalhada dos detalhes nos arquivos de log.
     *
     * @return
     */
    @GetMapping(path = "/log/status")
    @ApiOperation(value = "Exibe o status atual da exibição detalhada dos detalhes nos arquivos de log.")
    public final String exibeStatusLog() {

        return LogManager.getStatusLog();

    }
    
}
