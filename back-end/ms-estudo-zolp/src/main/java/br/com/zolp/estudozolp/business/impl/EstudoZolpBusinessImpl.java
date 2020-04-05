package br.com.zolp.estudozolp.business.impl;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.business.EstudoZolpBusiness;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.service.AcessoSistemaService;
import br.com.zolp.estudozolp.types.TipoLog;
import br.com.zolp.estudozolp.util.Eval;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsavel pela implementacao das operacoes para o tratamento das regras de negocio.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class EstudoZolpBusinessImpl implements EstudoZolpBusiness {

    @Autowired
    private AcessoSistemaService acessoSistemaService;


    // --- FAZ ALGO -------------------------------------------------------------


    @Override
    public void fazAlgo(Object param) throws EstudoZolpException {

        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpBusinessImpl.class, "fazAlgo");

        // Efetua o log das informações de entrada
        LogManager.logDetalhe(Level.INFO, EstudoZolpBusinessImpl.class, "fazAlgo",
            " Dados entrada [ " + param + " ].");

        // Valida os parametros de entrada do serviço
        if (Eval.isAnyEmpty(param)) {

            LogManager.logDetalhe(Level.ERROR, EstudoZolpBusinessImpl.class, "fazAlgo",
                    " Foram informados valores invalidos nos parametros de entrada do servico.");

            throw new EstudoZolpException("Valores invalidos nos parametros de entrada do servico.");

        }

        try {

            // Busca usuario
            UsuarioSistema usuario = acessoSistemaService.obterUsuario(1L);

            PerfilAcesso perfil = acessoSistemaService.obterPerfil(1L);

        } catch (Exception e) {

            LogManager.logDetalhe(Level.ERROR, EstudoZolpBusinessImpl.class, "fazAlgo",
                "Erro ao fazer algo.", e);
        }

        // Efetua o log das informações de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpBusinessImpl.class, "fazAlgo");

    }

}
