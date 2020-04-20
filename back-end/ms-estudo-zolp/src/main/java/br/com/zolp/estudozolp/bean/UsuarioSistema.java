package br.com.zolp.estudozolp.bean;

import br.com.zolp.estudozolp.excel.SheetColumnIgnore;
import br.com.zolp.estudozolp.excel.SheetHeader;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Classe responsável pelas informacoes de UsuarioSistema.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioSistema implements Serializable{

	@SheetColumnIgnore
	private static final long serialVersionUID = 8452078778449621833L;

	@SheetHeader(name = "Codigo do Usuário")
	private Long idUsuario;

	@SheetHeader(name = "Codigo da unidade de pesquisa")
	private Long idUnidadePesquisa;

	@SheetHeader(name = "Codigo do Perfil")
	private Long idPerfil;

	@SheetHeader(name = "Nome do usuário")
	private String username;

	@SheetHeader(name = "Nome")
	private String nome;

	@SheetHeader(name = "Senha")
	@SheetColumnIgnore
	private String senha;

	@SheetHeader(name = "Email do usuario.")
	private String email;

	@SheetHeader(name = "Senha temporária.")
	private boolean flSenhaTemporaria;

	@SheetHeader(name = "Usuário ativo.")
	private boolean flAtivo;

	@SheetHeader(name = "Telefone do usuário.")
	private String fone;

	@SheetHeader(name = "Administrador.")
	private String admin;

	public UsuarioSistema() {
	}

	/**
	 * Obtem o valor corrente de dsModifiidUsuariocacao.
	 *
	 * @return O valor corrente de idUsuario.
	 */
	public final Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Define um novo valor para idUsuario.
	 *
	 * @param idUsuario O novo valor para idUsuario.
	 */
	public final void setIdUsuario(final Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtem o valor corrente de idUnidadePesquisa.
	 *
	 * @return O valor corrente de idUnidadePesquisa.
	 */
	public final Long getIdUnidadePesquisa() {
		return idUnidadePesquisa;
	}

	/**
	 * Define um novo valor para idUnidadePesquisa.
	 *
	 * @param idUnidadePesquisa O novo valor para idUnidadePesquisa.
	 */
	public final void setIdUnidadePesquisa(final Long idUnidadePesquisa) {
		this.idUnidadePesquisa = idUnidadePesquisa;
	}

	/**
	 * Obtem o valor corrente de idPerfil.
	 *
	 * @return O valor corrente de idPerfil.
	 */
	public final Long getIdPerfil() {
		return idPerfil;
	}

	/**
	 * Define um novo valor para idPerfil.
	 *
	 * @param idPerfil O novo valor para idPerfil.
	 */
	public final void setIdPerfil(final Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * Obtem o valor corrente de username.
	 *
	 * @return O valor corrente de username.
	 */
	public final String getUsername() {
		return username;
	}

	/**
	 * Define um novo valor para username.
	 *
	 * @param username O novo valor para username.
	 */
	public final void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * Obtem o valor corrente de nome.
	 *
	 * @return O valor corrente de nome.
	 */
	public final String getNome() {
		return nome;
	}

	/**
	 * Define um novo valor para nome.
	 *
	 * @param nome O novo valor para nome.
	 */
	public final void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * Obtem o valor corrente de senha.
	 *
	 * @return O valor corrente de senha.
	 */
	public final String getSenha() {
		return senha;
	}

	/**
	 * Define um novo valor para senha.
	 *
	 * @param senha O novo valor para senha.
	 */
	public final void setSenha(final String senha) {
		this.senha = senha;
	}

	/**
	 * Obtem o valor corrente de email.
	 *
	 * @return O valor corrente de email.
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * Define um novo valor para email.
	 *
	 * @param email O novo valor para email.
	 */
	public final void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Obtem o valor corrente de flSenhaTemporaria.
	 *
	 * @return O valor corrente de flSenhaTemporaria.
	 */
	public final boolean getFlSenhaTemporaria() {
		return flSenhaTemporaria;
	}

	/**
	 * Define um novo valor para flSenhaTemporaria.
	 *
	 * @param flSenhaTemporaria O novo valor para flSenhaTemporaria.
	 */
	public final void setFlSenhaTemporaria(final boolean flSenhaTemporaria) {
		this.flSenhaTemporaria = flSenhaTemporaria;
	}

	/**
	 * Obtem o valor corrente de flAtivo.
	 *
	 * @return O valor corrente de flAtivo.
	 */
	public final boolean getFlAtivo() {
		return flAtivo;
	}

	/**
	 * Define um novo valor para flAtivo.
	 *
	 * @param flAtivo O novo valor para flAtivo.
	 */
	public final void setFlAtivo(final boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	/**
	 * Obtem o valor corrente de fone.
	 *
	 * @return O valor corrente de fone.
	 */
	public final String getFone() {
		return fone;
	}

	/**
	 * Define um novo valor para fone.
	 *
	 * @param fone O novo valor para fone.
	 */
	public final void setFone(final String fone) {
		this.fone = fone;
	}

	/**
	 * Obtem o valor corrente de admin.
	 *
	 * @return O valor corrente de admin.
	 */
	public final String getAdmin() {
		return admin;
	}

	/**
	 * Define um novo valor para admin.
	 *
	 * @param admin O novo valor para admin.
	 */
	public final void setAdmin(final String admin) {
		this.admin = admin;
	}

	@Override
	public final String toString() {
		return "UsuarioSistema{" +
			"idUsuario=" + idUsuario +
			", idUnidadePesquisa=" + idUnidadePesquisa +
			", idPerfil=" + idPerfil +
			", username='" + username + '\'' +
			", nome='" + nome + '\'' +
			", senha='" + senha + '\'' +
			", email='" + email + '\'' +
			", flSenhaTemporaria=" + flSenhaTemporaria +
			", flAtivo=" + flAtivo +
			", fone='" + fone + '\'' +
			", admin='" + admin + '\'' +
			'}';
	}
}
