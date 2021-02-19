package co.com.microservicio.model.balancesresponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalancesResponse {
    private float agreedRemittanceQuota;
    private float available;
    private float availableOverdraftBalance;
    private float availableOverdraftQuota;
    private float blocked;
    private float cash;
    private float cashStartDay;
    private float normalInterest;
    private float overdraftValue;
    private float pockets;
    private float receivable;
    private float remittanceQuota;
    private float remittanceQuotaUsage;
    private float suspensionInterest;
    private float unavailable;
    private float unavailableStartDayClearingStartDay;
}
