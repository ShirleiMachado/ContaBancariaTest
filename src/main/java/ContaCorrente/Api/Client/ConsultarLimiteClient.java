package ContaCorrente.Api.Client;

import ContaCorrente.Api.dto.ResponseLimite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultarLimiteClient {

    //usado para fazer chamadas em outras apis

    @Value("ms.consultar.limite.cliente.url")
    private String hostConsultarLimite;
    RestTemplate restTemplate = new RestTemplate();

    public ResponseLimite consultar(String id_conta){
        String urlConsultarLimite
                = hostConsultarLimite.concat(id_conta).concat("/limite");
        ResponseEntity<ResponseLimite> response
                = restTemplate.getForEntity(urlConsultarLimite, ResponseLimite.class);
        return response.getBody();
    }

}
