package co.com.microservicio.model.balancesresponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalancesAndMovements {
    private BalancesAndMovementsData data;
}
