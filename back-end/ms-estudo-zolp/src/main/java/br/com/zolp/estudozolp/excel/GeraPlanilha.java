package br.com.zolp.estudozolp.excel;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class GeraPlanilha {

    private List<?> objetos;
    
	public <T> List<?> getObjetos() {
		return objetos;
	}

	public <T> void setObjetos(List<?> objetos) {
		this.objetos = objetos;
	}

	/**
	 * Adiciona uma celula com conteudo String
	 * 
	 * @param planilha
	 * @param coluna
	 * @param linha
	 * @param conteudo
	 * @param cellformat
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void adicionaStringCelula(WritableSheet planilha, int coluna, int linha, String conteudo,
		WritableCellFormat cellformat) throws RowsExceededException, WriteException {

		// Monta uma celula informando Coluna Linha Conteudo
		Label label = new Label(coluna, linha, conteudo);
		label.setCellFormat(cellformat);
		
		// Adiciona a celula na planilha
		planilha.addCell(label);

	}
	
	
	/**
	 * Adiciona uma celula com conteudo Numerico
	 * 
	 * @param planilha
	 * @param coluna
	 * @param linha
	 * @param numero
	 * @param cellformat
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void adicionaNumeroCelula(WritableSheet planilha, int coluna, int linha, Double numero,
		WritableCellFormat cellformat) throws WriteException, RowsExceededException {

		Number number = new Number(coluna, linha, numero);
		number.setCellFormat(cellformat);
		planilha.addCell(number);

	}
	
	
	/**
	 * Adiciona uma celula com conteudo de uma Formula (String)
	 * 
	 * @param planilha
	 * @param coluna
	 * @param linha
	 * @param formula
	 * @param cellformat
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void adicionaFormulaCelula(WritableSheet planilha, int coluna, int linha, String formula,
		WritableCellFormat cellformat) throws WriteException, RowsExceededException {

		//"SUM(A2:A10)"
		Formula auxFormula = new Formula(coluna, linha, formula);
		auxFormula.setCellFormat(cellformat);
		planilha.addCell(auxFormula);

	}


	/**
	 * Cria um cabecalho formatado com base na classe informada
	 * 
	 * @param planilha
	 * @param clazz
	 * @throws WriteException
	 */
	private <T> void criaCabecalho(WritableSheet planilha, Class<T> clazz) throws WriteException{

		// Cria a fonte times Bold tamanho 12
		WritableFont fontTimesBold12pt = new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD);
		
		// Cria a formatacao da celula
		WritableCellFormat cellFormat = new WritableCellFormat(fontTimesBold12pt);
		
		// Ajusta as bordas
		Border border = Border.ALL;
		BorderLineStyle borderLineStyle = BorderLineStyle.THIN;		
		cellFormat.setBorder(border, borderLineStyle);
		
		// Monta o cabecalho
		int i=0;
		for(Field  f : clazz.getDeclaredFields()){
	
			// Ignora coluna com anotacao SheetColumnIgnore
			if(this.ignoraProcessamentoColuna(f)){
				continue;
			} 
			
			SheetHeader sh = f.getAnnotation(SheetHeader.class);
			
			String auxConteudo;
			
			if(sh != null){
				
				auxConteudo = sh.name();
				
			}else{

				StringBuilder sb = new StringBuilder();
				sb
				.append(f.getName().substring(0, 1).toUpperCase())
				.append(f.getName().substring(1, f.getName().length()));
				auxConteudo = sb.toString();
				
			}
			
			adicionaStringCelula(planilha, i++, 0, auxConteudo, cellFormat);
			
		}
		
	}
	
    /**
     * Efetua o processamento de uma lista de itens
     * 
     * @param planilha
     * @throws WriteException
     */
	private void processaConteudo(WritableSheet planilha) throws WriteException{

		// Percorre os itens e constroi o conteudo
		for(Object item : getObjetos()){
	
			criaConteudoItem(planilha, item);
			
		}
		
	}
	
	
	/**
	 * Escreve o conteudo dos objetos na planilha
	 * 
	 * @param planilha
	 * @param item
	 * @throws WriteException
	 */
	private <T> void criaConteudoItem(WritableSheet planilha, T item) throws WriteException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		// Cria a fonte times tamanho 12
		WritableFont fontTimes12pt = new WritableFont(WritableFont.TIMES, 12);
		
		// Cria a formatacao da celula
		WritableCellFormat cellFormat = new WritableCellFormat(fontTimes12pt);
		 
		// Ajusta as bordas
		Border border = Border.ALL;
		BorderLineStyle borderLineStyle = BorderLineStyle.THIN;		
		cellFormat.setBorder(border, borderLineStyle);
		
		// Busca a quantidade de linhas ja existentes na planilha
		int linha = planilha.getRows();
		
		// Monta o conteudo
		int coluna=0;
		// Percorre os metodos da classe recuperando seus valores
		for(Field  f : item.getClass().getDeclaredFields()){
			
			// Ignora coluna com anotacao SheetColumnIgnore
			if(this.ignoraProcessamentoColuna(f)){
				continue;
			} 
		    
			String s = f.getName();
			
			try{
				
				StringBuilder auxSb = new StringBuilder();
				auxSb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1, s.length()));
					
				// Metodo a ser executado
				Method m = item.getClass().getDeclaredMethod("get" + auxSb.toString()); 
				
				// Obtem o conteudo do metodo get
				Object auxObj = m.invoke(item);
				
				if(auxObj == null) {
					
					adicionaStringCelula(planilha, coluna++, linha, " ", cellFormat);
					
				}else {
					
				    // Verificar o tipo de retorno para identificar qual tipo de campo no excel devera ser criado
					if(	m.getReturnType().equals(Short.class) ||
						m.getReturnType().equals(Integer.class) ||
						m.getReturnType().equals(Long.class) ||
						m.getReturnType().equals(Float.class)
					){
					
						Double conteudo = Double.parseDouble( auxObj.toString() );
						adicionaNumeroCelula(planilha, coluna++, linha, conteudo, cellFormat);		
										
					}else if(m.getReturnType().equals(Double.class)){
						
						Double conteudo = (Double) auxObj;					
						adicionaNumeroCelula(planilha, coluna++, linha, conteudo, cellFormat);
						
					}else if(m.getReturnType().equals(Date.class)){
						
						Date conteudo = (Date) auxObj;
						adicionaStringCelula(planilha, coluna++, linha, sdf.format(conteudo), cellFormat);
						
					}else if(m.getReturnType().equals(Calendar.class)){
						
						Calendar conteudo = (Calendar) auxObj;
						adicionaStringCelula(planilha, coluna++, linha, sdf.format(conteudo), cellFormat);
						
					}else{

						adicionaStringCelula(planilha, coluna++, linha, auxObj.toString(), cellFormat);
						
					}
					
				}
				
			}catch(Exception e){
				
			}
			
		}
		
	}

		
	/**
	 * Efetua o processamento da lista de objetos existente no outPutStream informado
	 * 
	 * @param out
	 * @param nomePlanilha
	 */
	public void processar(OutputStream out, String nomePlanilha) throws Exception{
		
		if(out == null)
			throw new IllegalArgumentException("Target da geracao do arquivo nao informado. "
				+ "Favor informar o objeto outPutStream.");
		
		processar(null, out, trataNomePlanilha(nomePlanilha));
		
	}
	
	
	/**
	 * Ajusta a largura das colunas
	 * 
	 * @param planilha
	 */
	private void ajustaColunas(WritableSheet planilha){
		
		int colunas = planilha.getColumns();
		
		for(int i = 0; i<colunas; i++){
			
		    CellView cell = planilha.getColumnView(i);
		    cell.setAutosize(true);
		    planilha.setColumnView(i, cell);
		    
		}
		
	}

	
	/**
	 * Efetua o processamento da lista de objetos existente enviando o resultado para um arquivo informado
	 * 
	 * @param caminho
	 * @param nomePlanilha
	 */
	public void processar(String caminho, String nomePlanilha) throws Exception{
		
		if((caminho == null || caminho.isEmpty()))
			throw new IllegalArgumentException("Target da geracao do arquivo nao informado. "
				+ "Favor informar o caminho do arquivo.");
		
		File file = new File(caminho);
		
		processar(file, null, trataNomePlanilha(nomePlanilha));

	}
    
	/**
	 * Efetua o tratamento do nome da planilha
	 * 
	 * @param nomePlanilha
	 * @return
	 */
	private String trataNomePlanilha(String nomePlanilha){
		return (nomePlanilha != null && !nomePlanilha.isEmpty() ? nomePlanilha : "Sem Nome");
	}
	
	/**
	 * Efetua o processamento da lista de objetos para gravacao do conteudo em formato de planilha
	 * 
	 * @param caminho
	 * @param out
	 * @param nomePlanilha
	 * @throws Exception
	 */
	private void processar(File caminho, OutputStream out, String nomePlanilha) throws Exception {
		
		if(this.getObjetos() == null || this.getObjetos().isEmpty()){
			throw new IllegalArgumentException("Nao foram localizados objetos para processamento.");			
		}
		
		// Ajusta as configurações do Arquivo xls (que contem as planilhas)
		WorkbookSettings configuracoes = new WorkbookSettings();
		configuracoes.setLocale(new Locale("pt", "BR"));

		// Cria o arquivo xls informando o caminho do arquivo e as configuracoes
		WritableWorkbook arquivo;
		
		if(caminho != null){
			arquivo = Workbook.createWorkbook(caminho, configuracoes);
		}else{
			arquivo = Workbook.createWorkbook(out, configuracoes);
		}
		
		// Cria uma planilha na posicao 0 
		arquivo.createSheet(nomePlanilha, 0);

		// Carrega a planilha para que a mesma possa ser editada
		WritableSheet planilha = arquivo.getSheet(0);
		
		// Preenche o cabeçalho do arquivo
		this.criaCabecalho(planilha, this.getObjetos().get(0).getClass());

		// Preenche o conteudo da planilha
		this.processaConteudo(planilha);
		
		// Ajusta a largura das colunas
		this.ajustaColunas(planilha);
		
		// Escreve o arquivo no disco
		arquivo.write();
		
		// Fecha a conexao do arquivo
		arquivo.close();

	}
	
	private boolean ignoraProcessamentoColuna(Field f) {
		
		boolean ignoraProcessamento = false;
		
		// Ignora coluna com anotacao SheetColumnIgnore
		SheetColumnIgnore sci = f.getAnnotation(SheetColumnIgnore.class);
		if(sci != null){
			ignoraProcessamento = true;
		}
		
		return ignoraProcessamento;

	}
	
}