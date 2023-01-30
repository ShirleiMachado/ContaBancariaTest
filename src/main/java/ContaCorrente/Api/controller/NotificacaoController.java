package ContaCorrente.Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ContaCorrente.Api.dto.MensagemSqs;
import ContaCorrente.Api.service.NotificacaoService;

@RestController
@RequestMapping("api/contas/validanotificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    public ResponseEntity<String> validarLimitMovimentacao(@RequestBody @Validated MensagemSqs mensagemSqs) throws JsonProcessingException {
    			notificacaoService.validaMovimentacao(mensagemSqs);
    	return ResponseEntity.ok("Validação concluida com sucesso!");   
    }
}
