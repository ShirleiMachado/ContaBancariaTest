package ContaCorrente.Api.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggerNotificacao {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime horaEnvioNotificacaoLimiteExcedido;
    
    @NotBlank
    private String dadosNotificacao;
    
    @NotBlank
    private String idConta;
}
