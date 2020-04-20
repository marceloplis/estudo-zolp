package br.com.zolp.estudozolp.controller;

import br.com.zolp.estudozolp.bean.User;
import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaUsuario;
import br.com.zolp.estudozolp.excel.GeraPlanilha;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;
import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.log.LogProcessManager;
import br.com.zolp.estudozolp.service.AcessoSistemaService;
import br.com.zolp.estudozolp.types.TipoLog;
import br.com.zolp.estudozolp.util.Dates;
import io.swagger.annotations.ApiOperation;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

 	@Autowired
	private GeraPlanilha geraPlanilha;

 	@Autowired
	LogProcessManager logProcessManager;

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
	@ApiOperation(value = "Efetua a inclusão de um usuario.")
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

	/**
	 * Chamada ao fluxo de lista de usuarios do sistema.
	 *
	 * @return Lista de usuarios
	 */
	@PostMapping(path = "/listaUsuarios", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Efetua a  busca dos usuarios.")
	public final ResponseEntity<List<UsuarioSistema>> listaUsuarios() {

		// Prepara o responseDoc para retorno:
		List<UsuarioSistema> listUsuarios = new ArrayList<>();

		try {

			// Efetua a busca dos usuarios
			FiltroConsultaUsuario fcu = new FiltroConsultaUsuario();


			listUsuarios = acessoSistemaService.consultarUsuario(fcu);

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

		return new ResponseEntity<>(listUsuarios, HttpStatus.OK);
	}

	/**
	 * Lista det. dispositivos para download (tela/binário).
	 *
	 * @return ResponseEntity<Resource>
	 */
	@PostMapping(path = "/listaUsuariosDownload") //, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista de usuários.")
	public final ResponseEntity<Resource> listaUsuariosDownload() {

		final String DATA_HORA = "_" + DateTimeFormatter
			.ofPattern("yyyyMMddHHmmss")
			.format(Dates.localDateTimeAtual());

		final String NOME_ARQUIVO = "listaUsuarios" + DATA_HORA + ".xls";

		boolean hasError = false;

		// Identifica a transacao nos logs
		logProcessManager.createUUID();

		// logging de entrada
		LogManager.log(Level.INFO, TipoLog.ENTRADA, UsuarioController.class,
				"listaUsuariosDownload");

//		LogManager.logDetalhe(Level.INFO, UsuarioController.class,
//				"listaUsuariosDownload", " Dados entrada [ requestDocument : "
//						+ requestDocument + " ].");

		// Prepara o resource de retorno:
		Resource resource = null;

		try {

			File tempFile = File.createTempFile("zlp-", "-tmp");

			// Efetua a busca dos usuarios
			FiltroConsultaUsuario fcu = new FiltroConsultaUsuario();

			UsuarioSistema us = acessoSistemaService.obterUsuario(2L);

			List<UsuarioSistema> listUsuarios = new ArrayList<>(); //acessoSistemaService.consultarUsuario(fcu);
			listUsuarios.add(us);

			this.geraPlanilha.processar(listUsuarios, tempFile, NOME_ARQUIVO);

			// Efetua a pesquisa pelos criterios de filtro fornecidos:
			final byte[] binario = Files.readAllBytes(tempFile.toPath());

			// Prepara o responseDoc para retorno:
			resource = new ByteArrayResource(binario);

			tempFile.deleteOnExit();

		} catch (EstudoZolpException eze) {
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "listaUsuariosDownload", " Erro!: ", eze);
			hasError = true;
		} catch (RegistroNaoLocalizadoException rnle) {
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "listaUsuariosDownload", " Erro!: ", rnle);
			hasError = true;
		} catch (PersistenciaException pe) {
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "listaUsuariosDownload", " Erro!: ", pe);
			hasError = true;
		} catch (Exception e) {
			// Eh preciso capturar outras excecoes que nao sejam do tipo RuntimeException, pois o
			// Hibernate cria um proxy que propaga as excecoes do tipo java.sql.Exception e que nao
			// sao tratadas na implementacao da service. Sem este catch, o erro eh propagado para o
			// REST HTTP como erro HTML-CODE 500.
			LogManager.logDetalhe(Level.ERROR, UsuarioController.class, "listaUsuariosDownload", " Erro!: ", e);
			hasError = true;
		}

		if (!hasError) {

			LogManager.log(Level.INFO, TipoLog.SAIDA, UsuarioController.class, "listaUsuariosDownload");

			return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + NOME_ARQUIVO)
				.body(resource);

		} else {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + NOME_ARQUIVO)
				.body(new ByteArrayResource("Erro!".getBytes()));
		}

	}

}
