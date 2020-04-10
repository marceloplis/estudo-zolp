package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Paciente;
import br.com.zolp.estudozolp.entity.TbPaciente;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link Paciente} para o objeto {@link TbPaciente}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class PacienteToEntity implements Converter<Paciente, TbPaciente> {

    @Override
    public final TbPaciente convert(final Paciente source) {

        TbPaciente doc = new TbPaciente();

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

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbPaciente populate(final Paciente source) {

        TbPaciente doc = new TbPaciente();

        if(Eval.isNotEmpty(source.getIdPaciente())) {
            doc.setIdPaciente(source.getIdPaciente());
        }

        if(Eval.isNotEmpty(source.getIdUnidadePesquisa())) {
            doc.setIdUnidadePesquisa(source.getIdUnidadePesquisa());
        }

        if(Eval.isNotEmpty(source.getCpf())) {
            doc.setCpf(source.getCpf());
        }

        if(Eval.isNotEmpty(source.getNome())) {
            doc.setNome(source.getNome());
        }

        if(Eval.isNotEmpty(source.getIniciaisNome())) {
            doc.setIniciaisNome(source.getIniciaisNome());
        }

        if(Eval.isNotEmpty(source.getNuRegistroProtocolo())) {
            doc.setNuRegistroProtocolo(source.getNuRegistroProtocolo());
        }

        if(Eval.isNotEmpty(source.getEndereco())) {
            doc.setEndereco(source.getEndereco());
        }

        if(Eval.isNotEmpty(source.getNuEndereco())) {
            doc.setNuEndereco(source.getNuEndereco());
        }

        if(Eval.isNotEmpty(source.getComplEndereco())) {
            doc.setComplEndereco(source.getComplEndereco());
        }

        if(Eval.isNotEmpty(source.getBairro())) {
            doc.setBairro(source.getBairro());
        }

        if(Eval.isNotEmpty(source.getCidade())) {
            doc.setCidade(source.getCidade());
        }

        if(Eval.isNotEmpty(source.getUf())) {
            doc.setUf(source.getUf());
        }

        if(Eval.isNotEmpty(source.getCep())) {
            doc.setCep(source.getCep());
        }

        if(Eval.isNotEmpty(source.getTelResidencial())) {
            doc.setTelResidencial(source.getTelResidencial());
        }

        if(Eval.isNotEmpty(source.getTelCelular())) {
            doc.setTelCelular(source.getTelCelular());
        }

        if(Eval.isNotEmpty(source.getTelTrabalho())) {
            doc.setTelTrabalho(source.getTelTrabalho());
        }

        if(Eval.isNotEmpty(source.getTelRecado())) {
            doc.setTelRecado(source.getTelRecado());
        }

        if(Eval.isNotEmpty(source.getPessoaRecado())) {
            doc.setPessoaRecado(source.getPessoaRecado());
        }

        if(Eval.isNotEmpty(source.getProfissao())) {
            doc.setProfissao(source.getProfissao());
        }

        if(Eval.isNotEmpty(source.getDtNascimento())) {
            doc.setDtNascimento(source.getDtNascimento());
        }

        if(Eval.isNotEmpty(source.getEscolaridade())) {
            doc.setEscolaridade(source.getEscolaridade());
        }

        if(Eval.isNotEmpty(source.getRaca())) {
            doc.setRaca(source.getRaca());
        }

        if(Eval.isNotEmpty(source.getSexo())) {
            doc.setSexo(source.getSexo());
        }

        if(Eval.isNotEmpty(source.getFlAtivo())) {
            doc.setFlAtivo(source.getFlAtivo());
        }

        if(Eval.isNotEmpty(source.getDtInclusao())) {
            doc.setDtInclusao(source.getDtInclusao());
        }

        return doc;
    }

}
