package ffas.portfolio.app.business.loan;

import ffas.portfolio.app.business.loan.dto.LoanDto;
import ffas.portfolio.app.business.loan.form.CreateLoanForm;
import ffas.portfolio.app.business.loan.form.UpdateLoanForm;
import ffas.portfolio.app.business.loan.port.LoanPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loanFacade")
public class LoanFacadeImpl implements LoanFacade {
    private final LoanPort loanPort;

    @Autowired
    public LoanFacadeImpl(final LoanPort loanPort) {
        this.loanPort = loanPort;
    }

    @Override
    public LoanDto save(final CreateLoanForm form) {
        return null;
    }

    @Override
    public LoanDto update(final UpdateLoanForm form) {
        return null;
    }
}
