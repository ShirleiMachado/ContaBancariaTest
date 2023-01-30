package ContaCorrente.Api.controller;

import ContaCorrente.Api.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoggerController {


    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping("/{id}")
    public NotificacaoService getById(@PathVariable Long id) {
        return notificacaoService;
    }
}
