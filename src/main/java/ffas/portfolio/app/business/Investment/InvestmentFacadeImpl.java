package ffas.portfolio.app.business.Investment;

import ffas.portfolio.app.business.Investment.dto.InvestmentDto;
import ffas.portfolio.app.business.Investment.form.CreateInvestmentForm;
import ffas.portfolio.app.business.Investment.port.InvestmentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("investmentFacade")
public class InvestmentFacadeImpl implements InvestmentFacade {

    private final InvestmentPort investmentPort;

    @Autowired
    public InvestmentFacadeImpl(final InvestmentPort investmentPort) {
        this.investmentPort = investmentPort;
    }


    @Override
    public InvestmentDto save(final CreateInvestmentForm form) {
        return investmentPort.save(form);
    }
}
