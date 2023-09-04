package ffas.portfolio.app.persistence.loan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface LoanRepository extends JpaRepository<Loan,Long> {
    Optional<Loan> findByUuid(final UUID uuid);
}
