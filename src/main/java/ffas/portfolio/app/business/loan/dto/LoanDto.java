package ffas.portfolio.app.business.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private UUID uuid;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private BigDecimal emi;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID user;
}
