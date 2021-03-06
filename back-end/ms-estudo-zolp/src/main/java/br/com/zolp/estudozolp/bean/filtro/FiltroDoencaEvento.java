package br.com.zolp.estudozolp.bean.filtro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Classe responsável pelas informacoes de Filtro de DoencaEvento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FiltroDoencaEvento extends FiltroConsulta {


}
