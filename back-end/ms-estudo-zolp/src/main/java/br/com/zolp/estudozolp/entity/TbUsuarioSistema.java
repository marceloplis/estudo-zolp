package br.com.zolp.estudozolp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe responsável pelo mapeamento da entidade TbUsuarioSistema.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name="TbUsuarioSistema")
public class TbUsuarioSistema implements Serializable{

	private static final long serialVersionUID = 8452078778449621833L;

	@Id
//	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
//	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_usuario")
	@Column(name="idUsuarioSistema", nullable = false)
	private Long idUsuario;

	@Column(name="idUnidadePesquisa")
	private Long idUnidadePesquisa;

	@Column(name="idPerfil", nullable = false)
	private Long idPerfil;

	@Column(name="username", nullable = false)
	private String username;

	@Column(name="nome", nullable = false)
	private String nome;

	@Column(name="senha", nullable = false)
	private String senha;
	
	@Column(name="email")
	private String email;

	@Column(name="flSenhaTemporaria", nullable = false)
	private boolean flSenhaTemporaria;

	@Column(name="flAtivo", nullable = false)
	private boolean flAtivo;

	@Column(name="fone")
	private String fone;
	
	@Column(name="admin")
	private String admin;

	public TbUsuarioSistema() {
	}

	/**
	 * Obtem o valor corrente de dsModifiidUsuariocacao.
	 *
	 * @return O valor corrente de idUsuario.
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Define um novo valor para idUsuario.
	 *
	 * @param idUsuario O novo valor para idUsuario.
	 */
	public void setIdUsuario(final Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtem o valor corrente de idUnidadePesquisa.
	 *
	 * @return O valor corrente de idUnidadePesquisa.
	 */
	public Long getIdUnidadePesquisa() {
		return idUnidadePesquisa;
	}

	/**
	 * Define um novo valor para idUnidadePesquisa.
	 *
	 * @param idUnidadePesquisa O novo valor para idUnidadePesquisa.
	 */
	public void setIdUnidadePesquisa(final Long idUnidadePesquisa) {
		this.idUnidadePesquisa = idUnidadePesquisa;
	}

	/**
	 * Obtem o valor corrente de idPerfil.
	 *
	 * @return O valor corrente de idPerfil.
	 */
	public Long getIdPerfil() {
		return idPerfil;
	}

	/**
	 * Define um novo valor para idPerfil.
	 *
	 * @param idPerfil O novo valor para idPerfil.
	 */
	public void setIdPerfil(final Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * Obtem o valor corrente de username.
	 *
	 * @return O valor corrente de username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Define um novo valor para username.
	 *
	 * @param username O novo valor para username.
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * Obtem o valor corrente de nome.
	 *
	 * @return O valor corrente de nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define um novo valor para nome.
	 *
	 * @param nome O novo valor para nome.
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * Obtem o valor corrente de senha.
	 *
	 * @return O valor corrente de senha.
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Define um novo valor para senha.
	 *
	 * @param senha O novo valor para senha.
	 */
	public void setSenha(final String senha) {
		this.senha = senha;
	}

	/**
	 * Obtem o valor corrente de email.
	 *
	 * @return O valor corrente de email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define um novo valor para email.
	 *
	 * @param email O novo valor para email.
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Obtem o valor corrente de flSenhaTemporaria.
	 *
	 * @return O valor corrente de flSenhaTemporaria.
	 */
	public boolean getFlSenhaTemporaria() {
		return flSenhaTemporaria;
	}

	/**
	 * Define um novo valor para flSenhaTemporaria.
	 *
	 * @param flSenhaTemporaria O novo valor para flSenhaTemporaria.
	 */
	public void setFlSenhaTemporaria(final boolean flSenhaTemporaria) {
		this.flSenhaTemporaria = flSenhaTemporaria;
	}

	/**
	 * Obtem o valor corrente de flAtivo.
	 *
	 * @return O valor corrente de flAtivo.
	 */
	public boolean getFlAtivo() {
		return flAtivo;
	}

	/**
	 * Define um novo valor para flAtivo.
	 *
	 * @param flAtivo O novo valor para flAtivo.
	 */
	public void setFlAtivo(final boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	/**
	 * Obtem o valor corrente de fone.
	 *
	 * @return O valor corrente de fone.
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * Define um novo valor para fone.
	 *
	 * @param fone O novo valor para fone.
	 */
	public void setFone(final String fone) {
		this.fone = fone;
	}

	/**
	 * Obtem o valor corrente de admin.
	 *
	 * @return O valor corrente de admin.
	 */
	public String getAdmin() {
		return admin;
	}

	/**
	 * Define um novo valor para admin.
	 *
	 * @param admin O novo valor para admin.
	 */
	public void setAdmin(final String admin) {
		this.admin = admin;
	}

	@Override
	public final String toString() {
		return "TbUsuarioSistema{" +
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
