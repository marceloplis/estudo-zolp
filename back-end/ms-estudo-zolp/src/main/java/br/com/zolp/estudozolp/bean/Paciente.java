package br.com.zolp.estudozolp.bean;

import br.com.zolp.estudozolp.excel.SheetHeader;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável pelas informacoes de Paciente.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paciente implements Serializable{

    private static final long serialVersionUID = -8687430250073332167L;

    //@SheetColumnIgnore // Ignora o processamento da coluna
    @SheetHeader( name = "Código do Paciente")
    private Long idPaciente;

    @SheetHeader( name = "Código da Unidade de Pesquisa")
    private Long idUnidadePesquisa;
    private String cpf;
    private String nome;
    private String iniciaisNome;
    private String nuRegistroProtocolo;
    private String endereco;
    private Integer nuEndereco;
    private String complEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String telResidencial;
    private String telCelular;
    private String telTrabalho;
    private String telRecado;
    private String pessoaRecado;
    private String profissao;
    private Date dtNascimento;
    private Integer escolaridade;
    private Integer raca;
    private String sexo;
    private String flAtivo;
    private Date dtInclusao;

    public Paciente() {
    }

    /**
     * Obtem o valor corrente de idPaciente.
     *
     * @return O valor corrente de idPaciente.
     */
    public Long getIdPaciente() {
        return idPaciente;
    }

    /**
     * Define um novo valor para idPaciente.
     *
     * @param idPaciente O novo valor para idPaciente.
     */
    public void setIdPaciente(final Long idPaciente) {
        this.idPaciente = idPaciente;
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
     * Obtem o valor corrente de cpf.
     *
     * @return O valor corrente de cpf.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define um novo valor para cpf.
     *
     * @param cpf O novo valor para cpf.
     */
    public void setCpf(final String cpf) {
        this.cpf = cpf;
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
     * Obtem o valor corrente de iniciaisNome.
     *
     * @return O valor corrente de iniciaisNome.
     */
    public String getIniciaisNome() {
        return iniciaisNome;
    }

    /**
     * Define um novo valor para iniciaisNome.
     *
     * @param iniciaisNome O novo valor para iniciaisNome.
     */
    public void setIniciaisNome(final String iniciaisNome) {
        this.iniciaisNome = iniciaisNome;
    }

    /**
     * Obtem o valor corrente de nuRegistroProtocolo.
     *
     * @return O valor corrente de nuRegistroProtocolo.
     */
    public String getNuRegistroProtocolo() {
        return nuRegistroProtocolo;
    }

    /**
     * Define um novo valor para nuRegistroProtocolo.
     *
     * @param nuRegistroProtocolo O novo valor para nuRegistroProtocolo.
     */
    public void setNuRegistroProtocolo(final String nuRegistroProtocolo) {
        this.nuRegistroProtocolo = nuRegistroProtocolo;
    }

    /**
     * Obtem o valor corrente de endereco.
     *
     * @return O valor corrente de endereco.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define um novo valor para endereco.
     *
     * @param endereco O novo valor para endereco.
     */
    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtem o valor corrente de nuEndereco.
     *
     * @return O valor corrente de nuEndereco.
     */
    public Integer getNuEndereco() {
        return nuEndereco;
    }

    /**
     * Define um novo valor para nuEndereco.
     *
     * @param nuEndereco O novo valor para nuEndereco.
     */
    public void setNuEndereco(final Integer nuEndereco) {
        this.nuEndereco = nuEndereco;
    }

    /**
     * Obtem o valor corrente de complEndereco.
     *
     * @return O valor corrente de complEndereco.
     */
    public String getComplEndereco() {
        return complEndereco;
    }

    /**
     * Define um novo valor para complEndereco.
     *
     * @param complEndereco O novo valor para complEndereco.
     */
    public void setComplEndereco(final String complEndereco) {
        this.complEndereco = complEndereco;
    }

    /**
     * Obtem o valor corrente de bairro.
     *
     * @return O valor corrente de bairro.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define um novo valor para bairro.
     *
     * @param bairro O novo valor para bairro.
     */
    public void setBairro(final String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtem o valor corrente de cidade.
     *
     * @return O valor corrente de cidade.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define um novo valor para cidade.
     *
     * @param cidade O novo valor para cidade.
     */
    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtem o valor corrente de uf.
     *
     * @return O valor corrente de uf.
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define um novo valor para uf.
     *
     * @param uf O novo valor para uf.
     */
    public void setUf(final String uf) {
        this.uf = uf;
    }

    /**
     * Obtem o valor corrente de cep.
     *
     * @return O valor corrente de cep.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define um novo valor para cep.
     *
     * @param cep O novo valor para cep.
     */
    public void setCep(final String cep) {
        this.cep = cep;
    }

    /**
     * Obtem o valor corrente de telResidencial.
     *
     * @return O valor corrente de telResidencial.
     */
    public String getTelResidencial() {
        return telResidencial;
    }

    /**
     * Define um novo valor para telResidencial.
     *
     * @param telResidencial O novo valor para telResidencial.
     */
    public void setTelResidencial(final String telResidencial) {
        this.telResidencial = telResidencial;
    }

    /**
     * Obtem o valor corrente de telCelular.
     *
     * @return O valor corrente de telCelular.
     */
    public String getTelCelular() {
        return telCelular;
    }

    /**
     * Define um novo valor para telCelular.
     *
     * @param telCelular O novo valor para telCelular.
     */
    public void setTelCelular(final String telCelular) {
        this.telCelular = telCelular;
    }

    /**
     * Obtem o valor corrente de telTrabalho.
     *
     * @return O valor corrente de telTrabalho.
     */
    public String getTelTrabalho() {
        return telTrabalho;
    }

    /**
     * Define um novo valor para telTrabalho.
     *
     * @param telTrabalho O novo valor para telTrabalho.
     */
    public void setTelTrabalho(final String telTrabalho) {
        this.telTrabalho = telTrabalho;
    }

    /**
     * Obtem o valor corrente de telRecado.
     *
     * @return O valor corrente de telRecado.
     */
    public String getTelRecado() {
        return telRecado;
    }

    /**
     * Define um novo valor para telRecado.
     *
     * @param telRecado O novo valor para telRecado.
     */
    public void setTelRecado(final String telRecado) {
        this.telRecado = telRecado;
    }

    /**
     * Obtem o valor corrente de pessoaRecado.
     *
     * @return O valor corrente de pessoaRecado.
     */
    public String getPessoaRecado() {
        return pessoaRecado;
    }

    /**
     * Define um novo valor para pessoaRecado.
     *
     * @param pessoaRecado O novo valor para pessoaRecado.
     */
    public void setPessoaRecado(final String pessoaRecado) {
        this.pessoaRecado = pessoaRecado;
    }

    /**
     * Obtem o valor corrente de profissao.
     *
     * @return O valor corrente de profissao.
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Define um novo valor para profissao.
     *
     * @param profissao O novo valor para profissao.
     */
    public void setProfissao(final String profissao) {
        this.profissao = profissao;
    }

    /**
     * Obtem o valor corrente de dtNascimento.
     *
     * @return O valor corrente de dtNascimento.
     */
    public Date getDtNascimento() {
        return dtNascimento;
    }

    /**
     * Define um novo valor para dtNascimento.
     *
     * @param dtNascimento O novo valor para dtNascimento.
     */
    public void setDtNascimento(final Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    /**
     * Obtem o valor corrente de escolaridade.
     *
     * @return O valor corrente de escolaridade.
     */
    public Integer getEscolaridade() {
        return escolaridade;
    }

    /**
     * Define um novo valor para escolaridade.
     *
     * @param escolaridade O novo valor para escolaridade.
     */
    public void setEscolaridade(final Integer escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * Obtem o valor corrente de raca.
     *
     * @return O valor corrente de raca.
     */
    public Integer getRaca() {
        return raca;
    }

    /**
     * Define um novo valor para raca.
     *
     * @param raca O novo valor para raca.
     */
    public void setRaca(final Integer raca) {
        this.raca = raca;
    }

    /**
     * Obtem o valor corrente de sexo.
     *
     * @return O valor corrente de sexo.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Define um novo valor para sexo.
     *
     * @param sexo O novo valor para sexo.
     */
    public void setSexo(final String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtem o valor corrente de flAtivo.
     *
     * @return O valor corrente de flAtivo.
     */
    public String getFlAtivo() {
        return flAtivo;
    }

    /**
     * Define um novo valor para flAtivo.
     *
     * @param flAtivo O novo valor para flAtivo.
     */
    public void setFlAtivo(final String flAtivo) {
        this.flAtivo = flAtivo;
    }

    /**
     * Obtem o valor corrente de dtInclusao.
     *
     * @return O valor corrente de dtInclusao.
     */
    public Date getDtInclusao() {
        return dtInclusao;
    }

    /**
     * Define um novo valor para dtInclusao.
     *
     * @param dtInclusao O novo valor para dtInclusao.
     */
    public void setDtInclusao(final Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    @Override
    public final String toString() {
        return "Paciente{" +
            "idPaciente=" + idPaciente +
            ", idUnidadePesquisa=" + idUnidadePesquisa +
            ", cpf='" + cpf + '\'' +
            ", nome='" + nome + '\'' +
            ", iniciaisNome='" + iniciaisNome + '\'' +
            ", nuRegistroProtocolo='" + nuRegistroProtocolo + '\'' +
            ", endereco='" + endereco + '\'' +
            ", nuEndereco=" + nuEndereco +
            ", complEndereco='" + complEndereco + '\'' +
            ", bairro='" + bairro + '\'' +
            ", cidade='" + cidade + '\'' +
            ", uf='" + uf + '\'' +
            ", cep='" + cep + '\'' +
            ", telResidencial='" + telResidencial + '\'' +
            ", telCelular='" + telCelular + '\'' +
            ", telTrabalho='" + telTrabalho + '\'' +
            ", telRecado='" + telRecado + '\'' +
            ", pessoaRecado='" + pessoaRecado + '\'' +
            ", profissao='" + profissao + '\'' +
            ", dtNascimento=" + dtNascimento +
            ", escolaridade=" + escolaridade +
            ", raca=" + raca +
            ", sexo='" + sexo + '\'' +
            ", flAtivo='" + flAtivo + '\'' +
            ", dtInclusao=" + dtInclusao +
            '}';
    }
}