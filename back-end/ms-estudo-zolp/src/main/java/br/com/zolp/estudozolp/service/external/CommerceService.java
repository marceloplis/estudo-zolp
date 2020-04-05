package br.com.grupostp.authzero.service.external;

import br.com.grupostp.abcommon.exception.ExternalServiceException;
import br.com.grupostp.authzero.bean.external.CardVerificationRequest;
import br.com.grupostp.authzero.bean.external.CardVerificationResponse;

/**
 * Interface responsável por efetuar a chamada as operações do web service CommerceServiceImpl.
 *
 * @author stp
 * @version 1.0
 */
public interface CommerceService {

    /**
     * Efetua a chamada a operação responsável pela verificacao do fluxo AuthZero.
     *
     * @param request
     * @return
     * @throws ExternalServiceException
     */
    CardVerificationResponse cardVerificationService(CardVerificationRequest request) throws ExternalServiceException;

}
