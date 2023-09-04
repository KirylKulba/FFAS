package ffas.portfolio.app.persistence.Investment;

import org.springframework.data.jpa.repository.JpaRepository;

interface InvestmentRepository extends JpaRepository<Investment, Long> {
}
