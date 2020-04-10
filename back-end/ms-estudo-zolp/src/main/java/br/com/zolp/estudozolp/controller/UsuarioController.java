package br.com.zolp.estudozolp.controller;

import br.com.zolp.estudozolp.bean.User;
import br.com.zolp.estudozolp.bean.UsuarioSistema;
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

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

/**
 *  Controller responsavel por expor as operacoes responsaveis pelo tratamento de usuario.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@RestController
public class UsuarioController {

 	@Autowired
	private AcessoSistemaService acessoSistemaService;

	@PostMapping("/login")
	public boolean login(@RequestBody User user) {
		return user.getUserName().equals("user") && user.getPassword().equals("pass");
	}

	@PostMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	}

	/**
	 * Chamada ao fluxo de inclusao de um usuario do sistema.
	 *
	 * @param usuarioSistemaRequest
	 * @return
	 */
	@PostMapping(path = "/incluirUsuario", consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Efetua a inclusão de um voucher.")
	public final ResponseEntity<UsuarioSistema> incluirUsuario(@RequestBody final UsuarioSistema usuarioSistemaRequest) {

		// Prepara o responseDoc para retorno:
		UsuarioSistema usuarioSistemaResponse = new UsuarioSistema();

		try {
			// Primeiro precisa converter o requestDoc para tipo manipulado pelas classes Business (bean):
			//final VoucherAbastece novoVoucher = incluirVoucherRequestToBean.convert(requestDocument);

			// Efetua a inclusao (id inexistente) ou atualizacao (id fornecido) do voucher:
			acessoSistemaService.incluirUsuario(usuarioSistemaRequest);

			usuarioSistemaResponse = usuarioSistemaRequest;

		} catch (EstudoZolpException eze) {
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "incluirUsuario", " Erro!: ", eze);
		} catch (RegistroNaoLocalizadoException rnle) {
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "incluirUsuario", " Erro!: ", rnle);
		} catch (PersistenciaException pe) {
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "incluirUsuario", " Erro!: ", pe);
		} catch (Exception e) {
			// Eh preciso capturar outras excecoes que nao sejam do tipo RuntimeException, pois o
			// Hibernate cria um proxy que propaga as excecoes do tipo java.sql.Exception e que nao
			// sao tratadas na implementacao da service. Sem este catch, o erro eh propagado para o
			// REST HTTP como erro HTML-CODE 500.
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "incluirUsuario", " Erro!: ", e);
		}

		return new ResponseEntity<UsuarioSistema>(usuarioSistemaResponse, HttpStatus.OK);
	}

}
