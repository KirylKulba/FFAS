package ffas.portfolio.app.persistence.finance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "financial_data_types")
class FinancialDataType {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name", length = 50)
    @Enumerated(EnumType.STRING)
    private Type typeName;

    public enum Type {
        Income, Expense;
    }
}
