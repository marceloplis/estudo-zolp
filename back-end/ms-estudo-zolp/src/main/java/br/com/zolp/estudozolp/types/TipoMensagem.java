package br.com.stp.mssimulatorgto.process.types;

/**
 * Created by stp on 17/11/16.
 */
public enum TipoMensagem {

    IMAGENS(1, "Imagem", "imagens"),
    PASSAGENS(2, "Passagens", "passagens"),
    PASSAGENS_PROCESSADAS(3, "Passagens Processadas", "passagensprocessadas"),
    REQUISITA_IMAGENS(4, "Requisita Imagens", "requisitaimagens"),
    SEQUENCIAL_TAG(5, "Sequencial Tags", "sequencialtags"),
    TAGS(6, "Tags", "tags"),
    TAGS_TOTAL(7, "Tags Total", "tagstotal"),
    TARIFAS(8,"Tarifas", "tarifas"),
    FALHA_COMUNICACAO(9, "Falha Comunica&ccedil;&atilde;o", "falhaComunicacao"),
    VEICULO_GRUPO(10, "Veiculo Grupo", "veiculoGrupo");

    private int codigoMensagem;
    private String dsMensagem;
    private String queue;

    private TipoMensagem(int codigoMensagem, String dsMensagem, String queue) {

        this.codigoMensagem = codigoMensagem;
        this.dsMensagem = dsMensagem;
        this.queue = queue;

    }

    public int getCodigoMensagem() {
        return this.codigoMensagem;
    }

    public String getDsMensagem() {
        return this.dsMensagem;
    }

    public String getQueue(){
        return this.queue;
    }

    public static TipoMensagem getTipoMensagemPorCodigo(int codigoMensagem){

        for(TipoMensagem tt : TipoMensagem.values()){
            if (tt.getCodigoMensagem() == codigoMensagem){
                return tt;
            }
        }

        return null;

    }

}
