package ffas.portfolio.app.business.Investment;

import ffas.portfolio.app.business.Investment.dto.InvestmentDto;
import ffas.portfolio.app.business.Investment.form.CreateInvestmentForm;

public interface InvestmentFacade {
    InvestmentDto save(final CreateInvestmentForm form);
}
