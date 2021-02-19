package co.com.microservicio.config;

import co.com.microservicio.model.balancesresponse.gateways.BalancesGateway;
import co.com.microservicio.model.balancesresponse.gateways.TransactionGateway;
import co.com.microservicio.usecase.balances.BalancesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public BalancesUseCase getBalancesUseCase(BalancesGateway balancesGateway, TransactionGateway transactionGateway){
        return new BalancesUseCase(balancesGateway, transactionGateway);
    }
}
