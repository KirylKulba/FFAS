package ffas.portfolio.app.business.Investment.port;

import ffas.portfolio.app.business.Investment.dto.InvestmentDto;
import ffas.portfolio.app.business.Investment.form.CreateInvestmentForm;

public interface InvestmentPort {
    InvestmentDto save(final CreateInvestmentForm form);
}
