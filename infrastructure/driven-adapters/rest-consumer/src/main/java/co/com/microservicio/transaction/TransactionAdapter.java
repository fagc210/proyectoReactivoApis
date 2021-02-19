package co.com.microservicio.transaction;


import co.com.microservicio.model.balancesresponse.gateways.TransactionGateway;
import co.com.microservicio.model.balancesresponse.transaction.DataTransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionAdapter implements TransactionGateway {

    private final WebClient client;


    @Override
    public Mono<DataTransactionResponse> getTransaction() {
        return client
                .post()
                .uri("/transaction")
                .retrieve()
                .bodyToMono(DataTransactionResponse.class)
                ;
    }
}
