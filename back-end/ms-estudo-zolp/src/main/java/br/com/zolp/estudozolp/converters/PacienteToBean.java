package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Paciente;
import br.com.zolp.estudozolp.entity.TbPaciente;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbPaciente} para o objeto {@link Paciente}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class PacienteToBean implements Converter<TbPaciente, Paciente> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final Paciente convert(final Object[] source) {

        final Paciente doc = new Paciente();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdPaciente(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setNome((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

    @Override
    public final Paciente convert(final TbPaciente source) {

        Paciente doc = new Paciente();

        if (source != null) {

            doc.setIdPaciente(source.getIdPaciente());
            doc.setIdUnidadePesquisa(source.getIdUnidadePesquisa());
            doc.setCpf(source.getCpf());
            doc.setNome(source.getNome());
            doc.setIniciaisNome(source.getIniciaisNome());
            doc.setNuRegistroProtocolo(source.getNuRegistroProtocolo());
            doc.setEndereco(source.getEndereco());
            doc.setNuEndereco(source.getNuEndereco());
            doc.setComplEndereco(source.getComplEndereco());
            doc.setBairro(source.getBairro());
            doc.setCidade(source.getCidade());
            doc.setUf(source.getUf());
            doc.setCep(source.getCep());
            doc.setTelResidencial(source.getTelResidencial());
            doc.setTelCelular(source.getTelCelular());
            doc.setTelTrabalho(source.getTelTrabalho());
            doc.setTelRecado(source.getTelRecado());
            doc.setPessoaRecado(source.getPessoaRecado());
            doc.setProfissao(source.getProfissao());
            doc.setDtNascimento(source.getDtNascimento());
            doc.setEscolaridade(source.getEscolaridade());
            doc.setRaca(source.getRaca());
            doc.setSexo(source.getSexo());
            doc.setFlAtivo(source.getFlAtivo());
            doc.setDtInclusao(source.getDtInclusao());

        }

        return doc;
    }

}
