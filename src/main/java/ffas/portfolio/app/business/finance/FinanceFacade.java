package ffas.portfolio.app.business.finance;

import ffas.portfolio.app.business.finance.dto.FinancialDataDto;
import ffas.portfolio.app.business.finance.form.CreateFinanceDataForm;
import ffas.portfolio.app.business.finance.form.UpdateFinanceDataForm;

public interface FinanceFacade {
    FinancialDataDto save(final CreateFinanceDataForm form);
    FinancialDataDto update(final UpdateFinanceDataForm form);
}
