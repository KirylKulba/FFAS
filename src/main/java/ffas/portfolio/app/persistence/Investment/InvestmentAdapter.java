package ffas.portfolio.app.persistence.Investment;

import ffas.portfolio.app.business.Investment.dto.InvestmentDto;
import ffas.portfolio.app.business.Investment.form.CreateInvestmentForm;
import ffas.portfolio.app.business.Investment.port.InvestmentPort;
import ffas.portfolio.app.business.common.exceptions.NotFoundException;
import ffas.portfolio.app.persistence.user.User;
import ffas.portfolio.app.persistence.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InvestmentAdapter implements InvestmentPort {
    private final InvestmentRepository investmentRepository;
    private final InvestmentTypeRepository investmentTypeRepository;
    private final UserRepository userRepository;

    public InvestmentAdapter(final InvestmentRepository investmentRepository,
                             final InvestmentTypeRepository investmentTypeRepository,
                             final UserRepository userRepository){
        this.investmentRepository = investmentRepository;
        this.investmentTypeRepository = investmentTypeRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public InvestmentDto save(final CreateInvestmentForm form) {
        final Investment investment = toEntity(form);
        return toDto(investmentRepository.save(investment));
    }

    private Investment toEntity(final CreateInvestmentForm form) {
        final Investment investment = new Investment();
        investment.setInvestmentType(getInvestmentTypeByName(form.getType()));
        investment.setInvestmentDate(form.getInvestmentDate());
        investment.setMaturityDate(form.getMaturityDate());
        investment.setAmount(form.getAmount());
        investment.setReturns(form.getReturns());
        investment.setUser(findUserByUuid(form.getUser()));
        return investment;
    }

    private InvestmentType getInvestmentTypeByName(final String type) {
        return investmentTypeRepository.findByTypeName(InvestmentType.Type.valueOf(type))
                .orElseThrow(() -> new NotFoundException("Investment type not found with name: " + type));
    }

    private User findUserByUuid(final UUID uuid) {
        return userRepository.findUserByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("User not found with uuid: " + uuid));
    }

    private InvestmentDto toDto(final Investment investment) {
        final InvestmentDto dto = new InvestmentDto();
        dto.setUser(investment.getUser().getUuid());
        dto.setType(investment.getInvestmentType().getTypeName().name());
        dto.setAmount(investment.getAmount());
        dto.setReturns(investment.getReturns());
        dto.setInvestmentDate(investment.getInvestmentDate());
        dto.setMaturityDate(investment.getMaturityDate());
        return dto;
    }
}
