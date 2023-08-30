package ffas.portfolio.app.persistence.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface FinancialDataRepository extends JpaRepository<FinancialData,Long> {
    Optional<FinancialData> findByUuid(final UUID uuid);
}
