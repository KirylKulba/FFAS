package ffas.portfolio.app.business.user.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserForm {
    private String citizenNumber;
    private String sex;
    private Integer age;
}
