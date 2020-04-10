package br.com.zolp.estudozolp.controller;

//import br.com.zolp.estudozolp.document.ObjetoRequestDocument;
//import br.com.zolp.estudozolp.document.ObjetoResponseDocument;
//import br.com.zolp.estudozolp.exception.EstudoZolpException;
//import br.com.zolp.estudozolp.exception.PersistenciaException;
//import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;
//import br.com.zolp.estudozolp.log.LogManager;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.event.Level;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *  Controller responsável por expor as operações de ...
// *
// * @author mamede
// * @version 0.0.1-SNAPSHOT
// *
// */
//@RestController
public class XPTORestController {

//    // TODO Incluir referente aos business, conversores, etc...
//    @Autowired
//    private Object business;
//
//    /**
//     * Chamada ao fluxo responsavel por...
//     *
//     * @param requestDocument
//     * @return
//     */
//    @PostMapping(
//        path = "/servicoXPTO",
//        consumes = MediaType.APPLICATION_JSON_VALUE,
//        produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @ApiOperation(value = "Efetua o processamento ....")
//    public final ResponseEntity<ObjetoResponseDocument> fazAlgumaCoisa(
//        @RequestBody final ObjetoRequestDocument requestDocument) {
//
//        // Inicializa response
//        ObjetoResponseDocument responseDocument = new ObjetoResponseDocument();
//
//        try {
//
//            // Efetua o processamento ....
//            //business.fazAlgo...
//
//            // Prepara o response
//            responseDocument.setRetorno("Retorno");
//
//        } catch (EstudoZolpException azae) {
//            LogManager.logDetalhe(Level.ERROR, XPTORestController.class, "fazAlgumaCoisa",
//                " Erro!: ", azae);
//            //responseDocument.set...
//        } catch (RegistroNaoLocalizadoException rnle) {
//            LogManager.logDetalhe(Level.ERROR, XPTORestController.class, "atualizarValidadeAprovacao",
//                " Erro!: ", rnle);
//            //responseDocument.set...
//        } catch (PersistenciaException pe) {
//            LogManager.logDetalhe(Level.ERROR, XPTORestController.class, "atualizarValidadeAprovacao",
//                " Erro!: ", pe);
//            //responseDocument.set...
//        } catch (Exception e) {
//            // Eh preciso capturar outras excecoes que nao sejam do tipo RuntimeException, pois o
//            // Hibernate cria um proxy que propaga as excecoes do tipo java.sql.Exception e que nao
//            // sao tratadas na implementacao da service. Sem este catch, o erro eh propagado para o
//            // REST HTTP como erro HTML-CODE 500.
//            LogManager.logDetalhe(Level.ERROR, XPTORestController.class, "atualizarValidadeAprovacao",
//                " Erro!: ", e);
//            //responseDocument.set...
//        }
//
//        return new ResponseEntity<ObjetoResponseDocument>(responseDocument, HttpStatus.OK);
//    }

}
