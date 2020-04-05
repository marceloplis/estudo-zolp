package br.com.grupostp.authzero.service.external.impl;

import br.com.grupostp.abcommon.exception.ExternalServiceException;
import br.com.grupostp.authzero.bean.external.ObterDadosCartaoAuthZeroRequest;
import br.com.grupostp.authzero.bean.external.ObterDadosCartaoAuthZeroResponse;
import br.com.grupostp.authzero.service.external.ConsultaDadosCartaoAbastecePS;
import br.com.grupostp.library.stplog.service.internal.LogManager;
import br.com.grupostp.library.stplog.service.types.TipoLog;
import br.com.stp.core.wsframework.ServiceClient;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Classe responsável pela implementação da chamada das operações do Web Service ConsultaDadosCartaoAbastecePS.
 *
 * @author stp
 * @version 1.0
 */
@Component
public class ConsultaDadosCartaoAbastecePSImpl implements ConsultaDadosCartaoAbastecePS {

    @Autowired
    @Resource(name = "WSCaller")
    private ServiceClient serviceClient;

    public ConsultaDadosCartaoAbastecePSImpl(){
    }

    /**
     * {@inheritDoc}
     */
    public ObterDadosCartaoAuthZeroResponse obterDadosCartaoAuthZero(ObterDadosCartaoAuthZeroRequest request)
        throws ExternalServiceException {

        LogManager.log(Level.INFO, TipoLog.ENTRADA, CommerceServiceImpl.class, "cardVerificationService");

        try {

            LogManager.logDetalhe(Level.INFO, CommerceServiceImpl.class,"obterDadosCartaoAuthZero",
                    "Request [ " + request + "].");

            ObterDadosCartaoAuthZeroResponse response =  serviceClient.invokeService("ConsultaDadosCartaoAbastecePS.obterDadosCartaoAuthZero",
                    request, ObterDadosCartaoAuthZeroResponse.class);

            LogManager.logDetalhe(Level.INFO, CommerceServiceImpl.class,"obterDadosCartaoAuthZero",
                    "Response [ " + response + "].");

            LogManager.log(Level.INFO, TipoLog.SAIDA, CommerceServiceImpl.class,"cardVerificationService");

            return response;

        } catch (Exception e) {

            LogManager.logDetalhe(Level.ERROR, CommerceServiceImpl.class, "cardVerificationService",
                    "Erro ao invocar serviço ConsultaDadosCartaoAbastecePS", e);

            throw new ExternalServiceException("Erro ao invocar serviço ConsultaDadosCartaoAbastecePSImpl", e);
        }

    }

}
