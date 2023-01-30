package ContaCorrente.Api.service;

import ContaCorrente.Api.Client.ConsultarLimiteClient;
import ContaCorrente.Api.Repository.NotificacaoRepository;
import ContaCorrente.Api.dto.MensagemSqs;
import ContaCorrente.Api.dto.ResponseLimite;
import ContaCorrente.Api.model.LoggerNotificacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificacaoService {


    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private ConsultarLimiteClient consultarLimiteClient;

    @Autowired
    private ObjectMapper objectMapper;

    //obj mensagemSqs será enviado via SQS Amazon
    public void avaliarMovimentacao(MensagemSqs mensagemSqs) throws JsonProcessingException {
        String id_conta = mensagemSqs.getAgencia().concat(mensagemSqs.getNumero_conta().concat(mensagemSqs.getDigito_conta()));
        ResponseLimite responseLimite = consultarLimiteClient.consultar(id_conta);

        if (mensagemSqs.getValor_movimento().compareTo(responseLimite.getLimite()) > 0) {
            enviaNotificacaoLimiteExcedido(mensagemSqs);

        }
    }

    private void enviaNotificacaoLimiteExcedido(MensagemSqs sqsMovimentacaoConta) throws JsonProcessingException {
            montarNotificacao(sqsMovimentacaoConta);
        notificacaoRepository.save(LoggerNotificacao.builder().dadosNotificacao(objectMapper.writeValueAsString(sqsMovimentacaoConta)).horaEnvio(LocalDateTime.now()).build());

    }

    private String montarNotificacao(MensagemSqs objSqs) {
        return "Prezado cliente o limite da conta: ".concat(objSqs.getNumero_conta()).concat("-").concat(objSqs.getDigito_conta()).concat("foi excedido para movimentação de valor").concat(objSqs.getValor_movimento().toString());

    }



}
