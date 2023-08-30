package ffas.portfolio.app.business.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialDataDto {
    private String type;
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;
    private UUID user;
}
