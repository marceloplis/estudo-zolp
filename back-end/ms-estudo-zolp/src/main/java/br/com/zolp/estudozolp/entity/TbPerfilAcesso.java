package br.com.zolp.estudozolp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe responsável pelo mapeamento da entidade TbPerfilAcesso.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Table(name="TbPerfilAcesso")
public class TbPerfilAcesso implements Serializable {

    private static final long serialVersionUID = 24158426272384L;

    @Id
//	@SequenceGenerator(name = "seq_perfil", sequenceName = "seq_perfil", allocationSize = 1)
//	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_perfil")
    @Column(name="idperfilacesso", nullable = false)
    private Long idPerfilAcesso;

    @Column(name="dsperfil", nullable = false)
    private String dsPerfil;

    /**
     * Obtem o valor corrente de idPerfilAcesso.
     *
     * @return O valor corrente de idPerfilAcesso.
     */
    public Long getIdPerfilAcesso() {
        return idPerfilAcesso;
    }

    public TbPerfilAcesso() {
    }

    /**
     * Define um novo valor para idPerfilAcesso.
     *
     * @param idPerfilAcesso O novo valor para idPerfilAcesso.
     */
    public void setIdPerfilAcesso(final Long idPerfilAcesso) {
        this.idPerfilAcesso = idPerfilAcesso;
    }

    /**
     * Obtem o valor corrente de dsPerfil.
     *
     * @return O valor corrente de dsPerfil.
     */
    public String getDsPerfil() {
        return dsPerfil;
    }

    /**
     * Define um novo valor para dsPerfil.
     *
     * @param dsPerfil O novo valor para dsPerfil.
     */
    public void setDsPerfil(final String dsPerfil) {
        this.dsPerfil = dsPerfil;
    }

    @Override
    public final String toString() {
        return "PerfilAcessoEntity{" +
                "idPerfilAcesso=" + idPerfilAcesso +
                ", dsPerfil='" + dsPerfil + '\'' +
                '}';
    }
}
