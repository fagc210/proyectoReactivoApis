package co.com.microservicio.api;

import co.com.microservicio.model.balancesresponse.BalancesAndMovements;
import co.com.microservicio.model.balancesresponse.BalancesResponse;
import co.com.microservicio.usecase.balances.BalancesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final BalancesUseCase balancesUseCase;

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        Mono<BalancesAndMovements> response = balancesUseCase.getBalances();
        return ServerResponse.ok().body(response, BalancesAndMovements.class);
    }


}
