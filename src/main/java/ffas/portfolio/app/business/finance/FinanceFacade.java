package ffas.portfolio.app.business.finance;

import ffas.portfolio.app.business.finance.dto.FinancialDataDto;
import ffas.portfolio.app.business.finance.form.CreateFinanceDataForm;
import ffas.portfolio.app.business.finance.form.UpdateFinanceDataForm;

import java.util.List;

public interface FinanceFacade {
    FinancialDataDto save(final CreateFinanceDataForm form);
    void saveAll(final List<CreateFinanceDataForm> forms);
    FinancialDataDto update(final UpdateFinanceDataForm form);
}
