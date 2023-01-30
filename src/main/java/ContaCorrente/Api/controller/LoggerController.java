package ContaCorrente.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ContaCorrente.Api.model.LoggerNotificacao;
import ContaCorrente.Api.service.NotificacaoService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/conta/registro/notificacao")
public class LoggerController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public List<LoggerNotificacao> getByIdConta(@PathParam(value = "idConta") String idConta){
        return notificacaoService.listaNotificacoesLimiteExcedido(idConta);
    }
}
