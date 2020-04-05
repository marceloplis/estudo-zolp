package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Paciente;
import br.com.zolp.estudozolp.entity.TbPaciente;
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
