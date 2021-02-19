package co.com.microservicio.model.balancesresponse.gateways;

import co.com.microservicio.model.balancesresponse.transaction.DataTransactionResponse;
import reactor.core.publisher.Mono;

public interface TransactionGateway {

    Mono<DataTransactionResponse> getTransaction();
}
