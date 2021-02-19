package co.com.microservicio.usecase.balances;

import co.com.microservicio.model.balancesresponse.BalancesAndMovements;
import co.com.microservicio.model.balancesresponse.BalancesAndMovementsData;
import co.com.microservicio.model.balancesresponse.BalancesResponse;
import co.com.microservicio.model.balancesresponse.MovementsResponse;
import co.com.microservicio.model.balancesresponse.balances.response.BalancesApiResponse;
import co.com.microservicio.model.balancesresponse.gateways.BalancesGateway;
import co.com.microservicio.model.balancesresponse.gateways.TransactionGateway;
import co.com.microservicio.model.balancesresponse.transaction.DataTransactionResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BalancesUseCase {

    private final BalancesGateway balancesGateway;
    private final TransactionGateway transactionGateway;

    public Mono<BalancesAndMovements>  getBalances(){

        return Mono.zip(balancesGateway.getBalance(),
                transactionGateway.getTransaction(),
                this::buildDataAll);


    //transactionGateway.getTransaction().map(this::buildDataTransaction);
        // balancesGateway.getBalance().map(this::buildData);


    }

    private BalancesAndMovements buildDataAll(BalancesApiResponse balancesApiResponse,DataTransactionResponse dataTransactionResponse){
        return BalancesAndMovements.builder()
                .data(BalancesAndMovementsData.builder()
                        .balancesResponse(BalancesResponse.builder()
                                .cash(balancesApiResponse.getAccount().getBalances().getCash()).build())
                        .movementsResponses(MovementsResponse.builder()
                                .data(dataTransactionResponse.getCustomer().getName())
                                .build())
                        .build())
                .build();

    }

    private BalancesAndMovements buildDataTransaction(DataTransactionResponse dataTransactionResponse){
        return BalancesAndMovements.builder()
                .data(BalancesAndMovementsData.builder()
                        .movementsResponses(MovementsResponse.builder()
                                .data(dataTransactionResponse.getCustomer().getName())
                                .build())
                        .build())
                .build();
    }

    private BalancesAndMovements buildData(BalancesApiResponse balancesApiResponse){
        return BalancesAndMovements.builder()
                .data(BalancesAndMovementsData.builder()
                        .balancesResponse(BalancesResponse.builder()
                                .cash(balancesApiResponse.getAccount().getBalances().getCash()).build())
                        .build())
                .build();

    }
}
