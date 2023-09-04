package ffas.portfolio.app.persistence.loan;

import ffas.portfolio.app.persistence.common.AbstractEntity;
import ffas.portfolio.app.persistence.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "\"loans\"")
public class Loan extends AbstractEntity {
    @Column(name = "principal_amount")
    private BigDecimal principalAmount;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "emi")
    private BigDecimal emi;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
