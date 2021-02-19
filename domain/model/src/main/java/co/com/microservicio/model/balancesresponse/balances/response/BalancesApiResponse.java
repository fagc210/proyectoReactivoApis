package co.com.microservicio.model.balancesresponse.balances.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalancesApiResponse {
    private Account account ;
}
