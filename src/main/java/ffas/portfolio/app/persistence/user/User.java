package ffas.portfolio.app.persistence.user;

import ffas.portfolio.app.persistence.Investment.Investment;
import ffas.portfolio.app.persistence.common.AbstractEntity;
import ffas.portfolio.app.persistence.finance.FinancialData;
import ffas.portfolio.app.persistence.loan.Loan;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "\"users\"")
public class User extends AbstractEntity {

    @Column(name = "sex", length = 50)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "citizen_number", unique = true, nullable = false)
    private String citizenNumber;

    @Column(name = "age")
    private Integer age;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<FinancialData> financialData = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<Loan> loans = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<Investment> investments = new HashSet<>();

    public enum Sex {
        Male, Female, Other
    }
}
