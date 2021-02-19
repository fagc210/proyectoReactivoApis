package co.com.microservicio.consumer;

import co.com.microservicio.model.balancesresponse.BalancesResponse;
import co.com.microservicio.model.balancesresponse.balances.response.BalancesApiResponse;
import co.com.microservicio.model.balancesresponse.gateways.BalancesGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements BalancesGateway // implements Gateway from domain
{

    private final WebClient client;


    @Override
    public Mono<BalancesApiResponse> getBalance() {
        BalancesResponse balancesResponse = null;
        return client
                .post()
                .uri("/balance")
                //.body(Mono.just(request), ObjectRequest.class)
                .retrieve()
                .bodyToMono(BalancesApiResponse.class);



    }
}