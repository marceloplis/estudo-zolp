package br.com.zolp.estudozolp.controller;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;
import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.service.AcessoSistemaService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Controller responsavel por expor as operacoes responsaveis pelo tratamento de perfis.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@RestController
public class PerfilController {

 	@Autowired
	private AcessoSistemaService acessoSistemaService;

	/**
	 * Chamada ao fluxo de inclusao de um perfil do sistema.
	 *
	 * @param perfilAcessoRequest
	 * @return
	 */
	@PostMapping(path = "/incluirPerfil", consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Efetua a inclusão de um voucher.")
	public final ResponseEntity<PerfilAcesso> incluirPerfil(@RequestBody final PerfilAcesso perfilAcessoRequest) {

		// Prepara o responseDoc para retorno:
		PerfilAcesso perfilAcessoResponse = new PerfilAcesso();

		try {
			// Primeiro precisa converter o requestDoc para tipo manipulado pelas classes Business (bean):
			//final VoucherAbastece novoVoucher = incluirVoucherRequestToBean.convert(requestDocument);

			// Efetua a inclusao (id inexistente) ou atualizacao (id fornecido) do voucher:
			acessoSistemaService.incluirPerfil(perfilAcessoRequest);

			perfilAcessoResponse = perfilAcessoRequest;

		} catch (EstudoZolpException eze) {
			LogManager.logDetalhe(Level.ERROR, PerfilController.class, "incluirPerfil", " Erro!: ", eze);
		} catch (RegistroNaoLocalizadoException rnle) {
			LogManager.logDetalhe(Level.ERROR, PerfilController.class, "incluirPerfil", " Erro!: ", rnle);
		} catch (PersistenciaException pe) {
			LogManager.logDetalhe(Level.ERROR, PerfilController.class, "incluirPerfil", " Erro!: ", pe);
		} catch (Exception e) {
			// Eh preciso capturar outras excecoes que nao sejam do tipo RuntimeException, pois o
			// Hibernate cria um proxy que propaga as excecoes do tipo java.sql.Exception e que nao
			// sao tratadas na implementacao da service. Sem este catch, o erro eh propagado para o
			// REST HTTP como erro HTML-CODE 500.
			LogManager.logDetalhe(Level.ERROR, PerfilController.class, "incluirPerfil", " Erro!: ", e);
		}

		return new ResponseEntity<PerfilAcesso>(perfilAcessoResponse, HttpStatus.OK);
	}

}
