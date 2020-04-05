package br.com.zolp.estudozolp.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Classe responsável pelas informacoes de PerfilAcesso.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PerfilAcesso implements Serializable {

    private static final long serialVersionUID = 24158426272384L;

    private Long idPerfilAcesso;
    private String dsPerfil;

    public PerfilAcesso() {
    }

    /**
     * Obtem o valor corrente de idPerfilAcesso.
     *
     * @return O valor corrente de idPerfilAcesso.
     */
    public final Long getIdPerfilAcesso() {
        return idPerfilAcesso;
    }

    /**
     * Define um novo valor para idPerfilAcesso.
     *
     * @param idPerfilAcesso O novo valor para idPerfilAcesso.
     */
    public final void setIdPerfilAcesso(final Long idPerfilAcesso) {
        this.idPerfilAcesso = idPerfilAcesso;
    }

    /**
     * Obtem o valor corrente de dsPerfil.
     *
     * @return O valor corrente de dsPerfil.
     */
    public final String getDsPerfil() {
        return dsPerfil;
    }

    /**
     * Define um novo valor para dsPerfil.
     *
     * @param dsPerfil O novo valor para dsPerfil.
     */
    public final void setDsPerfil(final String dsPerfil) {
        this.dsPerfil = dsPerfil;
    }

    @Override
    public final String toString() {
        return "PerfilAcesso{" +
            "idPerfilAcesso=" + idPerfilAcesso +
            ", dsPerfil='" + dsPerfil + '\'' +
            '}';
    }
}
