package ffas.portfolio.app.persistence.finance;

import ffas.portfolio.app.business.finance.dto.FinancialDataDto;

import java.util.Set;
import java.util.stream.Collectors;

public class FinanceMapper {
    public static Set<FinancialDataDto> toDto(final Set<FinancialData> data) {
        return data.stream()
                .map(FinanceMapper::toDto)
                .collect(Collectors.toSet());
    }

    private static FinancialDataDto toDto(final FinancialData data) {
        final FinancialDataDto dto = new FinancialDataDto();
        dto.setType(data.getFinancialDataType().getTypeName().toString());
        dto.setAmount(data.getAmount());
        dto.setDescription(data.getDescription());
        dto.setUser(data.getUser().getUuid());
        return dto;
    }
}
