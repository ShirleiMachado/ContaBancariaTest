package ContaCorrente.Api.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import ContaCorrente.Api.dto.ResponseLimite;

@Service
public class ConsultarLimiteClient {

    @Value("MS.CONSULTAR.LIMITE.CLIENTE.URL")
    private String hostConsultarLimite;
    
    RestTemplate restTemplate = new RestTemplate();

	public ResponseLimite consultar(String id_conta) {
		String urlConsultarLimite = hostConsultarLimite.concat(id_conta).concat("/limite");
		
		try {
			ResponseEntity<ResponseLimite> response = restTemplate.getForEntity(urlConsultarLimite, ResponseLimite.class);
			return response.getBody();
		} catch (RestClientException ex) {
			throw new RestClientException("Error ao chamar o microserviço consultar-limite", ex);
		}
	}
}
