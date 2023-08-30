package ffas.portfolio.app.persistence.user;

import ffas.portfolio.app.persistence.common.AbstractEntity;
import ffas.portfolio.app.persistence.finance.FinancialData;
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

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "\"user\"")
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
            fetch = FetchType.LAZY
    )
    private List<FinancialData> financialData = new ArrayList<>();

    public enum Sex {
        Male, Female, Other
    }
}
