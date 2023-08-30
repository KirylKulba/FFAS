package ffas.portfolio.app.persistence.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface FinancialDataTypeRepository extends JpaRepository<FinancialDataType,Long> {
    Optional<FinancialDataType> findByTypeName(final FinancialDataType.Type type);
}
