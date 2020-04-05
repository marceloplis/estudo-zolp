package br.com.grupostp.authzero.service.external;

import br.com.grupostp.abcommon.exception.ExternalServiceException;
import br.com.grupostp.authzero.bean.external.ObterDadosCartaoAuthZeroRequest;
import br.com.grupostp.authzero.bean.external.ObterDadosCartaoAuthZeroResponse;

/**
 * Interface responsável por efetuar a chamada as operações do web service ConsultaDadosCartaoAbastecePS.
 *
 * @author stp
 * @version 1.0
 */
public interface ConsultaDadosCartaoAbastecePS {

    /**
     * Efetua a chamada a operação responsável pela busca das informacoes de cartao de credito.
     *
     * @param request
     * @return
     * @throws ExternalServiceException
     */
    ObterDadosCartaoAuthZeroResponse obterDadosCartaoAuthZero(ObterDadosCartaoAuthZeroRequest request)
        throws ExternalServiceException;

}
