package ffas.portfolio.app.business.finance.form;

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
public class UpdateFinanceDataForm {
    private UUID uuid;
    private String type;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
}
