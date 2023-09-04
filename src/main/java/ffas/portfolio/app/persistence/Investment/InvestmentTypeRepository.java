package ffas.portfolio.app.persistence.Investment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface InvestmentTypeRepository extends JpaRepository<InvestmentType, Long> {
    Optional<InvestmentType> findByTypeName(final InvestmentType.Type type);
}
