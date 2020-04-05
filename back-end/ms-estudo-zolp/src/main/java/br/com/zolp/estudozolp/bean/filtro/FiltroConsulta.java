package br.com.zolp.estudozolp.bean.filtro;

/**
 * Classe responsável pelas informacoes base de Filtro de Consulta.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class FiltroConsulta {

	private Long id;

	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
