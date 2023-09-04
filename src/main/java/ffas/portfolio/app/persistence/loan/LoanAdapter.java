package ffas.portfolio.app.persistence.loan;

import ffas.portfolio.app.business.common.exceptions.NotFoundException;
import ffas.portfolio.app.business.loan.dto.LoanDto;
import ffas.portfolio.app.business.loan.form.CreateLoanForm;
import ffas.portfolio.app.business.loan.form.UpdateLoanForm;
import ffas.portfolio.app.business.loan.port.LoanPort;
import ffas.portfolio.app.persistence.user.User;
import ffas.portfolio.app.persistence.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoanAdapter implements LoanPort {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    public LoanAdapter(final LoanRepository loanRepository,
                       final UserRepository userRepository){
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public LoanDto save(final CreateLoanForm form) {
        final Loan loan = toEntity(form);
        return toDto(loanRepository.save(loan));
    }

    @Override
    @Transactional
    public LoanDto update(final UpdateLoanForm form) {
        final Loan loan = loanRepository.findByUuid(form.getUuid())
                .orElseThrow(() -> new NotFoundException("Loan not found with uuid: " + form.getUuid().toString()));
        updateValues(loan, form);
        return toDto(loan);
    }

    private void updateValues(final Loan loan, final UpdateLoanForm form) {
        loan.setPrincipalAmount(form.getPrincipalAmount());
        loan.setInterestRate(form.getInterestRate());
        loan.setStartDate(form.getStartDate());
        loan.setEndDate(form.getEndDate());
    }

    private Loan toEntity(final CreateLoanForm form) {
        final Loan loan = new Loan();
        loan.setPrincipalAmount(form.getPrincipalAmount());
        loan.setInterestRate(form.getInterestRate());
        loan.setStartDate(form.getStartDate());
        loan.setEndDate(form.getEndDate());
        loan.setUser(findUserByUuid(form.getUser()));
        return loan;
    }

    private User findUserByUuid(final UUID uuid) {
        return userRepository.findUserByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("User not found with uuid: " + uuid));
    }

    private LoanDto toDto(final Loan loan) {
        final LoanDto dto = new LoanDto();
        dto.setUser(loan.getUser().getUuid());
        dto.setEmi(loan.getEmi());
        dto.setStartDate(loan.getStartDate());
        dto.setEndDate(loan.getEndDate());
        dto.setInterestRate(loan.getInterestRate());
        dto.setUuid(loan.getUuid());
        return dto;
    }
}
