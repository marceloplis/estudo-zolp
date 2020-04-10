package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.AuditoriaEstudo;
import br.com.zolp.estudozolp.entity.TbAuditoriaEstudo;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link AuditoriaEstudo} para o objeto {@link TbAuditoriaEstudo}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class AuditoriaEstudoToEntity implements Converter<AuditoriaEstudo, TbAuditoriaEstudo> {

    @Override
    public final TbAuditoriaEstudo convert(final AuditoriaEstudo source) {

        TbAuditoriaEstudo doc = new TbAuditoriaEstudo();

        if (source != null) {

            doc.setIdAuditoriaEstudo(source.getIdAuditoriaEstudo());
            doc.setUsername(source.getUsername());
            doc.setDtModificacao(source.getDtModificacao());
            doc.setTpModificacao(source.getTpModificacao());
            doc.setDsModificacao(source.getDsModificacao());
            doc.setTpEntidade(source.getTpEntidade());
            doc.setIdPaciente(source.getIdPaciente());

        }

        return doc;
    }

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbAuditoriaEstudo populate(final AuditoriaEstudo source) {

        TbAuditoriaEstudo doc = new TbAuditoriaEstudo();

        if(Eval.isNotEmpty(source.getIdAuditoriaEstudo())) {
            doc.setIdAuditoriaEstudo(source.getIdAuditoriaEstudo());
        }

        if(Eval.isNotEmpty(source.getUsername())) {
            doc.setUsername(source.getUsername());
        }

        if(Eval.isNotEmpty(source.getDtModificacao())) {
            doc.setDtModificacao(source.getDtModificacao());
        }

        if(Eval.isNotNull(source.getTpModificacao())) {
            doc.setTpModificacao(source.getTpModificacao());
        }

        if(Eval.isNotEmpty(source.getDsModificacao())) {
            doc.setDsModificacao(source.getDsModificacao());
        }

        if(Eval.isNotEmpty(source.getTpEntidade())) {
            doc.setTpEntidade(source.getTpEntidade());
        }

        if(Eval.isNotEmpty(source.getIdPaciente())) {
            doc.setIdPaciente(source.getIdPaciente());
        }

        return doc;
    }

}
