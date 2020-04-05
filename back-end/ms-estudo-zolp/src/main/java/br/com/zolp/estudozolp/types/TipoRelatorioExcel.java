package br.com.zolp.estudozolp.types;

/**
 * Created by stp on 27/01/18.
 */
public enum TipoRelatorioExcel {

    DADOS_PACIENTE(1, "dadosPaciente.xls", "Dados do Paciente"),
    EXCLUSAO_ESTUDO(2, "exclusaoEstudo.xls", "Exclus�o do Estudo"),
    EVENTOS_ADVERSOS(3, "eventosAdversos.xls", "Eventos Adversos"),   
    VISITA_00(4, "visita00.xls", "Visita 0"),
    VISITA_01(5, "visita01.xls", "Visita 1"),
    VISITA_02(6, "visita02.xls", "Visita 2"),
    VISITA_03(7, "visita03.xls", "Visita 3"),
    VISITA_04(8, "visita04.xls", "Visita 4"),
    VISITA_05(9, "visita05.xls", "Visita 5"),
    VISITA_06(10, "visita06.xls", "Visita 6"),
    VISITA_07(11, "visita07.xls", "Visita 7"),
    VISITA_08(12, "visita08.xls", "Visita 8"),
    VISITA_09(13, "visita09.xls", "Visita 9"),    
    VISITA_10(14, "visita10.xls", "Visita 10"),
    VISITA_11(15, "visita11.xls", "Visita 11"),    
    VISITA_12(16, "visita12.xls", "Visita 12"),    
    VISITA_13(17, "visita13.xls", "Visita 13"),
    VISITA_14(18, "visita14.xls", "Visita 14"),
    VISITA_15(19, "visita15.xls", "Visita 15"),    
    VISITA_16(20, "visita16.xls", "Visita 16"),
    VISITA_17(21, "visita17.xls", "Visita 17"),
    MEDICAMENTOS_PACIENTE(22, "medicamentos_pacientes.xls", "Medicamentos de Pacientes"); 

    private int codigo;
    private String nmArquivoExportado;
    private String nmPlanilha;

    private TipoRelatorioExcel(int codigo, String nmArquivoExportado, String nmPlanilha) {

        this.codigo = codigo;
        this.nmArquivoExportado = nmArquivoExportado;
        this.nmPlanilha = nmPlanilha;

    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNmArquivoExportado() {
        return this.nmArquivoExportado;
    }

    public String getNmPlanilha(){
        return this.nmPlanilha;
    }

    public static TipoRelatorioExcel getTipoRelatorioExcelPorCodigo(int codigo){

        for(TipoRelatorioExcel tre : TipoRelatorioExcel.values()){
            if (tre.getCodigo() == codigo){
                return tre;
            }
        }

        return null;

    }

}
