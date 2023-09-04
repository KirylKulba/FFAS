package ffas.portfolio.app.business.loan;

import ffas.portfolio.app.business.loan.dto.LoanDto;
import ffas.portfolio.app.business.loan.form.CreateLoanForm;
import ffas.portfolio.app.business.loan.form.UpdateLoanForm;

public interface LoanFacade {
    LoanDto save(final CreateLoanForm form);
    LoanDto update(final UpdateLoanForm form);
}
