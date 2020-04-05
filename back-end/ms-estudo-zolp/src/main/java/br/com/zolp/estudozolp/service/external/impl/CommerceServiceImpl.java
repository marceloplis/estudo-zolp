package br.com.grupostp.authzero.service.external.impl;

import br.com.grupostp.abcommon.exception.ExternalServiceException;
import br.com.grupostp.abcommon.util.AppConfigFile;
import br.com.grupostp.authzero.bean.external.CardVerificationRequest;
import br.com.grupostp.authzero.bean.external.CardVerificationResponse;
import br.com.grupostp.authzero.service.external.CommerceService;
import br.com.grupostp.authzero.util.Constants;
import br.com.grupostp.library.stplog.service.internal.LogManager;
import br.com.grupostp.library.stplog.service.types.TipoLog;
import br.com.stp.core.wsframework.ServiceClient;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Classe responsável pela implementação da chamada das operações do Web Service CommerceService (GetNet).
 *
 * @author stp
 * @version 1.0
 */
@Component
public class CommerceServiceImpl implements CommerceService {

    @Autowired
    @Resource(name = "WSCaller")
    private ServiceClient serviceClient;

    public CommerceServiceImpl(){
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardVerificationResponse cardVerificationService(CardVerificationRequest request)
        throws ExternalServiceException {

        LogManager.log(Level.INFO, TipoLog.ENTRADA, CommerceServiceImpl.class, "cardVerificationService");

        try {

            // Efetua a coonfiguração do proxy para chamada do servico GetNet com base nos parametros cadastrados no
            // arquivos de propriedades.
            this.configuraProxy();

            LogManager.logDetalhe(Level.INFO, CommerceServiceImpl.class,"cardVerificationService",
                "Request [ " + request + "].");

            // Efetua a chamada do serviço
            CardVerificationResponse response = serviceClient.invokeService("CommerceService.cardVerificationService",
                request, CardVerificationResponse.class);

            LogManager.logDetalhe(Level.INFO, CommerceServiceImpl.class,"cardVerificationService",
                    "Response [ " + response + "].");

            LogManager.log(Level.INFO, TipoLog.SAIDA, CommerceServiceImpl.class,"cardVerificationService");

            return response;

        } catch (Exception e) {

            LogManager.logDetalhe(Level.ERROR, CommerceServiceImpl.class, "cardVerificationService",
                "Erro ao invocar serviço CommerceService", e);

            throw new ExternalServiceException("Erro ao invocar serviço CommerceServiceImpl", e);
        }

    }

    /**
     * Efetua a configuracao das informações de proxy para acesso ao serviço getNet.
     */
    private void configuraProxy(){

        LogManager.log(Level.INFO, TipoLog.ENTRADA, CommerceServiceImpl.class, "configuraProxy");

        try{

            AppConfigFile appConfigFile = new AppConfigFile(Constants.CONFIG_FILE_NAME);

            String proxyHost  = appConfigFile.getProperty(Constants.GETNET_PROXY_HOST);
            String proxyPort  = appConfigFile.getProperty(Constants.GETNET_PROXY_PORT);
            String url        = appConfigFile.getProperty(Constants.GETNET_URL_SERVICE);

            serviceClient.setOverrideEndpoint( url );

            if ( proxyHost != null && !proxyHost.isEmpty() ) {
                serviceClient.setOverrideProxyHost( proxyHost );
            }

            if ( proxyPort != null && !proxyPort.isEmpty() ) {
                serviceClient.setOverrideProxyPort( new Integer( proxyPort ) );
            }

        } catch (Exception e) {

            LogManager.logDetalhe(Level.ERROR, CommerceServiceImpl.class,"configuraProxy",
                "Erro ao efetuar a busca das informacoes.", e);

            throw new br.com.grupostp.authzero.exception.EstudoZolpException("Erro ao efetuar a busca das informacoes de configuracao de proxy do "
                + "arquivo de propriedades.", e);
        }

        LogManager.log(Level.INFO, TipoLog.SAIDA, CommerceServiceImpl.class, "configuraProxy");

    }

}
