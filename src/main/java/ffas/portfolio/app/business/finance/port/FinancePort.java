package ffas.portfolio.app.business.finance.port;

import ffas.portfolio.app.business.finance.dto.FinancialDataDto;
import ffas.portfolio.app.business.finance.form.CreateFinanceDataForm;
import ffas.portfolio.app.business.finance.form.UpdateFinanceDataForm;

import java.util.List;

public interface FinancePort {
    FinancialDataDto save(final CreateFinanceDataForm createUserForm);
    FinancialDataDto update(final UpdateFinanceDataForm updateUserForm);
    void saveAll(final List<CreateFinanceDataForm> financialData);
}
