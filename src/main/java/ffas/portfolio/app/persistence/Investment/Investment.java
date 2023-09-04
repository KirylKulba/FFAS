package ffas.portfolio.app.persistence.Investment;

import ffas.portfolio.app.persistence.common.AbstractEntity;
import ffas.portfolio.app.persistence.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "\"investment\"")
public class Investment extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private InvestmentType investmentType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "returns")
    private BigDecimal returns;

    @Column(name = "investment_date")
    private LocalDate investmentDate;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
