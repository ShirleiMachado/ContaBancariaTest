package ContaCorrente.Api.Repository;

import ContaCorrente.Api.model.LoggerNotificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<LoggerNotificacao, Long> {

}
