package ffas.portfolio.app.persistence.user.entity;

import ffas.portfolio.app.persistence.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "\"user\"")
public class User extends AbstractEntity {

    @Column(name = "sex")
    private String sex;

    @Column(name = "citizen_number", unique = true)
    private String citizenNumber;

    @Column(name = "age")
    private Integer age;
}
