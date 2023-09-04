package ffas.portfolio.app.business.Investment.form;

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
public class CreateInvestmentForm {
    private String type;
    private BigDecimal amount;
    private BigDecimal returns;
    private LocalDate investmentDate;
    private LocalDate maturityDate;
    private UUID user;
}
