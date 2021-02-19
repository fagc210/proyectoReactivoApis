package co.com.microservicio.model.balancesresponse.gateways;

import co.com.microservicio.model.balancesresponse.BalancesResponse;
import co.com.microservicio.model.balancesresponse.balances.response.BalancesApiResponse;
import reactor.core.publisher.Mono;

public interface BalancesGateway {

    Mono<BalancesApiResponse> getBalance();

}
