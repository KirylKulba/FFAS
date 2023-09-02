package ffas.portfolio.app.business.finance;

import ffas.portfolio.app.business.finance.dto.FinancialDataDto;
import ffas.portfolio.app.business.finance.form.CreateFinanceDataForm;
import ffas.portfolio.app.business.finance.form.UpdateFinanceDataForm;
import ffas.portfolio.app.business.finance.port.FinancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("financeFacade")
public class FinanceFacadeImpl implements FinanceFacade {

    private final FinancePort financePort;

    @Autowired
    public FinanceFacadeImpl(final FinancePort financePort) {
        this.financePort = financePort;
    }

    @Override
    public FinancialDataDto save(final CreateFinanceDataForm financeForm) {
        return financePort.save(financeForm);
    }

    @Override
    public void saveAll(final List<CreateFinanceDataForm> forms) {
        financePort.saveAll(forms);
    }

    @Override
    public FinancialDataDto update(final UpdateFinanceDataForm financeForm) {
        return financePort.update(financeForm);
    }
}
