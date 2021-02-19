package co.com.microservicio.model.balancesresponse.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataTransactionResponse {

    private TransactionApiResponse transaction;
    private OfficeApiResponse office;
    private CustomerApiResponse customer;

    }
